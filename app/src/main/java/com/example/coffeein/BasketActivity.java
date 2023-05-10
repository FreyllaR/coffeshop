package com.example.coffeein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.coffeein.databinding.ActivityBasketBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityBasketBinding binding;

    ImageButton homebtn, favour, basket, profile;

    Button paybut;

    ImageView homeview, favourview, basketview, profileview;

    ListView lvBasket;

    ArrayList<Product> products_coffee = new ArrayList<>();

    ArrayList<Product> products_dessert = new ArrayList<>();


    ArrayList<Product> common_products = new ArrayList<>();
    BoxAdapter boxAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homebtn = binding.imageButton;
        favour = binding.imageButton2;
        basket = binding.imageButton3;
        profile = binding.imageButton4;
        paybut = binding.paybutton;
        paybut.setOnClickListener(this);
        homebtn.setOnClickListener(this);
        favour.setOnClickListener(this);
        basket.setOnClickListener(this);
        profile.setOnClickListener(this);
        homeview = binding.imageView9;
        favourview = binding.imageView10;
        basketview = binding.imageView11;
        profileview = binding.imageView12;
        homeview.setVisibility(View.INVISIBLE);
        favourview.setVisibility(View.INVISIBLE);
        basketview.setVisibility(View.VISIBLE);
        profileview.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();

        lvBasket = binding.lvBasket;

        products_coffee = (ArrayList<Product>) intent.getSerializableExtra("Items");
        products_dessert = (ArrayList<Product>) intent.getSerializableExtra("Items2");

        for(int i = 0; i < products_coffee.size(); i++){
            common_products.add(products_coffee.get(i));
        }

        for(int i = 0; i < products_dessert.size(); i++){
            common_products.add(products_dessert.get(i));
        }


        if(products_coffee.size() != 0) {
            boxAdapter = new BoxAdapter(this, common_products);
            lvBasket.setAdapter(boxAdapter);
        }

        if(products_coffee.size() == 0 && products_dessert.size() == 0){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Корзина пуста", Toast.LENGTH_LONG);
            toast.show();
            paybut.setClickable(false);
        }else{
            paybut.setClickable(true);
        }
        setTitle("Корзина");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.clean){
           lvBasket.setAdapter(null);
           products_dessert.clear();
           products_coffee.clear();
           common_products.clear();
           MainActivity.CleanUp();
           MainActivity2.CleanUp();
            paybut.setClickable(false);
        }else{
            paybut.setClickable(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, MapActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                homeview.setVisibility(View.INVISIBLE);
                favourview.setVisibility(View.VISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.INVISIBLE);
                break;
            case R.id.imageButton:
                Intent intent3 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent3);
                homeview.setVisibility(View.VISIBLE);
                favourview.setVisibility(View.INVISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.INVISIBLE);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                homeview.setVisibility(View.INVISIBLE);
                favourview.setVisibility(View.INVISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.VISIBLE);
                break;
            case R.id.paybutton:
                Intent intent5 = new Intent(this, PaymentActivity.class);
                intent5.putExtra("Cmps", common_products);
                startActivity(intent5);
                break;
        }
    }
}