package com.example.marta.lolcomponent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.marta.lolcomponent.component.IComponent;
import com.example.marta.lolcomponent.component.SampleComponent;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<IComponent> components;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        components = new ArrayList<>();
        components.add(new SampleComponent());
        components.add(new SampleComponent());
        components.add(new SampleComponent());

        LinearLayout container = (LinearLayout) findViewById(R.id.main_container);

        for(final IComponent component: components){
            View view = getLayoutInflater().inflate(component.getResourceId(),null);
            container.addView(view);
        }
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
