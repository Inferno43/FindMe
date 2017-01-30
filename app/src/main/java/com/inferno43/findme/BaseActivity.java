package com.inferno43.findme;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.inferno43.findme.callbacks.AbstractActivityCallback;
import com.inferno43.findme.callbacks.AbstractFragmentCallback;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

public class BaseActivity extends AppCompatActivity implements AbstractActivityCallback,AbstractFragmentCallback{


    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args) {
        startActivity(new Intent(this,claz));
    }

    @Override
    public void startActivityForResult(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args, int reqCode) {

    }

    @Override
    public void addFragment(Class<? extends android.support.v4.app.Fragment> fragment, boolean addToBackStack, Bundle args) {

    }

    @Override
    public void replaceFragment(Class<? extends android.support.v4.app.Fragment> fragment, boolean addToBackStack, Bundle args) {
        try {
            Fragment frag = fragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(args!=null)frag.setArguments(args);
            transaction.replace(R.id.contentFrame, frag);
            transaction.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public  void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull android.support.v4.app.Fragment fragment, int frameId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

}
