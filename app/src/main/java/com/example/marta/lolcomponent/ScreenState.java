package com.example.marta.lolcomponent;

import com.example.marta.lolcomponent.validation.IValidationVisitor;

import java.util.HashMap;

/**
 * Created by Marta on 02/04/2015.
 */
public class ScreenState implements IValidationVisitor {

    private final HashMap<FieldType, String> fieldValues;

    public ScreenState() {
        fieldValues = new HashMap<>();
    }

    @Override
    public String getValue(final FieldType valueName) {
        return fieldValues.get(valueName);
    }

    @Override
    public void setValue(final FieldType fieldType, final String displayedValue) {
        fieldValues.put(fieldType, displayedValue);
    }
}
