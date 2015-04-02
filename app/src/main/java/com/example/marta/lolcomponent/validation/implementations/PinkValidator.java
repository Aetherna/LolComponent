package com.example.marta.lolcomponent.validation.implementations;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.ScreenState;
import com.example.marta.lolcomponent.validation.ValidationResultType;
import com.example.marta.lolcomponent.validation.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public class PinkValidator implements IValidator {

    @Override
    public ValidationResultType validate(final ScreenState screenState) {
        String neededValue1 = screenState.getValue(FieldType.SAMPLE_FIELD_1);
        String neededValue2 = screenState.getValue(FieldType.SAMPLE_FIELD_2);

        if(!neededValue1.equals("expected1") || !neededValue2.equals("expected2") ){
            return ValidationResultType.INVALID_SAMPLE_FIELD_2;
        }
        return ValidationResultType.PASSED;
    }
}
