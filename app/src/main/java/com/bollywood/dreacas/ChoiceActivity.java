package com.bollywood.dreacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bollywood.dreacas.databinding.ActivityChoiceBinding;

public class ChoiceActivity extends AppCompatActivity {

    private ActivityChoiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGamesPressed();
            }
        });

        binding.buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onExitPressed();
            }
        });
    }

    public void onGamesPressed() {
        startActivity(new Intent(this, FirstGameChoiceActivity.class));
    }

    public void onExitPressed() {
        finish();
    }
}
