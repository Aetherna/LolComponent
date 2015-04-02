package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.R;

/**
 * Created by Marta on 02/04/2015.
 */
public enum ComponentValidationResult {

    PASSED(R.string.validation_success),
    INVALID_FROM_LOCATION(R.string.sample_component_validation_error);

    ComponentValidationResult(final int errorMessage) {
        this.errorMessage = errorMessage;
    }

    private int errorMessage;

    public int getErrorMessage() {
        return errorMessage;
    }

}
