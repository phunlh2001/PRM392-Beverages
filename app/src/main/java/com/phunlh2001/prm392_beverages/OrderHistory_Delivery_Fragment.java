package com.phunlh2001.prm392_beverages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phunlh2001.prm392_beverages.adapters.OrderHistoryAdapter;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderType;

import java.util.ArrayList;
import java.util.List;


public class OrderHistory_Delivery_Fragment extends Fragment {
    RecyclerView rcv;
    OrderHistoryAdapter orderHistoryAdapter;
    List<Order> mListOrder;

    public OrderHistory_Delivery_Fragment(List<Order> mListOrder) {
        this.mListOrder = mListOrder;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_history_delivery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = view.findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setHasFixedSize(true);
        orderHistoryAdapter = new OrderHistoryAdapter(getContext(), mListOrder, "DELIVERY");
        rcv.setAdapter(orderHistoryAdapter);
        orderHistoryAdapter.notifyDataSetChanged();
    }
}