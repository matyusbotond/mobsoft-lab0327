package com.example.mobsoft.mobsoft.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter presenter;
    private Tracker mTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MobSoftApplication.injector.inject(this);

        // Obtain the shared Tracker instance.
        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume(){
        super.onResume();

        String name = "Login";
        String tag = "google";
        Log.i(tag, "Setting screen name: " + name);
        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
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

    public void lgnButton_onClick(View view) {

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Login")
                .build());

        presenter.login(((EditText)this.findViewById(R.id.username)).getText().toString(),((EditText)this.findViewById(R.id.password)).getText().toString());

    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
