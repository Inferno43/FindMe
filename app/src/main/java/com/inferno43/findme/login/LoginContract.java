package com.inferno43.findme.login;

import android.content.Context;
import android.content.Intent;

import com.inferno43.findme.BasePresenter;
import com.inferno43.findme.BaseView;

/**
 * Created by ${ mohanakrishnan.m} on 1/27/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{

        void showProgress (String message);
    }

    interface Presenter extends BasePresenter{
        void result(int requestCode, int resultCode);
        void startActvity(Intent intent);
        void onClick(Context context, int viewId);

    }
}
