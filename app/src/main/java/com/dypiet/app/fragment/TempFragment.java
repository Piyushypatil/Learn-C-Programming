package com.dypiet.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dypiet.app.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TempFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.activity_main, container, false);

    }
}
