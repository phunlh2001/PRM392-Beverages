package com.phunlh2001.prm392_beverages.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.phunlh2001.prm392_beverages.Delivery_Preparing_Fragment;
import com.phunlh2001.prm392_beverages.OrderHistory_Delivery_Fragment;
import com.phunlh2001.prm392_beverages.OrderHistory_StorePickup_Fragment;
import com.phunlh2001.prm392_beverages.Store_pickup_No_Order_Fragment;

public class ViewPagerOrderHistoryAdapter extends FragmentStateAdapter {
    public ViewPagerOrderHistoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new OrderHistory_StorePickup_Fragment();
            case 1:
                //return new Delivery_NoOrder_Fragment();\
                return new OrderHistory_Delivery_Fragment();

            default:
                return new Store_pickup_No_Order_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
