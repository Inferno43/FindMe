package com.inferno43.findme.login;

import com.inferno43.findme.dagger.component.HelperComponent;

import dagger.Component;

/**
 * Created by LoginComponent on 1/27/17.
 */

@Component (modules = LoginModule.class)
public interface LoginComponent {
    void injectLoginPresenter(LoginActivity Activity);
}
