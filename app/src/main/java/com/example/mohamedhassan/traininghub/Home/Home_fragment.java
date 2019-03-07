package com.example.mohamedhassan.traininghub.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.mohamedhassan.traininghub.Model_RoomTraining.GetRoomListData;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomListData;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.TrainingRoomListData;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.RoomDetails.RoomWorkSpaceListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Home_fragment extends Fragment implements WorkSpaceListContract.View {

    ProgressBar mProgressView;
    RecyclerView recyclerView,recyclerView2;
    ImageView photo_GetRooms;
    private List<TrainingRoomListData> movieVendorList = new ArrayList<>();
    private List<RoomListData> roomListData = new ArrayList<>();
     WrokSpaceListAdapter wrokSpaceListAdapter;

    private List<GetRoomListData> getRoomListData = new ArrayList<>();
    private RoomWorkSpaceListAdapter roomListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);

      //  mProgressView = (ProgressBar)view.findViewById(R.id.home_progress);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view_TrainingRoom);

        wrokSpaceListAdapter = new WrokSpaceListAdapter(getContext(),movieVendorList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(wrokSpaceListAdapter);



        photo_GetRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(recyclerView2.getVisibility()==View.GONE ){

                    recyclerView2.setVisibility(View.VISIBLE);

                }else if (recyclerView2.getVisibility()==View.VISIBLE){

                    recyclerView2.setVisibility(View.GONE);


                }

            }
        });


        prepareVendorData();


        return view;
    }

   /* @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();

    }

    @Override
    public void navigateToDetailRoom() {

        Intent intent = new Intent(getContext(), WorkSpaceDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgress(boolean show) {

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

    }*/

    private void prepareVendorData() {

        TrainingRoomListData movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Mohamed Hassan", "Sohag","01156043662","From 15:00 To 17:00","3.5","25/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Mahmoud Hassan",
                "Cairo","01113246541","From 17:00 To 19:00","4.3","5/1/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Ahemd Hassan",
                "Giza","012654132141","From 15:00 To 21:00","4.6","5/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Ali Hassan",
                "Maadi","01156055662","From 15:00 To 17:00","3.5","21/1/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Hain Hassan",
                "Aswan","01156254682","From 13:00 To 17:00","3.3","26/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Kaream Hassan",
                "Louxor","01121458662","From 17:00 To 19:00","4.2","21/3/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Amr Hassan",
                "Helwan ","01126513662","From 1600 To 19:00","2.5","25/1/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Hassan Hassan",
                "Mansoura " ,"0115254662","From 12:00 To 15:00","3.7","5/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Mostafa Hassan",
                "Sohag","01153053655","From 13:00 To 16:00","2.3","10/2/2019");
        movieVendorList.add(movie);

        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Said Hassan",
                "Assiut ","011560254","From 15:00 To 21:00","3.2","21/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Mohamed Amr " ,
                "Assiut ","0115605253","From 13:00 To 15:00","4.3","15/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Hani Amr",
                "Assiut ","0115621456","From 19:00 To 23:00","3.2","15/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Mostafa Amr",
                "Assiut ","0115612345","From 17:00 To 19:00","4.5","21/3/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Ahmed Amr",
                "Assiut ","01156025456","From 13:00 To 23:00","3.7","25/2/2019");
        movieVendorList.add(movie);
        movie = new TrainingRoomListData(R.drawable.training_courses,R.drawable.star_fill,"Amr Hassan",
                "Assiut ","011560351176","From 11:00 To 21:00","4.7","21/2/2019");
        movieVendorList.add(movie);
    }



   /* private void prepareGetRoomData() {

        GetRoomListData getRoomListData = new GetRoomListData(R.drawable.food,R.drawable.drink,R.drawable.food,"Room 1"
                ,"50 P#H","25");
        this.getRoomListData.add(getRoomListData);
        this.getRoomListData.add(getRoomListData);
        getRoomListData = new GetRoomListData(R.drawable.food,R.drawable.drink,R.drawable.food,"Room 2"
                ,"35 P#H","50");
        this.getRoomListData.add(getRoomListData);
        getRoomListData = new GetRoomListData(R.drawable.food,R.drawable.drink,R.drawable.food,"Room 3"
                ,"45 P#H","75");
        this.getRoomListData.add(getRoomListData);
        getRoomListData = new GetRoomListData(R.drawable.food,R.drawable.drink,R.drawable.food,"Room 4"
                ,"30 P#H","100");
        this.getRoomListData.add(getRoomListData);
        getRoomListData = new GetRoomListData(R.drawable.food,R.drawable.drink,R.drawable.food,"Room 5"
                ,"55 P#H","35");
        this.getRoomListData.add(getRoomListData);

    }*/

}
