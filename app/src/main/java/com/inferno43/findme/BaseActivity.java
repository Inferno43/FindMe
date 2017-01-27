package com.inferno43.findme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.inferno43.findme.callbacks.AbstractActivityCallback;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

public class BaseActivity extends AppCompatActivity implements AbstractActivityCallback{


    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args) {
        startActivity(new Intent(this,claz));
    }

    @Override
    public void startActivityForResult(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args, int reqCode) {

    }
}
