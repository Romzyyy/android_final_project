package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewActivity extends AppCompatActivity {

    TextView textViewName, textViewDesc;

    ItemsModel itemsModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);
        TextView tittle = findViewById(R.id.toolbar_tittle);


        textViewName = findViewById(R.id.textViewName);
        textViewDesc = findViewById(R.id.textViewDesc);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            textViewName.setText(itemsModel.getName());
            textViewDesc.setText(itemsModel.getDesc());
        }

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ItemViewActivity.this, user.class);
                startActivity(intent);
            }
        });
    }
}