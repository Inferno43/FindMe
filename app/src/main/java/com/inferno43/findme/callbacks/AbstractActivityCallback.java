package com.inferno43.findme.callbacks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Saravana on 1/23/17.
 */

public interface AbstractActivityCallback {

    void startActivity(Class<? extends AppCompatActivity> claz,boolean addTobackstack,Bundle args);
    void startActivityForResult(Class<? extends AppCompatActivity> claz,boolean addTobackstack,Bundle args,int reqCode);
}
