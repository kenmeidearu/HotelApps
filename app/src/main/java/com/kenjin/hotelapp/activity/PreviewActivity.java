package com.kenjin.hotelapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


import com.kenjin.hotelapp.R;
import com.kenjin.hotelapp.adapter.TabFragmentPagerAdapter;

public class PreviewActivity extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        pager=(ViewPager) findViewById(R.id.pager);
        tabs=(TabLayout) findViewById(R.id.tabs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

        tabs.setupWithViewPager(pager);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Log.e("Home pressed","home presed");
            Toast.makeText(PreviewActivity.this,"kembali ke menu utama",
                    Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
