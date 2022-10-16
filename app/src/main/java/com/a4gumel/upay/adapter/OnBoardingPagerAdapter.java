package com.a4gumel.upay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.a4gumel.upay.R;
import com.a4gumel.upay.databinding.OnboardingLayoutBinding;

public class OnBoardingPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OnBoardingPagerAdapter(Context context) {
        this.context = context;
    }

    public int[] sliderImages = {
            R.drawable.undraw_transfer_money,
            R.drawable.undraw_happy_news,
            R.drawable.undraw_mobile_pay

    };

    public String[] sliderHeadings = {
            context.getString(R.string.slider_heading_2),
            context.getString(R.string.slider_heading_1),
            context.getString(R.string.slider_heading_3)
    };

    @Override
    public int getCount() {
        return sliderHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_layout, container, false);

        OnboardingLayoutBinding onboardingLayoutBinding = OnboardingLayoutBinding.bind(view);
        TextView heading = onboardingLayoutBinding.onBoardingTitle;
        ImageView image = onboardingLayoutBinding.onBoardingImage;

        image.setImageResource(sliderImages[position]);
        heading.setText(sliderHeadings[position]);

        container.addView(view);


        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
