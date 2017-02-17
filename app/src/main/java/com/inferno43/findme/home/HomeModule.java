package com.inferno43.findme.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${USER_NAME} on 2/10/17.
 */

@Module
public class HomeModule {

    private final HomeContract.View mView;

    public HomeModule(HomeContract.View view) {
        mView = view;
    }

    @Provides
    HomeContract.View provideHomeContractView() {
        return mView;
    }
}
