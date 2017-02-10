package com.inferno43.findme.login;

import android.content.Context;
import android.os.Bundle;

import com.inferno43.findme.BaseActivity;
import com.inferno43.findme.R;
import com.inferno43.findme.dagger.Injector;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity  {
    @Inject LoginPresenter loginPresenter;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        LoginFragment loginFragment = new LoginFragment();

        if (loginFragment != null ) {
            replaceFragment(getSupportFragmentManager(),loginFragment, false, null);
            new Injector(loginFragment).getLoginComponent().injectLoginPresenter(this);
        }

        loginPresenter.start();

    }
}
