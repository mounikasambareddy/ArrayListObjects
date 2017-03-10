package com.example.user1.arraylistobjects;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double locationLatitude, locationLongitude;
Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView);
       // getGpsLocations();
        //********* Simple Span to color text ************//
        // this is the text that we going to work on
        SpannableString text = new SpannableString("Iam an example for spannable string ");
        // make "Iam" (characters 0 to 3) green
        text.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 0, 3, 0);
        // Put the SpannableString in textview

        //**** Relative Span to change text relative to others  ****//
        //changing the text from 5 to 9 1.5f bigger than textview size
        text.setSpan(new RelativeSizeSpan(1.5f), 5, 9, 0);

        text.setSpan(
                new ClickableSpan() {
                    @Override
                    public void onClick(View widget)
                    {
                        Toast.makeText(getApplicationContext(), "Click!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        ds.setColor(getResources().getColor(R.color.colorPrimary));
                    }
                }, 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);


        //************ Clickable Span **************//
        // going to make "for" a clickable text and bring a toast
        ClickableSpan clickfor = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "hello clicked for", Toast.LENGTH_LONG).show();
            }
        };
        text.setSpan(clickfor, 15, 18, 0);

        //******** Strike through text***********//
        text.setSpan(new StrikethroughSpan(), 9, 14, 0);
        //******** URL Span *********************//
        text.setSpan(new URLSpan("http://eazyprogramming.blogspot.in/"), 22, 26, 0);
        //******** ForegroundColor *********************//
        text.setSpan(new ForegroundColorSpan(Color.GREEN), 22, 26, 0);
        // make our ClickableSpans and URLSpans work
        txt.setMovementMethod(LinkMovementMethod.getInstance());

        txt.setText(text, TextView.BufferType.SPANNABLE);
    }
    public void getGpsLocations() {
        GPSTracker gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation())
        {
            locationLatitude = gps.getLatitude();
            locationLongitude = gps.getLongitude();
            Toast.makeText(getApplicationContext(),"lat"+locationLongitude+"..."+locationLongitude,Toast.LENGTH_SHORT).show();
        }
    }
}
