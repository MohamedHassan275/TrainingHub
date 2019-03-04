package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;

import com.example.mohamedhassan.traininghub.TrainingRoomDetailsActivity.TrainingRoomDetailsContract;

public class RoomDetailsPresenter implements RoomDetailsContract.Presenter {

    private RoomDetailsContract.View mView;

    private Context mContext;

    public RoomDetailsPresenter(RoomDetailsContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }
}
