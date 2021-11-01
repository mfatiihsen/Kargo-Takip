package org.example.takip_kargo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mfs.takip_kargo.R;
import com.google.android.gms.ads.AdView;

import java.util.Timer;
import java.util.TimerTask;

public class mng extends AppCompatActivity {
    private WebView webView;
    private ProgressBar pb;
    int counter = 0;
    RelativeLayout surat;
    private AdView mAdView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mng);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-4365766653931652/7538781656");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        toolbar = (Toolbar) findViewById(R.id.toolbar_aras);
        setSupportActionBar(toolbar);
        toolbar.setTitle("MNG Kargo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.web_view_mng);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });
        webView.loadUrl("https://www.mngkargo.com.tr/gonderitakip");

        Prog();
        surat = (RelativeLayout) findViewById(R.id.surat_layout);
        webView = (WebView) findViewById(R.id.web_view_mng);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent geriButonu = new Intent(getApplicationContext(), MainActivity.class);
            NavUtils.navigateUpTo(this, geriButonu);
            return true;
        }
        return true;
    }


    public void Prog(){
        pb = (ProgressBar) findViewById(R.id.progresBar_surat);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter == 50){
                    t.cancel();
                    System.out.println("İşlem bitti");
                    surat.setVisibility(View.INVISIBLE);
                }
            }
        };
        t.schedule(tt,0,50);
    }
}