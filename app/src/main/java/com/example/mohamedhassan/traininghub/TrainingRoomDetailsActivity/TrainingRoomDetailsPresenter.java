package com.example.mohamedhassan.traininghub.TrainingRoomDetailsActivity;

import android.content.Context;

public class TrainingRoomDetailsPresenter {

    private TrainingRoomDetailsContract.View mView;

    private Context mContext;

    public TrainingRoomDetailsPresenter(TrainingRoomDetailsContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
