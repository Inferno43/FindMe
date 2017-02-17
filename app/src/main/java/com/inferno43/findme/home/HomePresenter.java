package com.inferno43.findme.home;

import javax.inject.Inject;

/**
 * Created by ${USER_NAME} on 2/10/17.
 */

public class HomePresenter implements HomeContract.Presenter{

    private final HomeContract.View mHome;

    @Inject
    public HomePresenter(HomeContract.View mHome) {
        this.mHome = mHome;

    }

    @Override
    public void start() {

    }
}
