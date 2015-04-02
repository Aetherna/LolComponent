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
    private ScreenState screenState;
    private ValidationResultListener validationResultListener;

    public ScreenValidator(ValidationResultListener validationResultListener, List<IComponent> components) {
        screenState = new ScreenState();
        this.validationResultListener = validationResultListener;
        createValidationChain(components);
    }

    private void createValidationChain(final List<IComponent> components) {
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
            ValidationResultType result = validationChain.get(component).validate(screenState);
            if(ValidationResultType.PASSED != result){
                validationResultListener.handleComponentValidationFailed(result);
                break;
            } else if(component.equals(requesterComponent)){
                validationResultListener.handleComponentValidationSuccessful(requesterComponent);
                break;
            }
        }
    }

    public interface ValidationResultListener {
        void handleComponentValidationSuccessful(IComponent component);
        void handleComponentValidationFailed(ValidationResultType result);
    }
}
