package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CountWay extends AppCompatActivity {
    com.example.myapplication.databinding.MncBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.myapplication.databinding.MncBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.submit.setOnClickListener(v -> new Thread(() -> {
            int i = countWays(Integer.parseInt(binding.editText.getText().toString().trim()));
            runOnUiThread(() -> binding.result.setText(i + ""));
        }).start());
    }

    private int countWays(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        ways[2] = 4;

        for (int i = 3; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }

        return ways[n - 1];
    }


}
