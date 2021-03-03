package com.foodOrder.easyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.foodOrder.easyfood.Adapters.OrdersAdapter;
import com.foodOrder.easyfood.Models.OrdersModel;
import com.foodOrder.easyfood.databinding.ActivityOderBinding;

import java.util.ArrayList;

public class oderActivity extends AppCompatActivity {

    ActivityOderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


      //  ArrayList<OrdersModel> list = new ArrayList<>();
       // list.add(new OrdersModel(R.drawable.shawarma,"Shawarma", "120", "56495645"));
        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();


        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.ordersRecylerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.ordersRecylerView.setLayoutManager(linearLayoutManager);

    }
}