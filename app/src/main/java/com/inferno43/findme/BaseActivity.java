package com.inferno43.findme;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.inferno43.findme.callbacks.AbstractActivityCallback;
import com.inferno43.findme.callbacks.AbstractFragmentCallback;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements AbstractActivityCallback,AbstractFragmentCallback{



    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args) {
        Intent intent = new Intent(this,claz);
        if(null!=args) intent.putExtras(args);
        intent.addFlags(addTobackstack?Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP:Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args, int reqCode) {

    }

    @Override
    public void addFragment(Class<? extends android.support.v4.app.Fragment> fragment, boolean addToBackStack, Bundle args) {

    }

    @Override
    public void replaceFragment(Class<? extends android.support.v4.app.Fragment> fragment, boolean addToBackStack, Bundle args) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment newFragment;
        String backStateName ;
        try {
            // Create new fragment
            newFragment = fragment.newInstance();
            backStateName = newFragment.getClass().getName();
            if (args != null) newFragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        if (addToBackStack) {
            // Add this transaction to the back stack
            ft.addToBackStack(backStateName);
        }

        // Change to a new fragment
        ft.replace(R.id.contentFrame, newFragment, fragment.getClass().getSimpleName());
        ft.commit();

    }

    public  void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull android.support.v4.app.Fragment fragment, int frameId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
