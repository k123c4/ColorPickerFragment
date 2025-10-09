package com.example.colorpicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceControl;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnMessageSendListener {

    FragmentManager fg;
    ColorsViewModel ColorsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Tag", String.valueOf(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)));
        if (ContextCompat.checkSelfPermission
                (this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            String[] perm = new String[]{Manifest.permission.RECEIVE_SMS};
            ActivityCompat.requestPermissions(this, perm, 67);
        }
        if (savedInstanceState == null) {
            ColorsModel = new ViewModelProvider(this).get(ColorsViewModel.class);
            fg = getSupportFragmentManager();
            FragmentTransaction trans = fg.beginTransaction();
            ColorPickFragment cf = new ColorPickFragment();
            trans.add(R.id.colorFragment,cf,"colorFrag");
            trans.commit();
            ColorListFragment cl = new ColorListFragment();
            trans.add(R.id.ListFragment,cl,"listFrag");
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String message = intent.getStringExtra("sms");
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMessageSend(String message) {

    }
}
