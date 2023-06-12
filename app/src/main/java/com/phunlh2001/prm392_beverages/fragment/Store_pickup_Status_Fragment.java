package com.phunlh2001.prm392_beverages.fragment;

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

import com.phunlh2001.prm392_beverages.R;


public class Store_pickup_Status_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Change layout to Store pickup


        View view = inflater.inflate(R.layout.fragment_delivery_stauts, container, false);
        TextView status = (TextView) view.findViewById(R.id.status_order);
        TextView location = (TextView) view.findViewById(R.id.location);
        ImageView imgTime = (ImageView) view.findViewById(R.id.locateToTime);
        //Received
        /*status.setText("Order received");
        status.setTextColor(Color.parseColor("#FC820A"));
        status.setBackgroundResource(R.drawable.custom_text_status_preparing);*/
        //Ready to pickup
        status.setText("Ready for pickup");
        status.setTextColor(Color.parseColor("#1A94FF"));
        status.setBackgroundResource(R.drawable.custom_text_status_delivering);

        //
        location.setText("10:00, Today");
        imgTime.setImageResource(R.drawable.img_home);

        //Onclick LinearLayout to go Order Detail
        LinearLayout orderDetail = (LinearLayout) view.findViewById(R.id.order_detail);
        orderDetail.setOnClickListener(v -> {
            Toast.makeText(view.getContext(), "Order detail of Store pickup", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}