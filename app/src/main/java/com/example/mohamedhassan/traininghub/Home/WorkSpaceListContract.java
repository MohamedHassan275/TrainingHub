package com.example.mohamedhassan.traininghub.Home;

public interface WorkSpaceListContract {

    interface View{

        void showMessage(String message);

        void navigateToDetailRoom();

        void showProgress(boolean show);

        void showRooms(boolean show);

        void SortinSearch();

        void FilteringSearch();

    }
    interface Presenter{


    }

}
