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

import com.example.mohamedhassan.traininghub.Model_RoomTraining.GetRoomListData;
import com.example.mohamedhassan.traininghub.R;

import java.util.List;

public class RoomWorkSpaceListAdapter extends RecyclerView.Adapter<RoomWorkSpaceListAdapter.MyViewHolder> {

    private List<GetRoomListData> roomListData;
    Context context;

    public RoomWorkSpaceListAdapter(List<GetRoomListData> roomListData, Context context) {
        this.roomListData = roomListData;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView PhotoDepartment1,PhotoDepartment2,PhotoDepartment3;
        public TextView Name, Capcity, Price;


        public MyViewHolder(View view) {
            super(view);

            PhotoDepartment1 = (ImageView) view.findViewById(R.id.image_get_room_department1);
            PhotoDepartment2 = (ImageView) view.findViewById(R.id.image_get_room_department2);
            PhotoDepartment3 = (ImageView) view.findViewById(R.id.image_get_room_department3);
            Name = (TextView) view.findViewById(R.id.name_get_room);
            Capcity = (TextView) view.findViewById(R.id.capcity_get_room);
            Price = (TextView) view.findViewById(R.id.price_get_room);


        }
    }


    public RoomWorkSpaceListAdapter(List<GetRoomListData> roomListData) {
        this.roomListData = roomListData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.room_list_home, viewGroup, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        GetRoomListData roomListData = this.roomListData.get(position);
        myViewHolder.PhotoDepartment1.setImageResource(roomListData.getPhotoDepartment1());
        myViewHolder.PhotoDepartment2.setImageResource(roomListData.getPhotoDepartment2());
        myViewHolder.PhotoDepartment3.setImageResource(roomListData.getPhotoDepartment3());
        myViewHolder.Name.setText(roomListData.getName());
        myViewHolder.Capcity.setText(roomListData.getCapcity());
        myViewHolder.Price.setText(roomListData.getPrice());


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(myViewHolder.itemView.getContext(), RoomAcitivityDetailsActivity.class);
                myViewHolder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return roomListData.size();
    }
}
