package com.example.dclassicsbooks;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        TextView title = findViewById(R.id.detailTitle);
        TextView author = findViewById(R.id.detailAuthor);
        TextView summary = findViewById(R.id.detailSummary);
        TextView back = findViewById(R.id.btnBack);
        ImageView image = findViewById(R.id.detailImage);

        EditText address = findViewById(R.id.inputAddress);
        EditText phone = findViewById(R.id.inputPhone);
        Button buy = findViewById(R.id.btnBuy);

        // 🔥 ambil data dari adapter
        title.setText(getIntent().getStringExtra("title"));
        author.setText(getIntent().getStringExtra("author"));
        summary.setText(getIntent().getStringExtra("summary"));
        image.setImageResource(getIntent().getIntExtra("image", 0));

        // BACK
        back.setOnClickListener(v -> finish());

        // EFFECT CLICK
        buy.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setAlpha(0.6f);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.setAlpha(1f);
            }
            return false;
        });

        // VALIDATION
        buy.setOnClickListener(v -> {

            String addr = address.getText().toString().trim();
            String ph = phone.getText().toString().trim();

            if (addr.isEmpty() || ph.isEmpty()) {
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("Address and Phone must be filled!")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            if (!ph.matches("\\d+")) {
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("Phone must be numeric!")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            new AlertDialog.Builder(this)
                    .setTitle("Success")
                    .setMessage("Confirmation email has been sent!")
                    .setPositiveButton("OK", (d, w) -> finish())
                    .show();
        });
    }
}
