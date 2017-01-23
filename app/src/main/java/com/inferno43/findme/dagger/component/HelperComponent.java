package com.inferno43.findme.dagger.component;

import com.inferno43.findme.LoginActivity;
import com.inferno43.findme.dagger.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ${ mohanakrishnan.m} on 1/23/17.
 */

@Singleton
@Component(modules={AppModule.class, HelperComponent.class})
public interface HelperComponent {

    void inject(LoginActivity activity);
}
