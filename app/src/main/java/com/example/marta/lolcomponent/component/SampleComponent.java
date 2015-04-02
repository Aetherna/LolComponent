package com.example.marta.lolcomponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marta.lolcomponent.FieldType;
import com.example.marta.lolcomponent.IValidator;
import com.example.marta.lolcomponent.R;
import com.example.marta.lolcomponent.Transaction;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponent implements IComponent {

    private int resourceId = R.layout.sample_component;
    private String displayedValue = "LOL HINT";
    private View componentView = null;
    private IValidator validator = null;
    private IValidationListener listener;
    private FieldType fieldType;

    public SampleComponent(Context context, FieldType fieldType, IValidator validator) {
        this.validator = validator;
        this.fieldType = fieldType;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        componentView = inflater.inflate(resourceId, null);

        EditText editText = (EditText) componentView.findViewById(R.id.sample_edit);
        editText.setText(displayedValue);

        Button button = (Button) componentView.findViewById(R.id.sample_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.startValidation(SampleComponent.this);
            }
        });

    }

    @Override
    public int getResourceId() {
        return resourceId;
    }

    @Override
    public String getDisplayedValue() {
        return displayedValue;
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
        transaction.setValue1("SetValue 1");
        transaction.setValue3("SetValue 3");
    }


}
