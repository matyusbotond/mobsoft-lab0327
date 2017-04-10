package com.example.mobsoft.mobsoft;

import android.app.Application;

import com.example.mobsoft.mobsoft.repository.Repository;
import com.example.mobsoft.mobsoft.ui.UIModule.UIModule;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);

        repository.open(getApplicationContext());
    }
}