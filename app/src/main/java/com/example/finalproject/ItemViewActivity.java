package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ItemViewActivity extends AppCompatActivity {

    TextView textView;

    ItemsModel itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        textView = findViewById(R.id.textViewName);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            textView.setText(itemsModel.getName());
        }
    }
}