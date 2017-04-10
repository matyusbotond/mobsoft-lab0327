package com.example.mobsoft.mobsoft.repository;

import android.content.Context;

import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.model.Person;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Person> getPersons() {
        return SugarRecord.listAll(Person.class);
    }

    @Override
    public Person getPerson(long id) {
        return null;
    }

    @Override
    public void savePerson(Person person) {
        SugarRecord.saveInTx(person);
    }

    @Override
    public void removePerson(Person person) {
        SugarRecord.deleteInTx(person);
    }

    @Override
    public List<Invoice> getInvoices() {
        return SugarRecord.listAll(Invoice.class);
    }

    @Override
    public Invoice getInvoice(long id) {
        return null;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        SugarRecord.saveInTx(invoice);
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        SugarRecord.deleteInTx(invoice);
    }
}
