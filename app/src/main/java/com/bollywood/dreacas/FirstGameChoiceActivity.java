package com.bollywood.dreacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bollywood.dreacas.databinding.ActivityFirstGameChoiceBinding;

public class FirstGameChoiceActivity extends AppCompatActivity {
    private ActivityFirstGameChoiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstGameChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.chooseButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressedChooseGame();
            }
        });
    }

    public void onPressedChooseGame() {
        startActivity(new Intent(this, GameOneActivity.class));
    }
}