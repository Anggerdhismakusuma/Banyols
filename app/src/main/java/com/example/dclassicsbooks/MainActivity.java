package com.example.dclassicsbooks;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private ImageView ivShowPassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        ivShowPassword = findViewById(R.id.iv_show_password);

        ivShowPassword.setOnClickListener(v -> {
            if (isPasswordVisible) {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                ivShowPassword.setImageResource(R.drawable.ic_visibility_off);
            } else {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                ivShowPassword.setImageResource(R.drawable.ic_visibility);
            }

            ivShowPassword.setImageTintList(ColorStateList.valueOf(Color.parseColor("#8C6F71")));

            isPasswordVisible = !isPasswordVisible;
            etPassword.setSelection(etPassword.getText().length());
        });

        btnLogin.setOnClickListener(v -> {
            validateLogin();
        });
    }

    private void validateLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // 1. Validasi Username: Harus diisi
        if (username.isEmpty()) {
            etUsername.setError("Username must be filled.");
            etUsername.requestFocus();
            return;
        }

        // 2. Validasi Password: Harus diisi
        if (password.isEmpty()) {
            etPassword.setError("Password must be filled.");
            etPassword.requestFocus();
            return;
        }

        // 3. Validasi Password: Minimal 8 char
        if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters.");
            etPassword.requestFocus();
            return;
        }

        // 4. Validasi Password: Harus Alphanumeric
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            etPassword.setError("Password must be alphanumeric.");
            etPassword.requestFocus();
            return;
        }

        // --- VALIDASI BENER ---

        UserData.loggedInUsername = username;

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);

        finish();
    }
}