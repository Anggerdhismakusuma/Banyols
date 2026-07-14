package com.example.dclassicsbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Store> storeList;
    private StoreListAdapter adapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rvStore);

        setSupportActionBar(toolbar);

        // Hilangkan tulisan "DClassicsBooks"
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View headerView = navigationView.getHeaderView(0);
        TextView tvNavUsername = headerView.findViewById(R.id.tv_nav_username);

        if (UserData.loggedInUsername != null &&
                !UserData.loggedInUsername.isEmpty()) {

            tvNavUsername.setText(UserData.loggedInUsername);

        } else {

            tvNavUsername.setText("Reader");
        }


        Menu menu = navigationView.getMenu();
        if (menu.findItem(R.id.nav_store) != null) {
            menu.findItem(R.id.nav_store).setVisible(false);
        }

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_home) {

                startActivity(new Intent(StoreActivity.this, HomeActivity.class));
                finish();

            } else if (id == R.id.nav_all_books) {

                startActivity(new Intent(StoreActivity.this, BooksActivity.class));
                finish();

            } else if (id == R.id.nav_logout) {

                Intent intent = new Intent(StoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Dummy Data
        storeList = new ArrayList<>();

        storeList.add(new Store(
                "D’Classics Anggrek",
                "Jl. Kebon Jeruk Raya No. 27, Jakarta",
                "+62 812-3456-7890",
                R.drawable.store1
        ));

        storeList.add(new Store(
                "D’Classics Alam Sutra",
                "Jl. Jalur Sutera Bar. No.Kav. 21, Tangerang",
                "+62 811-2233-4455",
                R.drawable.store2
        ));

        storeList.add(new Store(
                "D’Classics Bandung",
                "Jl. Pasir Kaliki No.25-27, Bandung",
                "+62 811-2233-4455",
                R.drawable.store3
        ));

        storeList.add(new Store(
                "D'Classics Antique Gallery",
                "Charing Cross Road, Diagon Alley",
                "+62 813-9848-9476",
                R.drawable.store4
        ));

        storeList.add(new Store(
                "D'Classics Tree of Knowledge",
                "Ohara Island",
                "+62 895-9240-9476",
                R.drawable.store5
        ));



        adapter = new StoreListAdapter(storeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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