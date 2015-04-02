package com.example.marta.lolcomponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marta.lolcomponent.R;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponent implements IComponent {

    private int resourceId = R.layout.sample_component;
    private String displayedValue = "LOL HINT";
    private View componentView = null;
    private IValidator validator = null;

    public SampleComponent(Context context, int resourceId) {
        this.resourceId = resourceId;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        componentView = inflater.inflate(resourceId, null);

        EditText editText = (EditText) componentView.findViewById(R.id.sample_edit);
        editText.setText(displayedValue);

        Button button = (Button) componentView.findViewById(R.id.sample_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getResourceId() {
        return resourceId;
    }


//    public boolean validate(IValidatorVisitor validator) {
//
//        return (validator.getSampleValueToValidate() != null);
//
//    }

    public IValidator getValidator() {
        return validator;
    }
//
//    public void xxx(Transaction transaction){
//        transaction.set
//    }

}
