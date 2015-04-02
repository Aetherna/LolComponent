package com.example.marta.lolcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.component.SampleComponent;
import com.example.marta.lolcomponent.component.SampleComponentValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements IComponent.IValidationListener {

    List<IComponent> components;

    private Map<IComponent, IValidator> validationChain;
    private IValidationVisitor validationVisitor;
    private Transaction transaction;

    @Override
    public void startValidation(IComponent requesterComponent) {

        validationVisitor.setValue(requesterComponent.getFieldType(),
                requesterComponent.getDisplayedValue());

        for (IComponent component : validationChain.keySet()) {
            if (validationChain.get(component).validate(validationVisitor)) {
                if (component.equals(requesterComponent)) {
                    requesterComponent.fillTransaction(transaction);
                    break;
                }
            } else {
                Toast.makeText(this, "Failed validation on " + requesterComponent
                                .getDisplayedValue(),
                        Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        components = new ArrayList<>();
        components.add(new SampleComponent(this, FieldType.FROM_DUPA,
                new SampleComponentValidator()));
        components.add(new SampleComponent(this, FieldType.DUPA,
                new SampleComponentValidator()));
        components.add(new SampleComponent(this, FieldType.QUANTITY, new SampleComponentValidator
                ()));

        validationChain = new LinkedHashMap<>();
        for (IComponent component : components) {
            component.setValidationListener(this);
            validationChain.put(component, component.getValidator());
        }

        LinearLayout container = (LinearLayout) findViewById(R.id.main_container);

        for (IComponent component : components) {
            container.addView(component.getInflatedView());
        }

        transaction = new Transaction();
        validationVisitor = new SampleValidationVisitor();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
