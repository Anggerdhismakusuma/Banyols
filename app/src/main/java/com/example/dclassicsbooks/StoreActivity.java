package com.example.dclassicsbooks;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Store> storeList;
    StoreListAdapter adapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        recyclerView = findViewById(R.id.rvStore);

        storeList = new ArrayList<>();
        //dummy
        storeList.add(new Store("D’Classics Anggrek", "Jakarta", "+62 812...", R.drawable.store1));
        storeList.add(new Store("D’Classics Alam Sutra", "Tangerang", "+62 811...", R.drawable.store2));

        adapter = new StoreListAdapter(storeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}