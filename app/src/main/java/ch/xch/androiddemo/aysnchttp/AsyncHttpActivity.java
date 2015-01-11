package ch.xch.androiddemo.aysnchttp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import ch.xch.androiddemo.R;

public class AsyncHttpActivity extends BaseHttpActivity {

    private static final String TEST_URL = "";
    private TextView tvResponseContent, tvResponseHeader, tvResponseStatus;
    private EditText etUrl;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynchttp);
        tvResponseContent = (TextView) findViewById(R.id.asynchttp_responsebody);
        tvResponseHeader = (TextView) findViewById(R.id.asynchttp_headers);
        tvResponseStatus = (TextView) findViewById(R.id.asynchttp_statuscode);
        etUrl = (EditText) findViewById(R.id.asynchttp_edit);
        etUrl.setText(TEST_URL);
        etUrl.clearFocus();
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        hideSoftKeyboard();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asynchttp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void runHttpRequest(View view) {
        hideSoftKeyboard();
        String url = etUrl.getText().toString();
        if (TextUtils.isEmpty(url)) {
            url = TEST_URL;
        }
        addRequestHandle(executeHttpRequest(getAsyncHttpClient(), url, null, null, getResponseHandler()));
    }


    @Override
    public ResponseHandlerInterface getResponseHandler() {
        return new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                System.out.println("ResponseHandler-onStart");
                tvResponseContent.setText(R.string.activity_asynchttp_loading);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                System.out.println("ResponseHandler-onFinish");
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                System.out.println("ResponseHandler-onRetry： " + retryNo);
            }

            @Override
            public void onPreProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                super.onPreProcessResponse(instance, response);
                System.out.println("ResponseHandler-onPreProcessResponse");
            }

            @Override
            public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                super.onPostProcessResponse(instance, response);
                System.out.println("ResponseHandler-onPostProcessResponse");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("ResponseHandler-onSuccess");
                showResponse(statusCode, headers, responseBody, true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("ResponseHandler-onFailure:　" + statusCode);
                showResponse(statusCode, headers, responseBody, false);
            }
        };
    }

    private void showResponse(int statusCode, Header[] headers, byte[] responseBody, boolean success) {

        showResponse(statusCode, headers, new String(responseBody), success);
    }

    protected void showResponse(int statusCode, Header[] headers, String responseBody, boolean success) {
        tvResponseStatus.setText(statusCode + "");
        StringBuffer sb = new StringBuffer();
        for (Header header : headers) {
            sb.append(header).append("\n");
        }
        tvResponseHeader.setText(sb.toString());
        if (success) {
            tvResponseContent.setText(responseBody);
        } else {
            Spanned content = Html.fromHtml(responseBody);
            tvResponseContent.setText(content);
        }
    }


    @Override
    public RequestHandle executeHttpRequest(AsyncHttpClient client, String URL, Header[] headers, HttpEntity entity, ResponseHandlerInterface responseHandler) {
        return client.get(this, URL, headers, null, responseHandler);
    }

    void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
