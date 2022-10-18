package com.a4gumel.upay.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a4gumel.upay.R;
import com.a4gumel.upay.activity.IMainActivity;
import com.a4gumel.upay.activity.MainActivity;
import com.a4gumel.upay.databinding.FragmentAccountBinding;
import com.a4gumel.upay.databinding.FragmentOnboardingBinding;


public class AccountFragment extends Fragment {


    private FragmentAccountBinding fragmentAccountBinding;
    private IMainActivity iMainActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentAccountBinding = FragmentAccountBinding.bind(view);

        fragmentAccountBinding.includedCreateOrLogin.signBtn.setOnClickListener(view1 -> {

            iMainActivity.navigateToHome();

        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iMainActivity = (MainActivity) getActivity();
    }
}