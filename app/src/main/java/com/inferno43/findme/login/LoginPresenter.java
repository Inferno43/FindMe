package com.inferno43.findme.login;

import javax.inject.Inject;

/**
 * Created by Saravana on 1/27/17.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private final LoginContract.View mTasksView;

    @Inject
    public LoginPresenter(LoginContract.View mTasksView) {
        this.mTasksView = mTasksView;

    }

    @Inject
    void setListener(){
        mTasksView.setPresenter(this);
    }




    @Override
    public void start() {

    }

    @Override
    public void login() throws Exception {
        if(mTasksView.isFieldsValid())
             mTasksView.startHome();
    }
}
