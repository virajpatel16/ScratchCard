package com.code.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class PayoutFragment extends Fragment {

    ImageView buttonpay1, buttonpay2, buttonpay3, buttonpay4;
    ImageView amezonpay1, amezonpay2;
    ImageView paytm1, paytm2;
    ImageView payeer1, payeer2;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payout, container, false);
        buttonpay1 = view.findViewById(R.id.pay1);
        buttonpay2 = view.findViewById(R.id.pay2);
        buttonpay3 = view.findViewById(R.id.pay3);
        buttonpay4 = view.findViewById(R.id.pay4);
        amezonpay1 = view.findViewById(R.id.amezonpay1);
        amezonpay2 = view.findViewById(R.id.amezonpay2);
        paytm1 = view.findViewById(R.id.paytm1);
        paytm2 = view.findViewById(R.id.paytm2);
        payeer1 = view.findViewById(R.id.payeer1);
        payeer2 = view.findViewById(R.id.payeer2);

        buttonpay1.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });

        buttonpay2.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        buttonpay3.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        buttonpay4.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        amezonpay1.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        amezonpay2.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        paytm1.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        paytm2.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        payeer1.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });
        payeer2.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), FormPayment.class);
            startActivity(intent);
        });


        return view;
    }


}

