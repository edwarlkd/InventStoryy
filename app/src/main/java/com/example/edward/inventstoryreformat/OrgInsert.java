package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Edward on 4/5/2016.
 */
public class OrgInsert extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orginst);
    }

    /*
    This is to insert new items to the inventory.
    Parameter View v is needed to check the display.
    Once this button is pressed, it will send the data to the database.
     */
    public void onClickOrgSubmitButton(View v){

        if(v.getId()==R.id.BSubmitButton){
            //we read data from signup
            EditText itemname = (EditText) findViewById(R.id.TFitemname);
            EditText price = (EditText) findViewById(R.id.TFprice);
            EditText quantity = (EditText) findViewById(R.id.TFquantity);
            EditText description = (EditText) findViewById(R.id.TFdescription);

            //convert them to string values
            String itemnamestr = itemname.getText().toString();
            String pricestr = price.getText().toString();
            String quantitystr = quantity.getText().toString();
            String descriptionstr = description.getText().toString();

            //insert to the database
            inventoryorg inv = new inventoryorg();
            inv.setItemname(itemnamestr);
            inv.setPrice(pricestr);
            inv.setQuantity(quantitystr);
            inv.setDescription(descriptionstr);

            /*
//java.lang.IllegalStateException: Could not execute method for android:onClick
//
//at com.example.edward.inventstoryreformat.OrgInsert.onSubmitButton(OrgInsert.java:51)
    = i think :51 is 'helper.insertOrganization(inv);
             */

            //this one needs to be enforced.
            helper.insertOrganization(inv);
            helper.close();

            //popup message.
            Toast pass = Toast.makeText(OrgInsert.this, "Successfully created.", Toast.LENGTH_LONG);
            pass.show();

            //'starting new activity.' To start, we need to make object of Intent class
            //This takes back to the 'Organization' after new data is inserted.
            Intent i = new Intent(OrgInsert.this, Organization.class);
            startActivity(i);
        }
    }

    /*
    This is a simple function that takes the user to the previous display, which will be
    first page of 'Organization portion'.
     */
    public void onCancelButton(View v){

        //In 'OrgInsert' if the user cancelled out on inserting new item.
        if(v.getId() == R.id.BCancelButton)
        {
            Intent i = new Intent(OrgInsert.this, Organization.class);
            startActivity(i);
        }
    }

}
