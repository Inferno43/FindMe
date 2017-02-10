package com.inferno43.findme.login;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inferno43.findme.BaseFragment;
import com.inferno43.findme.R;
import com.inferno43.findme.dagger.Injector;
import com.inferno43.findme.exceptions.EmptyTextException;
import com.inferno43.findme.exceptions.InvalidArgumentException;
import com.inferno43.findme.home.HomeActivity;
import com.inferno43.findme.toolbox.Utils;
import com.inferno43.findme.view.DotsView;

import javax.inject.Inject;

/**
 * Created by LoginFragment on 1/27/17.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View{

    LoginContract.Presenter mPresenter;
    private View rootView;
    private EditText userName;
    private EditText password;
    private Button signIn;
    private Context context;

    private DotsView dotsView;
    private AnimatorSet animatorSet;

    @Inject
    Utils utils;

    public LoginFragment() {
    }
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login, container, false);
        context = getActivity();
        new Injector(context).getHelperComponent().injectHelper(LoginFragment.this);
        userName = (EditText)rootView.findViewById(R.id.userName);
        password = (EditText)rootView.findViewById(R.id.password);
        signIn = (Button)rootView.findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mPresenter.login();
                } catch (Exception e) {
                    if(e instanceof EmptyTextException || e instanceof InvalidArgumentException)
                        Snackbar.make(rootView,e.getMessage(),Snackbar.LENGTH_LONG).show();
                }
            }
        });
        dotsView  =(DotsView)rootView.findViewById(R.id.dotsView);

        animatorSet = new AnimatorSet();
        return rootView;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void startHome() {
        startActivity(HomeActivity.class,false,null);
    }

    @Override
    public boolean isFieldsValid() throws EmptyTextException, InvalidArgumentException {
        if(userName.getText().toString().isEmpty()  &&  password.getText().toString().isEmpty())
            throw new EmptyTextException("Fields are empty");
        if(utils.validUserName(userName.getText().toString()) && utils.validpassword(password.getText().toString()))
            return true;
        else
            throw new InvalidArgumentException("Please enter Username and Password correctly");
    }


}
