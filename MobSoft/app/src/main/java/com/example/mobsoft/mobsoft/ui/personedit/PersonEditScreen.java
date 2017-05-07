package com.example.mobsoft.mobsoft.ui.personedit;

import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.ScreenBase;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface PersonEditScreen  extends ScreenBase {
    void setSaveResult();

    void setPerson(Person person);
}
