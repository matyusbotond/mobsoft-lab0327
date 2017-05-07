package com.example.mobsoft.mobsoft.interactor.invoice;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoicesEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.RemoveInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.SaveInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonsEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.RemovePersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.SavePersonEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.network.api.InvoicesApi;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class InvoiceInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    InvoicesApi invoicesApi;

    public InvoiceInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getInvoices(){
        GetInvoicesEvent event = new GetInvoicesEvent();

        try {
            List<Invoice> invoices = repository.getInvoices();

            List<com.example.mobsoft.mobsoft.network.model.Invoice> response = invoicesApi.invoicesGet().execute().body();

            for(Invoice i : new ArrayList<>(invoices)){
                com.example.mobsoft.mobsoft.network.model.Invoice contains = null;
                for(com.example.mobsoft.mobsoft.network.model.Invoice s : response){
                    if(i.getId().equals(s.getId())){
                        contains = s;
                        break;
                    }
                }

                if(contains != null){
                    invoices.add(new Invoice(contains));
                }
            }

            event.setInvoices(invoices);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getInvoice(long id){
        GetInvoiceEvent event = new GetInvoiceEvent();

        try {
            Invoice invoice = repository.getInvoice(id);

            if(invoice == null){
                com.example.mobsoft.mobsoft.network.model.Invoice response = invoicesApi.invoicesIdGet((double) id).execute().body();

                invoice = new Invoice(response);
            }

            event.setInvoice(invoice);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveInvoice(Invoice invoice){
        SaveInvoiceEvent event = new SaveInvoiceEvent();

        try {
            repository.saveInvoice(invoice);
            invoicesApi.invoicesPost(invoice.ConvertToApi()).execute();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removeInvoice(Invoice invoice){
        RemoveInvoiceEvent event = new RemoveInvoiceEvent();

        try {
            repository.removeInvoice(invoice);
            invoicesApi.invoicesIdDelete(Double.valueOf(invoice.getId()));
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
