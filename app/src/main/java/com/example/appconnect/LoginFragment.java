package com.example.appconnect;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.appconnect.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.loginScreen.setOnClickListener(v -> hideKeyboard());

        binding.btnSignUp.setOnClickListener(v -> 
            Navigation.findNavController(v).navigate(R.id.action_login_to_register)
        );

        binding.btnLogin.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_movieRecyclerViewFragment);
        });

        binding.txtForgotPassword.setOnClickListener(v -> {

        });

        addTextInputListener();

    }

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

    private void validateButtonState() {
        if (binding == null) return;
        boolean isEmailEmpty = binding.editEmail.getText() == null || binding.editEmail.getText().toString().trim().isEmpty();
        boolean isPasswordEmpty = binding.editPassword.getText() == null || binding.editPassword.getText().toString().trim().isEmpty();

        binding.btnLogin.setEnabled(!isEmailEmpty && !isPasswordEmpty);
    }

    private void addTextInputListener() {
        TextWatcher handleTextChange = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        binding.editEmail.addTextChangedListener(handleTextChange);
        binding.editPassword.addTextChangedListener(handleTextChange);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
