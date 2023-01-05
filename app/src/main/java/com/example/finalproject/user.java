package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintProperties;
import androidx.constraintlayout.widget.Constraints;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class user extends AppCompatActivity {
    ListView listView;

    String names[] = {"Apple", "Banana", "watermelon", "kiwi", "orange","mango","pepaya","jambu","sawo","mengkudu","jeruk","apple","semangka"};
    String desc[] = {"this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange","this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange","this is Apple", "this is Banana", "this is Watermelon", "this is Kiwi", "this is Orange"};


    ArrayAdapter<String> arrayAdapter;
    List<ItemsModel> listItems = new ArrayList<>();

    CustomAdaptor customAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
//        getSupportActionBar().hide();

        listView = findViewById(R.id.listview);


        for(int i = 0; i < names.length; i++){
            listItems.add(new ItemsModel(names[i], desc[i]));
        }
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems);
//        listView.setAdapter(arrayAdapter);
        customAdaptor = new CustomAdaptor(listItems, this);
        listView.setAdapter(customAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdaptor.getFilter().filter(newText);
                return false;
            }
        });
    return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_view){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CustomAdaptor extends BaseAdapter implements Filterable {
        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdaptor(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_items,null);
            TextView itemName = view.findViewById(R.id.itemName);
            TextView itemDesc = view.findViewById(R.id.itemDesc);

            itemName.setText(itemsModelListFiltered.get(i).getName());
            itemDesc.setText(itemsModelListFiltered.get(i).getDesc());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(user.this, ItemViewActivity.class).putExtra("item", itemsModelListFiltered.get(i)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();
                    String constraint = null;
                    if(constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    }else {
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();
                        for(ItemsModel itemsModel:itemsModelList){
                            if (itemsModel.getName().contains(searchStr) || itemsModel.getDesc().contains(searchStr)){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    itemsModelListFiltered = (List<ItemsModel>) filterResults.values;
                    notifyDataSetChanged();

                }
            };
            return filter;
        }
    }
}