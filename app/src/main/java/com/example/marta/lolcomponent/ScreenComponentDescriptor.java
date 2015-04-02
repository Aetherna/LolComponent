package com.example.marta.lolcomponent;

import android.content.Context;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.component.implementations.BlueComponent;
import com.example.marta.lolcomponent.component.implementations.PinkComponent;
import com.example.marta.lolcomponent.validation.implementations.BlueValidator;
import com.example.marta.lolcomponent.validation.implementations.PinkValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 02/04/2015.
 */
public class ScreenComponentDescriptor {

    private List<IComponent> components;
    private Context context;

    public ScreenComponentDescriptor(final Context context) {
        this.context = context;
        components = new ArrayList<>();
        components.add(new BlueComponent(context, FieldType.SAMPLE_FIELD_1,
                new BlueValidator()));
        components.add(new PinkComponent(context, FieldType.SAMPLE_FIELD_2,
                new PinkValidator()));
    }

    public List<IComponent> getScreenComponents() {
        return components;

    }

}
