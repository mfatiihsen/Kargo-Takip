package org.example.takip_kargo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.mfs.takip_kargo.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar pb;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Prog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(start);
                finish();
            }
        }, 2200);
    }

    public void Prog() {
        pb = (ProgressBar) findViewById(R.id.progresBar_surat);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter == 50) {
                    t.cancel();
                    System.out.println("İşlem bitti");
                }
            }
        };
        t.schedule(tt, 90, 50);
    }
}