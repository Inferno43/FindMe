package com.inferno43.findme.home;

import com.inferno43.findme.login.LoginActivity;

import dagger.Component;

/**
 * Created by ${USER_NAME} on 2/10/17.
 */

@Component(modules = HomeModule.class)
public interface HomeComponent {

    void injectHomePresenter(HomeActivity Activity);
}
