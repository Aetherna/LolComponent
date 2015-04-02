package com.example.marta.lolcomponent.validation;

import com.example.marta.lolcomponent.ScreenState;
import com.example.marta.lolcomponent.component.IComponent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marta on 02/04/2015.
 */
public class ScreenValidator implements IComponent.IValidationListener {

    private Map<IComponent, IValidator> validationChain;
    private IValidationVisitor screenState;
    private ValidationResultListener validationResultListener;


    public ScreenValidator(ValidationResultListener validationResultListener) {
        screenState = new ScreenState();
        this.validationResultListener = validationResultListener;
    }

    public void setComponentsToValidate(List<IComponent> components) {
        validationChain = new LinkedHashMap<>();
        for (IComponent component : components) {
            component.setValidationListener(this);
            validationChain.put(component, component.getValidator());
        }
    }

    @Override
    public void startValidation(IComponent requesterComponent) {

        screenState.setValue(requesterComponent.getFieldType(),
                requesterComponent.getComponentValue());

        for (IComponent component : validationChain.keySet()) {

            if (validationChain.get(component).validate(screenState)) {
                if (component.equals(requesterComponent)) {
                    validationResultListener.handleComponentValidationResult(new ValidationResult(true, requesterComponent));
                    break;
                }
            } else {
                validationResultListener.handleComponentValidationResult(new ValidationResult(false, requesterComponent));
                break;
            }
        }
    }

    public interface ValidationResultListener {
        void handleComponentValidationResult(ValidationResult validationResult);
    }
}
