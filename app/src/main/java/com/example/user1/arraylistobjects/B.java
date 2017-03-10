package com.example.user1.arraylistobjects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by user1 on 10/13/2016.
 */

public class B extends AppCompatActivity
{
   public static ArrayList<Contacts> data1= new ArrayList<Contacts>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Contacts contacts = new Contacts();
        contacts.setPhonenumber("58325968656");
        contacts.setId(1);
        contacts.setName("sumathi");
        data1.add(contacts);
        Contacts contacts1= new Contacts();
        contacts1.setPhonenumber("58325968656");
        contacts1.setId(1);
        contacts1.setName("prasu");
        data1.add(contacts1);
        Contacts contacts2= new Contacts();
        contacts2.setPhonenumber("58325968656");
        contacts2.setId(1);
        contacts2.setName("gowthami");
        data1.add(contacts2);

        Intent intent= new Intent(B.this,C.class);
        startActivity(intent);
    }
}
