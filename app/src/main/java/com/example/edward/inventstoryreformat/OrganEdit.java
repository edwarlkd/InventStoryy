package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Edward on 4/17/2016.
 * This class is gonna be for editing item.
 * It will be connected with database to receive the data and modify back into it.
 */
public class OrganEdit extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickorganeditconfirm(View v)
    {
        //for now, it just takes back to 'organization'
        if(v.getId() == R.id.BCancelButton)
        {
            Intent i = new Intent(OrganEdit.this, Organization.class);
            startActivity(i);

            //popup message
            Toast pass = Toast.makeText(OrganEdit.this, "For now it does nothing, back 'organization'", Toast.LENGTH_SHORT);
            pass.show();
        }
    }

    public void onClickorganeditcancel(View v)
    {
        //In 'OrgInsert' if the user cancelled out on inserting new item.
        if(v.getId() == R.id.BCancelButton)
        {
            Intent i = new Intent(OrganEdit.this, Organization.class);
            startActivity(i);
        }
    }
}
