package com.example.coffeein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.coffeein.databinding.ActivityFavouriteBinding;

public class FavouriteActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityFavouriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("Name", binding.editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}