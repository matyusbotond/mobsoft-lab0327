package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.interactor.invoice.InvoiceInteractor;
import com.example.mobsoft.mobsoft.interactor.persons.PersonInteractor;
import com.example.mobsoft.mobsoft.repository.RepositoryModule;
import com.example.mobsoft.mobsoft.ui.UIModule.UIModule;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsActivity;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsPresenter;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditActivity;
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditPresenter;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesPresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsActivity;
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsPresenter;
import com.example.mobsoft.mobsoft.ui.personedit.PersonEditActivity;
import com.example.mobsoft.mobsoft.ui.personedit.PersonEditPresenter;
import com.example.mobsoft.mobsoft.ui.persons.PersonsActivity;
import com.example.mobsoft.mobsoft.ui.persons.PersonsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(InvoiceDetailsActivity invoiceDetailsActivity);

    void inject(InvoiceEditActivity invoiceEditActivity);

    void inject(InvoicesActivity invoicesActivity);

    void inject(LoginActivity loginActivity);

    void inject(PersonDetailsActivity personDetailsActivity);

    void inject(PersonEditActivity personEditActivity);

    void inject(PersonsActivity personsActivity);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(PersonInteractor personInteractor);

    void inject(InvoiceInteractor invoiceInteractor);

    void inject(InvoiceDetailsPresenter invoiceDetailsPresenter);

    void inject(InvoiceEditPresenter invoiceEditPresenter);

    void inject(InvoicesPresenter invoicesPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(PersonsPresenter personsPresenter);

    void inject(PersonDetailsPresenter personDetailsPresenter);

    void inject(PersonEditPresenter personEditPresenter);

}