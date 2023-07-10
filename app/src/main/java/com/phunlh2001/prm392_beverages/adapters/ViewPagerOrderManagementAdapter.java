package com.phunlh2001.prm392_beverages.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.phunlh2001.prm392_beverages.Delivery_NoOrder_Fragment;
import com.phunlh2001.prm392_beverages.Delivery_Preparing_Fragment;
import com.phunlh2001.prm392_beverages.Store_pickup_No_Order_Fragment;
import com.phunlh2001.prm392_beverages.Store_pickup_Status_Fragment;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderType;
import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerOrderManagementAdapter extends FragmentStateAdapter {

    List<Order> mListOrder = new ArrayList<>();
    int userId = 1;
    public ViewPagerOrderManagementAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        User user = new User("Phuong@gmail.com", "123", "Phuong", "Ca Mau", "013", "a", RoleAccount.USER);
        getDataOrder();
        boolean isHavingOrder = false;
        switch (position){
            case 0:
                //This code doesn't compare userId yet!!!! waiting for dtb
                for(Order o: mListOrder){
                    if(o.getShip_type().equals(OrderType.STORE_PICKUP) && (o.getStatus().equals(OrderStatus.READY_FOR_PICKUP) || o.getStatus().equals(OrderStatus.ORDER_RECEIVED))){
                        isHavingOrder = true;
                        return new Store_pickup_Status_Fragment(o);
                    }
                }
                if(!isHavingOrder) {
                    return new Store_pickup_No_Order_Fragment();
                }
            case 1:
                for(Order o: mListOrder){
                    if(o.getShip_type().equals(OrderType.DELIVERY) && (o.getStatus().equals(OrderStatus.DELIVERING) || o.getStatus().equals(OrderStatus.PREPARING))){
                        isHavingOrder = true;
                        return new Delivery_Preparing_Fragment(o);
                    }
                }
                if(!isHavingOrder) {
                    return new Store_pickup_No_Order_Fragment();
                }
            default:
                return new Store_pickup_No_Order_Fragment();
        }
    }

    public void getDataOrder(){
        mListOrder.add(new Order(100, OrderType.DELIVERY,OrderStatus.PREPARING, userId));
        mListOrder.add(new Order(130, OrderType.STORE_PICKUP,OrderStatus.ORDER_RECEIVED, userId));
        mListOrder.add(new Order(1302, OrderType.DELIVERY,OrderStatus.DELIVERED, userId));
        mListOrder.add(new Order(1303, OrderType.DELIVERY,OrderStatus.DELIVERY_FAILED, userId));
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
