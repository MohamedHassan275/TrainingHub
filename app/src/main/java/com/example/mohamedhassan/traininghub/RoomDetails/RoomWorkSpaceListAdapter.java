package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mohamedhassan.traininghub.Model_RoomTraining.RoomWorkSpaceListData;
import com.example.mohamedhassan.traininghub.R;

import java.util.ArrayList;

public class RoomWorkSpaceListAdapter extends RecyclerView.Adapter<RoomWorkSpaceListAdapter.MyViewHolder> {


    Context context;
    private ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData;
    private LinearLayout linearLayout;
    private LinearLayout.LayoutParams layoutParams;

    public RoomWorkSpaceListAdapter(Context context, ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData) {
        this.context = context;
        this.roomWorkSpaceListData = roomWorkSpaceListData;
    }

    public RoomWorkSpaceListAdapter(Context context, ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData, LinearLayout.LayoutParams layoutParams) {
        this.context = context;
        this.roomWorkSpaceListData = roomWorkSpaceListData;
        this.layoutParams = layoutParams;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.room_work_space_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.handel(roomWorkSpaceListData,position);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public CardView CardViewRoomWorkSpace;
        public TextView Name, Capcity, Price;


        public MyViewHolder(View view) {
            super(view);

            linearLayout = (LinearLayout) view.findViewById(R.id.layout_room_work_space);
            CardViewRoomWorkSpace = (CardView) view.findViewById(R.id.cardWorkSpaceViewRoom);
            Name = (TextView) view.findViewById(R.id.nameRoomWorkSpace);
            Capcity = (TextView) view.findViewById(R.id.capacityRoomWorkSpace);
            Price = (TextView) view.findViewById(R.id.priceRoomWorkSpace);


        }

        private void handel(final ArrayList<RoomWorkSpaceListData> roomWorkSpaceListData, final int Postion){

            if (layoutParams==null){
              //  layoutParams= (LinearLayout.LayoutParams) layoutAdapterConstraintLayout.getLayoutParams();
            }else {
                linearLayout.setLayoutParams(layoutParams);
                layoutParams.setMargins(0,5,0,5);
                itemView.requestFocus();
            }

            Name.setText(roomWorkSpaceListData.get(Postion).getNameRoomWorkSpace());
            Capcity.setText(roomWorkSpaceListData.get(Postion).getCapistyRoomWorkSpace());
            Price.setText(roomWorkSpaceListData.get(Postion).getSalaryRoomWorkSpace());

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
        return roomWorkSpaceListData.size();
    }
}
