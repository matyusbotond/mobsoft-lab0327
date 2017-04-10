package com.example.mobsoft.mobsoft.ui.persons;

import com.example.mobsoft.mobsoft.model.Person;
import com.example.mobsoft.mobsoft.ui.ScreenBase;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface PersonsScreen  extends ScreenBase {
    void setPersons(List<Person> persons);
}
