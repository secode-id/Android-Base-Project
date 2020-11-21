/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.controller.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.syafii.androidbaseproject.R;
import com.syafii.androidbaseproject.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<User> userList;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setDataUser(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User data = userList.get(position);

        holder.tvName.setText(data.getName());
        holder.tvNumber.setText(data.getNumber());
        holder.tvEmail.setText(data.getEmail());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.tv_email)
        TextView tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
