package com.xinxue.ftputils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String pName = "com.estrongs.android.pop";
    private Button newestNotice, yinShi, eBook, zhuDi;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getPackageManager().getLaunchIntentForPackage(pName);
        judgeCopy();
        init();
    }

    private void judgeCopy() {
        if (!MyApplication.isBuyed) {
            Toast.makeText(this, "该版本为未授权版，只能使用5分钟", Toast.LENGTH_LONG).show();
            AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intent1 = new Intent(this, ExitActivity.class);
            PendingIntent intent = PendingIntent.getActivity(this, 0, intent1, 0);
            manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5 * 1000*60, intent);
        }
    }

    private void init() {
        newestNotice = (Button) findViewById(R.id.newestNotice);
        yinShi = (Button) findViewById(R.id.yinShi);
        eBook = (Button) findViewById(R.id.eBook);
        zhuDi = (Button) findViewById(R.id.zhuDi);
        yinShi.setOnClickListener(this);
        eBook.setOnClickListener(this);
        zhuDi.setOnClickListener(this);
        newestNotice.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eBook:
                startActivity(intent);
                break;
            case R.id.zhuDi:
                startActivity(intent);
                break;
            case R.id.yinShi:
                startActivity(intent);
                break;
            case R.id.newestNotice:

                break;
        }
    }
}
