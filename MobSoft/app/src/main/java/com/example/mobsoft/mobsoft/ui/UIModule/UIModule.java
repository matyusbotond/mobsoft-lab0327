package com.example.mobsoft.mobsoft.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

import android.content.Context;


import com.example.mobsoft.mobsoft.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

}
