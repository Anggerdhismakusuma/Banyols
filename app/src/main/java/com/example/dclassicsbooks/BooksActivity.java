package com.example.dclassicsbooks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

public class BooksActivity extends AppCompatActivity {

    private TextView tabFiction, tabNonFiction;
    private ViewPager2 viewPagerBooks;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setupToolbar();
        setupNavigationDrawer();

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

    private void setupToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        // Biar tombol hamburger di pojok kiri atas bisa buka sidebar
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void setupNavigationDrawer() {

        // Ambil header Navigation Drawer
        View headerView = navigationView.getHeaderView(0);

        // Username di header
        TextView tvNavUsername = headerView.findViewById(R.id.tv_nav_username);

        if (tvNavUsername != null && UserData.loggedInUsername != null) {
            tvNavUsername.setText(UserData.loggedInUsername);
        }

        // Sembunyikan menu "All Books" karena sedang berada di halaman All Books
        Menu menu = navigationView.getMenu();
        if (menu.findItem(R.id.nav_all_books) != null) {
            menu.findItem(R.id.nav_all_books).setVisible(false);
        }

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_home) {

                Intent intent = new Intent(BooksActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            } else if (id == R.id.nav_store) {

                Intent intent = new Intent(BooksActivity.this, StoreActivity.class);
                startActivity(intent);
                finish();

            } else if (id == R.id.nav_logout) {

                Intent intent = new Intent(BooksActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}