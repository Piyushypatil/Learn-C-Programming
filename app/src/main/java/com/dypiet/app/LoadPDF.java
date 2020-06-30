package com.dypiet.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoadPDF extends AppCompatActivity {
    private static final String TAG = "LoadPDF";
    WebView pdfView;
    TextView pdfurl;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         pdfView = findViewById(R.id.pdf);
         pdfurl = findViewById(R.id.pd);
         progressBar = findViewById(R.id.prob);
        Snackbar.make(findViewById (android.R.id.content),"Wait Page is under Loading  !!!",Snackbar.LENGTH_LONG).show ();
        progressBar.setVisibility(View.VISIBLE);
                 String url = getIntent().getStringExtra("url");
                 Log.e("URL",url);
                 if (url == null) {
                     Log.e(TAG, "'url' must be specified");
                 }
                 else {
                     pdfView.getSettings().setBuiltInZoomControls(true);
                     pdfView.loadUrl(url);
                     finish();
                 }

        }



}

