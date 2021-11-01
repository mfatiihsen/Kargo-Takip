package org.example.takip_kargo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mfs.takip_kargo.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Applications extends AppCompatActivity {

    Toolbar toolbar;
    private ImageView flapy;
    private ImageView yemek_ta;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications);


        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-4365766653931652/1670178196");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolbar = (Toolbar) findViewById(R.id.appToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        flapy = (ImageView) findViewById(R.id.flapy);
        yemek_ta = (ImageView) findViewById(R.id.yemekTarif);

        flapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent app1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=org.mfs.first_my_game"));
                startActivity(app1);
                //https://play.google.com/store
            }
        });
        yemek_ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent app2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=org.mfs.yeni_uygulama"));
                startActivity(app2);
            }
        });
    }


    // Toolbar geri butonu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent geriButonu = new Intent(getApplicationContext(), Menu_Activity.class);
            NavUtils.navigateUpTo(this, geriButonu);
            return true;
        }
        return true;
    }
}