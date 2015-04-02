package com.example.marta.lolcomponent.component;

import com.example.marta.lolcomponent.R;

/**
 * Created by Marta on 02/04/2015.
 */
public class SampleComponent implements IComponent{

    private int resourceId = R.layout.sample_component;
    private String displayedValue;

    @Override
    public int getResourceId() {
        return resourceId;
    }

//    public boolean validate(IValidatorVisitor validator){
//
//        return (validator.getSampleValueToValidate() != null);
//
//    }
//
//    public void xxx(Transaction transaction){
//        transaction.set
//    }

}
