package com.example.marta.lolcomponent.component.implementations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.R;
import com.example.marta.lolcomponent.Transaction;
import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.validation.IValidator;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponent2 implements IComponent {

    private int resourceId = R.layout.sample_component2;
    private String componentValue = "test value 2";

    private View componentView = null;
    private IValidator validator = null;
    private IValidationListener listener;
    private FieldType fieldType;

    public SampleComponent2(Context context, FieldType fieldType, IValidator validator) {
        this.validator = validator;
        this.fieldType = fieldType;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        componentView = inflater.inflate(resourceId, null);

        final EditText editText = (EditText) componentView.findViewById(R.id.sample_edit);
        editText.setText(componentValue);

        Button button = (Button) componentView.findViewById(R.id.sample_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                componentValue = editText.getText().toString();
                listener.startValidation(SampleComponent2.this);
            }
        });
    }

    @Override
    public String getComponentValue() {
        return componentValue;
    }

    @Override
    public void setValidationListener(final IValidationListener listener) {
        this.listener = listener;
    }

    @Override
    public FieldType getFieldType() {
        return fieldType;
    }

    @Override
    public View getInflatedView() {
        return componentView;
    }

    @Override
    public IValidator getValidator() {
        return validator;
    }

    @Override
    public void fillTransaction(final Transaction transaction) {
        transaction.setValue2("SetValue 2 by " + this.getClass().getSimpleName());
        transaction.setValue4("SetValue 4 by " + this.getClass().getSimpleName());
    }

}
