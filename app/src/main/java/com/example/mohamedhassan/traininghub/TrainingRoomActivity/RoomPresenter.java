package com.example.mohamedhassan.traininghub.TrainingRoomActivity;

import android.content.Context;

import com.example.mohamedhassan.traininghub.Register.RegisterContract;

public class RoomPresenter {

    private RoomContract.View mView;

    private Context mContext;

    public RoomPresenter(RoomContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
