package com.example.marta.lolcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.validation.ValidationResultType;
import com.example.marta.lolcomponent.validation.ScreenValidator;


public class MainActivity extends ActionBarActivity implements ScreenValidator.ValidationResultListener {

    private ScreenValidator screenValidator;
    private Transaction transaction;
    private ScreenComponentDescriptor componentDescriptor;

    private TextView transactionInfo;


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
        transactionInfo = (TextView) findViewById(R.id.transactionValues);
        transactionInfo.setText(transaction.toString());
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
    public void handleComponentValidationSuccessful(IComponent component) {
        component.fillTransaction(transaction);
        transactionInfo.setText(transaction.toString());
    }

    @Override
    public void handleComponentValidationFailed(ValidationResultType result) {
        Toast.makeText(this, result.getErrorMessage(), Toast.LENGTH_SHORT).show();
        transactionInfo.setText(transaction.toString());
    }
}
