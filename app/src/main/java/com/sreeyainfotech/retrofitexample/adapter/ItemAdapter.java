package com.sreeyainfotech.retrofitexample.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.sreeyainfotech.retrofitexample.Main2Activity;
import com.sreeyainfotech.retrofitexample.MainActivity;
import com.sreeyainfotech.retrofitexample.R;
import com.sreeyainfotech.retrofitexample.model.Allcategorieslist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KSTL on 24-04-2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context mContext;
    List<Allcategorieslist> contactsList, filterList;
    private Allcategorieslist contact;
    MainActivity  callBack;

    public ItemAdapter(Context mContext, List<Allcategorieslist> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        this.filterList = new ArrayList<Allcategorieslist>();

        this.filterList.addAll(this.contactsList);
    }


    @SuppressLint("NewApi")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        viewGroup.setClipToPadding(false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item_view, viewGroup, false);
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        view.setElevation(30);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        contact = filterList.get(position);
        holder.contact_name.setText(contact.getCategory_name());
        holder.contact_number.setText(contact.getCategory_id());
        Picasso.with(mContext)
                .load(contact.getImage_path())
                //.placeholder(R.drawable.ic_placeholder)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
               // .resize(500, 500)
                .into(holder.imageview);

        holder.imageview.setContentDescription(contact.getCategory_name());
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shipmentdetail = new Intent(mContext, Main2Activity.class);
                shipmentdetail.putExtra("Model", view.getContentDescription().toString());
                mContext.startActivity(shipmentdetail);

            }
        });


    }

    @Override
    public int getItemCount() {
        //return eventsList.size();
        return (null != filterList ? filterList.size() : 0);
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView contact_name, contact_number;
        ImageView imageview;

        public ViewHolder(View view) {
            super(view);
            contact_name = (TextView) view.findViewById(R.id.contact_name);
            contact_number = (TextView) view.findViewById(R.id.contact_number);
            imageview=(ImageView)view.findViewById(R.id.imageview);
        }
    }

    public void filter(final String text) {

        // Searching could be complex..so we will dispatch it to a different thread...
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Clear the filter list
                filterList.clear();

                // If there is no search value, then add all original list items to filter list
                if (TextUtils.isEmpty(text)) {

                    filterList.addAll(contactsList);

                } else {
                    // Iterate in the original List and add it to filter list...
                    for (Allcategorieslist item : contactsList) {
                        if (item.getCategory_id().toLowerCase().contains(text.toLowerCase()) ||
                                item.getCategory_name().contains(text.toLowerCase())) {
                            // Adding Matched items
                            filterList.add(item);
                        }
                    }
                }

                // Set on UI Thread
                ((MainActivity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Notify the List that the DataSet has changed...
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();
    }
}
