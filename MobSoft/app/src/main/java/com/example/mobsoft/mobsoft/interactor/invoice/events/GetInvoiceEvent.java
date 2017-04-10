package com.example.mobsoft.mobsoft.interactor.invoice.events;

import com.example.mobsoft.mobsoft.model.Invoice;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetInvoiceEvent {
    private Invoice invoice;
    private Exception throwable;

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }
}
