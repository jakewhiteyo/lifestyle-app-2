package com.example.lifestyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lifestyle.dashboardfragments.DashboardBMIFragment;
import com.example.lifestyle.dashboardfragments.DashboardFitnessGoalsFragment;
import com.example.lifestyle.dashboardfragments.DashboardHikesFragment;
import com.example.lifestyle.dashboardfragments.DashboardMainFragment;
import com.example.lifestyle.dashboardfragments.DashboardWeatherFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        DashboardMainFragment dashboardMainFragment = new DashboardMainFragment();

        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.fl_frag_dashboard, dashboardMainFragment, "frag_dashboard");
        fTrans.commit();


        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // set home selected
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        // perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.dashboard:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}