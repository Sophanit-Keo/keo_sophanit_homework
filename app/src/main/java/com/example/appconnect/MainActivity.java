package com.example.appconnect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appconnect.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            loginUser();
        });

        binding.txtForgotPassword.setOnClickListener(v -> {

        });
    }

    private void loginUser() {

        String email =
                binding.editEmail.getText() != null
                        ? binding.editEmail.getText().toString().trim()
                        : "";

        String password =
                binding.editPassword.getText() != null
                        ? binding.editPassword.getText().toString()
                        : "";

        binding.emailLayout.setError(null);
        binding.passwordLayout.setError(null);

        if (email.isEmpty()) {
            binding.emailLayout.setError(
                    "Enter your email or username"
            );
            return;
        }

        if (password.isEmpty()) {
            binding.passwordLayout.setError(
                    "Enter your password"
            );
            return;
        }
    }
}