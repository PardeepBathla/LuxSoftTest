package com.example.luxpmtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.luxpmtestapp.databinding.ActivityRegisterationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegisterationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registeration);

        binding.tvAlreadyAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginScreen();
            }
        });

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.etEmail.getText().toString().trim();
                String pass = binding.etPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegistrationActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Utils.isValidEmail(email)) {
                    Toast.makeText(RegistrationActivity.this, "Please provide the valid email format", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(RegistrationActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Utils.isValidPass(pass)) {
                    Toast.makeText(RegistrationActivity.this, "Please provide valid password", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

    }

    private void goToLoginScreen() {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}