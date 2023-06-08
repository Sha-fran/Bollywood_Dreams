package com.bollywood.dreacas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bollywood.dreacas.databinding.ActivityYourBinding;

public class YourActivity extends AppCompatActivity {
    private ActivityYourBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEmailPressed();
            }
        });

        binding.buttonAnonymus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnonymusPressed();
            }
        });
    }

    public void onEmailPressed() {
        startActivity(new Intent(this, PutEmailActivity.class));
    }

    public void onAnonymusPressed() {
        startActivity(new Intent(this, ChoiceActivity.class));
    }

}
