package com.example.coffeein;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coffeein.databinding.ActivityPaymentBinding;

import java.util.ArrayList;
import java.util.Random;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    BoxAdapter boxAdapter;

    ArrayList<Product> common_products = new ArrayList<>();

    ListView lvBasket;

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Заказ");
        Intent intent = getIntent();
        lvBasket = binding.lvBasket;
        common_products = (ArrayList<Product>) intent.getSerializableExtra("Cmps");
        boxAdapter = new BoxAdapter(this, common_products);
        lvBasket.setAdapter(boxAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(PaymentActivity.this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}