package com.code.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fragment_container extends AppCompatActivity {
int checkin=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_container);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getIntent().getExtras()!= null){
           checkin= getIntent().getIntExtra("dailycheck",1);
            if (checkin==101){


                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new DailyrewardFragment())
                        .commit();
            }else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new ReferralFragment())
                        .commit();
            }
        }




    }
    }
