package com.foodOrder.easyfood.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foodOrder.easyfood.DBHelper;
import com.foodOrder.easyfood.MainActivity;
import com.foodOrder.easyfood.Models.OrdersModel;
import com.foodOrder.easyfood.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.OrderName.setText(model.getOderItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.orderprice.setText(model.getPrice());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                    new AlertDialog.Builder(context)
                    .setTitle("Delete")
                            .setIcon(R.drawable.delete)
                            .setMessage("You want to delete this item ?")
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    DBHelper helper = new DBHelper(context);
                                    if(helper.deleteOrder(model.getOrderNumber())>0){

                                    }
                                }
                            }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).show();

                return false;
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
            ImageView orderImage;
            TextView OrderName, orderNumber, orderprice;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.orderImage);
            OrderName = itemView.findViewById(R.id.OderItemName);
            orderNumber = itemView.findViewById(R.id.oderNumber);
            orderprice = itemView.findViewById(R.id.foodPrice);
        }
    }
}
