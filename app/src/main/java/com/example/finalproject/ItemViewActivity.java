package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ItemViewActivity extends AppCompatActivity {

    TextView textViewName, textViewDesc;

    ItemsModel itemsModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        textViewName = findViewById(R.id.textViewName);
        textViewDesc = findViewById(R.id.textViewDesc);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            textViewName.setText(itemsModel.getName());
            textViewDesc.setText(itemsModel.getDesc());
        }
    }
}