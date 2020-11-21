/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.controller.homepage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.syafii.androidbaseproject.R;
import com.syafii.androidbaseproject.controller.profile.ProfileActivity;
import com.syafii.androidbaseproject.model.User;
import com.syafii.androidbaseproject.utils.ActivityUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.rv_user)
    RecyclerView rvUser;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnAccount)
    CircleImageView ciAccount;


    private MainContract.Presenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.start();
    }


    @Override
    public void initView() {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getUser();
            }
        });
        ciAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(MainActivity.this, ProfileActivity.class);
                overridePendingTransition(R.anim.anim_right_to_left, R.anim.anim_left_to_right);
            }
        });

        adapter = new MainAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUser.setLayoutManager(layoutManager);
        presenter.getUser();

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        if (swipeRefresh !=null) swipeRefresh.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showSuccessDataUser(List<User> userList) {
        adapter.setDataUser(userList);
        rvUser.setAdapter(adapter);
    }

    @Override
    public void showFailedDataUser(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}