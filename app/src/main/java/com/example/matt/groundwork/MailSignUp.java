package com.example.matt.groundwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MailSignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_sign_up);

        Button addImage = (Button) findViewById(R.id.send_email);
        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Mail m = new Mail("matt.mariutto@gmail.com", "Over9000!!!");
                //Mail m = new Mail();

                String[] toArr = {"matt.mariutto@gmail.com", "mcm11e@my.fsu.edu"};
                m.setTo(toArr);
                m.setFrom("matt.mariutto@gmail.com");
                m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
                m.setBody("Email body.");


                try {
                    m.addAttachment("/sdcard/filelocation");

                    if (m.send()) {
                        Toast.makeText(MailSignUp.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MailSignUp.this, "Email was not sent.", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                    Log.e("MailApp", "Could not send email", e);
                }

                Intent i = new Intent(getApplicationContext(),
                        MainMenu.class);
                startActivity(i);
            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mail_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
