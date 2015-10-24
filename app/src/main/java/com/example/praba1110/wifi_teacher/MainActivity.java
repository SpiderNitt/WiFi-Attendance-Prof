package com.example.praba1110.wifi_teacher;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progress;
    String s1,s2;
    TextView time;
    String[] students_present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time= (TextView) findViewById(R.id.textView);
        progress=new ProgressDialog(this);
        progress.setMessage("Discovering devices..");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void attendance(View v){
        final discovery d=new discovery();
        d.start_discovery();
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                progress.show();
                //time.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                progress.dismiss();
                Toast.makeText(getApplicationContext(),"Attendance taken",Toast.LENGTH_SHORT).show();
                d.end_discovery();
                s1=d.getDevices()[0];
                s2=d.getDevices()[1];
                students_present=d.getDevices();
                Intent intent=new Intent(getApplicationContext(),List.class);
                Bundle b=new Bundle();
                b.putStringArray("presentees", students_present);
                intent.putExtras(b);
                startActivity(intent);
            }
        }.start();
     /*  Toast.makeText(this, s1, Toast.LENGTH_SHORT).show();
        new CountDownTimer(4000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_SHORT).show();
            }
        }.start();
*/
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
