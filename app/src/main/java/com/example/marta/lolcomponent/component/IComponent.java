package com.example.marta.lolcomponent.component;

import android.view.View;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.Transaction;
import com.example.marta.lolcomponent.validation.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public interface IComponent {

    IValidator getValidator();

    void fillTransaction(Transaction transaction);

    String getComponentValue();

    void setValidationListener(IValidationListener listener);

    FieldType getFieldType();

    View getInflatedView();

    public interface IValidationListener {
        void startValidation(IComponent requesterComponent);
    }
}
