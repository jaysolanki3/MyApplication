package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SpecificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_RADIO_BUTTON = 0;
    private static final int VIEW_TYPE_SPECIFICATION = 1;

    private List<SpecificationGroup> groups;
    private List<SpecificationItem> items;
    private int selectedPosition = 0;

    public SpecificationAdapter(List<SpecificationItem> items,List<SpecificationGroup> groups) {
        this.items = items;
        this.groups = groups;
        this.items = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < groups.size()) {
            return VIEW_TYPE_RADIO_BUTTON;
        } else {
            return VIEW_TYPE_SPECIFICATION;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_RADIO_BUTTON) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_button, parent, false);
            return new RadioButtonViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_specification, parent, false);
            return new SpecificationViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_RADIO_BUTTON) {
            RadioButtonViewHolder radioButtonViewHolder = (RadioButtonViewHolder) holder;
            SpecificationItem group = items.get(position);
            radioButtonViewHolder.radioButton.setChecked(position == selectedPosition);
            radioButtonViewHolder.textViewName.setText(group.getName().get(0));
            radioButtonViewHolder.textViewPrice.setText("₹ " + group.getPrice() + ".00");
            radioButtonViewHolder.itemView.setOnClickListener(v -> {
                selectedPosition = holder.getAdapterPosition();
                updateItems(groups.get(selectedPosition).getList());
                notifyDataSetChanged();
            });


        } else {
            SpecificationViewHolder specificationViewHolder = (SpecificationViewHolder) holder;
            String[] rows = new String[4];
            Integer[] price = new Integer[4];
            Integer[] id = new Integer[4];
            int i = 0;
            SpecificationGroup item = groups.get(position);
            specificationViewHolder.ntitle.setText(item.getName().get(0));
            for (SpecificationItem specItem : item.getList())
            {
                id[i] = specItem.getUniqueId();
                rows[i] = specItem.getName().get(0);
                price[i] = specItem.getPrice();
                i++;
            }

            if(item.getUniqueId() == 1617 || item.getUniqueId() == 1616){
                specificationViewHolder.r4.setVisibility(View.GONE);
                specificationViewHolder.item1.setText(rows[0]);
                specificationViewHolder.item2.setText(rows[1]);
                specificationViewHolder.item3.setText(rows[2]);
                specificationViewHolder.price1.setText("₹"+price[0]+".00");
                specificationViewHolder.price2.setText("₹"+price[1]+".00");
                specificationViewHolder.price3.setText("₹"+price[2]+".00");
            } else if (item.getUniqueId() == 1614) {
                specificationViewHolder.r3.setVisibility(View.GONE);
                specificationViewHolder.r4.setVisibility(View.GONE);
                specificationViewHolder.item1.setText(rows[0]);
                specificationViewHolder.item2.setText(rows[1]);
                specificationViewHolder.price1.setText("₹"+price[0]+".00");
                specificationViewHolder.price2.setText("₹"+price[1]+".00");
            } else if (item.getUniqueId() == 1615) {
                specificationViewHolder.item1.setText(rows[0]);
                specificationViewHolder.item2.setText(rows[1]);
                specificationViewHolder.item3.setText(rows[2]);
                specificationViewHolder.item4.setText(rows[3]);
                specificationViewHolder.price1.setText("₹"+price[0]+".00");
                specificationViewHolder.price2.setText("₹"+price[1]+".00");
                specificationViewHolder.price3.setText("₹"+price[2]+".00");
                specificationViewHolder .price4.setText("₹"+price[3]+".00");
            }
        }
    }

    @Override
    public int getItemCount() {
        return groups.size() + items.size();
    }

    private void updateItems(List<SpecificationItem> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public static class RadioButtonViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView textViewName;
        TextView textViewPrice;

        public RadioButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }

    public static class SpecificationViewHolder extends RecyclerView.ViewHolder {
        CheckBox[] cb = new CheckBox[4];
        public TextView ntitle, price1, price2, price3, price4;
        public CheckBox item1,item2,item3,item4;
        public RelativeLayout r3,r4;

        public SpecificationViewHolder(@NonNull View itemView) {
            super(itemView);
            ntitle = itemView.findViewById(R.id.title);
            price1 = itemView.findViewById(R.id.price1);
            price2 = itemView.findViewById(R.id.price2);
            price3 = itemView.findViewById(R.id.price3);
            price4 = itemView.findViewById(R.id.price4);
            item1 = itemView.findViewById(R.id.item1);
            item2 = itemView.findViewById(R.id.item2);
            item3 = itemView.findViewById(R.id.item3);
            item4 = itemView.findViewById(R.id.item4);
            r3 = itemView.findViewById(R.id.row3);
            r4 = itemView.findViewById(R.id.row4);
            cb[0] = item1;
            cb[1] = item2;
            cb[2] = item3;
            cb[3] = item4;
        }
    }
}
