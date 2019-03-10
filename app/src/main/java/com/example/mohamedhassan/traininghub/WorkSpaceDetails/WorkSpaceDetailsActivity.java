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
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.MapsActivity;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.RoomDetails.RoomListAdapter;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomDetailsListData;


import java.util.ArrayList;

public class WorkSpaceDetailsActivity extends AppCompatActivity implements WorkSpaceDetailsActivityContract.View {

    RecyclerView recyclerView;
    private ArrayList<RoomDetailsListData> roomDetailsListDataa = new ArrayList<>();
    private RoomListAdapter roomListAdapter;
    TextView location;
    ImageView phone_call,share_phone;
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
        phone_call = (ImageView)findViewById(R.id.phone_call);
        share_phone = (ImageView)findViewById(R.id.share_phone);

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



