package com.example.mobsoft.mobsoft.ui.invoicedetails;

import android.util.Log;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.RemoveInvoiceEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class InvoiceDetailsPresenter extends Presenter<InvoiceDetailsScreen> {
    @Inject
    InvoiceInteractor invoiceInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public InvoiceDetailsPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(InvoiceDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getInvoice(final long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                invoiceInteractor.getInvoice(id);
            }
        });
    }

    public void removeInvoice(final Invoice invoice) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                invoiceInteractor.removeInvoice(invoice);
            }
        });
    }

    public void onEventMainThread(GetInvoiceEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setInvoice(event.getInvoice());
                screen.setLoading(false);
            }
        }
    }

    public void onEventMainThread(RemoveInvoiceEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setLoading(false);
                screen.setRemoveResult();
            }
        }
    }
}
