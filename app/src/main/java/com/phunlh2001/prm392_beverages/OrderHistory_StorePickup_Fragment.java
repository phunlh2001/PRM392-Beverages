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

public class OrderHistory_StorePickup_Fragment extends Fragment {
    RecyclerView rcv;
    OrderHistoryAdapter orderHistoryAdapter;
    List<Order> mListOrder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_history_store_pickup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        rcv = view.findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setHasFixedSize(true);
        orderHistoryAdapter = new OrderHistoryAdapter(getContext(), mListOrder, "STOREPICKUP");
        rcv.setAdapter(orderHistoryAdapter);
        orderHistoryAdapter.notifyDataSetChanged();
    }

    private void initData(){
        mListOrder = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            Order order = new Order(135, OrderType.DELIVERY, OrderStatus.DELIVERED,1);
            mListOrder.add(order);
        }
    }
}