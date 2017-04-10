package com.example.mobsoft.mobsoft.interactor.persons.events;

import com.example.mobsoft.mobsoft.model.Person;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetPersonsEvent {


    private List<Person> persons;
    private Exception throwable;

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setThrowable(Exception throwable) {
        this.throwable = throwable;
    }

    public Exception getThrowable() {
        return throwable;
    }
}
