package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SpecificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_RADIO_BUTTON = 0;
    private static final int VIEW_TYPE_SPECIFICATION = 1;

    private List<SpecificationGroup> groups;
    private List<SpecificationItem> items;
    private int selectedPosition = 0;
    String modifier;
    private OnItemClickListener onItemClickListener;
    private Context context;
    Integer flag = 0;

    public interface OnItemClickListener {
        void onItemClick(SpecificationGroup group, String modifier, Integer price);
    }

    public SpecificationAdapter(Context context,List<SpecificationGroup> groups, List<SpecificationItem> items, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.groups = groups;
        this.items = items;
        this.onItemClickListener = onItemClickListener;
        Log.e("group size", String.valueOf(groups.size()));
        Log.e("item size", String.valueOf(items.size()));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_RADIO_BUTTON;
        } else {
            return VIEW_TYPE_SPECIFICATION;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_specification1, parent, false);
        if (viewType == VIEW_TYPE_RADIO_BUTTON) {
            return new RadioButtonViewHolder(view);

        } else {
            //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_specification, parent, false);
            return new SpecificationViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SpecificationGroup group1 = groups.get(position);
        if (holder.getItemViewType() == VIEW_TYPE_RADIO_BUTTON) {
            RadioButtonViewHolder radioButtonViewHolder = (RadioButtonViewHolder) holder;

            String[] rows = new String[5];
            Integer[] price = new Integer[5];
            int i = 0;
            for (SpecificationItem specItem : group1.getList()) {
                rows[i] = specItem.getName().get(0);
                price[i] = specItem.getPrice();
                i++;
            }
            radioButtonViewHolder.ntitle.setText(group1.getName().get(0).toString());
            radioButtonViewHolder.rdgroup.setActivated(true);
            radioButtonViewHolder.r1.setText(rows[0]);
            radioButtonViewHolder.r2.setText(rows[1]);
            radioButtonViewHolder.r3.setText(rows[2]);
            radioButtonViewHolder.r4.setText(rows[3]);
            radioButtonViewHolder.r5.setText(rows[4]);
            radioButtonViewHolder.p1.setText("₹ " + price[0] + ".00");
            radioButtonViewHolder.p2.setText("₹ " + price[1] + ".00");
            radioButtonViewHolder.p3.setText("₹ " + price[2] + ".00");
            radioButtonViewHolder.p4.setText("₹ " + price[3] + ".00");
            radioButtonViewHolder.p5.setText("₹ " + price[4] + ".00");
//            if(flag == 0){
//                onItemClickListener.onItemClick(group1,"1 BHK",price[0]);
//            }
//            radioButtonViewHolder.rdgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                    RadioButton checkedRadioButton = group.findViewById(checkedId);
//                    Toast.makeText(context, "Clicked "+checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
//                    if (checkedRadioButton.getText().equals("1 BHK")) {
//                        notifyDataSetChanged();
//                        onItemClickListener.onItemClick(group1,"1 BHK",price[0]);
//                    } else if (checkedRadioButton.getText().equals("2 BHK")) {
//                        notifyDataSetChanged();
//                        onItemClickListener.onItemClick(group1,"2 BHK",price[1]);
//                    } else if (checkedRadioButton.getText().equals("3 BHK")) {
//                        notifyDataSetChanged();
//                        onItemClickListener.onItemClick(group1,"3 BHK",price[2]);
//                    }else if (checkedRadioButton.getText().equals("4 BHK")) {
//                        notifyDataSetChanged();
//                        onItemClickListener.onItemClick(group1,"4 BHK",price[3]);
//                    }else if (checkedRadioButton.getText().equals(">4 BHK")) {
//                        notifyDataSetChanged();
//                        onItemClickListener.onItemClick(group1,">4 BHK",price[4]);
//                    }
//
//                }
//            });
//            radioButtonViewHolder.radioButton.setChecked(position == selectedPosition);
//            radioButtonViewHolder.textViewName.setText(item.getName().get(0));
//            radioButtonViewHolder.textViewPrice.setText("₹ " + item.getPrice() + ".00");
//
//            if (selectedPosition == 0) {
//                onItemClickListener.onItemClick(item, "First", item.getPrice());
//            }
//            radioButtonViewHolder.itemView.setOnClickListener(v -> {
//                selectedPosition = holder.getAdapterPosition();
//
//                if (selectedPosition == 1) {
//                    modifier = "2 BHK";
//                } else if (selectedPosition == 2) {
//                    modifier = "3 BHK";
//                } else if (selectedPosition == 3) {
//                    modifier = "4 BHK";
//                } else if (selectedPosition == 4) {
//                    modifier = ">4 BHK";
//                } else {
//                    modifier = "1 BHK";
//                }
//
//                notifyDataSetChanged();
////                onItemClickListener.onItemClick(item,modifier,item.getPrice());
//            });

        } else {
            if(flag == 0){
                onItemClickListener.onItemClick(group1,"1 BHK",999);
            }
            SpecificationViewHolder specificationViewHolder = (SpecificationViewHolder) holder;
            String[] rows = new String[4];
            Integer[] price = new Integer[4];
            Integer[] id = new Integer[4];
            int i = 0;
            SpecificationGroup group = groups.get(position);
            if (group.getUnique_id() == 1617 || group.getUnique_id() == 1616) {
                Log.e("in", "first if");
                specificationViewHolder.r4.setVisibility(View.GONE);
            } else if (group.getUnique_id() == 1614) {
                specificationViewHolder.r3.setVisibility(View.GONE);
                specificationViewHolder.r4.setVisibility(View.GONE);
            }
            specificationViewHolder.ntitle.setText(group.getName().get(0));
            for (SpecificationItem specItem : group.getList()) {
                id[i] = specItem.getUniqueId();
                rows[i] = specItem.getName().get(0);
                price[i] = specItem.getPrice();
                specificationViewHolder.cb[i].setText(specItem.getName().get(0).toString());
                i++;
            }
            specificationViewHolder.price1.setText("₹" + price[0] + ".00");
            specificationViewHolder.price2.setText("₹" + price[1] + ".00");
            specificationViewHolder.price3.setText("₹" + price[2] + ".00");
            specificationViewHolder.price4.setText("₹" + price[3] + ".00");

        }
    }

    @Override
    public int getItemCount() {
        //return (groups.size() + items.size());
        return groups.size();
    }

    public void updateItems(List<SpecificationGroup> newGroup) {
        groups = newGroup;
        notifyDataSetChanged();
    }

    public static class RadioButtonViewHolder extends RecyclerView.ViewHolder {
        //        RadioButton radioButton;
//        TextView textViewName;
//        TextView textViewPrice;
//
//        public RadioButtonViewHolder(@NonNull View itemView) {
//            super(itemView);
//            radioButton = itemView.findViewById(R.id.radioButton);
//            textViewName = itemView.findViewById(R.id.textViewName);
//            textViewPrice = itemView.findViewById(R.id.textViewPrice);
//        }
        RadioButton r1,r2,r3,r4,r5;
        RadioGroup rdgroup;
        TextView p1,p2,p3,p4,p5,ntitle;
        TextView[] parray = new TextView[5];
        RelativeLayout radiobutton, checkbox;


        public RadioButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            ntitle = itemView.findViewById(R.id.title);
            radiobutton = itemView.findViewById(R.id.linear1);
            checkbox = itemView.findViewById(R.id.relative1);
            checkbox.setVisibility(View.GONE);
            rdgroup = itemView.findViewById(R.id.selectradio);
            r1 = itemView.findViewById(R.id.radioButton1);
            r2 = itemView.findViewById(R.id.radioButton2);
            r3 = itemView.findViewById(R.id.radioButton3);
            r4 = itemView.findViewById(R.id.radioButton4);
            r5 = itemView.findViewById(R.id.radioButton5);
            p1 = itemView.findViewById(R.id.textViewPrice1);
            p2 = itemView.findViewById(R.id.textViewPrice2);
            p3 = itemView.findViewById(R.id.textViewPrice3);
            p4 = itemView.findViewById(R.id.textViewPrice4);
            p5 = itemView.findViewById(R.id.textViewPrice5);
        }
    }

    public static class SpecificationViewHolder extends RecyclerView.ViewHolder {
        CheckBox[] cb = new CheckBox[4];
        public TextView ntitle, price1, price2, price3, price4;
        public CheckBox item1, item2, item3, item4;
        public RelativeLayout r3, r4;
        RelativeLayout radiobutton, checkbox;

        public SpecificationViewHolder(@NonNull View itemView) {
            super(itemView);
            radiobutton = itemView.findViewById(R.id.linear1);
            checkbox = itemView.findViewById(R.id.relative1);
            radiobutton.setVisibility(View.GONE);
            checkbox.setVisibility(View.VISIBLE);
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
