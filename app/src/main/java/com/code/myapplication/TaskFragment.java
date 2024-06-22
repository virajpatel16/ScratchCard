package com.code.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class TaskFragment extends Fragment {

    private CardView cardView;


    CardView daily;

     @SuppressLint("MissingInflatedId")
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_task, container, false);
        cardView = view.findViewById(R.id.reffralcard);
         daily=view.findViewById(R.id.daily);
        // Set click listener for CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(),Fragment_container.class);
                intent.putExtra("dailycheck",102);
               startActivity(intent);

            }
        });
         daily.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // Get the current date
                 Calendar calendar = Calendar.getInstance();
                 int currentDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

                 // Get the last clicked date from SharedPreferences
                 SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                 int lastClickedDayOfYear = sharedPreferences.getInt("lastClickedDayOfYear", -1);

                 // Check if the button has been clicked today
                 if (currentDayOfYear != lastClickedDayOfYear) {
                     // Allow the action since it hasn't been clicked today
                     Intent intent = new Intent(getActivity(), Fragment_container.class);
                     intent.putExtra("dailycheck", 101);

                     startActivity(intent);

                     // Update the last clicked date in SharedPreferences
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putInt("lastClickedDayOfYear", currentDayOfYear);
                     editor.apply();
                 } else {
                     // Show a message indicating that the button can only be clicked once a day
                     Toast.makeText(getActivity(), "Already Claimed!.", Toast.LENGTH_SHORT).show();
                 }
             }
         });

        return view;

    }
}