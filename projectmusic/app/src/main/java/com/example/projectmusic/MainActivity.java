package com.example.projectmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] data ={"music1","music2","music3","music4","music5","music6","music7","music8","music9","music10","music11","music12","music13","music14"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,data);
        ListView ListView =(ListView) findViewById(R.id.ListView);
        ListView.setAdapter(adapter);
    }
}
