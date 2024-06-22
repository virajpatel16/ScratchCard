package com.code.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ShareViewModel extends AndroidViewModel {
    private final MutableLiveData<Integer> priceLiveData;
    private final SharedPreferences sharedPreferences;

    public ShareViewModel(@NonNull Application application) {
        super(application);
        sharedPreferences = application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        priceLiveData = new MutableLiveData<>();
        int storedPrice = sharedPreferences.getInt("price", 0);
        priceLiveData.setValue(storedPrice);
    }

    public LiveData<Integer> getPrice() {
        return priceLiveData;
    }

    public void setPrice(int price) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("price", price);
        editor.apply();
        priceLiveData.setValue(price);
    }
}
