package com.example.mobsoft.mobsoft.ui.persons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mobsoft.mobsoft.MobSoftApplication;
import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.invoices.InvoicesArrayAdapter;
import com.example.mobsoft.mobsoft.ui.persondetails.PersonDetailsActivity;

import java.util.List;

import javax.inject.Inject;

public class PersonsActivity extends AppCompatActivity implements PersonsScreen {

    @Inject
    PersonsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        MobSoftApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.personsToolbar);
        setSupportActionBar(myToolbar);

        presenter.getPersons();
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
    public void setPersons(List<Person> persons) {
        final PersonsArrayAdapter adapter = new PersonsArrayAdapter(this,persons);

        ((ListView)this.findViewById(R.id.personsListView)).setAdapter(adapter);
        ((ListView)this.findViewById(R.id.personsListView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person)parent.getItemAtPosition(position);
                Intent in = new Intent(parent.getContext(), PersonDetailsActivity.class);
                Bundle b = new Bundle();
                b.putLong("id", p.getId());
                in.putExtras(b);
                startActivity(in);
            }
        });

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
        getMenuInflater().inflate(R.menu.persons_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                presenter.getPersons();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
