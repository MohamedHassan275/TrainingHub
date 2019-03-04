package com.example.mohamedhassan.traininghub.login;

public interface LoginContract {

    interface View{

        void showMessage(String message);

        void navigateToMain();

        void navigateToRegister();

        void navigateToHome();

        void showProgress(boolean show);

        boolean isEmailValid(String email);

        boolean isPasswordValid(String password);

        void attemptLogin();
    }

    interface Presenter{

        void login(String email, String password);
    }
}
