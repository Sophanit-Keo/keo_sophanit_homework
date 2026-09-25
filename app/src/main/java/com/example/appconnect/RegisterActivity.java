package com.example.appconnect;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appconnect.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainRegister, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.registerScreen.setOnClickListener(v -> hideKeyboard());

        // Sign Up button click
        binding.btnRegister.setOnClickListener(v -> {
            if(validatePassword()){
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

        setupTextWatchers();
    }
    // Hide keyboard
    private void hideKeyboard() {
        View currentFocused = getCurrentFocus();
        View view = currentFocused != null ? currentFocused : new View(this);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    // Validate button state based on input fields
    private void validateButtonState() {
        String username = binding.editUsername.getText() != null ? binding.editUsername.getText().toString().trim() : "";
        String email = binding.editEmail.getText() != null ? binding.editEmail.getText().toString().trim() : "";
        String password = binding.editPassword.getText() != null ? binding.editPassword.getText().toString().trim() : "";
        String confirmPassword = binding.editConfirmPassword.getText() != null ? binding.editConfirmPassword.getText().toString().trim() : "";

        boolean allFieldsFilled = !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty();
        binding.btnRegister.setEnabled(allFieldsFilled);
    }
    // Validate password match
    private boolean validatePassword() {
        String password = binding.editPassword.getText() != null ? binding.editPassword.getText().toString().trim() : "";
        String confirmPassword = binding.editConfirmPassword.getText() != null ? binding.editConfirmPassword.getText().toString().trim() : "";
        if (!password.equals(confirmPassword)) {
            binding.confirmPasswordLayout.setError("Passwords do not match");
            return false;
        }
        return true;
    }
    // Set up text watchers for input fields
    private void setupTextWatchers() {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.confirmPasswordLayout.setError(null);
                validateButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        binding.editUsername.addTextChangedListener(watcher);
        binding.editEmail.addTextChangedListener(watcher);
        binding.editPassword.addTextChangedListener(watcher);
        binding.editConfirmPassword.addTextChangedListener(watcher);
    }
}