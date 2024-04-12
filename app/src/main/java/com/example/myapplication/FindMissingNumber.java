package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class FindMissingNumber extends AppCompatActivity {
    com.example.myapplication.databinding.MncBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.myapplication.databinding.MncBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.editText.setVisibility(View.GONE);
        binding.submit.setOnClickListener(v -> new Thread(() -> {
            int[] arr = {6, 7, 8, 9, 11, 12, 13, 14, 15};
            find(arr);
        }).start());
    }


    public void find(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != 1) {
                int finalI = i;
                runOnUiThread(() -> binding.result.setText(Arrays.toString(arr) + ": " + (arr[finalI - 1] + 1) + ""));
                return;
            }
        }
    }
}

