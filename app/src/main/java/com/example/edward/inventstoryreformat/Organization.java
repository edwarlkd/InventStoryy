package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Edward on 4/5/2016.
 */
public class Organization extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization);

        //fetch this string value
        //String username = getIntent().getStringExtra("Name");
        //examples: (not used nor needed)
        //this is an example simply insert our username
        //TextView tv = (TextView)findViewById(R.id.TVusername);
        //tv.setText(username);

    }

    /*
    This is for when users want to add more events and other schedules.
    //To be implemented further...
     */
    public void onAddingButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BAddInven)
        {
            Intent i = new Intent(Organization.this, OrgInsert.class);
            startActivity(i);
        }
    }

    /*
    This interaction allows users to select one or more items.
     */
    public void onSelectButton(View v)
    {
        //allow users to select n of items -> Then, delete or share.
        //if one item selected->view, delete, or share.
    }

    public void onShowlistButton(View v)
    {
        if(v.getId() == R.id.BShowlistorg)
        {
            Intent i = new Intent(Organization.this, Organlist.class);
            startActivity(i);
        }
    }

    //long press on a item, pop up comes up with 4 choice.
    //view, edit, delete, share


//'orginst'.
//'Submit' for organization. Connect and store in the database.
//Further for organization, create a table to display charts.
//Edit after accessing an item
//multiple selection to delete or share.
//long press -> view,edit,delete, share


}
