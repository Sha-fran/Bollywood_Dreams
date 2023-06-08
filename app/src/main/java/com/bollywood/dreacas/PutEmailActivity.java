package com.bollywood.dreacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bollywood.dreacas.databinding.ActivityPutEmailBinding;

public class PutEmailActivity extends AppCompatActivity {
    ActivityPutEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPutEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onContinuePressed();
            }
        });
    }

    public void onContinuePressed() {
        startActivity(new Intent(this, ChoiceActivity.class));
    }
}