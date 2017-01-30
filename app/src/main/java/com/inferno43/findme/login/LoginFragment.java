package com.inferno43.findme.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.inferno43.findme.R;

/**
 * Created by LoginFragment on 1/27/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View{

    LoginContract.Presenter mPresenter;
    private EditText userName;
    private EditText password;
    private Button signIn;

    public LoginFragment() {
    }
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login, container, false);
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
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }
}
