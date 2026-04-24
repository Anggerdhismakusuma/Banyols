package com.example.dclassicsbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    // 1. Deklarasi variabel global untuk simpan username (Requirement task)
    public static String globalUsername = "";

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Hubungkan variabel dengan ID di XML
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // 3. Aksi saat tombol login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userVal = etUsername.getText().toString();
                String passVal = etPassword.getText().toString();

                // Validasi Username kosong
                if (userVal.isEmpty()) {
                    etUsername.setError("Username must be filled!");
                }
                // Validasi Password kosong
                else if (passVal.isEmpty()) {
                    etPassword.setError("Password must be filled!");
                }
                // Validasi Alphanumeric (Hanya huruf dan angka)
                else if (!passVal.matches("[a-zA-Z0-9]+")) {
                    etPassword.setError("Password must be alphanumeric!");
                }
                // Jika semua sukses
                else {
                    // Simpan username ke variabel global
                    globalUsername = userVal;

                    // Pindah ke halaman Home
                    Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Agar user tidak bisa klik back ke login lagi
                }
            }
        });
    }
}