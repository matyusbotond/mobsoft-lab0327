package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.network.api.InvoicesApi;
import com.example.mobsoft.mobsoft.repository.Repository;

import org.junit.Test;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static org.junit.Assert.assertEquals;

/**
 * Created by matyu on 2017. 05. 15..
 */

public class InvoiceInteractorTest {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    InvoicesApi invoicesApi;

    InvoiceInteractor invoiceInteractor;

    @Test
    public void getInvoicesShoudlWork() throws Exception {

        invoiceInteractor.getInvoices();
    }
}
