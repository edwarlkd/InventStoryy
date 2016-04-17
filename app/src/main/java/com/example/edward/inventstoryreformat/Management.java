package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Edward on 4/5/2016.
 * This is for Management portion of our application
 * To be inserted after 'Organization' is completed first.
 */
public class Management extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management);
    }

    /*
    This function is enforced when a 'Adding' button is pressed from 'management.xml'
     */
    public void onAddEventsButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BAddevents)
        {
            Intent i = new Intent(Management.this, ManagInsert.class);
            startActivity(i);
        }
    }

    public void onClickCalenderButton(View v)
    {
        if(v.getId() == R.id.BMcalendar)
        {
            Intent i = new Intent(Management.this, Calendarviewmanag.class);
            startActivity(i);
        }
    }

    public void onBackButtonClick(View v)
    {
        if(v.getId() == R.id.Bbackbutton)
        {
            Intent i = new Intent(Management.this, display.class);
            startActivity(i);
        }

    }


}
