package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.ui.UIModule.UIModule;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsActivity;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditActivity;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsActivity;
import com.example.mobsoft.mobsoft.ui.personedit.PersonEditActivity;
import com.example.mobsoft.mobsoft.ui.persons.PersonsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(InvoiceDetailsActivity invoiceDetailsActivity);

    void inject(InvoiceEditActivity invoiceEditActivity);

    void inject(InvoicesActivity invoicesActivity);

    void inject(LoginActivity loginActivity);

    void inject(PersonDetailsActivity personDetailsActivity);

    void inject(PersonEditActivity personEditActivity);

    void inject(PersonsActivity personsActivity);
}