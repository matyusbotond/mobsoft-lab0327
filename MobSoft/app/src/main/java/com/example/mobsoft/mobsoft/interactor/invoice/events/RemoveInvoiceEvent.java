package com.example.mobsoft.mobsoft.interactor.invoice.events;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class RemoveInvoiceEvent {
    private Exception throwable;

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }
}
