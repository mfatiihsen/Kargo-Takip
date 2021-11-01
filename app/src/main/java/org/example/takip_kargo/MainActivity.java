package org.example.takip_kargo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mfs.takip_kargo.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btn_surat;
    private ImageView btn_aras;
    private ImageView btn_ptt;
    private ImageView btn_ups;
    private ImageView btn_yurtici;
    private ImageView btn_mng;
    private TextView yazi;
    private NavigationView navigationView;
    Toolbar toolbar;
    private DrawerLayout drawer;
    private ImageView menu_btn;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tanim();
        Click();

        Ads();


        menu_btn = (ImageView) findViewById(R.id.imageMenu);
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secenek = new Intent(MainActivity.this, Menu_Activity.class);
                startActivity(secenek);
            }
        });
    }

    public void Ads() {

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-4365766653931652/1939795021");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    //tanımlama işlemleri
    public void Tanim() {
        btn_surat = (ImageView) findViewById(R.id.surat);
        btn_aras = (ImageView) findViewById(R.id.aras);
        btn_ptt = (ImageView) findViewById(R.id.ptt);
        btn_ups = (ImageView) findViewById(R.id.ups);
        btn_yurtici = (ImageView) findViewById(R.id.yurtici);
        btn_mng = (ImageView) findViewById(R.id.mng);
    }

    // butonlara tıklama
    public void Click() {
        btn_surat.setOnClickListener(this);
        btn_aras.setOnClickListener(this);
        btn_ptt.setOnClickListener(this);
        btn_ups.setOnClickListener(this);
        btn_yurtici.setOnClickListener(this);
        btn_mng.setOnClickListener(this);
    }

    //butonlara tıklama operasyonu
    @Override
    public void onClick(View v) {
        if (v.getId() == btn_surat.getId()) {
            System.out.println("Surat Kargo tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            //progresLayout.setVisibility(View.VISIBLE);
            Intent surat = new Intent(this, surat.class);
            startActivity(surat);
        } else if (v.getId() == btn_aras.getId()) {
            System.out.println("Aras Kargoya Tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            Intent aras = new Intent(this, aras.class);
            startActivity(aras);
        } else if (v.getId() == btn_ptt.getId()) {
            System.out.println("Ptt Kargo tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            Intent ptt = new Intent(this, ptt.class);
            startActivity(ptt);
        } else if (v.getId() == btn_ups.getId()) {
            System.out.println("Ups Kargo tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            Intent ups = new Intent(this, ups.class);
            startActivity(ups);
        } else if (v.getId() == btn_yurtici.getId()) {
            System.out.println("Yurt İçi  kargoya Tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            Intent yurt_ici = new Intent(this, yurt_ici.class);
            startActivity(yurt_ici);
        } else if (v.getId() == btn_mng.getId()) {
            System.out.println("MNG Kargo tıklandı");
            //progressBar.setVisibility(View.VISIBLE);
            Intent mng = new Intent(this, mng.class);
            startActivity(mng);
        } else {
            Toast.makeText(this, "Hata Oluştu lütfen tekrar deneyin", Toast.LENGTH_LONG).show();
        }
    }


}

