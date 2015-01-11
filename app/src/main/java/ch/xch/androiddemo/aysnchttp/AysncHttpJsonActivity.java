package ch.xch.androiddemo.aysnchttp;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;

import ch.xch.androiddemo.bean.DemoJson;

/**
 * Created by XCH on 2015/1/11.
 */
public class AysncHttpJsonActivity extends AsyncHttpActivity {

    @Override
    public ResponseHandlerInterface getResponseHandler() {
        return new BaseJsonHttpResponseHandler<DemoJson>() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, DemoJson response) {
                showResponse(statusCode, headers, rawJsonResponse, true);
                System.out.println(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, DemoJson errorResponse) {
                showResponse(statusCode, headers, rawJsonData, false);
            }

            @Override
            protected DemoJson parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                if(isFailure) return null;
                return new ObjectMapper().readValues(new JsonFactory().createParser(rawJsonData), DemoJson.class).next();
            }
        };
    }
}
