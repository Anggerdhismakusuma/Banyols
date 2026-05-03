package com.example.dclassicsbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ImageButton btnPrev, btnNext;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView tvGreeting, tvNavUsername, tvViewAll;
    private RecyclerView rvFeatured;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupToolbar();
        setupNavigationDrawer();
        setupCarousel();
        setupFeaturedBooks();

        tvViewAll.setOnClickListener(v -> {
            // Nanti 'BooksActivity.class' ganti sama BooksPage yang dibuat ya darr
            Intent intent = new Intent(HomeActivity.this, BooksActivity.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        tvGreeting = findViewById(R.id.tv_home_greeting);
        viewPager2 = findViewById(R.id.vp_carousel);
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
        rvFeatured = findViewById(R.id.rv_featured);
        tvViewAll = findViewById(R.id.tv_view_all_books);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        String username = UserData.loggedInUsername;
        tvGreeting.setText("Hello, " + (username != null ? username : "Reader"));
    }

    private void setupNavigationDrawer() {
        View headerView = navigationView.getHeaderView(0);
        tvNavUsername = headerView.findViewById(R.id.tv_nav_username);
        if (tvNavUsername != null) {
            tvNavUsername.setText(UserData.loggedInUsername);
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_logout) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void setupCarousel() {
        List<StoreCarousel> storeItems = new ArrayList<>();

        storeItems.add(new StoreCarousel(
                R.drawable.store1,
                "D'Classics Store Anggrek",
                "Jl. Kebon Jeruk Raya No. 27, Jakarta",
                "+62 812-3456-7890"
        ));

        storeItems.add(new StoreCarousel(
                R.drawable.store2,
                "D'Classics Store Alam Sutra",
                "Jl. Jalur Sutera Bar. No.Kav. 21, Tangerang",
                "+62 811-2233-4455"
        ));

        storeItems.add(new StoreCarousel(
                R.drawable.store3,
                "D'Classics Store Bandung",
                "Jl. Pasir Kaliki No.25-27, Bandung",
                "+62 813-9988-7766"
        ));

        storeItems.add(new StoreCarousel(
                R.drawable.store4,
                "D'Classics Antique Gallery",
                "Charing Cross Road, Diagon Alley",
                "+62 813-9848-9476"
        ));

        storeItems.add(new StoreCarousel(
                R.drawable.store5,
                "D'Classics Tree of Knowledge",
                "Ohara Island",
                "+62 895-9240-9476"
        ));

        CarouselAdapter adapter = new CarouselAdapter(storeItems);
        viewPager2.setAdapter(adapter);

        viewPager2.setPageTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });

        btnNext.setOnClickListener(v -> viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1));
        btnPrev.setOnClickListener(v -> viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // Geser tiap 3 detik
            }
        });
    }

    private void setupFeaturedBooks() {
        rvFeatured.setLayoutManager(new LinearLayoutManager(this));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", R.drawable.gatsby));
        bookList.add(new Book("Moby Dick", "Herman Melville", R.drawable.moby_dick));
        bookList.add(new Book("Pride & Prejudice", "Jane Austen", R.drawable.pride_prejudice));
        bookList.add(new Book("1984", "George Orwell", R.drawable.orwell_1984));

        BookAdapter bookAdapter = new BookAdapter(this, bookList);
        rvFeatured.setAdapter(bookAdapter);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int nextItem = viewPager2.getCurrentItem() + 1;
            if (nextItem >= viewPager2.getAdapter().getItemCount()) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(nextItem);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
