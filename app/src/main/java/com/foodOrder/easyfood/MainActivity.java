package com.foodOrder.easyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.foodOrder.easyfood.Adapters.MainAdapter;
import com.foodOrder.easyfood.Models.MainModel;
import com.foodOrder.easyfood.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.sample_main_food);

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger, "Burger", "250","with all the fixings, cheese, lettuce, tomato, onions and special sauce or mayonnaise!"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "450","Pepperoni, mushrooms, Spanish onions, green peppers, bacon & mozzarella."));
        list.add(new MainModel(R.drawable.pasta, "Pasta", "320","Pasta, Ravioli, Carbonara, Marinara, Lasagna, Alfredo, Aliolio, Tom's Pasta and more!"));
        list.add(new MainModel(R.drawable.shawarma, "Shawarma", "110","Chicken Shawarma with Garlic Sauce Plate. Served with rice, spiced potatoes, green salad and pita bread."));
        list.add(new MainModel(R.drawable.fried_chiken, "Fried Chicken", "220","It makes for some delicious fried chicken wings."));


        MainAdapter adapter = new MainAdapter(list ,this);
        binding.recyclerv.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerv.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders :
                startActivity(new Intent(MainActivity.this, oderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}