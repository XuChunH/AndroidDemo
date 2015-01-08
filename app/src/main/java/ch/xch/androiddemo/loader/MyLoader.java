package ch.xch.androiddemo.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by XCH on 2015/1/8.
 */
public class MyLoader extends AsyncTaskLoader {

    public MyLoader(Context context) {
        super(context);
        System.out.println("init a loader object");
    }

    @Override
    public Object loadInBackground() {
        Toast.makeText(getContext(), "loader get a message : Hello World !", Toast.LENGTH_SHORT).show();
        return "loader get a message : Hello World !";
    }
}
