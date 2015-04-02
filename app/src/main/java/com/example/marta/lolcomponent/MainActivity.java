package com.example.marta.lolcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.validation.ComponentValidationResult;
import com.example.marta.lolcomponent.validation.ScreenValidator;
import com.example.marta.lolcomponent.validation.ValidationResult;


public class MainActivity extends ActionBarActivity implements ScreenValidator.ValidationResultListener {

    private ScreenValidator screenValidator;
    private Transaction transaction;
    private ScreenComponentDescriptor componentDescriptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout container = (LinearLayout) findViewById(R.id.main_container);

        componentDescriptor = new ScreenComponentDescriptor(this);
        screenValidator = new ScreenValidator(this, componentDescriptor.getScreenComponents());

        for (IComponent component : componentDescriptor.getScreenComponents()) {
            container.addView(component.getInflatedView());
        }
        transaction = new Transaction();
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

    @Override
    public void handleComponentValidationResult(final ValidationResult validationResult) {
        if (validationResult.getResult() == ComponentValidationResult.PASSED) {
            validationResult.getComponent().fillTransaction(transaction);
        } else {
            Toast.makeText(this, validationResult.getErrorMessageResourceId(), Toast.LENGTH_SHORT).show();
        }
    }
}
