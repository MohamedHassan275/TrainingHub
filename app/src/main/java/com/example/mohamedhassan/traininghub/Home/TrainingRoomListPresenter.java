package com.example.mohamedhassan.traininghub.Home;

import android.content.Context;



public class TrainingRoomListPresenter implements TrainingRoomListContract.Presenter {

    private TrainingRoomListContract.View mView;

    private Context mContext;

    public TrainingRoomListPresenter(TrainingRoomListContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
