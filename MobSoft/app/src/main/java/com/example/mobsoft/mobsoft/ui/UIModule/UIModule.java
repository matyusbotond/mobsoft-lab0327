package com.example.mobsoft.mobsoft.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

import android.content.Context;


import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsPresenter;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditPresenter;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsPresenter;
import com.example.mobsoft.mobsoft.ui.personedit.PersonEditPresenter;
import com.example.mobsoft.mobsoft.ui.persons.PersonsPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

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

    @Provides
    @Singleton
    public InvoiceDetailsPresenter provideInvoiceDetails() {
        return new InvoiceDetailsPresenter();
    }

    @Provides
    @Singleton
    public InvoiceEditPresenter provideInvoiceEditPresenter() {
        return new InvoiceEditPresenter();
    }

    @Provides
    @Singleton
    public InvoicesPresenter provideInvoicesPresenter() {
        return new InvoicesPresenter();
    }

    @Provides
    @Singleton
    public PersonDetailsPresenter providePersonDetailsPresenter() {
        return new PersonDetailsPresenter();
    }


    @Provides
    @Singleton
    public PersonEditPresenter providePersonEditPresenter() {
        return new PersonEditPresenter();
    }


    @Provides
    @Singleton
    public PersonsPresenter providePersonsPresenter() {
        return new PersonsPresenter();
    }


    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
