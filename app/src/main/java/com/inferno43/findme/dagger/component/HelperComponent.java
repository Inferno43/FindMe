package com.inferno43.findme.dagger.component;

import android.content.Context;

import com.inferno43.findme.BaseActivity;
import com.inferno43.findme.login.LoginActivity;
import com.inferno43.findme.dagger.modules.HelperModule;
import com.inferno43.findme.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ${ saravana } on 1/23/17.
 */

@Singleton
@Component(modules={ HelperModule.class})
public interface HelperComponent {

    Context context();
    void injectHelper(LoginFragment Fragment);
}
