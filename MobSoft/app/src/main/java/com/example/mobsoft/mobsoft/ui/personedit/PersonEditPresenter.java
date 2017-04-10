package com.example.mobsoft.mobsoft.ui.personedit;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.SaveInvoiceEvent;
import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.events.SavePersonEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class PersonEditPresenter extends Presenter<PersonEditScreen> {
    @Inject
    PersonInteractor personInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public PersonEditPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(PersonEditScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void savePerson(final Person Person) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personInteractor.savePerson(Person);
            }
        });
    }

    public void onEventMainThread(SavePersonEvent event) {
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
