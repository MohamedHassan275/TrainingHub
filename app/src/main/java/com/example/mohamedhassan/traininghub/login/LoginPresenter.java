package com.example.mohamedhassan.traininghub.login;

import android.content.Context;

import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.APIService;
import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.APIUrl;
import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.Result;
import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View mView;

    private Context mContext;

    public LoginPresenter(LoginContract.View view, Context context) {

        mView = view;

        mContext = context;
    }

    @Override
    public void login(String email, String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);


        Call<Result> call = service.userLogin(email, password);

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                mView.showProgress(false);

                mView.showMessage(response.body().getMessage());

                if (!response.body().getError()) {

                    SessionManager.getInstance(mContext).createLoginSession(response.body().getUser());
                    mView.navigateToMain();
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                mView.showProgress(false);
                mView.showMessage(t.getMessage());
            }
        });

    }

}
