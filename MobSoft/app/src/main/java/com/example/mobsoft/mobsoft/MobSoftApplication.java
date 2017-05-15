package com.example.mobsoft.mobsoft;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.mobsoft.mobsoft.repository.Repository;
import com.example.mobsoft.mobsoft.ui.UIModule.UIModule;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
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
        Fabric.with(this, new Crashlytics());

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

        injector.inject(this);

        repository.open(getApplicationContext());
    }

    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}