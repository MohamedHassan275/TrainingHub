package com.example.mohamedhassan.traininghub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.mohamedhassan.traininghub.Home.HomeMain;

import java.util.Locale;

public class ChangeLangauge extends AppCompatActivity implements View.OnClickListener {

    Context context = this;
    Dialog dialog;
    Button btn_arabic,btn_english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_langauge);

        ChangeLangauge.this.setTitle("Training");
        ShowActivationDialog();

    }

       private boolean ShowActivationDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.change_language, null);

        btn_arabic = (Button) alertLayout.findViewById(R.id.btn_arabic);
        btn_english = (Button) alertLayout.findViewById(R.id.btn_english);

        btn_arabic.setOnClickListener(this);


        btn_english.setOnClickListener(this);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);


        dialog = alert.create();
        dialog.show();
        return false;
    }

    @Override
    public void onClick(View v) {


        String languageToLoad = "en";

        if (v == btn_arabic){
            languageToLoad  = "ar";
        }else if(v==btn_english){
            languageToLoad  = "en";
        }


        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,context.getResources().getDisplayMetrics());



        Intent intent = new Intent(ChangeLangauge.this, HomeMain.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
