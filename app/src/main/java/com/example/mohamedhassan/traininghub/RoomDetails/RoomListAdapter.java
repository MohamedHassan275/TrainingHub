package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomDetailsListData;
import com.example.mohamedhassan.traininghub.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.MyViewHolder> {

    private ArrayList<RoomDetailsListData> roomDetailsListData;
    Context context;

    public RoomListAdapter(Context context, ArrayList<RoomDetailsListData> roomListData) {
        this.context = context;
        this.roomDetailsListData = roomListData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.room_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.handel(roomDetailsListData,position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView circleImageView;
        public CardView cardViewRoom;
        public TextView Name, Capcity, Price;


        public MyViewHolder(View view) {
            super(view);

            cardViewRoom = (CardView) view.findViewById(R.id.cardViewRoom);
            circleImageView = (CircleImageView) view.findViewById(R.id.circleRoomListImageView);
            Name = (TextView) view.findViewById(R.id.TextView_nameRoom);
            Capcity = (TextView) view.findViewById(R.id.TextView_capacityRoomList);
            Price = (TextView) view.findViewById(R.id.Textview_priceRoomList);



        }


        private void handel(final ArrayList<RoomDetailsListData> roomDetailsListData, final int Postion){

            circleImageView.setImageResource(roomDetailsListData.get(Postion).getPhoto());
            Name.setText(roomDetailsListData.get(Postion).getName());
            Capcity.setText(roomDetailsListData.get(Postion).getCapcity());
            Price.setText(roomDetailsListData.get(Postion).getPrice());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(), RoomAcitivityDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return roomDetailsListData.size();
    }
}