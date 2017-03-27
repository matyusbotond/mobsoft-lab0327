package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.ui.UIModule.UIModule;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}