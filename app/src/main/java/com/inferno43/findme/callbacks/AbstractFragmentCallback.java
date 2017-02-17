package com.inferno43.findme.callbacks;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Saravana on 1/23/17.
 */

public interface AbstractFragmentCallback {

    void addFragment(@NonNull FragmentManager fragmentManager,@NonNull Fragment fragment,
                     boolean addTobackstack, Bundle args);
    void replaceFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment,
                         boolean addTobackstack, Bundle args);
}
