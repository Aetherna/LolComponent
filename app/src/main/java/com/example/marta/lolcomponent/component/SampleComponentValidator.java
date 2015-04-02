package com.example.marta.lolcomponent.component;

import android.text.TextUtils;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.IValidationVisitor;
import com.example.marta.lolcomponent.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponentValidator implements IValidator {

    @Override
    public boolean validate(final IValidationVisitor validationVisitor) {
        String fromLocationBarcode = validationVisitor.getValue(FieldType.FROM_DUPA);
        return (TextUtils.isEmpty(fromLocationBarcode));
    }


}
