package com.example.mohamedhassan.traininghub.TrainingRoomDetailsActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.MapsActivity;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.RoomDetails.RoomListAdapter;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomListData;


import java.util.ArrayList;
import java.util.List;

public class TrainingRoomActivity extends AppCompatActivity implements RoomContract.View {

    RecyclerView recyclerView;
    private List<RoomListData> movieVendorList = new ArrayList<>();
    private RoomListAdapter roomAdapter;
    TextView location;
    ImageView phone_call,share_phone;
    TrainingRoomActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_room);


        TrainingRoomActivity.this.setTitle("Training Room");
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_Room);

        roomAdapter = new RoomListAdapter(movieVendorList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(roomAdapter);

        location = (TextView)findViewById(R.id.location_traning_room);
        phone_call = (ImageView)findViewById(R.id.phone_call);
        share_phone = (ImageView)findViewById(R.id.share_phone);

        location.setOnClickListener(View->BrnLocation());
        phone_call.setOnClickListener(View->Callmobile());
        share_phone.setOnClickListener(View->SharePhone());



        prepareVendorData();

    }

    private void prepareVendorData() {

        RoomListData movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 1","100","35 pare hour",
                "From 15:00 To 17:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 2","25","25 pare hour",
                "From 13:00 To 15:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 3","35","30 pare hour",
                "From 11:00 To 13:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 4","50","25 pare hour",
                "From 9::00 To 11:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 5","75","50 pare hour",
                "From 17:00 To 19:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 6","65","75 pare hour",
                "From 19:00 To 21:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 7","65","65 pare hour",
                "From 21:00 To 23:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 8","30","60 pare hour",
                "From 7:00 To 9:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 9","35","55 pare hour",
                "From 13:00 To 19:00");
        movieVendorList.add(movie);
        movie = new RoomListData(R.drawable.training_courses,R.drawable.food,R.drawable.food,R.drawable.drink,"Room 10","15","55 pare hour",
                "From 6:00 To 9:00");
        movieVendorList.add(movie);


    }

    @Override
    public void BrnLocation() {

        startActivity(new Intent(TrainingRoomActivity.this, MapsActivity.class));
        finish();

    }

    @Override
    public void Callmobile() {


        String Phone = "01156043662";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + Phone));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }

    @Override
    public void SharePhone() {

        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,"The Mobile");
        i.putExtra(Intent.EXTRA_TEXT,"01156043662 ");
        startActivity(Intent.createChooser(i," "));

    }

     /*   @Override
    public void RoomClick() {


    }*/

    /*@Override
    public void DileCallmobile() {


    }*/

}



