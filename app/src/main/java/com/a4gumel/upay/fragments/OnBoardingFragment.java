package com.a4gumel.upay.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.a4gumel.upay.R;
import com.a4gumel.upay.adapter.OnBoardingPagerAdapter;
import com.a4gumel.upay.databinding.FragmentOnboardingBinding;
import com.google.android.material.button.MaterialButton;

public class OnBoardingFragment extends Fragment {

    private FragmentOnboardingBinding onBoardingBinding;
    private OnBoardingPagerAdapter onBoardingPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onBoardingBinding = FragmentOnboardingBinding.bind(view);

        ViewPager sliderViewPager = onBoardingBinding.introPager;
        LinearLayout indicatorLayout = onBoardingBinding.indicatorLayout;
        MaterialButton nextBtn = onBoardingBinding.nextBtn;

        onBoardingPagerAdapter = new OnBoardingPagerAdapter(getContext());

        sliderViewPager.setAdapter(onBoardingPagerAdapter);

    }
}