package com.example.coffeein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.coffeein.databinding.ActivityMain2Binding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, Serializable {


    static ArrayList<Product> products = new ArrayList<Product>();

    static ArrayList<Serializable> ready_products = new ArrayList<Serializable>();

    private ActivityMain2Binding binding;

    boolean flag = true;

    ImageButton homebtn, favour, basket, profile;
    ImageView homeview, favourview, basketview, profileview;
    Button Coffee;

    BoxAdapter2 boxAdapter2;


    ListView lvMain2;

    Button btn2;


    String [] notes = {"Чизкейк Нью-Йорк", "Печенье", "Пончик", "Кофейная прага", "Макарони"};

    int[] myImageList = new int[]{R.drawable.chizkeik, R.drawable.pechenie, R.drawable.ponchik, R.drawable.tortchoko, R.drawable.pachkabutslad};

    int[] price = {200, 400, 100, 250, 150};


    private static ArrayList<Integer> checked = new ArrayList<>(Arrays.asList(6));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homebtn = binding.imageButton;
        favour = binding.imageButton2;
        basket = binding.imageButton3;
        profile = binding.imageButton4;
        homeview = binding.imageView9;
        favourview = binding.imageView10;
        basketview = binding.imageView11;
        profileview = binding.imageView12;
        homebtn.setOnClickListener(this);
        favour.setOnClickListener(this);
        basket.setOnClickListener(this);
        profile.setOnClickListener(this);
        homeview.setVisibility(View.VISIBLE);
        favourview.setVisibility(View.INVISIBLE);
        basketview.setVisibility(View.INVISIBLE);
        profileview.setVisibility(View.INVISIBLE);
        Coffee = binding.coffee;
        Coffee.setOnClickListener(this);
        products.clear();
        fillData();
        boxAdapter2 = new BoxAdapter2(this, products);
        lvMain2 = binding.lvMain2;
        lvMain2.setAdapter(boxAdapter2);
        setTitle("Меню");
    }

    public static void CleanUp(){
        checked.clear();
        ready_products.clear();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, MapActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent3.putExtra("Items2", check());
                intent3.putExtra("Items", MainActivity.check());
                startActivity(intent3);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                break;
            case R.id.coffee:
                Intent intent5 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent5);
                break;
        }
    }

    public static void onPress(int id) {
        checked.add(id);
    }

    public static ArrayList<Serializable> check(){
        int i = 0;
        ready_products.clear();
        while(i != products.size()){
            for(int q = 0; q < checked.size(); q++) {
                if (checked.get(q) == i) {
                    ready_products.add(products.get(i));
                }
            }
            i++;
        }
        return ready_products;
    }

    void fillData(){
        for(int i = 0; i < 5; i++){
            products.add(new Product(notes[i], price[i],  myImageList[i], btn2));
        }
    }

}