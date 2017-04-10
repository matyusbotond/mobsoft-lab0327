package com.example.mobsoft.mobsoft.interactor;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Module
public class InteractorModule {

    @Provides
    public InvoiceInteractor provideInvoices(){
        return new InvoiceInteractor();
    }

    @Provides
    public PersonInteractor providePersons(){
        return new PersonInteractor();
    }
}
