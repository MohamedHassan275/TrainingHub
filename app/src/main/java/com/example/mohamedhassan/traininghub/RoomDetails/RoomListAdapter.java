package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mohamedhassan.traininghub.ChangeLangauge;
import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomListData;
import com.example.mohamedhassan.traininghub.R;

import java.util.List;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.MyViewHolder> {

    private List<RoomListData> moviesList;
    Context context;

    public RoomListAdapter(Context context, List<RoomListData> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView PhotoRoom,image_traininge_room_department,image_traininge_room_department2,image_traininge_room_department3;
        public TextView Name, Capcity, Price, Valable;


        public MyViewHolder(View view) {
            super(view);

            PhotoRoom = (ImageView) view.findViewById(R.id.image_traininge_room);
            image_traininge_room_department = (ImageView) view.findViewById(R.id.image_traininge_room_department);
            image_traininge_room_department2 = (ImageView) view.findViewById(R.id.image_traininge_room_department2);
            image_traininge_room_department3 = (ImageView) view.findViewById(R.id.image_traininge_room_department3);
            Name = (TextView) view.findViewById(R.id.name_traininge_room);
            Capcity = (TextView) view.findViewById(R.id.capcity_traininge_room);
            Price = (TextView) view.findViewById(R.id.price_traininge_room);
            Valable = (TextView) view.findViewById(R.id.valable_traininge_room);

        }
    }

    public RoomListAdapter(List<RoomListData> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.room_training, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        RoomListData movie = moviesList.get(position);
        myViewHolder.PhotoRoom.setImageResource(movie.getPhoto());
        myViewHolder.image_traininge_room_department.setImageResource(movie.getImage_traininge_room_department());
        myViewHolder.image_traininge_room_department2.setImageResource(movie.getImage_traininge_room_department2());
        myViewHolder.image_traininge_room_department3.setImageResource(movie.getImage_traininge_room_department3());
        myViewHolder.Name.setText(movie.getName());
        myViewHolder.Capcity.setText(movie.getCapcity());
        myViewHolder.Price.setText(movie.getPrice());
        myViewHolder.Valable.setText(movie.getValable());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context,ChangeLangauge.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
