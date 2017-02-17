package com.inferno43.findme.login;

import com.inferno43.findme.login.LoginContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LoginModule on 1/27/17.
 */

@Module
public class LoginModule {
    private final LoginContract.View mView;

    public LoginModule(LoginContract.View view) {
        mView = view;
    }

    @Provides
    LoginContract.View provideLoginContractView() {
        return mView;
    }
}
