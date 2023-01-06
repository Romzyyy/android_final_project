package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class admin extends AppCompatActivity {
    ListView listView;

    String names[] = {"Apple", "Banana", "watermelon", "kiwi", "orange","mango","pepaya","jambu","sawo","mengkudu","jeruk","apple","semangka"};
    String desc[] = {"this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange","this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange","this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange"};

    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> baseAdapter;
    List<ItemsModel> listItems = new ArrayList<>();

    user.CustomAdaptor customAdaptor;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter(this, names, desc);
        listView.setAdapter(customAdapter);

    }

    public class CustomAdapter extends ArrayAdapter<String> {
        private String[] names;
        private String[] desc;

        public CustomAdapter(@NonNull Context context, String[] names, String[] desc) {
            super(context, R.layout.custom_list_item, names);
            this.names = names;
            this.desc = desc;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View customView = layoutInflater.inflate(R.layout.custom_list_item, parent, false);

            String name = names[position];
            String description = desc[position];

            TextView nameTextView = customView.findViewById(R.id.nameTextView);
            TextView descTextView = customView.findViewById(R.id.descriptionTextView);

            nameTextView.setText(name);
            descTextView.setText(description);

            return customView;
        }
    }

}