package com.example.luxpmtestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.luxpmtestapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private String username = "test@luxpmsoft.com";
    private String password = "test1234!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);


        binding.tvDontHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });
        binding.btnLogin.setOnClickListener(view -> {

            String email = binding.etEmail.getText().toString().trim();
            String pass = binding.etPass.getText().toString().trim();


            if (TextUtils.isEmpty(email)){
                Toast.makeText(LoginActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Utils.isValidEmail(email)) {
                Toast.makeText(LoginActivity.this, "Please provide the valid email format", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!email.equals(username)) {
                Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(pass)){
                Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();

                return;
            }

            if (pass.length() < 8) {
                Toast.makeText(this, "Length should not be less than 8", Toast.LENGTH_SHORT).show();

                return;
            }

            if (!pass.equals(password)) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();

                return;
            }


            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        });
    }
}