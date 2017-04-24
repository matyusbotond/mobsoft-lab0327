package com.example.mobsoft.mobsoft.ui.invoices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mobsoft.mobsoft.R;
import com.example.mobsoft.mobsoft.model.Invoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class InvoicesArrayAdapter extends ArrayAdapter<Invoice> {
    private final Context context;
    private final List<Invoice> values;

    public InvoicesArrayAdapter(Context context, List<Invoice> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.invoices_rowlayout, parent, false);
        TextView fromTxv = (TextView) rowView.findViewById(R.id.fromTxv);
        TextView createDateTxv = (TextView) rowView.findViewById(R.id.createDateTxv);
        TextView idTxv = (TextView) rowView.findViewById(R.id.idTxv);

        fromTxv.setText(values.get(position).getFromName());
        createDateTxv.setText(values.get(position).getCreated().toString());
        idTxv.setText(values.get(position).getId().toString());

        return rowView;
    }
}
