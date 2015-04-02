package com.example.marta.lolcomponent.validation.implementations;

import android.text.TextUtils;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.ScreenState;
import com.example.marta.lolcomponent.validation.ComponentValidationResult;
import com.example.marta.lolcomponent.validation.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponent2Validator implements IValidator {

    @Override
    public ComponentValidationResult validate(final ScreenState screenState) {
        String neededValue1 = screenState.getValue(FieldType.SAMPLE_FIELD_1);
        String neededValue2 = screenState.getValue(FieldType.SAMPLE_FIELD_2);

        if(!neededValue1.equals("expected1") || !neededValue2.equals("expected2") ){
            return ComponentValidationResult.INVALID_SAMPLE_FIELD_2;
        }
        return ComponentValidationResult.PASSED;
    }
}
