package com.a4gumel.upay.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.a4gumel.upay.R;
import com.a4gumel.upay.activity.IMainActivity;
import com.a4gumel.upay.activity.MainActivity;
import com.a4gumel.upay.adapter.OnBoardingAdapter;
import com.a4gumel.upay.databinding.FragmentOnboardingBinding;
import com.a4gumel.upay.models.OnBoardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingFragment extends Fragment {

    private FragmentOnboardingBinding onBoardingBinding;
    private OnBoardingAdapter onBoardingAdapter;
    private IMainActivity iMainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_onboarding, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onBoardingBinding = FragmentOnboardingBinding.bind(view);

        setUpOnBoardingItems();
        setUpOnBoardingIndicators();

        onBoardingBinding.introPager.setAdapter(onBoardingAdapter);

        onBoardingBinding.introPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setUpCurrentIndicators(position);
            }
        });

        onBoardingBinding.nextBtn.setOnClickListener(view1 -> {

            int currentItem = onBoardingBinding.introPager.getCurrentItem() + 1;

            if (currentItem < onBoardingAdapter.getItemCount()) {

                onBoardingBinding.introPager.setCurrentItem(currentItem);

            } else {

                iMainActivity.navigateToAccount();

            }
        });


    }

    private void setUpOnBoardingItems() {

        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem onBoardingItemBest = new OnBoardingItem();
        onBoardingItemBest.setImage(R.drawable.undraw_transfer_money);
        onBoardingItemBest.setTitle(getString(R.string.on_boarding_heading_1));

        OnBoardingItem onBoardingItemFinance = new OnBoardingItem();
        onBoardingItemFinance.setImage(R.drawable.undraw_mobile_pay);
        onBoardingItemFinance.setTitle(getString(R.string.on_boarding_heading_2));

        OnBoardingItem onBoardingItemMobile = new OnBoardingItem();
        onBoardingItemMobile.setImage(R.drawable.undraw_happy_news);
        onBoardingItemMobile.setTitle(getString(R.string.on_boarding_heading_3));

        onBoardingItems.add(onBoardingItemBest);
        onBoardingItems.add(onBoardingItemFinance);
        onBoardingItems.add(onBoardingItemMobile);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setUpOnBoardingIndicators() {

        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMarginEnd(8);
        layoutParams.setMarginStart(8);

        for (int i = 0; i < indicators.length; i++) {

            indicators[i] = new ImageView(getContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getContext(),
                    R.drawable.onboarding_indicator_inactive));

            indicators[i].setLayoutParams(layoutParams);
            onBoardingBinding.indicatorLayout.addView(indicators[i]);
        }
    }

    private void setUpCurrentIndicators(int index) {

        int childCount = onBoardingBinding.indicatorLayout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) onBoardingBinding.indicatorLayout.getChildAt(i);

            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(),
                        R.drawable.onboarding_indicator_active));
            } else {

                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(),
                        R.drawable.onboarding_indicator_inactive));
            }
        }

        if (index == onBoardingAdapter.getItemCount() - 1) {

            onBoardingBinding.nextBtn.setText(getString(R.string.get_started));

        } else {

            onBoardingBinding.nextBtn.setText(getString(R.string.next));

        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iMainActivity = (MainActivity) getActivity();
    }
}