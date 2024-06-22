package com.code.myapplication;

import android.annotation.SuppressLint;



import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;

import in.myinnos.androidscratchcard.ScratchCard;

public class HomeFragment extends Fragment {

    private TextView textViewprize;
    ImageView rateapp;

    TextView textView;
    private ScratchCard mScratchCard;
    private ShareViewModel viewModel;
    LottieAnimationView lottieAnimationView;


    int sum = 0;
    private final int totalPrice = 0;


    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rateapp = view.findViewById(R.id.rateapp);
        textViewprize = view.findViewById(R.id.prize);

        lottieAnimationView = view.findViewById(R.id.anim);

        mScratchCard = view.findViewById(R.id.scratchCard);
        lottieAnimationView.setVisibility(View.INVISIBLE);


    










        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {



            @SuppressLint("NewApi")
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                int scratchPrice = generateRandomNumber(); // Generate the new scratch price
                String priceText = String.valueOf(scratchPrice);
                textViewprize.setText(priceText); // Set the new scratch price in textViewpriz

                viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
                viewModel.setPrice(Integer.parseInt(priceText));






                if (visiblePercent >= 0.01) {
                    // Hide the ScratchCard
                    mScratchCard.setVisibility(View.GONE);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                }
            }

        });


        rateapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayStore();
            }
        });


        return view;
    }


    private int generateRandomNumber() {
        int scratchPrice;
        scratchPrice = (int) (Math.random() * 100);
        textViewprize.setText(String.valueOf(scratchPrice));
        return scratchPrice;
    }

    private void openPlayStore() {
        String appPackageName = " com.code.scratchcash";
        try {
            Intent playStoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
            playStoreIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(playStoreIntent);
        } catch (android.content.ActivityNotFoundException e) {
            Intent playStoreWebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName));
            startActivity(playStoreWebIntent);
        }
    }



}
