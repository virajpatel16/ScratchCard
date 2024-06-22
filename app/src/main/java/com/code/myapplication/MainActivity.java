package com.code.myapplication;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    int total = 0;


    TextView textView;
    ShareViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showprize = findViewById(R.id.showprize);


        viewModel = new ViewModelProvider(this).get(ShareViewModel.class);

        viewModel.getPrice().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newPrice) {
                // Retrieve the old total from SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                int oldTotal = sharedPreferences.getInt("total", 0);

                // Calculate the updated total by adding the old total and the new price
                int updatedTotal = oldTotal + newPrice;


                // Set the prize text to display the updated amount
                showprize.setText(String.valueOf(updatedTotal));

                // Save the updated total back to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("total", updatedTotal);
                editor.apply();
            }
        });

        initView();

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        textView = findViewById(R.id.chnagetitle);

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout, homeFragment);
        fragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    replaceFragment(new HomeFragment());

                    textView.setText("SCRATCHER");
                } else if (itemId == R.id.navigation_task) {

                    replaceFragment(new TaskFragment());
                    textView.setText("TASK & EARN");
                } else if (itemId == R.id.navigation_share) {
                    textView.setText("REFERRAL");
                    replaceFragment(new ShareFragment());

                } else if (itemId == R.id.navigation_payout) {
                    textView.setText("PAYOUT");
                    replaceFragment(new PayoutFragment());

                }
                return true;
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();

        viewModel.setPrice(total);
    }




    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.exitdialog, null);
        alert.setView(view);
        final AlertDialog dialog = alert.create();
        dialog.setCancelable(false);
        view.findViewById(R.id.btnyes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finishAffinity();
                // finishAndRemoveTask();
            }
        });
        view.findViewById(R.id.btnno).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}




