package com.inferno43.findme.dagger.modules;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inferno43.findme.toolbox.SharedPref;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

@Module
public class HelperModule {

    Context context;
    public HelperModule(Context context) {
        this.context = context;
    }

    @Provides //scope is not necessary for parameters stored within the module
    public Context context() {
        return context;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides @Singleton
    SharedPref provideSharedPrefs(){
        SharedPref sharedPref = new SharedPref();
        return sharedPref;
    }
}
