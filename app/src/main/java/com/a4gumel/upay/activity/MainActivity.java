package com.a4gumel.upay.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.a4gumel.upay.R;
import com.a4gumel.upay.databinding.ActivityMainBinding;
import com.a4gumel.upay.fragments.AccountFragment;
import com.a4gumel.upay.fragments.OnBoardingFragment;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "MainActivity";

    private ActivityMainBinding mainBinding;
    private OnBoardingFragment onBoardingFragment = new OnBoardingFragment();
    private AccountFragment accountFragment = new AccountFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainBinding.bottomNavView.setBackground(null);

        setOnBoardingFragment();

        try {
            setContentView(mainBinding.getRoot());

        } catch (Exception e) {

            Log.e(TAG, e.toString());

        }
    }

    private void setOnBoardingFragment() {

        mainBinding.bottomAppBar.setVisibility(View.GONE);
        mainBinding.navHostFragment.setVisibility(View.GONE);
        mainBinding.scanFab.setVisibility(View.GONE);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragmentContainer, onBoardingFragment);
        // Complete the changes added above
        ft.commit();

    }

    @Override
    public void navigateToHome() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.remove(onBoardingFragment);
        ft.commit();

        mainBinding.fragmentContainer.setVisibility(View.GONE);
        mainBinding.scanFab.setVisibility(View.VISIBLE);
        mainBinding.bottomAppBar.setVisibility(View.VISIBLE);
        mainBinding.navHostFragment.setVisibility(View.VISIBLE);
    }

    @Override
    public void navigateToAccount() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragmentContainer, accountFragment);
        ft.commit();

    }
}