package com.example.mohamedhassan.traininghub.Home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomWorkSpaceListData;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.WorkSpaceListData;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.RoomDetails.RoomWorkSpaceListAdapter;
import com.example.mohamedhassan.traininghub.WorkSpaceDetails.WorkSpaceDetailsActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WrokSpaceListAdapter extends RecyclerView.Adapter<WrokSpaceListAdapter.MyViewHolder> {

    Context context;
    private ArrayList<WorkSpaceListData> workSpaceListData;
    private ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData;
    private RoomWorkSpaceListAdapter roomWorkSpaceListAdapter;
    private Boolean roomMode;
    private WorkSpaceListContract.View mView;


    public WrokSpaceListAdapter(Context context, ArrayList<WorkSpaceListData> workSpaceListData, ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData) {
        this.context = context;
        this.workSpaceListData = workSpaceListData;
        this.roomWorkSpaceListData = roomWorkSpaceListData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        android.view.View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.work_space_list, viewGroup, false);


        return new WrokSpaceListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.handel(workSpaceListData, position);

    }

    @Override
    public int getItemCount() {

        return workSpaceListData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public CircleImageView Photo;
        public TextView Name, Area, available;
        public CardView cardView;
        public ImageButton imageButton;
        public RatingBar ratingBar;
        public RecyclerView roomRecyclerView;


        public MyViewHolder(android.view.View view) {
            super(view);

            cardView = (CardView) view.findViewById(R.id.cardview_work_space);
            Photo = (CircleImageView) view.findViewById(R.id.circleWorkSpaceImageView);
            imageButton = (ImageButton) view.findViewById(R.id.workSpaceImageButton);
            Name = (TextView) view.findViewById(R.id.name_WorkSpace);
            Area = (TextView) view.findViewById(R.id.Area);
            available = (TextView) view.findViewById(R.id.valable_WorkSpace);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar_WorkSpace);
            roomRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewWorkSpace);

        }

        private void handel(final ArrayList<WorkSpaceListData> spaceListData, final int Postion) {
            roomMode = false;
            showRooms(roomMode);
            Photo.setImageResource(spaceListData.get(Postion).getPhoto());
            Name.setText(spaceListData.get(Postion).getName());
            Area.setText(spaceListData.get(Postion).getArea());
            available.setText("from " + spaceListData.get(Postion).getStart_time() + " to " + spaceListData.get(Postion).getEnd_time());
            ratingBar.setRating((float) spaceListData.get(Postion).getRating());

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            roomWorkSpaceListAdapter = new RoomWorkSpaceListAdapter(itemView.getContext(), roomWorkSpaceListData, layoutParams);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            roomRecyclerView.setLayoutManager(layoutManager);
            roomRecyclerView.setAdapter(roomWorkSpaceListAdapter);
            roomWorkSpaceListAdapter.notifyDataSetChanged();



            itemView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {

                    Intent intent = new Intent(itemView.getContext(), WorkSpaceDetailsActivity.class);
                   /* RoomTrainingDetailsModel roomTrainingDetailsModel;
                    roomTrainingDetailsModel=spaceListData.get(Postion);
                    intent.putExtra("work",roomTrainingDetailsModel);*/
                    itemView.getContext().startActivity(intent);
                }

            });
            imageButton.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    if (!roomMode) {
                        roomMode = true;
                    } else roomMode = false;

                    showRooms(roomMode);
                }
            });

        }

        public void showRooms(boolean show) {
            roomRecyclerView.setVisibility(show ? android.view.View.VISIBLE : android.view.View.GONE);
        }
    }


}
