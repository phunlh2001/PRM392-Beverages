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


public class Delivery_Preparing_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_stauts, container, false);
        TextView status = (TextView) view.findViewById(R.id.status_order);
        //If order is Delivering
        status.setText("Delivering");
        status.setTextColor(Color.parseColor("#1A94FF"));
        status.setBackgroundResource(R.drawable.custom_text_status_delivering);
        //Else layout will display Preparing (Already in design)

        //Onclick LinearLayout to go Order Detail
        LinearLayout orderDetail = (LinearLayout) view.findViewById(R.id.order_detail);
        orderDetail.setOnClickListener(v -> {
            Toast.makeText(view.getContext(), "Order detail of delivery", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}