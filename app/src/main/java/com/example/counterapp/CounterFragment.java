package com.example.counterapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.counterapp.databinding.FragmentCounterBinding;

public class CounterFragment extends Fragment {
    private FragmentCounterBinding binding;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCounterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnResult.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            String count = String.valueOf(counter);
            bundle.putString("key", count);
            ResultFragment resultFragment = new ResultFragment();
            resultFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, resultFragment).addToBackStack(null).commit();
        });

        binding.counterView.setText(String.valueOf(counter));



        binding.btnPlus.setOnClickListener(v -> {
            counter++;
            binding.counterView.setText(String.valueOf(counter));

        });

        binding.btnMinus.setOnClickListener(v -> {
            counter--;
            binding.counterView.setText(String.valueOf(counter));

        });

    }
}