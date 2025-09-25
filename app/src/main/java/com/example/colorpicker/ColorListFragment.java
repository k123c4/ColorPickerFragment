package com.example.colorpicker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorListFragment extends Fragment {

    public ColorListFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ColorListFragment newInstance(String param1, String param2) {
        ColorListFragment fragment = new ColorListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_list, container, false);
    }
}