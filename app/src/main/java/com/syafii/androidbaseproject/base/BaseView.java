/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.base;

public interface BaseView<T> {
    void initView();
    void showLoading();
    void hideLoading();
    void setPresenter(T presenter);
}
