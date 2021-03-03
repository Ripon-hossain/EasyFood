package com.foodOrder.easyfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.foodOrder.easyfood.Models.OrdersModel;

import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 4;


    public DBHelper(@Nullable Context context  ) {
        super(context, DBNAME, null, DBVERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table EasyFood"+"(id integer primary key autoincrement," +
                        "name text," +
                        "phone text,"+
                        "price int,"+
                        "image int,"+
                        "quantity int,"+
                        "description,"+
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists EasyFood");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String description, String foodname, int quantity){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone",phone);
        values.put("price", price);
        values.put("image",image);
        values.put("quantity",quantity);
        values.put("description", description);
        values.put("foodname", foodname);
       long id = db.insert("EasyFood",null, values);
        if(id <=0){
            return false;

        }else {
            return true;
        }
    }
    public ArrayList<OrdersModel> getOrders(){

        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select id,foodname,image,price from EasyFood", null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setOderItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return orders;
    }
    public int deleteOrder(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return  sqLiteDatabase.delete("EasyFood", "id="+id,null);
    }
}
