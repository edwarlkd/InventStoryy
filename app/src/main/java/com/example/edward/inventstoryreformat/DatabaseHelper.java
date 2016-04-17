package com.example.edward.inventstoryreformat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by Edward on 4/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    //contacts
    private static final String TABLE_CONTACTS = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONENUMBER = "phonenumber";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    //inventory
    private static final String TABLE_ORGANIZATIONS = "organizations";
    private static final String COLUMN_ORGANIZATION_ITEMID = "itemid";
    private static final String COLUMN_ORGANIZATION_ITEMNAME = "itemname";
    private static final String COLUMN_ORGANIZATION_PRICE = "price";
    private static final String COLUMN_ORGANIZATION_QUANTITY = "quantity";
    private static final String COLUMN_ORGANIZATION_DESCRIPTION = "description";

    //management
    private static final String TABLE_MANAGEMENTS = "managements";
    private static final String COLUMN_MANAGEMENT_EVENTID = "eventid";
    private static final String COLUMN_MANAGEMENT_EVENTNAME = "eventname";
    private static final String COLUMN_MANAGEMENT_EVENTDATE = "eventdate";


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "inventstory.db";

    //decare database variable
    SQLiteDatabase db;

    //create a table for to hold values.
    private static final String TABLE_CREATE_CONTACTS = "create table " + TABLE_CONTACTS + "("
            + COLUMN_ID + " integer primary key, "
            + COLUMN_NAME + " text not null , "
            + COLUMN_EMAIL + " text not null , "
            + COLUMN_PHONENUMBER + " text not null , "
            + COLUMN_UNAME + " text not null , "
            + COLUMN_PASS + " text not null" + ");";

    //create a table for to hold values.
    private static final String TABLE_CREATE_ORGANIZATIONS = "create table " + TABLE_ORGANIZATIONS + "("
            + COLUMN_ORGANIZATION_ITEMID + " integer primary key autoincrement, "
            + COLUMN_ORGANIZATION_ITEMNAME + " text not null , "
            + COLUMN_ORGANIZATION_PRICE + " text not null , "
            + COLUMN_ORGANIZATION_QUANTITY + " text not null , "
            + COLUMN_ORGANIZATION_DESCRIPTION + " text not null " + ");";

    //create a table for to hold values.
    private static final String TABLE_CREATE_MANAGEMENTS = " create table " + TABLE_MANAGEMENTS + "("
            + COLUMN_MANAGEMENT_EVENTID + " integer primary key autoincrement, "
            + COLUMN_MANAGEMENT_EVENTNAME + " text not null , "
            + COLUMN_MANAGEMENT_EVENTDATE + " text not null " + ");";

    //constructor
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
    This is for 'Sign Up'. Parameter is an object from class 'contact'
    From the input object 'c', it gather the information from it and store it in the table
    in the database.
    */
    public void insertContact(contact c){

        //to insert to the database, use 'getWrite...' to make connection
        db = this.getWritableDatabase();
        //create content values
        ContentValues values = new ContentValues();

        // '*' means everything
        // fetch the data
        String query = "select * from 'contacts' ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount(); //returns number of rows in the cursor

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PHONENUMBER, c.getPhonenumber());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        //insert the data in 'values' to the specified table.
        db.insert(TABLE_CONTACTS, null, values);

    }

    /*

    //Called in 'OrgInsert' class to submit data into the database.
     */
    public void insertOrganization(inventoryorg c){

        // '*' means everything
        // fetch the data
        /*
        Caused by: android.database.sqlite.SQLiteException:
        no such table: inventoryorg (code 1): , while compiling: select * from inventoryorg

Caused by: android.database.sqlite.SQLiteException: no such table: organizations (code 1): , while compiling: select * from 'organizations'

         1.table is not being created
         suspect: 'count' from value.put for ItemID

         */

        //to insert to the database, use 'getWrite...' to make connection
        db = this.getWritableDatabase();
        //create content values
        ContentValues values = new ContentValues();

        //String query = " select * from organizations ";
       // Cursor cursor = db.rawQuery(query, null);
      //  int count = cursor.getCount(); //returns number of rows in the cursor
     //   values.put(COLUMN_ORGANIZATION_ITEMID, count); // should this be changed to 'c.getItemid()'
        values.put(COLUMN_ORGANIZATION_ITEMNAME, c.getItemname());
        values.put(COLUMN_ORGANIZATION_PRICE, c.getPrice());
        values.put(COLUMN_ORGANIZATION_QUANTITY, c.getQuantity());
        values.put(COLUMN_ORGANIZATION_DESCRIPTION, c.getDescription());

        db.insert(TABLE_ORGANIZATIONS, null, values);

    }

    public void insertManagement(inventorymanag c){

        //to insert to the database, use 'getWrite...' to make connection
        db = this.getWritableDatabase();
        //create content values
        ContentValues values = new ContentValues();

        // '*' means everything
        // fetch the data
        String query = " select * from managements ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount(); //what does this do

        values.put(COLUMN_MANAGEMENT_EVENTID, count);
        values.put(COLUMN_MANAGEMENT_EVENTNAME, c.getEventname());
        values.put(COLUMN_MANAGEMENT_EVENTDATE, c.getEventdate());

        db.insert(TABLE_MANAGEMENTS, null, values);

    }


    /*
    //This is for login; it checks the uname and search for matching password
    Parameter is String uname, which stands for username.
    The return value is the password matching to the username.
    */
    //used in MainActivity
    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "select uname, pass from " + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0); //username

                if(a.equals(uname)){ //if userinput 'uname' equals any value of username 'a' in the list
                    b = cursor.getString(1); //intialize the matching password to a variable 'b'
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 //change
        db.execSQL(TABLE_CREATE_CONTACTS);
        db.execSQL(TABLE_CREATE_ORGANIZATIONS);
        db.execSQL(TABLE_CREATE_MANAGEMENTS);
        //db.execSQL(TABLE_CREATE_CONTACTS+TABLE_CREATE_ORGANIZATIONS+TABLE_CREATE_MANAGEMENTS);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORGANIZATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MANAGEMENTS);
 //       db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS
   //             + " DROP TABLE IF EXISTS " + TABLE_ORGANIZATIONS
     //           + " DROP TABLE IF EXISTS " + TABLE_MANAGEMENTS); //doesn't work.
        this.onCreate(db);

    }
}
