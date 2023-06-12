package com.phunlh2001.prm392_beverages.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.phunlh2001.prm392_beverages.R;


public class Delivery_NoOrder_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_delivery__no_order_, container, false);
        Button btn = (Button) rootView.findViewById(R.id.btn_order_now);
        btn.setOnClickListener(v -> {
            Toast.makeText(rootView.getContext(), "Order delivery (coming soon)", Toast.LENGTH_SHORT).show();
        });
        return rootView;
    }
}