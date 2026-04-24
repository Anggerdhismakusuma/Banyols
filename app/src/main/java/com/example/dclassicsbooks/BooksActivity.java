package com.example.dclassicsbooks;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class BooksActivity extends AppCompatActivity {

    private TextView tabFiction;
    private TextView tabNonFiction;
    private ViewPager2 viewPagerBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        // Ngenalin tombol tab dan viewpager dari XML ke Java
        tabFiction = findViewById(R.id.tabFiction);
        tabNonFiction = findViewById(R.id.tabNonFiction);
        viewPagerBooks = findViewById(R.id.viewPagerBooks);

        // Pasang si "Jembatan" (Adapter)
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPagerBooks.setAdapter(adapter);

        // Aksi 1: Kalau teks Tab diklik, halamannya geser
        tabFiction.setOnClickListener(v -> viewPagerBooks.setCurrentItem(0));
        tabNonFiction.setOnClickListener(v -> viewPagerBooks.setCurrentItem(1));

        // Aksi 2: Kalau layarnya di-swipe, warna Tab-nya ngikutin berubah
        viewPagerBooks.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    // Halaman Fiction Aktif (Tab kiri warna maroon, kanan abu-abu)
                    tabFiction.setTextColor(Color.parseColor("#500216"));
                    tabFiction.setBackgroundResource(R.drawable.tab_indicator_line);
                    tabNonFiction.setTextColor(Color.parseColor("#BBBBBB"));
                    tabNonFiction.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    // Halaman Non-Fiction Aktif (Tab kanan warna maroon, kiri abu-abu)
                    tabNonFiction.setTextColor(Color.parseColor("#500216"));
                    tabNonFiction.setBackgroundResource(R.drawable.tab_indicator_line);
                    tabFiction.setTextColor(Color.parseColor("#BBBBBB"));
                    tabFiction.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
    }
}