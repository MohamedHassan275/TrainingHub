package com.example.mohamedhassan.traininghub.Register;



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

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;

    private Context mContext;

    public RegisterPresenter(RegisterContract.View view, Context context) {
        mView=view;
        mContext=context;
    }

    @Override
    public void register(String email, String name, String password, String phone,String gander, String government, String city) {

        Retrofit retrofit=new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService=retrofit.create(APIService.class);
        Call<Result> call=apiService.createUser(name,email,password,phone,gander,government,city);
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
            }
        });
    }
}