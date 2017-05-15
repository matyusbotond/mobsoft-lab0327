package com.example.mobsoft.mobsoft.interactor.persons;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.GetPersonsEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.LoginEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.RemovePersonEvent;
import com.example.mobsoft.mobsoft.interactor.persons.events.SavePersonEvent;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.network.api.InvoicesApi;
import com.example.mobsoft.mobsoft.network.api.PersonsApi;
import com.example.mobsoft.mobsoft.network.api.UsersApi;
import com.example.mobsoft.mobsoft.repository.Repository;

import java.util.ArrayList;
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

    @Inject
    PersonsApi personsApi;

    @Inject
    UsersApi usersApi;

    public PersonInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getPersons(){
        GetPersonsEvent event = new GetPersonsEvent();

        try {
            List<Person> persons = repository.getPersons();

            List<com.example.mobsoft.mobsoft.network.model.Person> response = personsApi.personsGet().execute().body();

            for(Person i : new ArrayList<>(persons)){
                com.example.mobsoft.mobsoft.network.model.Person contains = null;
                for(com.example.mobsoft.mobsoft.network.model.Person s : response){
                    if(i.getId().equals(s.getId())){
                        contains = s;
                        break;
                    }
                }

                if(contains != null){
                    persons.add(new Person(contains));
                }
            }

            event.setPersons(persons);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getPerson(long id){
        GetPersonEvent event = new GetPersonEvent();

        try {
            Person person = repository.getPerson(id);

            if(person == null){
                person = new Person(personsApi.personsIdGet((double) id).execute().body());
            }

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
            personsApi.personsPost(person.ConvertToApi());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removePerson(Person person){
        RemovePersonEvent event = new RemovePersonEvent();
        try {
            personsApi.personsIdDelete(Double.valueOf(person.getId()));
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

            usersApi.loginPost(userName, password).execute();

            event.setLoginSuccessfull(true);

            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }

    }
}
