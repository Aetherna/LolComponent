package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.component.IComponent;

/**
 * Created by Marta on 02/04/2015.
 */
public class ValidationResult {
    private ComponentValidationResult result;
    private IComponent component;

    public ValidationResult(final ComponentValidationResult result, IComponent component) {
        this.result = result;
        this.component = component;
    }

    public ComponentValidationResult getResult() {
        return result;
    }

    public int getErrorMessageResourceId() {
        return result.getErrorMessage();
    }

    public IComponent getComponent() {
        return component;
    }
}
