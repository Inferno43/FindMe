package com.inferno43.findme.dagger;

import android.content.Context;

import com.inferno43.findme.dagger.component.DaggerHelperComponent;
import com.inferno43.findme.dagger.component.HelperComponent;
import com.inferno43.findme.dagger.modules.HelperModule;
import com.inferno43.findme.login.DaggerLoginComponent;
import com.inferno43.findme.login.LoginComponent;
import com.inferno43.findme.login.LoginFragment;
import com.inferno43.findme.login.LoginModule;

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
    public Injector(LoginFragment loginFragment) {
        loginComponent = DaggerLoginComponent.builder().loginModule(new LoginModule(loginFragment)).build();
    }


    public HelperComponent getHelperComponent() {
        return component;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }




}
