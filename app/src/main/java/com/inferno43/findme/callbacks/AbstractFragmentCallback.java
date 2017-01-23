package com.inferno43.findme.callbacks;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

public interface AbstractFragmentCallback {

    void addFragment(Class<? extends Fragment> fragment,boolean addToBackStack,Bundle args);
    void replaceFragment(Class<? extends Fragment> fragment,boolean addToBackStack,Bundle args);
}
