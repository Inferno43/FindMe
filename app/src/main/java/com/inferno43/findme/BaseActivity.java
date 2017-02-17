package com.inferno43.findme;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.inferno43.findme.callbacks.AbstractActivityCallback;
import com.inferno43.findme.callbacks.AbstractFragmentCallback;

/**
 * Created by Saravana on 1/23/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements AbstractActivityCallback, AbstractFragmentCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onStart() {
        super.onStart();


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void startActivity(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args) {
        Intent intent = new Intent(this, claz);
        if (null != args) intent.putExtras(args);
        intent.addFlags(addTobackstack ? Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP : Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Class<? extends AppCompatActivity> claz, boolean addTobackstack, Bundle args, int reqCode) {

    }

    @Override
    public void addFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment,
                            boolean addTobackstack, Bundle args) {

    }

    @Override
    public void replaceFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment,
                                boolean addTobackstack, Bundle args) {
        String backStateName = fragment.getClass().getName();
        if (args != null) fragment.setArguments(args);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contentFrame, fragment, backStateName);
        if (addTobackstack) transaction.addToBackStack(backStateName);
        transaction.commit();
    }


    protected void enableToolBar(boolean enable) {
        if (enable) {
            if (findViewById(R.id.toolbar) != null)
                findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
            else
                findViewById(R.id.toolbar).setVisibility(View.GONE);

        }

    }


}
