package com.example.mobsoft.mobsoft.interactor.persons;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonsEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.LoginEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.RemovePersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.SavePersonEvent;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class PersonInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public PersonInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getPersons(){
        GetPersonsEvent event = new GetPersonsEvent();

        try {
            List<Person> persons = repository.getPersons();
            event.setPersons(persons);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getPerson(int id){
        GetPersonEvent event = new GetPersonEvent();

        try {
            Person person = repository.getPerson(id);
            event.setPerson(person);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void savePerson(Person person){
        SavePersonEvent event = new SavePersonEvent();

        try {
            repository.savePerson(person);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removePerson(Person person){
        RemovePersonEvent event = new RemovePersonEvent();
        try {
            repository.removePerson(person);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void login(String userName, String password) {
        LoginEvent event = new LoginEvent();

        try {
            //TODO login hívás

            event.setLoginSuccessfull(true);

            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }

    }
}
