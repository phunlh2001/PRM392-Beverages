package com.phunlh2001.prm392_beverages;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;


public class OrderManagement extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager2 viewPager2;
    ViewPagerOrderManagementAdapter viewPagerOrderManagementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //Fragment
        //Test fragment order management
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setTabIndicatorFullWidth(true);
        mTabLayout.addTab(mTabLayout.newTab().setText("Store pickup"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Delivery"));

        viewPager2= findViewById(R.id.view_pager);
        viewPagerOrderManagementAdapter = new ViewPagerOrderManagementAdapter(this);
        viewPager2.setAdapter(viewPagerOrderManagementAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTabLayout.getTabAt(position).select();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_management_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.history) {
            Toast.makeText(this, "Order history coming soon", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action1) {
            Toast.makeText(this, "Action 1 clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action2) {
            Toast.makeText(this, "Action 2 clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.exit) {
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

