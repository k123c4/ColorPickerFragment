package com.example.colorpicker;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class ColorsViewModel extends ViewModel {

    private MutableLiveData<LinkedList<String>> colorsll;
    public void  setColors(LinkedList<String> l){
        colorsll.setValue(l);
    }

    public ColorsViewModel() {
        this.colorsll = new MutableLiveData<>();
    }

    public LinkedList<String> getcolors(){
        return colorsll.getValue();
    }

    public void addColorsll(String c){
        LinkedList<String> l = getcolors();
        l.add(c);
        colorsll.setValue(l);
    }
}
