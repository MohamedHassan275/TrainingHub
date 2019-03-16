package com.example.mohamedhassan.traininghub.WorkSpaceDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.MapsActivity;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomTrainingDetailsModel;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.RoomDetails.RoomListAdapter;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomDetailsListData;


import java.util.ArrayList;

public class WorkSpaceDetailsActivity extends AppCompatActivity implements WorkSpaceDetailsActivityContract.View {

    RecyclerView recyclerView;
    private ArrayList<RoomDetailsListData> roomDetailsListDataa = new ArrayList<>();
     ArrayList<RoomTrainingDetailsModel> roomTrainingDetailsModels = new ArrayList<>();
    private RoomListAdapter roomListAdapter;
    TextView location, name_traning_room,area_traning_room,phone_traning_room,avalable_traning_room
            ,details_traning_room,city_training_room,number_of_rooms_traning_room;
    RatingBar ratingBar_room;
    ImageView phone_call,share_phone,photo_traning_room;
    Context context = this;
    private String WorkRoomName[] = {"Room1", "Room2", "Room3", "Room4", "Room5",
            "Room6", "Room7", "Room8", "Room9"};
    private String WorkRoomPrice[] = {"25 P#H","50 P#H","35 P#H","45 P#H","75 P#H","100 P#H","55 P#H","65 P#H","85 P#H"};
    private String WorkRoomCapcity[] =  {"100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire",
            "100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_work_space);

        WorkSpaceDetailsActivity.this.setTitle("Training Room");

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_Room);
        location = (TextView)findViewById(R.id.location_traning_room);
        name_traning_room = (TextView)findViewById(R.id.name_traning_room);
        area_traning_room = (TextView)findViewById(R.id.area_traning_room);
        phone_traning_room = (TextView)findViewById(R.id.phone_traning_room);
        avalable_traning_room = (TextView)findViewById(R.id.avalable_traning_room);
        details_traning_room = (TextView)findViewById(R.id.details_traning_room);
        city_training_room = (TextView)findViewById(R.id.city_training_room);
        number_of_rooms_traning_room = (TextView)findViewById(R.id.number_of_rooms_traning_room);
        location = (TextView)findViewById(R.id.location_traning_room);
        phone_call = (ImageView)findViewById(R.id.phone_call);
        share_phone = (ImageView)findViewById(R.id.share_phone);
        ratingBar_room = (RatingBar) findViewById(R.id.ratingBar_room);


      //  roomTrainingDetailsModels= ((RoomTrainingDetailsModel) getIntent().getSerializableExtra("work"));

        roomDetailsListDataa = new ArrayList<>();
        for (int i = 0; i < WorkRoomName.length; i++) {
            RoomDetailsListData
                    roomDetailsListData = new RoomDetailsListData();
            roomDetailsListData.setPhoto(R.drawable.profile_ic);
            roomDetailsListData.setName(WorkRoomName[i]);
            roomDetailsListData.setCapcity(WorkRoomCapcity[i]);
            roomDetailsListData.setPrice(WorkRoomPrice[i]);
            roomDetailsListDataa.add(roomDetailsListData);

            roomListAdapter = new RoomListAdapter(context, roomDetailsListDataa);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this
                    , LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(roomListAdapter);

            name_traning_room.setText("Mohamed Hassan");
            area_traning_room.setText("Nasr City");
            phone_traning_room.setText("01156043662");
            avalable_traning_room.setText("From 12 pm to 12 Am");
            details_traning_room.setText(R.string.details);
            city_training_room.setText("Cairo");
            number_of_rooms_traning_room.setText("Number Of Rooms : 9 Rooms");
            ratingBar_room.setRating(Float.parseFloat(String.valueOf(4.5)));

        location.setOnClickListener(View->BrnLocation());
        phone_call.setOnClickListener(View->Callmobile());
        share_phone.setOnClickListener(View->SharePhone());


        }
        
    }


    @Override
    public void BrnLocation() {

        startActivity(new Intent(WorkSpaceDetailsActivity.this, MapsActivity.class));
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



