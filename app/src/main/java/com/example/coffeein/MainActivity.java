package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.coffeein.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Serializable {

    private ActivityMainBinding binding;
    static ArrayList<Product> products = new ArrayList<Product>();

    static ArrayList<Serializable> ready_products = new ArrayList<Serializable>();

    private static ArrayList<Integer> checked = new ArrayList<>(Arrays.asList(6));

    ImageButton homebtn, favour, basket, profile;
    ImageView homeview, favourview, basketview, profileview;
    Button Dessert;

    BoxAdapter boxAdapter;


    ListView lvMain;

    Button btn;


    String [] notes = {"Эспрессо", "Американо", "Капучино", "Латте", "Какао"};

    int[] myImageList = new int[]{R.drawable.ekspres, R.drawable.amerika, R.drawable.kapp, R.drawable.latt, R.drawable.kaka};

    int[] price = {180, 200, 200, 250, 150};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
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
        Dessert = binding.dessert;
        Dessert.setOnClickListener(this);
        fillData();
        boxAdapter = new BoxAdapter(this, products);
        lvMain = binding.lvMain;
        lvMain.setAdapter(boxAdapter);
        setTitle("Меню");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, FavouriteActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent3.putExtra("Items", check());
                intent3.putExtra("Items2", MainActivity2.check());
                startActivity(intent3);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                break;
            case R.id.dessert:
                Intent intent5 = new Intent(this, MainActivity2.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent5);
                break;
        }
    }


    public static void onPress(int id) {
        checked.add(id);
    }

    public static ArrayList<Serializable> check(){
        int i = 0;
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
            products.add(new Product(notes[i], price[i],  myImageList[i], btn));
        }
    }

}