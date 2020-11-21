/*
 * Created by Muhamad Syafii
 * Saturday, 21/11/2020
 * Copyright (c) 2020 by SECODE.
 * All Rights Reserved
 */

package com.syafii.androidbaseproject.controller.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.syafii.androidbaseproject.R;
import com.syafii.androidbaseproject.controller.homepage.MainActivity;
import com.syafii.androidbaseproject.utils.ActivityUtils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ActivityUtils.openActivity(SplashScreenActivity.this, MainActivity.class);
                finish();
            }
        },3000);
    }
}