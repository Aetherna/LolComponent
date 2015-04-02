package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.R;

/**
 * Created by Marta on 02/04/2015.
 */
public enum ValidationResultType {

    PASSED(R.string.validation_success),
    INVALID_SAMPLE_FIELD_1(R.string.blue_component_validation_error),
    INVALID_SAMPLE_FIELD_2(R.string.pink_component_validation_error);

    ValidationResultType(final int errorMessage) {
        this.errorMessage = errorMessage;
    }

    private int errorMessage;

    public int getErrorMessage() {
        return errorMessage;
    }

}
