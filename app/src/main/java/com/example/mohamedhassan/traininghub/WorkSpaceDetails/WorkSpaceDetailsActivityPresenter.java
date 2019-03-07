package com.example.mohamedhassan.traininghub.WorkSpaceDetails;

import android.content.Context;

public class WorkSpaceDetailsActivityPresenter {

    private WorkSpaceDetailsActivityContract.View mView;

    private Context mContext;

    public WorkSpaceDetailsActivityPresenter(WorkSpaceDetailsActivityContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


}
