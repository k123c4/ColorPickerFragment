package com.example.colorpicker;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

import kotlin.collections.UCollectionsKt;

public class ColorsViewModel extends ViewModel {

    private MutableLiveData<LinkedList<String>> colorsll;

    public void  setColors(LinkedList<String> l){
        colorsll.setValue(l);


    }

    public ColorsViewModel() {
        this.colorsll = new MutableLiveData<>();
        LinkedList<String> l = new LinkedList<>();
        colorsll.setValue(l);
    }
    public void setColorsll(LinkedList<String> l){
        colorsll.setValue(l);
    }

    public MutableLiveData<LinkedList<String>> getColorsll(){
        return colorsll;
    }

    public void addColors(String c){
        LinkedList<String> l = getColorsll().getValue();
        l.add(c);
        Log.i("Colors",l.toString());
        colorsll.setValue(l);
    }
}
