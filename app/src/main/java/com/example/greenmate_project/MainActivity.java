package com.example.greenmate_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private ListActivity listActivity;
    private ScanActivity scanActivity;
    private SearchActivity searchActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@androidx.annotation.NonNull MenuItem menuItem) {
                return false;
            }

            //@Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.list_item:
                        setFrag(0);
                    case R.id.scan_item:
                        setFrag(1);
                    case R.id.search_item:
                        setFrag(2);
                }

            }
        });
        listActivity = new ListActivity();
        scanActivity = new ScanActivity();
        searchActivity = new SearchActivity();
        setFrag(0);
    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.mainFrame, listActivity);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.mainFrame, scanActivity);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.mainFrame, searchActivity);
                ft.commit();
                break;

        }
    }
}