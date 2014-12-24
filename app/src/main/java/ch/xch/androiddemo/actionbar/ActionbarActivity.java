package ch.xch.androiddemo.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ch.xch.androiddemo.R;

public class ActionbarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ActionBar actionBar = getActionBar();

        /* 显示返回上一级菜单键，需要在Manifest中设置属性parentActivityName（API16以下需在<activity/>标签中加入<meta-data
            android:name="android.support.PARENT_ACTIVITY"
            android:value=".MainActivity" />）。 当返回的上一级更具情况不同的时候，采用覆写 getSupportParentActivityIntent()
             和 onCreateSupportNavigateUpTaskStack()的方法*/
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("");
        actionBar.setCustomView(R.layout.activity_actionbar);
//        actionBar.setIcon(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
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
}
