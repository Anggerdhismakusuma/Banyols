package com.example.dclassicsbooks;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // 🔹 INIT VIEW
        TextView title = findViewById(R.id.detailTitle);
        TextView author = findViewById(R.id.detailAuthor);
        TextView summary = findViewById(R.id.detailSummary);
        ImageView image = findViewById(R.id.detailImage);
        TextView back = findViewById(R.id.btnBack);

        EditText address = findViewById(R.id.inputAddress);
        EditText phone = findViewById(R.id.inputPhone);
        Button buy = findViewById(R.id.btnBuy);

        // 🔥 AMBIL DATA DARI INTENT
        title.setText(getIntent().getStringExtra("title"));
        author.setText(getIntent().getStringExtra("author"));
        summary.setText(getIntent().getStringExtra("summary"));
        image.setImageResource(getIntent().getIntExtra("image", 0));

        // 🔙 BACK BUTTON
        back.setOnClickListener(v -> finish());

        // 🎯 BUTTON EFFECT (mousedown)
        buy.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.6f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.setAlpha(1f);
            }
            return false;
        });

        buy.setOnClickListener(v -> {

            String addr = address.getText().toString().trim();
            String ph = phone.getText().toString().trim();

            if (addr.isEmpty() && ph.isEmpty()) {
                showError("All fields must be filled!");
                return;
            }

            if (addr.isEmpty()) {
                showError("Address must be filled!");
                return;
            }

            if (ph.isEmpty()) {
                showError("Phone number must be filled!");
                return;
            }

            if (!ph.matches("\\d+")) {
                showError("Phone number must contain digits only!");
                return;
            }

            if (ph.length() < 10) {
                showError("Phone number must be at least 10 digits!");
                return;
            }

            showSuccessDialog();
        });
    }

    private void showError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

    private void showSuccessDialog() {

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_success, null);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .create();

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        dialog.show();

        Button btnClose = dialogView.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });
    }
}
