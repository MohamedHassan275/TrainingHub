package com.example.mohamedhassan.traininghub.MainFragmentClases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mohamedhassan.traininghub.R;
import com.example.mohamedhassan.traininghub.Register.RegisterActivity;
import com.example.mohamedhassan.traininghub.login.LoginActivity;

public class SignAndRegisterFragment extends Fragment {

    Button btnLogin, btnRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.sign_and_register_fragment, container, false);


        btnLogin = (Button) view.findViewById(R.id.btn_login_home_homescreen);
        btnRegister = (Button) view.findViewById(R.id.btn_register_homescreen);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }



}
