package com.a4gumel.upay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.util.Log;

import com.a4gumel.upay.R;
import com.a4gumel.upay.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainBinding.bottomNavView.setBackground(null);

        try {
            setContentView(mainBinding.getRoot());

        } catch (Exception e) {

            Log.e(TAG, e.toString());

        }
    }
}