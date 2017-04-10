package com.example.mobsoft.mobsoft.ui.invoices;

import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.ScreenBase;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface InvoicesScreen  extends ScreenBase {
    void setInvoices(List<Invoice> invoices);
}
