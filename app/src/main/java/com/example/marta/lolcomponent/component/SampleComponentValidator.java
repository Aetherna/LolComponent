package com.example.marta.lolcomponent.component;

import android.text.TextUtils;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.validation.ComponentValidationResult;
import com.example.marta.lolcomponent.validation.IValidationVisitor;
import com.example.marta.lolcomponent.validation.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponentValidator implements IValidator {

    @Override
    public ComponentValidationResult validate(final IValidationVisitor validationVisitor) {
        String fromLocationBarcode = validationVisitor.getValue(FieldType.FROM_DUPA);

        if (!TextUtils.isEmpty(fromLocationBarcode)) {
            return ComponentValidationResult.PASSED;
        } else {
            return ComponentValidationResult.INVALID_FROM_LOCATION;
        }
    }
}
