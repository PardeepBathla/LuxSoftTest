package com.example.luxpmtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.luxpmtestapp.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {
    ActivityWelcomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        binding.btnSignup.setOnClickListener(view -> goToRegistrationScreen());



    }

    private void goToRegistrationScreen(){
        startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
    }
}