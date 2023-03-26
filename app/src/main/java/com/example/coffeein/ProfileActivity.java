package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.coffeein.databinding.ActivityProfileBinding;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityProfileBinding binding;

    Button BSelectImage;

    ImageButton homebtn, favour, basket, profile;

    ImageView homeview, favourview, basketview, profileview, IVPreviewImage;

    int SELECT_PICTURE = 200;

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

    ActivityResultLauncher<Intent> startBasketActivityForResult = registerForActivityResult(
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
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
        basketview.setVisibility(View.INVISIBLE);
        profileview.setVisibility(View.VISIBLE);
        BSelectImage = binding.BSelectImage;
        IVPreviewImage = binding.IVPreviewImage;

        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
    }

    void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int  requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == SELECT_PICTURE){
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri){
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, FavouriteActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startFavouriteActivityForResult.launch(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startBasketActivityForResult.launch(intent3);
                break;
            case R.id.imageButton:
                Intent intent4 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startMainActivityForResult.launch(intent4);
                break;
        }
    }



}