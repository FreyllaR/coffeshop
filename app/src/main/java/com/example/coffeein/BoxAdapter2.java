package com.example.coffeein;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.coffeein.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxAdapter2 extends BaseAdapter {

    Context ctx;

    Button check2;

    LayoutInflater lInflater;
    ArrayList<Product> objects;
    
    BoxAdapter2(Context context, ArrayList<Product> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return objects.size();
    }


    public Object getItem(int i) {
        return objects.get(i);
    }


    public long getItemId(int i) {
        return i;
    }

    public int getPrice(){
        int sum = 0;
        for(int i = 0; i < objects.size(); i++){
            sum += objects.get(i).price;
        }
        return sum;
    }



    public View getView(int i, View convertview, ViewGroup parent) {

        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        Product p = getProduct(i);

        binding.tvDescr.setText(p.name);
        binding.tvPrice.setText(p.price + " рублей");
        binding.ivImage.setImageResource(p.image);
        
        check2 = binding.butcheck;

        check2.setOnClickListener(v -> {
            MainActivity2.onPress(i);
        });

        return binding.getRoot();

    }


    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

}