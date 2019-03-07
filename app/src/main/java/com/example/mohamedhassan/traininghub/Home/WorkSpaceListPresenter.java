package com.example.mohamedhassan.traininghub.Home;

import android.content.Context;



public class WorkSpaceListPresenter implements WorkSpaceListContract.Presenter {

    private WorkSpaceListContract.View mView;

    private Context mContext;

    public WorkSpaceListPresenter(WorkSpaceListContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
