package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
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

    public SpecificationAdapter(List<SpecificationGroup> groups) {
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
            SpecificationGroup group = groups.get(position);
            radioButtonViewHolder.radioButton.setText(group.getName().get(0));
            radioButtonViewHolder.radioButton.setChecked(position == selectedPosition);
            radioButtonViewHolder.itemView.setOnClickListener(v -> {
                selectedPosition = holder.getAdapterPosition();
                updateItems(groups.get(selectedPosition).getList());
                notifyDataSetChanged();
            });
        } else {
            SpecificationViewHolder specificationViewHolder = (SpecificationViewHolder) holder;
            SpecificationItem item = items.get(position - groups.size());
            specificationViewHolder.textViewName.setText(item.getName().get(0));
            specificationViewHolder.textViewPrice.setText("₹ " + item.getPrice());
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

        public RadioButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }

    public static class SpecificationViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPrice;

        public SpecificationViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
