package com.inferno43.findme.login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.inferno43.findme.R;

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
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void startActvity(Intent intent) {

    }

    @Override
    public void onClick(Context context, int viewid) {
        switch (viewid){
            case R.id.signIn:
                Toast.makeText(context,"hi",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void start() {

    }
}
