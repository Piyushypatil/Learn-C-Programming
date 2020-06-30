package com.dypiet.app;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.dypiet.app.Model.QuestionPaperPDF;
import com.dypiet.app.fragment.PPaperAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.intellij.lang.annotations.Language;

public class PPaperViewActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DatabaseReference mDatabase;
    PPaperAdapter mAdapter;
    RecyclerView mRecycler;
    LottieAnimationView animationView;


    private ArrayList<QuestionPaperPDF> mPaperList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppdf);
        mRecycler = findViewById(R.id.recycler_view);
        animationView = findViewById(R.id.animation_view);

        String language=getIntent().getStringExtra("Language");
        String  branch =getIntent().getStringExtra("Branch");
        Log.e("NULL","'branch' is "+branch);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Program").child(branch);

        mPaperList = new ArrayList<>();

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    QuestionPaperPDF questionPaper = snapshot.getValue(QuestionPaperPDF.class);
                    mPaperList.add(questionPaper);
                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                animationView.setVisibility (View.GONE);
            }
        });

        mAdapter = new PPaperAdapter(mPaperList,this);
        RecyclerView.LayoutManager recyce = new GridLayoutManager(this,2);
        mRecycler.setLayoutManager(recyce);
        mRecycler.setItemAnimator( new DefaultItemAnimator());
        mRecycler.setAdapter(mAdapter);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}