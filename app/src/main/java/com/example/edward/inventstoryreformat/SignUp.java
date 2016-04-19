package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Edward on 4/4/2016.
 */
public class SignUp extends Activity {

    //use DatabaseHelper class, so create an object.
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    /*
    // 'onSignUpClick' function is enforced when the user select 'Sign Up' button on the main menu.
    //Input parameter (View v) is used to check its id to see if it's a button for signup
    //In sign up, it checks if the input pass1 and pass2 are equal. If so, then put it
     */
    public void onSignUpClick(View v){
        if(v.getId()==R.id.BSignUpButton)
        {
            //we read data from signup
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText phonenumber = (EditText)findViewById(R.id.TFphonenumber);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            //convert them to string values
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String phonenumberstr = phonenumber.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){

                //popup messagee if pass1 and pass2 don't match
                //('Toast' is used)
                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else{

                //insert to the database
                contact c = new contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setPhonenumber(phonenumberstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
                helper.close();

                //popup message.
                Toast pass = Toast.makeText(SignUp.this, "Successful! Now, Log In", Toast.LENGTH_SHORT);
                pass.show();

                //'starting new activity.' To start, we need to make object of Intent class
                //This takes back to the main menu after signing up is completed.
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            }

        }

    }


}
