package com.phunlh2001.prm392_beverages.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phunlh2001.prm392_beverages.R;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;

import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder>{
    Context context;
    List<Order> mListOrder;
    String type;
    public IClickItem iClickItem;
    public interface IClickItem{
        void onBindItem(Order order);
    }
    public OrderHistoryAdapter(Context context, List<Order> mListOrder, String type, IClickItem iClickItem) {
        this.context = context;
        this.mListOrder = mListOrder;
        this.type = type;
        this.iClickItem = iClickItem;
    }

    @NonNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if(type.equals("DELIVERY")){
            view = LayoutInflater.from(context).inflate(R.layout.orderhistory_delivery_item, parent, false);
        }
        else if(type.equals("STOREPICKUP")){
            view = LayoutInflater.from(context).inflate(R.layout.orderhistory_storepickup_item, parent, false);
        }
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryViewHolder holder, int position) {
        Order order = mListOrder.get(position);
        holder.totalPrice.setText(Double.toString(order.getTotal_price()));
        if(order.getStatus().equals(OrderStatus.DELIVERY_FAILED)){
            holder.status.setText("Delivery failed");
            holder.status.setTextColor(Color.parseColor("#FF424E"));
            holder.status.setBackgroundResource(R.drawable.custom_text_status_failed);
        }
        holder.linearLayout.setOnClickListener(v -> {
            iClickItem.onBindItem(order);
        });

    }

    @Override
    public int getItemCount() {
        if(mListOrder != null){
            return mListOrder.size();
        }
        return 0;
    }

    public class OrderHistoryViewHolder extends RecyclerView.ViewHolder{
        TextView totalPrice;
        TextView status;
        LinearLayout linearLayout;

        public OrderHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            totalPrice = itemView.findViewById(R.id.totalPrice);
            status = itemView.findViewById(R.id.status_order);
            linearLayout = itemView.findViewById(R.id.order_detail);
        }
    }
}
