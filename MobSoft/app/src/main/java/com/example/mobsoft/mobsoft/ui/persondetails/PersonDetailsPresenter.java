package com.example.mobsoft.mobsoft.ui.persondetails;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.invoice.events.RemoveInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.RemovePersonEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class PersonDetailsPresenter extends Presenter<PersonDetailsScreen> {
    @Inject
    PersonInteractor personInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public PersonDetailsPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(PersonDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getPerson(final long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personInteractor.getPerson(id);
            }
        });
    }

    public void removePerson(final Person person) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personInteractor.removePerson(person);
            }
        });
    }

    public void onEventMainThread(GetPersonEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setPerson(event.getPerson());
                screen.setLoading(false);
            }
        }
    }

    public void onEventMainThread(RemovePersonEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setLoading(false);
                screen.showMessage("Sikeres törlés");
            }
        }
    }
}
