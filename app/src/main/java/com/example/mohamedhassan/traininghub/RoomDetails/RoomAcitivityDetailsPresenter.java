package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;

public class RoomAcitivityDetailsPresenter implements RoomAcitivityDetailsContract.Presenter {

    private RoomAcitivityDetailsContract.View mView;

    private Context mContext;

    public RoomAcitivityDetailsPresenter(RoomAcitivityDetailsContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }
}
