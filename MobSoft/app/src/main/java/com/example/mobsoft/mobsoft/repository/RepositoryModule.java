package com.example.mobsoft.mobsoft.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository provideMainPresenter() {
        return new MemoryRepository();
    }
}
