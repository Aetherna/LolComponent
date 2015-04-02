package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.component.IComponent;

/**
 * Created by Marta on 02/04/2015.
 */
public class ValidationResult {
    private boolean result;
    private IComponent component;

    public ValidationResult(final boolean result, IComponent component) {
        this.result = result;
        this.component = component;
    }

    public boolean isResult() {
        return result;
    }

    public int getErrorMessageResourceId() {
        return component.getValidationErrorResourceId();
    }

    public IComponent getComponent() {
        return component;
    }
}
