package com.example.marta.lolcomponent.component;

import android.view.View;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.validation.IValidator;
import com.example.marta.lolcomponent.Transaction;

/**
 * Created by Marta on 02/04/2015.
 */
public interface IComponent {
    int getResourceId();

    IValidator getValidator();

    void fillTransaction(Transaction transaction);

    String getComponentValue();

    void setValidationListener(IValidationListener listener);

    FieldType getFieldType();

    View getInflatedView();

    int getValidationErrorResourceId();

    public interface IValidationListener {
    void startValidation(IComponent requesterComponent);
    }
}
