package com.example.mohamedhassan.traininghub.NavFragmentClases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mohamedhassan.traininghub.Home.HomeMain;
import com.example.mohamedhassan.traininghub.Model_LoginAndRegister.SessionManager;
import com.example.mohamedhassan.traininghub.R;

public class Profile_fragment extends Fragment {

Button logout;
SessionManager sessionManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        logout = (Button)view.findViewById(R.id.logout);

        sessionManager=new SessionManager(getActivity());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessionManager.logoutUser();
                startActivity(new Intent(getActivity(), HomeMain.class));
                getActivity().finish();
            }
        });
        return view;
    }
}