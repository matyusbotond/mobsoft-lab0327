package com.example.mobsoft.mobsoft.ui.invoiceedit;

import com.example.mobsoft.mobsoft.model.Invoice;
import com.example.mobsoft.mobsoft.ui.ScreenBase;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface InvoiceEditScreen extends ScreenBase{
    void showMessage(String message);

    void setSaveResult();

    void setInvoice(Invoice invoice);
}
