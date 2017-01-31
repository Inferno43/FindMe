package com.inferno43.findme.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inferno43.findme.BaseFragment;
import com.inferno43.findme.R;
import com.inferno43.findme.dagger.Injector;
import com.inferno43.findme.exceptions.EmptyTextException;
import com.inferno43.findme.home.HomeActivity;
import com.inferno43.findme.toolbox.Utils;

import javax.inject.Inject;

/**
 * Created by LoginFragment on 1/27/17.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View{

    LoginContract.Presenter mPresenter;
    private EditText userName;
    private EditText password;
    private Button signIn;
    private Context context;

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
        View root = inflater.inflate(R.layout.login, container, false);
        context = getActivity();
        new Injector(context).getHelperComponent().injectHelper(LoginFragment.this);
        userName = (EditText)root.findViewById(R.id.userName);
        password = (EditText)root.findViewById(R.id.password);
        signIn = (Button)root.findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(getActivity(),view.getId());
            }
        });
        return root;
    }

    @Override
    public void showProgress(String message) {

    }

    @Override
    public boolean validate() {
        try {
            if(utils.validUserName(userName.getText().toString()) && utils.validpassword( password.getText().toString()))
                return true;
        } catch (EmptyTextException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public void submit() {
        if(validate())
            startActivity(HomeActivity.class,false,null);
        else
            Toast.makeText(context,"error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }
}
