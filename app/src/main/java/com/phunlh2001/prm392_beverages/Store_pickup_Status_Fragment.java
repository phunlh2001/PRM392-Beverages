package com.phunlh2001.prm392_beverages;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Store_pickup_Status_Fragment extends Fragment {
    private Order order;

    public Store_pickup_Status_Fragment(Order order) {
        this.order = order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Change layout to Store pickup


        View view = inflater.inflate(R.layout.fragment_delivery_stauts, container, false);
        TextView status = (TextView) view.findViewById(R.id.status_order);
        TextView location = (TextView) view.findViewById(R.id.location);
        ImageView imgTime = (ImageView) view.findViewById(R.id.locateToTime);
        TextView totalPrice = (TextView) view.findViewById(R.id.totalPrice);
        TextView order_date = (TextView) view.findViewById(R.id.order_date);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        //Received
        if(order.getStatus().equals(OrderStatus.ORDER_RECEIVED)){
            status.setText("Order received");
            status.setTextColor(Color.parseColor("#FC820A"));
            status.setBackgroundResource(R.drawable.custom_text_status_preparing);
            totalPrice.setText(String.valueOf(order.getTotal_price()));
            order_date.setText(String.valueOf(date));
        }
        //Ready to pickup
        if(order.getStatus().equals(OrderStatus.READY_FOR_PICKUP)){
            status.setText("Ready for pickup");
            status.setTextColor(Color.parseColor("#1A94FF"));
            status.setBackgroundResource(R.drawable.custom_text_status_delivering);
            totalPrice.setText(String.valueOf(order.getTotal_price()));
            order_date.setText(String.valueOf(date));
        }


        //
        location.setText("10:00, Today");
        imgTime.setImageResource(R.drawable.img_clock);

        //Onclick LinearLayout to go Order Detail
        LinearLayout orderDetail = (LinearLayout) view.findViewById(R.id.order_detail);
        orderDetail.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getBaseContext(), OrderDetail.class);
            intent.putExtra("message", "Message");
            getActivity().startActivity(intent);
        });
        return view;
    }
}