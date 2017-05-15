package com.example.mobsoft.mobsoft.ui.invoicedetails;

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
import com.example.mobsoft.mobsoft.ui.invoiceedit.InvoiceEditActivity;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.persons.PersonsActivity;

import javax.inject.Inject;

public class InvoiceDetailsActivity extends AppCompatActivity implements InvoiceDetailsScreen {

    @Inject
    InvoiceDetailsPresenter presenter;

    private long invoiceId;
    private Invoice invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_details);

        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.invoiceDetailsToolbar);
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
    public void setLoading(boolean loading) {

    }

    @Override
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;

        TextView idTv = (TextView)findViewById(R.id.idTv);
        TextView dateTv = (TextView)findViewById(R.id.dateTv);
        TextView fromNameTv = (TextView)findViewById(R.id.fromNameTv);
        TextView addressTv = (TextView)findViewById(R.id.addressTv);
        TextView amountTv = (TextView)findViewById(R.id.amountTv);
        TextView taxTv = (TextView)findViewById(R.id.taxTv);
        TextView totalTv = (TextView)findViewById(R.id.totalTv);

        idTv.setText(invoice.getId().toString());
        dateTv.setText(invoice.getCreated().toString());
        fromNameTv.setText(invoice.getFromName());
        addressTv.setText(invoice.getFromAddress());
        amountTv.setText(invoice.getNetAmount());
        taxTv.setText(invoice.getTax());
        totalTv.setText(invoice.getNetAmount()*invoice.getTax()/100);
    }

    @Override
    public void setRemoveResult() {
        Intent in = new Intent(this, InvoicesActivity.class);
        startActivity(in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.invoice_details_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                presenter.getInvoice(invoiceId);
                return true;

            case R.id.action_delete:
                presenter.removeInvoice(invoice);
                return true;

            case R.id.action_edit:
                Intent in = new Intent(this, InvoiceEditActivity.class);
                Bundle b = new Bundle();
                b.putLong("id", invoiceId);
                in.putExtras(b);
                startActivity(in);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
