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

public class Social_Media extends AppCompatActivity {

    Toolbar toolbar;
    ImageView wp;
    ImageView Ig;
    ImageView dc;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social__media);

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-4365766653931652/1754826722");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolbar = (Toolbar) findViewById(R.id.socialToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        wp = (ImageView) findViewById(R.id.whatsapp);
        Ig = (ImageView) findViewById(R.id.instagram);
        dc = (ImageView) findViewById(R.id.discord);

        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatapp = new Intent(Intent.ACTION_VIEW,Uri.parse("https://chat.whatsapp.com/ENYrQlpOS3vJVbUmxZhBUm"));
                startActivity(whatapp);
            }
        });

        Ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instagram = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/yazilimcgenc/?hl=tr"));
                startActivity(instagram);
            }
        });
        dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discord = new Intent(Intent.ACTION_VIEW,Uri.parse("https://discord.gg/3mVDYfhAUB"));
                startActivity(discord);
            }
        });
    }

    // toolbar geri tuşu
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