package com.inferno43.findme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.inferno43.findme.callbacks.AbstractActivityCallback;
import com.inferno43.findme.callbacks.AbstractFragmentCallback;

/**
 * Created by BaseFragment on 1/30/17.
 */

public abstract class BaseFragment extends Fragment implements AbstractActivityCallback,AbstractFragmentCallback{

    private AbstractFragmentCallback mCallback;
    private AbstractActivityCallback mActivityCallback;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setHasOptionsMenu(true);
        try {
            mCallback = (AbstractFragmentCallback) activity;
            mActivityCallback = (AbstractActivityCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + AbstractFragmentCallback.class.getCanonicalName());
        }

    }

    @Override
    public void addFragment(Class<? extends Fragment> fragment, boolean addToBackStack, Bundle args) {
        mCallback.addFragment(fragment, addToBackStack, args);
    }

    @Override
    public void replaceFragment(Class<? extends Fragment> fragment, boolean addToBackStack, Bundle args) {
        mCallback.replaceFragment(fragment, addToBackStack, args);
    }

    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args) {
        mActivityCallback.startActivity(claz,addTobackstack,args);
    }

    @Override
    public void startActivityForResult(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args, int reqCode) {
        mActivityCallback.startActivityForResult(claz,addTobackstack,args,reqCode);
    }
}