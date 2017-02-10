package com.inferno43.findme.login;

import android.content.Context;
import android.content.Intent;

import com.inferno43.findme.BasePresenter;
import com.inferno43.findme.BaseView;
import com.inferno43.findme.exceptions.EmptyTextException;
import com.inferno43.findme.exceptions.InvalidArgumentException;

/**
 * Created by ${ mohanakrishnan.m} on 1/27/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{

        void startHome();
        boolean isFieldsValid() throws Exception;
    }

    interface Presenter extends BasePresenter{
        void login() throws Exception;

    }
}
