package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.FieldType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marta on 02/04/2015.
 */
public interface IValidationVisitor {
    String getValue(FieldType fromLocation);

    void setValue(FieldType fieldType, String displayedValue);
}
