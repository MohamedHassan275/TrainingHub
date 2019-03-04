package com.example.mohamedhassan.traininghub.RoomDetails;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mohamedhassan.traininghub.R;

public class RoomTrainingDetailsActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room__training__details);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(RoomTrainingDetailsActivity.this);

        viewPager.setAdapter(viewPagerAdapter);


    }
}
