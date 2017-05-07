package com.example.mobsoft.mobsoft.ui.persons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Person;

import java.util.List;

/**
 * Created by matyu on 2017. 05. 07..
 */



public class PersonsArrayAdapter extends ArrayAdapter<Person> {
    private final Context context;
    private final List<Person> values;

    public PersonsArrayAdapter(Context context, List<Person> values) {
            super(context, -1, values);
            this.context = context;
            this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.person_row_layout, parent, false);
            TextView nameTv = (TextView) rowView.findViewById(R.id.trowLayoutvName);

            nameTv.setText(values.get(position).getName());
            return rowView;
    }
}
