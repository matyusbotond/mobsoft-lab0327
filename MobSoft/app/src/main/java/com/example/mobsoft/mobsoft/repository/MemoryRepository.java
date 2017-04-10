package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.model.Roles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class MemoryRepository implements Repository {

    public static List<Person> persons;
    public static List<Invoice> invoices;

    @Override
    public void open(Context applicationContext) {
        persons = new ArrayList<>();
        invoices = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Invoice data = new Invoice();

            data.setId((long) (i + 1));
            data.setCreated(new Date());
            data.setFromAddress("2117 Isaszeg, Mátyás király utca "+i+".");
            data.setFromName("Teszt elek " + i);
            data.setNetAmount(100*i);
            data.setTax(27);

            invoices.add(data);
        }

        for (int i = 0; i < 2; i++) {
            Person data = new Person();

            data.setId((long) (i + 1));
            data.setName("Teszt Elek " + i);
            data.setPassword("qwer");
            data.setUsername("tesztelek");
            data.setRole(Roles.Concrator);

            persons.add(data);
        }
    }

    @Override
    public void close() {

    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public Person getPerson(long id) {

        for (Person p : persons) {
            if(p.getId() == id){
                return p;
            }
        }

        return null;
    }

    @Override
    public void savePerson(Person person) {
        if(person.getId() == 0){
            persons.add(person);
        }
        else{
            Person old = getPerson(person.getId());
            persons.remove(old);
            persons.add(person);
        }
    }

    @Override
    public void removePerson(Person person) {
        persons.remove(person);
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public Invoice getInvoice(long id) {
        for (Invoice i : invoices) {
            if(i.getId() == id){
                return i;
            }
        }

        return null;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        if(invoice.getId() == 0){
            invoices.add(invoice);
        }
        else{
            Invoice old = getInvoice(invoice.getId());
            invoices.remove(old);
            invoices.add(invoice);
        }
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        invoices.remove(invoice);
    }
}
