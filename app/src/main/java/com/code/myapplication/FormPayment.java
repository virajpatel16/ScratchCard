package com.code.myapplication;




import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Patterns;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;


public class FormPayment extends AppCompatActivity {
    private EditText editTextName,editTextupinumber;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private View.OnClickListener submitClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_payment);
        this.submitClickListener = this.submitClickListener;
        editTextName = findViewById(R.id.editTextName);
        editTextupinumber = findViewById(R.id.editTextupinumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(submitClickListener);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateInput()) {
                    // Call methods to get name, email, and mobile
                    String name = getName();
                    String email = getEmail();
                    String mobile = getmobile();

                    // Perform necessary actions with the obtained data
                    // For example, you can pass this data to another method, start another activity, etc.
                    // Here, we are just printing the values as an example
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Mobile: " + mobile);
                    openDialog(name, email, mobile);

                }
                else {
                    // Handle the case when OnSubmitListener is null

                    // Optionally, display a message to the user or take other corrective actions
                }


            }
        });
    }
    public String getName() {
        return editTextName.getText().toString().trim();
    }

    public String getEmail() {
        return editTextEmail.getText().toString().trim();
    }
    public String getmobile() {
        return editTextupinumber.getText().toString().trim();
    }

    private boolean validateInput() {
        String name = getName();
        String email = getEmail();
        String phoneNumber = getmobile();

        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Name cannot be empty");
            editTextName.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Invalid email address");
            editTextEmail.requestFocus();
            return false;
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Invalid email address");
            editTextEmail.requestFocus();
            return false;
        } else if (!email.endsWith("@gmail.com")) {
            editTextEmail.setError("Email must end with @gmail.com");
            editTextEmail.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(phoneNumber)) {
            editTextupinumber.setError("Phone number cannot be empty");
            editTextupinumber.requestFocus();
            return false;
        }else if (phoneNumber.length() != 10) {
            editTextupinumber.setError("Phone number must be 10 digits long");
            editTextupinumber.requestFocus();
            return false;
        }


        return true;
    }
    private void openDialog(String name, String email, String mobile) {
        // Create a new instance of the dialog
        Dialog dialog = new Dialog(this);

        // Set the custom dialog layout
        dialog.setContentView(R.layout.dialog_custom_second);

        // Find the button in the dialog layout
        ExtendedFloatingActionButton buttonConform = dialog.findViewById(R.id.buttonconform);

        // Set a click listener for the button
        buttonConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any action when the button is clicked
                // For example, you can dismiss the dialog
                dialog.dismiss();
                finish();

                // You can also perform any other action here
                // For example, start another activity or show a toast
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Show the dialog
        dialog.show();
    }





}