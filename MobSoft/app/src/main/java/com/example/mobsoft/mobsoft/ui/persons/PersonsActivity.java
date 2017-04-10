package com.example.mobsoft.mobsoft.ui.persons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Person;

import java.util.List;

import javax.inject.Inject;

public class PersonsActivity extends AppCompatActivity implements PersonsScreen {

    @Inject
    PersonsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
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
    public void setPersons(List<Person> persons) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setLoading(boolean loading) {

    }
}
