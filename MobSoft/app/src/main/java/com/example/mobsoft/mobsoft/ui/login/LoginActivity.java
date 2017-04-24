package com.example.mobsoft.mobsoft.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void setLoginResponse(boolean loginSuccessfull) {
        Intent in=new Intent(this, InvoicesActivity.class);
        startActivity(in);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setLoading(boolean loading) {

    }

    public void lgnButton_OnClick(View v){
        presenter.login(((EditText)this.findViewById(R.id.username)).getText().toString(),((EditText)this.findViewById(R.id.password)).getText().toString());
    }
}
