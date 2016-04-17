package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Edward on 4/17/2016.
 */
public class OrganEdit extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickorganeditconfirm(View v)
    {

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
