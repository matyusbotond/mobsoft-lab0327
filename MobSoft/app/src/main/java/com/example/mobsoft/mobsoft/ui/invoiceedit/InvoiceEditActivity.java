package com.example.mobsoft.mobsoft.ui.invoiceedit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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
    private long invoiceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_edit);
        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.invoiceEditToolbar);
        setSupportActionBar(myToolbar);

        invoiceId = getIntent().getExtras().getLong("id");

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
        presenter.getInvoice(invoiceId);
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

        TextView idTv = (TextView)findViewById(R.id.invoiceEditNumber);
        TextView name = (TextView)findViewById(R.id.invoiceEditName);
        TextView address = (TextView)findViewById(R.id.invoiceEditAddress);
        TextView amount = (TextView)findViewById(R.id.invoiceEditAmount);
        TextView tax = (TextView)findViewById(R.id.invoiceEditTax);

        idTv.setText(invoice.getId().toString());
        name.setText(invoice.getFromName());
        address.setText(invoice.getFromAddress());
        amount.setText(String.valueOf(invoice.getNetAmount()));
        tax.setText(String.valueOf(invoice.getNetAmount()));
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

                TextView idTv = (TextView)findViewById(R.id.invoiceEditNumber);
                TextView name = (TextView)findViewById(R.id.invoiceEditName);
                TextView address = (TextView)findViewById(R.id.invoiceEditAddress);
                TextView amount = (TextView)findViewById(R.id.invoiceEditAmount);
                TextView tax = (TextView)findViewById(R.id.invoiceEditTax);

                invoice.setId(Long.parseLong(idTv.getText().toString()));
                invoice.setNetAmount(Integer.parseInt(amount.getText().toString()));
                invoice.setFromName(name.getText().toString());
                invoice.setFromAddress(address.getText().toString());
                invoice.setTax(Integer.parseInt(tax.getText().toString()));

                presenter.saveInvoice(invoice);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
