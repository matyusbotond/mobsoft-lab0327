package com.example.mobsoft.mobsoft.ui.invoices;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoicesEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.SaveInvoiceEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class InvoicesPresenter extends Presenter<InvoicesScreen> {
    @Inject
    InvoiceInteractor invoiceInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public InvoicesPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(InvoicesScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getInvoices() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                invoiceInteractor.getInvoices();
            }
        });
    }

    public void onEventMainThread(GetInvoicesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setInvoices(event.getInvoices());
                screen.setLoading(false);
            }
        }
    }
}
