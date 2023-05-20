package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sectionPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secation_page);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(sectionPage.this);
        bottomNavigationView.setSelectedItemId(R.id.Home_tab);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Home_Fragment home_fragment = new Home_Fragment();
        TrasactionFragment trasactionFragment = new TrasactionFragment();
        AboutFragment aboutFragment = new AboutFragment();
        switch (item.getItemId()) {
            case R.id.Home_tab:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, home_fragment).commit();
                return true;

            case R.id.trasactionPage:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, trasactionFragment).commit();
                return true;

            case R.id.aboutPage:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, aboutFragment).commit();
                return true;
        }
        return false;
    }
}