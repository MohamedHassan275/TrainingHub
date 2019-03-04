package com.example.mohamedhassan.traininghub.Register;

public interface RegisterContract {

    interface View{

        void showMessage(String message);



        void showProgress(boolean show);
        void IntentLogin();
        void navigateToMain();
        boolean isNameValid(String Name);
        boolean isEmailValid(String Email);
        boolean isPhoneValid(String Phone);
        boolean isGenderValid(String Gender);
        boolean isGovernmentValid (String gov);
        boolean isPasswordValid(String Password);
       // boolean isConfirmPasswordUserValid(String ConfirmPassword);
        void attemptRegister();



    }

    interface Presenter{

        void register(String email,String name, String password,String phone,String gander,String government,String city);
    }

}
