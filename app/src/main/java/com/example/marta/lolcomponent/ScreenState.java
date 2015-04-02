package com.example.marta.lolcomponent;

import java.util.HashMap;

/**
 * Created by Marta on 02/04/2015.
 */
public class ScreenState {

    private final HashMap<FieldType, String> fieldValues;

    public ScreenState() {
        fieldValues = new HashMap<>();
    }

    public String getValue(final FieldType valueName) {
        return fieldValues.get(valueName);
    }

    public void setValue(final FieldType fieldType, final String displayedValue) {
        fieldValues.put(fieldType, displayedValue);
    }
}
