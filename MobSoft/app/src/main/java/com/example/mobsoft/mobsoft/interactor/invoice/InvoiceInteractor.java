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
import com.example.mobsoft.mobsoft.repository.Repository;

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

    public InvoiceInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getInvoices(){
        GetInvoicesEvent event = new GetInvoicesEvent();

        try {
            List<Invoice> Invoices = repository.getInvoices();
            event.setInvoices(Invoices);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getInvoice(int id){
        GetInvoiceEvent event = new GetInvoiceEvent();

        try {
            Invoice Invoice = repository.getInvoice(id);
            event.setInvoice(Invoice);
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
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
