package com.example.mobsoft.mobsoft.ui.invoiceedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsPresenter;

import javax.inject.Inject;

public class InvoiceEditActivity extends AppCompatActivity implements InvoiceEditScreen {

    @Inject
    InvoiceEditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_edit);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setLoading(boolean loading) {

    }
}
