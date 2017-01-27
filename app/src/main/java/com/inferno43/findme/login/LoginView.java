package com.inferno43.findme.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.inferno43.findme.R;

/**
 * Created by Saravana on 1/27/17.
 */

public class LoginView extends ScrollChildSwipeRefreshLayout implements LoginContract.View{

    private LoginContract.Presenter mPresenter;
    private EditText userName;
    private EditText password;
    private Button   signIn;

    public LoginView(Context context) {
        super(context);
        init();
    }


    void init(){
        inflate(getContext(), R.layout.activity_login, this);
        final ScrollChildSwipeRefreshLayout swipeRefreshLayout = this;
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getContext(), R.color.colorPrimary),
                ContextCompat.getColor(getContext(), R.color.colorAccent),
                ContextCompat.getColor(getContext(), R.color.colorPrimaryDark)
        );
        userName  = (EditText) findViewById(R.id.userName);
        password  = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signIn);

        signIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onClick(getContext(),view.getId());
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               // mPresenter.start();
            }
        });
    }
    @Override
    public void showProgress(String message) {

    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
