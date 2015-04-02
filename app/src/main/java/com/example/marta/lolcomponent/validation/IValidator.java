package com.example.marta.lolcomponent.validation;

/**
 * Created by Marta on 02/04/2015.
 */
public interface IValidator {

    ComponentValidationResult validate(IValidationVisitor validationVisitor);

}
