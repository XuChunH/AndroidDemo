package ch.xch.androiddemo.camera;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import ch.xch.androiddemo.R;

public class CameraActivity extends Activity implements SurfaceHolder.Callback, Camera.PictureCallback {

    private SurfaceView mSurfaceView;
    private Camera mCamera;
    private File picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mSurfaceView = (SurfaceView) findViewById(R.id.camera_surface);
        SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    public void takePicture(View view) {
//        mCamera.stopPreview();
        mCamera.takePicture(null, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camera, menu);
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

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = Camera.open();
        try {
            mCamera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Camera.Parameters mParameters = mCamera.getParameters();
        mParameters.setPictureFormat(PixelFormat.JPEG);
        mCamera.setDisplayOrientation(0);
        mCamera.setParameters(mParameters);
        mCamera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        new PictureTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, data);
        mCamera.startPreview();
    }

    private class PictureTask extends AsyncTask<byte[], String, String> {
        @Override
        protected String doInBackground(byte[]... params) {
            String fname = DateFormat.format("yyyyMMddhhmmss", new Date()).toString() + ".jpg";

            //picture = new File(Environment.getExternalStorageDirectory(),fname);// create file

            picture = new File(Environment.getExternalStorageDirectory() + File.separator + fname);

            try {
                FileOutputStream fos = new FileOutputStream(picture.getPath()); // Get file output stream
                fos.write(params[0]); // Written to the file
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
