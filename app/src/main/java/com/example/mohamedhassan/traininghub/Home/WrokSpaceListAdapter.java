package com.example.mohamedhassan.traininghub.Home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.Model_RoomTraining.TrainingRoomListData;
import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.WorkSpaceDetails.WorkSpaceDetailsActivity;

import java.util.List;

public class WrokSpaceListAdapter extends RecyclerView.Adapter<WrokSpaceListAdapter.MyViewHolder> {

    private List<TrainingRoomListData> moviesList;
    Context context;

    public WrokSpaceListAdapter(Context context, List<TrainingRoomListData> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public ImageView Photo;
        public TextView Name, Location, Phone,Valable,date_vendor;
        public CardView cardView;
        public RatingBar ratingBar_vendor;


        public MyViewHolder(View view) {
            super(view);

            Photo = (ImageView) view.findViewById(R.id.image_traininge_room_list);
            Name = (TextView) view.findViewById(R.id.name_traininge_room_list);
            Location = (TextView) view.findViewById(R.id.location_traininge_room_list);
            Phone = (TextView) view.findViewById(R.id.phone_traininge_room_list);
            date_vendor = (TextView) view.findViewById(R.id.date_vendor);
            Valable = (TextView) view.findViewById(R.id.valable_traininge_room_list);
            cardView = (CardView) view.findViewById(R.id.cardview_vedor);
            ratingBar_vendor = (RatingBar) view.findViewById(R.id.ratingBar_vendor);


        }


    }

    public WrokSpaceListAdapter(List<TrainingRoomListData> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.training_room_recyclerview, viewGroup, false);


        return new WrokSpaceListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        TrainingRoomListData vendor = moviesList.get(position);
        myViewHolder.Photo.setImageResource(vendor.getPhoto());
        myViewHolder.Name.setText(vendor.getName());
        myViewHolder.Location.setText(vendor.getLocation());
        myViewHolder.Phone.setText(vendor.getPhone());
        myViewHolder.date_vendor.setText(vendor.getDate());
        myViewHolder.Valable.setText(vendor.getValable());
        myViewHolder.ratingBar_vendor.setRating(Float.parseFloat(vendor.getRatingBarTrainingRoom()));




        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context,WorkSpaceDetailsActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}