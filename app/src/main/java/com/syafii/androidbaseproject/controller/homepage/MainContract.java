/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.controller.homepage;

import com.syafii.androidbaseproject.base.BasePresenter;
import com.syafii.androidbaseproject.base.BaseView;
import com.syafii.androidbaseproject.model.User;

import java.util.List;

public interface MainContract {
    interface View extends BaseView<Presenter>{
        void showSuccessDataUser(List<User> userList);
        void showFailedDataUser(String message);
    }

    interface Presenter extends BasePresenter{
        void getUser();
    }
}
