package com.example.mobsoft.mobsoft.ui.login;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.invoice.events.GetInvoicesEvent;
import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.events.LoginEvent;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class LoginPresenter extends Presenter<LoginScreen> {
    @Inject
    PersonInteractor personInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(final String userName, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personInteractor.login(userName, password);
            }
        });
    }

    public void onEventMainThread(LoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.setLoginResponse(event.isLoginSuccessfull());
                screen.setLoading(false);
            }
        }
    }
}
