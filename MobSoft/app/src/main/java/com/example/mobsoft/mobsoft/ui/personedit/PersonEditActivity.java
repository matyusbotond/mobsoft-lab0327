package com.example.mobsoft.mobsoft.ui.personedit;

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
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsActivity;
import com.example.mobsoft.mobsoft.ui.persons.PersonsActivity;

import javax.inject.Inject;

public class PersonEditActivity extends AppCompatActivity implements PersonEditScreen {

    private Person person;

    private long personId;

    @Inject
    PersonEditPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_edit);
        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.personEditToolbar);
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
    public void showMessage(String message) {

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

                TextView password = (TextView)findViewById(R.id.password);
                TextView role = (TextView)findViewById(R.id.role);
                TextView name = (TextView)findViewById(R.id.name);
                TextView username = (TextView)findViewById(R.id.username);

                person.setName(name.getText().toString());
                person.setUsername(username.getText().toString());
                person.setRole(role.getText().toString());
                person.setPassword(password.getText().toString());

                presenter.savePerson(person);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void setSaveResult() {
        Intent in = new Intent(this, PersonDetailsActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", person.getId());
        in.putExtras(b);
        startActivity(in);
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;

        TextView password = (TextView)findViewById(R.id.password);
        TextView role = (TextView)findViewById(R.id.role);
        TextView name = (TextView)findViewById(R.id.name);
        TextView username = (TextView)findViewById(R.id.username);

        role.setText(person.getRole().toString());
        name.setText(person.getName().toString());
        username.setText(person.getUsername().toString());

    }
}
