package com.example.colorpicker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class ColorListFragment extends Fragment {
    private ColorsViewModel ColorsModel;
    ListView  ListViewWidget;
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
        View view = inflater.inflate(R.layout.fragment_color_list,container,false);
        ListViewWidget = view.findViewById(R.id.elements);
        return view;

    }
    @Override
    public void onViewCreated(View view,Bundle savedInstance )
    {
     ColorsModel = new ViewModelProvider(getActivity()).get(ColorsViewModel.class);
     ColorsModel.getColorsll().observe(getViewLifecycleOwner(), new Observer<LinkedList<String>>() {
         @Override
         public void onChanged(LinkedList<String> strings) {
             ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ColorsModel.getColorsll().getValue());
             ListViewWidget.setAdapter(adapter);
         }
     });
    }
}