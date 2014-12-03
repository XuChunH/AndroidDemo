package ch.xch.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.xch.androiddemo.utils.Constant;
import ch.xch.androiddemo.utils.SharedPreferencesUtil;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private SharedPreferencesUtil spUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spUtil = new SharedPreferencesUtil(this);
        if (spUtil.getTheme() == Constant.THEME_LIGHT) {
            setTheme(R.style.MyTheme_Light);
        }
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), android.R.layout.simple_list_item_1, new String[]{Constant.TEXT_TITLE}, new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_change_theme) {
            spUtil.setTheme(spUtil.getTheme() == Constant.THEME_LIGHT ? Constant.THEME_DARK : Constant.THEME_LIGHT);
            Intent restartIntent = new Intent(this, MainActivity.class);
            restartIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(restartIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_change_theme);
        if (new SharedPreferencesUtil(this).getTheme() == Constant.THEME_LIGHT) {
            item.setIcon(R.drawable.ic_action_theme_dark);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Intent broadcastIntent = new Intent(Constant.ACTION_DEFAULT, null);
        broadcastIntent.addCategory(Constant.CATEGORY_DEFAULT);
        PackageManager pm = getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentActivities(broadcastIntent, 0);
        if (infos != null) {
            for (ResolveInfo info : infos) {
                CharSequence label = info.loadLabel(pm);
                if (TextUtils.isEmpty(label)) {
                    label = info.activityInfo.name;
                }
                Intent intent = new Intent();
                intent.setClassName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
                Map<String, Object> item = new HashMap<String, Object>();
                item.put(Constant.TEXT_TITLE, label);
                item.put(Constant.TEXT_INTENT, intent);
                data.add(item);
            }
        }
        return data;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "position: " + position + " id: " + id, Toast.LENGTH_SHORT).show();
    }

}
