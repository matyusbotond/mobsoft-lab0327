package com.example.mobsoft.mobsoft.interactor.persons.events;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class LoginEvent {
    private Exception throwable;
    private boolean loginSuccessfull;

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }

    public void setLoginSuccessfull(boolean loginSuccessfull) {
        this.loginSuccessfull = loginSuccessfull;
    }

    public boolean isLoginSuccessfull() {
        return loginSuccessfull;
    }
}
