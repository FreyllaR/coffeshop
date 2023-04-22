package com.example.coffeein;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Product extends ArrayList<Parcelable> implements Parcelable {
    String name;
    int price;
    int image;

    Button buttoncheck;

    Product(String _describe, int _price, int _image, Button butt){
        name = _describe;
        price = _price;
        image = _image;
        buttoncheck = butt;
    }

    protected Product(Parcel in) {
        name = in.readString();
        price = in.readInt();
        image = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
        parcel.writeInt(image);
    }
}
