package com.inferno43.findme.dagger.modules;

import com.inferno43.findme.AppController;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

public class AppModule {

    AppController appController;

    public AppModule(AppController appController) {
        this.appController = appController;
    }

    @Provides
    @Singleton
    AppController providesApplication(){
        return appController;
    }
}
