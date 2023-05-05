package com.example.coffeein;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;

import android.os.Bundle;

public class MapActivity extends AppCompatActivity {


    private final String MAPKIT_API_KEY = "67143d2e-0fc7-4a20-8f2e-1fbe89608927";

    private MapView mapview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);
        mapview = findViewById(R.id.mapView3);
        mapview.getMap();
        setTitle("Кофейни");
    }
    
}