package com.example.mobsoft.mobsoft.ui.invoiceedit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsActivity;
import com.example.mobsoft.mobsoft.ui.invoicedetails.InvoiceDetailsPresenter;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;

import javax.inject.Inject;

public class InvoiceEditActivity extends AppCompatActivity implements InvoiceEditScreen {

    private Invoice invoice;

    @Inject
    InvoiceEditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_edit);
        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.invoiceEditToolbar);
        setSupportActionBar(myToolbar);

        presenter.getInvoice(getIntent().getExtras().getLong("id"));
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
    public void setSaveResult() {
        Intent in = new Intent(this, InvoiceDetailsActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", invoice.getId());
        in.putExtras(b);
        startActivity(in);
    }

    @Override
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void setLoading(boolean loading) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:

                presenter.saveInvoice(invoice);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
