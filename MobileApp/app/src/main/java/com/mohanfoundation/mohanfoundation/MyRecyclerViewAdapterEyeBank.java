package com.mohanfoundation.mohanfoundation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by 986513 on 2/11/2016.
 */
public class MyRecyclerViewAdapterEyeBank extends RecyclerView.Adapter<MyRecyclerViewAdapterEyeBank.DataObjectHolder> {

    private ArrayList<DataObjectEyeBank> mDataset;
    private static HomeViewClickListener myClickListener;


    public static class DataObjectHolder extends RecyclerView.ViewHolder  {
        TextView state;
        TextView city;
        TextView address;
        TextView name;
        TextView phonenumber;
        TextView email;


        public DataObjectHolder(View itemView) {
            super(itemView);
            state= (TextView) itemView.findViewById(R.id.state);
            city=(TextView) itemView.findViewById(R.id.city);
            address = (TextView) itemView.findViewById(R.id.eyebank_address);
            name=(TextView) itemView.findViewById(R.id.eyebank_name);
            phonenumber=(TextView) itemView.findViewById(R.id.eyebank_number);
            email = (TextView) itemView.findViewById(R.id.eyebank_email);

            //itemView.setOnClickListener(this);
        }

       /* @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }*/


    }

    public void setOnItemClickListener(HomeViewClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapterEyeBank(ArrayList<DataObjectEyeBank> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_eyebank, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.state.setText(mDataset.get(position).getState());
        holder.city.setText(mDataset.get(position).getCity());
        holder.name.setText(mDataset.get(position).getNameOfEyebank());
        holder.email.setText(mDataset.get(position).getEmail());
        holder.phonenumber.setText(mDataset.get(position).getPhone());
        holder.address.setText(mDataset.get(position).getPostalAddress());

    }

    public void addItem(DataObjectEyeBank dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface HomeViewClickListener {
        public void onItemClick(int position, View v);
    }
}

