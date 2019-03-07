package com.example.mohamedhassan.traininghub.RoomDetails;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedhassan.traininghub.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class RoomAcitivityDetailsActivity extends AppCompatActivity {

    final long DELAY_MS = 300;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int currentPage = 0;
    Timer timer;
    int NUM_PAGES;
    Context context = this;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd/MM/yyy";
    DatePickerDialog.OnDateSetListener DateRoomBooking;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
    LinearLayout LinearDateBook;
    TextView dateRoomBook;
    private Spinner roomStatusSpinner;
    private ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        RoomAcitivityDetailsActivity.this.setTitle("Room Details");


        DifinView();
        setOnClickListener();


        viewPagerAdapter = new ViewPagerAdapter(RoomAcitivityDetailsActivity.this);
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void ScorllPhoto() {

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES - 1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }

        };
        currentPage = 0;


        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }


    private void DifinView() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dateRoomBook = (TextView) findViewById(R.id.dateBook);
        LinearDateBook = (LinearLayout) findViewById(R.id.LinearDateBook);
        roomStatusSpinner = (Spinner) findViewById(R.id.roomSpinner);
    }


    private void setOnClickListener() {

        LinearDateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(context, DateRoomBooking, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        DateRoomBooking = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }

        };


        long currentdate = System.currentTimeMillis();
        String dateString = sdf.format(currentdate);
        dateRoomBook.setText(dateString);

        ScorllPhoto();

        arrayAdapter = ArrayAdapter.createFromResource(RoomAcitivityDetailsActivity.this, R.array.room_status_array, R.layout.spinner_text);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomStatusSpinner.setAdapter(arrayAdapter);
        roomStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pos = String.valueOf(position);
                Toast.makeText(RoomAcitivityDetailsActivity.this, "the item selected position " + pos, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void updateDate() {

        dateRoomBook.setText(sdf.format(myCalendar.getTime()));

    }

}
