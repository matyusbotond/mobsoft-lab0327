package com.example.mobsoft.mobsoft.interactor.invoice.events;

import com.example.mobsoft.mobsoft.model.Invoice;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetInvoicesEvent {
    private List<Invoice> invoices;
    private Exception throwable;

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }
}
