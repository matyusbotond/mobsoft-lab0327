package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public interface Repository {

    void open(Context applicationContext);

    void close();

    List<Person> getPersons();

    Person getPerson(long id);

    void savePerson(Person person);

    void removePerson(Person person);

    List<Invoice> getInvoices();

    Invoice getInvoice(long id);

    void saveInvoice(Invoice invoice);

    void removeInvoice(Invoice invoice);
}
