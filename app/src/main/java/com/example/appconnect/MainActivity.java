package com.example.appconnect;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appconnect.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.loginScreen.setOnClickListener(v -> hideKeyboard());

        binding.btnLogin.setOnClickListener(v -> {

        });

        binding.txtForgotPassword.setOnClickListener(v -> {

        });

        addTextInputListener();
    }

    private void hideKeyboard() {
        // Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();

        // If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void validateButtonState() {
        boolean isEmailEmpty = binding.editEmail.getText() == null || binding.editEmail.getText().toString().trim().isEmpty();
        boolean isPasswordEmpty = binding.editPassword.getText() == null || binding.editPassword.getText().toString().trim().isEmpty();

        binding.btnLogin.setEnabled(!isEmailEmpty && !isPasswordEmpty);
    }

    private void addTextInputListener() {
        TextWatcher handleTextChange = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateButtonState();
            }
        };

        binding.editEmail.addTextChangedListener(handleTextChange);
        binding.editPassword.addTextChangedListener(handleTextChange);
    }
}