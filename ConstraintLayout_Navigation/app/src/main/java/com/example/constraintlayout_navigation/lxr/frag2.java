package com.example.constraintlayout_navigation.lxr;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.constraintlayout_navigation.R;

public class frag2 extends Fragment {

    private View zj;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zj = inflater.inflate(R.layout.frag2_layout, null);
        return zj;
    }
}
