package com.code.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class DailyrewardFragment extends Fragment {

Button  BTN_NO;

    private static final String PREFS_NAME = "DailyRewardPrefs";
    private static final String KEY_LAST_REWARD_DATE = "lastRewardDate";
    private static final String KEY_POINTS = "points";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dailyreward, container, false);
        BTN_NO=view.findViewById(R.id.BTN_NO);

        BTN_NO = view.findViewById(R.id.BTN_NO);
        BTN_NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                claimDailyReward();
            }
        });






        return  view;
    }

    private void claimDailyReward() {
        // Get the last reward date from SharedPreferences
        SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        long lastRewardDate = prefs.getLong(KEY_LAST_REWARD_DATE, 0);


        long currentDate = System.currentTimeMillis();

        // Check if it's a new day
        if (isSameDay(lastRewardDate, currentDate)) {
            Toast.makeText(getActivity(), "You have already claimed your daily reward today", Toast.LENGTH_SHORT).show();
        } else {
            // Reward the user with 1500 points
            int currentPoints = prefs.getInt(KEY_POINTS, 0);
            currentPoints += 150;

            // Save the new points and last reward date to SharedPreferences
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(KEY_POINTS, currentPoints);
            editor.putLong(KEY_LAST_REWARD_DATE, currentDate);
            editor.apply();

            Toast.makeText(getActivity(), "You have claimed your daily reward. You now have " + currentPoints + " points.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isSameDay(long date1, long date2) {
        // Convert the timestamps to days
        long day1 = date1 / (1000 * 60 * 60 * 24);
        long day2 = date2 / (1000 * 60 * 60 * 24);

        return day1 == day2;
    }
}