package com.example.drylaundry;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Home();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new order();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new Profile();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment)
                        .commit();
                return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
