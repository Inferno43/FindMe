package com.inferno43.findme.dagger;

import android.content.Context;

import com.inferno43.findme.dagger.component.DaggerHelperComponent;
import com.inferno43.findme.dagger.component.HelperComponent;
import com.inferno43.findme.dagger.modules.HelperModule;
import com.inferno43.findme.login.DaggerLoginComponent;
import com.inferno43.findme.login.LoginComponent;
import com.inferno43.findme.login.LoginModule;
import com.inferno43.findme.login.LoginView;

/**
 * Created by ${ mohanakrishnan.m} on 1/25/17.
 */

public class Injector {
    private HelperComponent component;
    private LoginComponent loginComponent;

    public Injector(Context context) {
        buildComponentAndInject(context);
    }
    public void buildComponentAndInject(Context context) {
        component = DaggerHelperComponent.builder().helperModule(new HelperModule(context))
                .build();

    }
    public Injector(LoginView loginView) {
        loginComponent = DaggerLoginComponent.builder().loginModule(new LoginModule(loginView)).build();
    }


    public HelperComponent getHelperComponent() {
        return component;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }




}
