package com.example.mohamedhassan.traininghub.TrainingRoomDetailsActivity;

import android.content.Context;

public class RoomPresenter {

    private RoomContract.View mView;

    private Context mContext;

    public RoomPresenter(RoomContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
