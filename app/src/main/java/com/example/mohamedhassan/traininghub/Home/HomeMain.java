package com.example.mohamedhassan.traininghub.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.SessionManager;
import com.example.mohamedhassan.traininghub.NavFragmentClases.Booking_fragmnt;
import com.example.mohamedhassan.traininghub.NavFragmentClases.SignAndRegisterFragment;
import com.example.mohamedhassan.traininghub.Home.Home_fragment;
import com.example.mohamedhassan.traininghub.NavFragmentClases.Profile_fragment;
import com.example.mohamedhassan.traininghub.R;

public class HomeMain extends AppCompatActivity {

    private TextView mTextMessage;
    private String tab;
    private SessionManager sessionManager;
    private boolean login = true;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        sessionManager=new SessionManager(this);
        login=sessionManager.isLoggedIn();

        tab= String.valueOf(R.string.title_home);


        mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        case R.id.navigation_home:
        Home_fragment homeFragment=new Home_fragment();
        FragmentTransaction fragmentTransactionHome=getSupportFragmentManager().beginTransaction();
        fragmentTransactionHome.replace(R.id.container,homeFragment).commit();
        return true;

        case R.id.navigation_booking:

            Booking_fragmnt bookingFragmnt=new Booking_fragmnt();
            FragmentTransaction fragmentTransactionBooking=getSupportFragmentManager().beginTransaction();
            fragmentTransactionBooking.replace(R.id.container,bookingFragmnt).commit();

        return true;
        case R.id.navigation_profile:

            if(login){

        Profile_fragment profileFragment=new Profile_fragment();
        FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
        fragmentTransaction2.replace(R.id.container,profileFragment).commit();

        return true;
        }

        else {

                SignAndRegisterFragment signAndRegisterFragment =new SignAndRegisterFragment();
                FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container,signAndRegisterFragment).commit();
        }

        }
        return false;
        }
        };
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(tab.equals(R.string.title_home)) {
        navigation.setSelectedItemId(R.id.navigation_home);
        } else if(tab.equals(R.string.titleprofile)){
        navigation.setSelectedItemId(R.id.navigation_profile);

        } else{
        navigation.setSelectedItemId(R.id.navigation_home);

        }
        }

        }