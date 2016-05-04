package com.acadgild.balu.acd_an_session_16_assignment_1_main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView textView_batterylevel;

    private BroadcastReceiver broadcastReceiver_batterylevel = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            int battery_level = intent.getIntExtra("level", 0);
            textView_batterylevel.setText(String.format(getResources().
                        getString(R.string.batterylevel), Integer.toString(battery_level) + "%"));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_batterylevel = (TextView) findViewById(R.id.textView_batterylevel);

        registerReceiver(broadcastReceiver_batterylevel, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver_batterylevel);
    }
}
