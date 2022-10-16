package com.a4gumel.upay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a4gumel.upay.R;
import com.a4gumel.upay.databinding.OnboardingLayoutBinding;
import com.a4gumel.upay.models.OnBoardingItem;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder> {


    private List<OnBoardingItem> onBoardingItems;

    public OnBoardingAdapter(List<OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.onboarding_layout,
                                parent,
                                false)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {

        holder.setData(onBoardingItems.get(position));

    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder {

        private TextView heading;
        private ImageView image;

        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            OnboardingLayoutBinding onboardingLayoutBinding = OnboardingLayoutBinding.bind(itemView);
            heading = onboardingLayoutBinding.onBoardingTitle;
            image = onboardingLayoutBinding.onBoardingImage;
        }

        void setData(OnBoardingItem onBoardingItem) {

            heading.setText(onBoardingItem.getTitle());
            image.setImageResource(onBoardingItem.getImage());
        }

    }
}
