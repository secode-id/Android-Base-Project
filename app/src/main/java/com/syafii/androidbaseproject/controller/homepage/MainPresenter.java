/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.controller.homepage;

import android.util.Log;

import com.google.gson.Gson;
import com.syafii.androidbaseproject.model.User;
import com.syafii.androidbaseproject.utils.DummyData;
import com.syafii.androidbaseproject.utils.constants.Constants;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void getUser() {
        DummyData data = new DummyData();
        List<User> userList = data.generateUserData();
        view.showSuccessDataUser(userList);

        if (userList != null) {
            view.showSuccessDataUser(userList);
        } else {
            view.showFailedDataUser(Constants.MESSAGE_ERROR_REQUEST);
        }
    }

    @Override
    public void start() {
        view.initView();
    }
}
