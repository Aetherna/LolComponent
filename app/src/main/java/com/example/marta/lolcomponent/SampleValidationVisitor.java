package com.example.marta.lolcomponent;

import java.util.HashMap;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleValidationVisitor implements IValidationVisitor {

    private final HashMap<FieldType, String> fieldValues;

    public SampleValidationVisitor() {
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
