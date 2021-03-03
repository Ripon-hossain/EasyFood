package com.foodOrder.easyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.foodOrder.easyfood.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image =  getIntent().getIntExtra("image",0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");

        binding.detailsImage.setImageResource(image);
        binding.detailsItemName.setText(name);
        binding.detailsPrice.setText(String.format("%d",price));
        binding.detailDescription.setText(description);

        DBHelper helepr = new DBHelper(this);

        binding.orderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               boolean isInserted = helepr.insertOrder(

                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())

                );
               if(isInserted){
                   Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_LONG).show();
               }else {
                   Toast.makeText(DetailActivity.this,"Error.", Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}