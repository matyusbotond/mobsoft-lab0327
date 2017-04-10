package com.example.mobsoft.mobsoft.ui.persons;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonsEvent;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class PersonsPresenter extends Presenter<PersonsScreen> {
    @Inject
    PersonInteractor personInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public PersonsPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(PersonsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getPersons() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personInteractor.getPersons();
            }
        });
    }

    public void onEventMainThread(GetPersonsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setPersons(event.getPersons());
                screen.setLoading(false);
            }
        }
    }
}
