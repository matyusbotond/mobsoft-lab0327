package com.example.mobsoft.mobsoft.interactor.persons.events;

import com.example.mobsoft.mobsoft.model.Person;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetPersonEvent {
    private Person person;
    private Exception throwable;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }
}
