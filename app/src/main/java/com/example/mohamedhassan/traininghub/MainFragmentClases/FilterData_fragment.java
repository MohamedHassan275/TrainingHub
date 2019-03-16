package com.example.mohamedhassan.traininghub.MainFragmentClases;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamedhassan.traininghub.Home.HomeFragment;
import com.example.mohamedhassan.traininghub.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FilterData_fragment extends Fragment {

    CardView cardViewWorkSpaceData;
    Spinner SpinnerlocationGovernment,SpinnerlocationCity,SpinnerStartTime,SpinnerEndTime, SpinnerNumberchair;
    String spinnerSelectedGovernment, SpinnerSelctedCity,SpinnerSelctedStartTime,SpinnerSelctedEndTime, SpinnerSelctedNumberchair;
    ArrayAdapter<CharSequence> arrayAdapterGovernmen,arrayAdapterCity,arrayAdapterStartTime,arrayAdapterEndTime, arrayAdapterchairNumber;
    ImageView  imageViewCancel, imageViewDone;
    SeekBar SeekBarPrice, SeekBarCapcity;
    TextView textViewPrice, textViewCapcity;
    Toolbar toolbar;
    RadioGroup RadioGroupNearBy;
    RadioButton RadioYes, RadioNo;
    LinearLayout linerlayoutWorkSpace;

    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd/MM/yyy";
    DatePickerDialog.OnDateSetListener DateFromFilter,DateToFilter;
    SimpleDateFormat sdfFrom = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
    SimpleDateFormat sdfTo = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
    TextView FromFilterLocation,ToFilterLocation;

    public FilterData_fragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmnt_filtring_data, container, false);

       // cardViewWorkSpaceData = view.findViewById(R.id.cardview_filterDataWorksSpace);
        imageViewCancel = view.findViewById(R.id.imageView_close);
        cardViewWorkSpaceData = view.findViewById(R.id.cardview_filterDataWorksSpace);
        imageViewDone = view.findViewById(R.id.imageView_Done);
        SeekBarPrice = view.findViewById(R.id.seekBarPrice);
        SeekBarCapcity = view.findViewById(R.id.seekBarCapcity);
        textViewPrice = view.findViewById(R.id.textView_price);
        textViewCapcity = view.findViewById(R.id.textView_capcity);
        RadioGroupNearBy=view.findViewById(R.id.radioGroupNearBy);
        RadioYes=view.findViewById(R.id.radioButton_yes);
        RadioNo=view.findViewById(R.id.radioButton_no);
        toolbar=view.findViewById(R.id.toolbar);
        SpinnerlocationCity=view.findViewById(R.id.SpinnerlocationCity);
        SpinnerlocationGovernment =view.findViewById(R.id.SpinnerlocationGovernment);
        FromFilterLocation =view.findViewById(R.id.textViewFromCalender);
        ToFilterLocation =view.findViewById(R.id.textViewToCalender);
        SpinnerStartTime=view.findViewById(R.id.SpinnerStartTime);
        SpinnerEndTime=view.findViewById(R.id.SpinnerEndTime);
        SpinnerNumberchair =view.findViewById(R.id.Spinnernumberchair);
        RadioNo.setChecked(true);

        SetonClickLisener();


        return view;
    }


    private void SetonClickLisener() {


        final long currentdate = System.currentTimeMillis();
        final String dateString = sdfFrom.format(currentdate);
        String dateString2 = sdfTo.format(currentdate);
        FromFilterLocation.setText(dateString);
        ToFilterLocation.setText(dateString2);

        FromFilterLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), DateFromFilter, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DateFromFilter = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateFrom();
            }

        };

        ToFilterLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(),DateToFilter , myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DateToFilter = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateTo();
            }

        };


        imageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null,fragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,homeFragment).commit();




            }
        });

        imageViewDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null,fragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,homeFragment).commit();

                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
            }
        });

        SeekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewPrice.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        SeekBarCapcity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewCapcity.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

        RadioNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpinnerlocationCity.setVisibility(View.GONE);
                SpinnerlocationGovernment.setVisibility(View.GONE);

            }
        });
        RadioYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpinnerlocationCity.setVisibility(View.VISIBLE);
                SpinnerlocationGovernment.setVisibility(View.VISIBLE);

            }
        });

        arrayAdapterGovernmen = ArrayAdapter.createFromResource(getActivity(),
                R.array.government_arrray , android.R.layout.simple_spinner_item);
        arrayAdapterGovernmen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerlocationGovernment.setAdapter(arrayAdapterGovernmen);
        SpinnerlocationGovernment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSelectedGovernment = SpinnerlocationGovernment.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        arrayAdapterCity = ArrayAdapter.createFromResource(getActivity(),
                R.array.city_arrray , android.R.layout.simple_spinner_item);
        arrayAdapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerlocationCity.setAdapter(arrayAdapterCity);
        SpinnerlocationCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerSelctedCity = SpinnerlocationCity.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        arrayAdapterStartTime = ArrayAdapter.createFromResource(getActivity(),
                R.array.start_time_array , android.R.layout.simple_spinner_item);
        arrayAdapterStartTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerStartTime.setAdapter(arrayAdapterStartTime);
        SpinnerStartTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerSelctedStartTime = SpinnerStartTime.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        arrayAdapterEndTime = ArrayAdapter.createFromResource(getActivity(),
                R.array.end_time_array , android.R.layout.simple_spinner_item);
        arrayAdapterEndTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerEndTime.setAdapter(arrayAdapterEndTime);
        SpinnerEndTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerSelctedEndTime = SpinnerEndTime.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        arrayAdapterchairNumber = ArrayAdapter.createFromResource(getActivity(),
                R.array.people_number_array , android.R.layout.simple_spinner_item);
        arrayAdapterchairNumber.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerNumberchair.setAdapter(arrayAdapterchairNumber);
        SpinnerNumberchair.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerSelctedNumberchair = SpinnerNumberchair.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }
    private void updateDateFrom() {

        FromFilterLocation.setText(sdfFrom.format(myCalendar.getTime()));

    }
    private void updateDateTo() {

        ToFilterLocation.setText(sdfTo.format(myCalendar.getTime()));

    }


}
