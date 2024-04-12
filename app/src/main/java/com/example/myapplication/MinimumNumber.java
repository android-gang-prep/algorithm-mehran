package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.MncBinding;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumber extends AppCompatActivity {

    MncBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MncBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(() -> getMinimumNumber(Integer.parseInt(binding.editText.getText().toString().trim()))).start();
            }
        });
    }

    private void getMinimumNumber(int num) {
        Integer[] coins = new Integer[]{25, 10, 5, 1};
        List<Integer> coins2 = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < coins.length; i++) {
            while (total < num) {
                total += coins[i];
                coins2.add(coins[i]);
            }
            if (total > num) {
                total -= coins[i];
                coins2.remove(coins2.size() - 1);
            }
            if (total == num) {
                String str = "Size:"+coins2.size()+" \n";
                for (int j = 0; j < coins2.size(); j++) {
                    str += " " + coins2.get(j);
                }
                String finalStr = str;
                runOnUiThread(() -> binding.result.setText(finalStr));

                return;
            }

        }
    }
}
