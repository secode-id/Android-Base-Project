/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.model.repository;

import com.syafii.androidbaseproject.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRest {

    @GET("put here")
    Call<User> getUserList();
}
