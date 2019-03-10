package com.example.mohamedhassan.traininghub.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomWorkSpaceListData;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.WorkSpaceListData;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.WorkSpaceDetails.WorkSpaceDetailsActivity;

import java.util.ArrayList;

public class Home_fragment extends Fragment implements WorkSpaceListContract.View {

    //  ProgressBar mProgressView;
    RecyclerView recyclerView;
    ImageView imageView_Sort,imageView_filtering;
    ArrayList<WorkSpaceListData> workSpaceListData = new ArrayList<>();
    ArrayList<RoomWorkSpaceListData> roomlistdata = new ArrayList<>();
    WrokSpaceListAdapter wrokSpaceListAdapter;

    private String WorkSpaceName[] = {"work 1", "work 2", "work 3", "work4", "work 5", "work 6",
            "work 7", "work 8", "work 9"};
    private String WorkSpaceCity[] = {"cairo", "Giza", "Sohag", "Alexandria", "Ismailia",
            "Sohag", "cairo", "Giza", "Alexandria"};
    private double WorkSpaceRate[] = {5, 4.5, 5, 3.2, 2.7, 5, 4.7, 4.3, 5};
    private String WorkSpaceStartTime[] =  {"6:00", "9:00", "11:00", "13:00", "15:00",
            "17:00", "19:00", "21:00", "24:00"};
    private String WorkSpaceEndTime[] =  {"8:00", "11:00", "13:00", "15:00", "17:00",
            "19:00", "21:00", "23:00", "26:00"};

    private String WorkRoomName[] = {"Room1", "Room2", "Room3", "Room4", "Room5",
            "Room6", "Room7", "Room8", "Room9"};
    private String WorkRoomPrice[] = {"25 P#H","50 P#H","35 P#H","45 P#H","75 P#H","100 P#H","55 P#H","65 P#H","85 P#H"};
    private String WorkRoomCapcity[] =  {"100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire",
            "100 Chaire", "100 Chaire", "100 Chaire", "100 Chaire"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        //   mProgressView = (ProgressBar) view.findViewById(R.id.home_progress);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_TrainingRoom);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        imageView_Sort = (ImageView) view.findViewById(R.id.imageView_sorting);
        imageView_filtering = (ImageView) view.findViewById(R.id.imageView_filtering);

        workSpaceListData = new ArrayList<>();
        for (int i = 0; i < WorkSpaceName.length; i++) {
            WorkSpaceListData
            workSpace = new WorkSpaceListData();
                    workSpace.setPhoto(R.drawable.profile_ic);
                    workSpace.setName(WorkSpaceName[i]);
                    workSpace.setArea(WorkSpaceCity[i]);
                    workSpace.setRating(WorkSpaceRate[i]);
                    workSpace.setStart_time(WorkSpaceStartTime[i]);
                    workSpace.setEnd_time(WorkSpaceEndTime[i]);
                    workSpaceListData.add(workSpace);

        }

        roomlistdata=new ArrayList<>();
        for (int i = 0; i< WorkRoomName.length; i++){
            RoomWorkSpaceListData roomSpace=new RoomWorkSpaceListData();
            roomSpace.setNameRoomWorkSpace(WorkRoomName[i]);
            roomSpace.setSalaryRoomWorkSpace(WorkRoomCapcity[i]);
            roomSpace.setCapistyRoomWorkSpace(WorkRoomPrice[i]);
            roomlistdata.add(roomSpace);
        }

        wrokSpaceListAdapter = new WrokSpaceListAdapter(getContext(), workSpaceListData,roomlistdata);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(wrokSpaceListAdapter);


        imageView_Sort.setOnClickListener(View->SortinSearch());
        imageView_filtering.setOnClickListener(View->FilteringSearch());


        return view;
    }

    @Override
    public void


    showMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void navigateToDetailRoom() {

        Intent intent = new Intent(getContext(), WorkSpaceDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgress(boolean show) {

        // mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    @Override
    public void showRooms(boolean show) {

        // recyclerView.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    @Override
    public void SortinSearch() {

        Toast.makeText(getActivity(), "SortingSearch", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FilteringSearch() {

        Toast.makeText(getActivity(), "FilteringSearch", Toast.LENGTH_SHORT).show();

    }


}





