package com.example.mobsoft.mobsoft.ui.persondetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesActivity;
import com.example.mobsoft.mobsoft.ui.personedit.PersonEditActivity;
import com.example.mobsoft.mobsoft.ui.persons.PersonsActivity;

import javax.inject.Inject;

public class PersonDetailsActivity extends AppCompatActivity implements PersonDetailsScreen{

    private long personId;

    @Inject
    PersonDetailsPresenter presenter;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.personDetailsToolbar);
        setSupportActionBar(myToolbar);

        personId = getIntent().getExtras().getLong("id");

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        presenter.getPerson(personId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;

        TextView nameTv = (TextView)findViewById(R.id.tvPersonDetailsName);
        TextView usernameTv = (TextView)findViewById(R.id.tvPersonDetailsUsername);

        nameTv.setText(person.getName());
        usernameTv.setText(person.getUsername());
    }

    @Override
    public void setRemoveResult() {
        Intent in = new Intent(this, PersonsActivity.class);
        startActivity(in);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setLoading(boolean loading) {

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
                presenter.getPerson(personId);
                return true;

            case R.id.action_delete:
                presenter.removePerson(person);
                return true;

            case R.id.action_edit:
                Intent in = new Intent(this, PersonEditActivity.class);
                Bundle b = new Bundle();
                b.putLong("id", personId);
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
