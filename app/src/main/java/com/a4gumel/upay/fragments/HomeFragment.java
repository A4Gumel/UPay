package com.a4gumel.upay.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a4gumel.upay.R;
import com.a4gumel.upay.activity.MainActivity;
import com.a4gumel.upay.databinding.ActivityMainBinding;
import com.a4gumel.upay.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding homeBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeBinding = FragmentHomeBinding.bind(view);
        Activity activity = new Activity();
        NavController navController = Navigation.findNavController(view);

        navController.navigate(HomeFragmentDirections.actionHomeFragmentToOnBoardingFragment());
    }
}