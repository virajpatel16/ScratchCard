package com.code.myapplication;



import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialogSecond extends Dialog {
    private static final String CHANNEL_ID ="" ;
    private final Button buttonConform;

    @SuppressLint("MissingInflatedId")
    public CustomDialogSecond(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_custom_second);


        buttonConform = findViewById(R.id.buttonconform);
        buttonConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}
