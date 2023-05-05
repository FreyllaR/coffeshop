package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.coffeein.databinding.ActivityBasketBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityBasketBinding binding;

    ImageButton homebtn, favour, basket, profile;

    ImageView homeview, favourview, basketview, profileview;

    ListView lvBasket, lvBasket2;

    ArrayList<Product> products_coffee = new ArrayList<>();

    ArrayList<Product> products_dessert = new ArrayList<>();
    BoxAdapter boxAdapter;

    BoxAdapter2 boxAdapter2;



    ActivityResultLauncher<Intent> startFavouriteActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> startMainActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> startProfileActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homebtn = binding.imageButton;
        favour = binding.imageButton2;
        basket = binding.imageButton3;
        profile = binding.imageButton4;
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
        lvBasket2 = binding.lvBasket2;

        products_coffee = (ArrayList<Product>) intent.getSerializableExtra("Items");
        products_dessert = (ArrayList<Product>) intent.getSerializableExtra("Items2");

        if(products_coffee.size() != 0) {
            boxAdapter = new BoxAdapter(this, products_coffee);
            lvBasket.setAdapter(boxAdapter);
        }
        if(products_dessert.size() != 0){
            boxAdapter2 = new BoxAdapter2(this, products_dessert);
            lvBasket2.setAdapter(boxAdapter2);
        }
        setTitle("Корзина");
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
        }
    }
}