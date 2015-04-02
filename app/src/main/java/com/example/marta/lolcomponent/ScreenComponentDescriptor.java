package com.example.marta.lolcomponent;

import android.content.Context;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.component.SampleComponent;
import com.example.marta.lolcomponent.component.SampleComponentValidator;

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
        components.add(new SampleComponent(context, FieldType.FROM_DUPA,
                new SampleComponentValidator()));
        components.add(new SampleComponent(context, FieldType.DUPA,
                new SampleComponentValidator()));
        components.add(new SampleComponent(context, FieldType.QUANTITY, new SampleComponentValidator
                ()));
    }

    public List<IComponent> getScreenComponents() {
        return components;

    }

}
