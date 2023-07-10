package com.phunlh2001.prm392_beverages;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.phunlh2001.prm392_beverages.R;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Delivery_Preparing_Fragment extends Fragment {
    private Order order;

    public Delivery_Preparing_Fragment(Order order) {
        this.order = order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_stauts, container, false);
        TextView status = (TextView) view.findViewById(R.id.status_order);
        TextView order_date = (TextView) view.findViewById(R.id.order_date);
        TextView totalPrice = (TextView) view.findViewById(R.id.totalPrice);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        if(order.getStatus().equals(OrderStatus.DELIVERING)){
            status.setText("Delivering");
            status.setTextColor(Color.parseColor("#1A94FF"));
            status.setBackgroundResource(R.drawable.custom_text_status_delivering);
            totalPrice.setText(String.valueOf(order.getTotal_price()));
            order_date.setText(String.valueOf(date));
        }else{
            totalPrice.setText(String.valueOf(order.getTotal_price()));
            order_date.setText(String.valueOf(date));
        }
        //Else layout will display Preparing (Already in design)

        //Onclick LinearLayout to go Order Detail
        LinearLayout orderDetail = (LinearLayout) view.findViewById(R.id.order_detail);
        orderDetail.setOnClickListener(v -> {
            Toast.makeText(view.getContext(), "Order detail of delivery", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}