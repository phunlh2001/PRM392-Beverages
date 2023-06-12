package com.phunlh2001.prm392_beverages;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.phunlh2001.prm392_beverages.fragment.Delivery_Preparing_Fragment;
import com.phunlh2001.prm392_beverages.fragment.Store_pickup_No_Order_Fragment;
import com.phunlh2001.prm392_beverages.fragment.Store_pickup_Status_Fragment;


public class ViewPagerOrderManagementAdapter extends FragmentStateAdapter {


    public ViewPagerOrderManagementAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                //return new Store_pickup_No_Order_Fragment();
                return new Store_pickup_Status_Fragment();
            case 1:
                //return new Delivery_NoOrder_Fragment();\
                return new Delivery_Preparing_Fragment();
            default:
                return new Store_pickup_No_Order_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
