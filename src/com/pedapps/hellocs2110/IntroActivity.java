package com.pedapps.hellocs2110;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Do all the setup associated with the Activity class -- Not implemented by me
        setContentView(R.layout.activity_intro); //Set our view to activity_intro.xml -- Not implemented by me
    }
    
    /*
     * launchHelloActivity(View view) is called when we click on the HelloActivity button.
     * In short, there are 2 ways to handle a button click:
     * 1. by declaring the android:onClick=... attribute in the xml. (Done here)
     * 2. by setting an OnClickListener in java. (Done in PrettyActivity and HelloActivity)
     * 
     * General Idea for following method 1:
     * i) Declare the android:onClick="someMethod" attribute for your button in the .xml file. (As done in activity_intro.xml)
     * ii) Then implement the method someMethod(View view) in your controller (the java file that corresponds to your .xml)
     * IMPORTANT: make sure the signature is exactly "public void someMethod(View view)" or Android will get confused.
     * (Obviously you can change 'someMethod' to whatever name you want - as long as it is consistent with step i) 
     * 
     */
    public void launchHelloActivity(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        startActivity(intent);
        /*
         * Here, we are creating an Intent. an Intent represents and abstract idea of needing to do something. 
         * That something could be starting another Activity, sending some data, or some other action that needs to take place.
         * Here, we are creating an Intent that is given the action of starting an instance of HelloActivity.
         * Then, by calling startActivity(intent), we ask the OS the start the Activity on a new "page."
         */
    }

    /*
     * launchPrettyActivity(View view) is called when we click on the PrettyActivity button.
     */
    public void launchPrettyActivity(View view) {
        Intent intent = new Intent(this, PrettyActivity.class);
        startActivity(intent);
        /*
         * We are doing the same exact thing as above, except with PrettyActivity instead of HelloActivity
         */
    }

    /*
    Everything past this point can be ignored.
    It is auto-generated code that comes with any class that extends the Activity class.
    In fact, you can erase it if you want and nothing important will happen - In fact you 
    will see that I have deleted in both other Activity files.
 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
