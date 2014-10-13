package com.pedapps.hellocs2110;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PrettyActivity extends Activity {
    Button do_nothing_button;
    TextView hello_world_text;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Do all the setup associated with the Activity class
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*
        Here, we are getting rid of the ActionBar (The TitleBar up at the top of the screen).
        It's better design to do it in the Manifest (since it's technically part of setup)
        But this is how you could do it dynamically.
         */
        setContentView(R.layout.activity_pretty); //Set our view to activity_hello.xml
        setUpLayout(); //Set up the layout
        respondToEvents(); //Set up a Listener for the Button
    }

    /*
    Connect to the Button and TextView in the Layout (activity_hello.xml)
     */
    public void setUpLayout() {
        do_nothing_button = (Button) findViewById(R.id.send_button);
        hello_world_text = (TextView) findViewById(R.id.hello_text);
        layout = (RelativeLayout) findViewById(R.id.pretty_layout);
        /*
        We have seen the first 2 assignments before. The third one is assigning layout variable
        to the layout with the id pretty_layout. If you look in activity_pretty.xml, we declare this
        attribute by saying android:id = "pretty_layout" while declaring the RelativeLayout element.
         */
        layout.setBackground(getResources().getDrawable(R.drawable.background));
        /*
        Although in activity_pretty.xml, we already did this exact thing
        (by saying android:background="@drawable/background")
        I wanted to show you how to set your background dynamically in Java.

        getResources() gives us access to our res folder.
        getDrawable() gives us access to the drawable folder inside the res folder.
        R.drawable.background is the drawable inside res/drawable that we want.
        layout.setBackground() sets the background of the current activity. (Terminology not 100%
        technically correct, but I think it makes the point more clearly).
         */
    }

    /*
    Respond to the do_nothing_button onClick event: display a Toast
     */
    public void respondToEvents() {
        do_nothing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This button actually doesn't do anything..", Toast.LENGTH_LONG).show();
                /*
                Ok This is not as complicated as it looks. A Toast is just a little alert that pops up for a split second.
                Toast.makeText(Context context, String text, Integer duration) takes these 3 arguments and creates a Toast.
                the .show() tells the OS to show the toast for the given duration.

                parameters:
                Toast.LENGTH_LONG : LENGTH_LONG is a final static integer declared in the Toast class. All it does is return the
                value 1. This tells the Toast object it should display the Toast for a long period of time (as opposed to
                Toast.LENGTH_SHORT)

                String text : This one is trivial.. you give it the String you want to be displayed with the Toast

                getApplicationContext() : Ok, this one is not fun at all. This parameter needs to be the Context of the Activity.
                Context is probably the hardest class for you to understand. But in short, Context is what allows each Activity
                to fit into the Application's Context. So each Activity has a Context, and each Application has sort of a global
                Context. Google Android Context for a better/more through explanation. Don't worry if you don't understand it though.

                * Disclaimer for more advanced Android developers: Yes, I am aware that getApplicationContext() should never be
                * used for Objects with short lifespans. But it is a whole lot less cryptic than HelloActivity.this
                * (which would be the correct alternative). This is a minor point though, so no need to actually worry about this.

                 */
            }
        });
    }



}
