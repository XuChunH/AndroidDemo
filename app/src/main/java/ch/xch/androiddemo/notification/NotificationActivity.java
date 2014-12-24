package ch.xch.androiddemo.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

import ch.xch.androiddemo.R;

public class NotificationActivity extends Activity {

    private TextView tvPath;
    private String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/temp.txt";
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        tvPath = (TextView) findViewById(R.id.notification_path);
        tvPath.setText(filePath);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void post(View view) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_LIGHTS);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle(getString(R.string.activity_notification_noti_title));
        builder.setContentText(getString(R.string.activity_notification_noti_content));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setDataAndType(Uri.parse(filePath), "text/plain");
//        intent.setData(Uri.parse(filePath));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        mNotificationManager.notify(new Random().nextInt(10), builder.build());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification, menu);
        return false;
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
