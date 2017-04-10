package com.example.mobsoft.mobsoft.ui.invoiceedit;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.RemoveInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.SaveInvoiceEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class InvoiceEditPresenter extends Presenter<InvoiceEditScreen> {
    @Inject
    InvoiceInteractor invoiceInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public InvoiceEditPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(InvoiceEditScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void saveInvoice(final Invoice invoice) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                invoiceInteractor.saveInvoice(invoice);
            }
        });
    }

    public void onEventMainThread(SaveInvoiceEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setLoading(false);
                screen.showMessage("Sikeres mentés");
            }
        }
    }


}
