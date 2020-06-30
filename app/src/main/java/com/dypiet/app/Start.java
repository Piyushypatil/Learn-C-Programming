package com.dypiet.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.dypiet.app.fragment.ExpandableListFragment;
import com.dypiet.app.fragment.PpaperFragment;
import com.dypiet.app.fragment.TempFragment;
import com.dypiet.app.fragment.TestFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment testFragment;
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    } String title = "";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmentselected =null;
            switch (item.getItemId()) {

                case R.id.navigation_theory:
                    title = "Theory";
                   fragmentselected=new ExpandableListFragment();
                    break;

                case R.id.navigation_QPaper:
                    title = "Online Test";
                    fragmentselected = new TestFragment();
                    break;
                case R.id.navigation_Test:
                    title = "Program";
                    fragmentselected = new PpaperFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragmentselected).commit();
            getSupportActionBar().setTitle(title);


            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container, new ExpandableListFragment());
        tx.commit();
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        getSupportActionBar().setTitle("Learn Programming");
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(!isConnected ()){
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_warning)
                    .setTitle("No Internet !")
                    .setCancelable (false)
                    .setMessage("Please turn on data or Wi-Fi to access this app")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish ();
                        }

                    })
                    .show();
        }
    }
    public boolean isConnected(){
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

}
