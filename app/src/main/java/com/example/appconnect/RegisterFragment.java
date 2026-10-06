package com.example.appconnect;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.appconnect.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerScreen.setOnClickListener(v -> hideKeyboard());

        binding.txtBackToLogin.setOnClickListener(v -> 
            Navigation.findNavController(v).navigate(R.id.action_register_to_login)
        );

        binding.btnRegister.setOnClickListener(v -> {
            if (validatePassword()) {
                Toast.makeText(requireContext(), "Account created successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });

        setupTextWatchers();
    }

    // hide keyboard
    private void hideKeyboard() {
        if (getActivity() == null) return;
        View currentFocused = getActivity().getCurrentFocus();
        View targetView = currentFocused != null ? currentFocused : getView();
        if (targetView != null && getContext() != null) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(targetView.getWindowToken(), 0);
            }
        }
    }
    // validate button state
    private void validateButtonState() {
        if (binding == null) return;
        String username = binding.editUsername.getText() != null ? binding.editUsername.getText().toString().trim() : "";
        String email = binding.editEmail.getText() != null ? binding.editEmail.getText().toString().trim() : "";
        String password = binding.editPassword.getText() != null ? binding.editPassword.getText().toString().trim() : "";
        String confirmPassword = binding.editConfirmPassword.getText() != null ? binding.editConfirmPassword.getText().toString().trim() : "";

        boolean allFieldsFilled = !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty();
        binding.btnRegister.setEnabled(allFieldsFilled);
    }

    private boolean validatePassword() {
        if (binding == null) return false;
        String password = binding.editPassword.getText() != null ? binding.editPassword.getText().toString().trim() : "";
        String confirmPassword = binding.editConfirmPassword.getText() != null ? binding.editConfirmPassword.getText().toString().trim() : "";
        if (!password.equals(confirmPassword)) {
            binding.confirmPasswordLayout.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private void setupTextWatchers() {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding != null) {
                    binding.confirmPasswordLayout.setError(null);
                    validateButtonState();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        };

        binding.editUsername.addTextChangedListener(watcher);
        binding.editEmail.addTextChangedListener(watcher);
        binding.editPassword.addTextChangedListener(watcher);
        binding.editConfirmPassword.addTextChangedListener(watcher);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
