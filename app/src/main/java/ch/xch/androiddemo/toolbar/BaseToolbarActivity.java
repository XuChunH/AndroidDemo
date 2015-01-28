package ch.xch.androiddemo.toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;

import ch.xch.androiddemo.R;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Administrator on 2015/1/23.
 */
public abstract class BaseToolbarActivity extends ActionBarActivity {

    protected Toolbar toolbar;
    protected int contentViewRes = R.layout.activity_toolbar;
    protected String activityTitle = "";

    /**
     * Toolbar既可作为Actionbar的替代品使用，也可作为单独的控件使用，
     * 故这里不使用setSupportActionBar的方法直接将ActionBar替代为Toolbar，具体的操作在子类中完成
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentViewRes);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        initActivityTitle();
    }

    protected void setActivityTitle(int resId){
        activityTitle = getString(resId);
    }

    protected void setActivityTitle(String title){
        activityTitle = title;
    }

    /**
     * 按照生活中的习惯，一个界面的Title应居中，
     * 而Toolbar的Title居左，可作为指示器的作用（具体的要视UI效果而定）
     */
    private void initActivityTitle(){
        if(TextUtils.isEmpty(activityTitle)){
            return;
        }
        TextView tvTitle = new TextView(this);
        tvTitle.setText(activityTitle);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Gravity.CENTER_HORIZONTAL);
        tvTitle.setLayoutParams(params);
        toolbar.addView(tvTitle);
    }

}
