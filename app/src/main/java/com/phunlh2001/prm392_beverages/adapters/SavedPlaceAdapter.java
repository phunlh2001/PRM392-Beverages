package com.phunlh2001.prm392_beverages.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phunlh2001.prm392_beverages.R;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.helper.ISavedPlace;

import java.util.List;

public class SavedPlaceAdapter extends RecyclerView.Adapter<SavedPlaceAdapter.SavedPlaceViewHolder> {
    List<User> userList;
    private final ISavedPlace iClickItem;

    public SavedPlaceAdapter(ISavedPlace iClickItem) {
        this.iClickItem = iClickItem;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<User> list) {
        userList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SavedPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false);
        return new SavedPlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedPlaceViewHolder holder, int position) {
        User user = userList.get(position);
        if (user == null) return;

        holder.tvName.setText(user.getFull_name());
        holder.tvPhone.setText(user.getPhone_number());
        holder.tvAddress.setText(user.getAddress());

        holder.btnEdit.setOnClickListener(v -> {
            iClickItem.onClickEditAddress(user);
            iClickItem.onClickDeleteAddress(user);
        });
    }

    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    public static class SavedPlaceViewHolder extends RecyclerView.ViewHolder {
        TextView tvAddress, tvName, tvPhone;
        ImageView btnEdit, btnDelete;

        public SavedPlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAddress = itemView.findViewById(R.id.addressSelector_address);
            tvName = itemView.findViewById(R.id.addressSelector_name);
            tvPhone = itemView.findViewById(R.id.addressSelector_numberPhone);
            btnEdit = itemView.findViewById(R.id.btn_edit_user_address);
            btnDelete = itemView.findViewById(R.id.btn_delete_user_address);
        }
    }
}
