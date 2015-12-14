package com.example.lijo.firebasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class usr extends AppCompatActivity {

    private Button loginbutton;
    private EditText loginemail;
    private EditText loginpassword;
    private ProgressDialog mAuthProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_usr);

        loginbutton=(Button)findViewById(R.id.loginbutton);
        loginemail=(EditText)findViewById(R.id.lmail);
        loginpassword=(EditText)findViewById(R.id.lpassword);





        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String login_email=loginemail.getText().toString();
                final String login_password=loginpassword.getText().toString();



                Firebase ref = new Firebase("https://clovers.firebaseio.com");

// Create a handler to handle the result of the authentication
                Firebase.AuthResultHandler authResultHandler = new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        // Authenticated successfully with payload authData
                        Toast.makeText(getApplicationContext(), "Authenticated successfully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // Authenticated failed with error firebaseError

                    }
                };


                // Or with an email/password combination
                ref.authWithPassword(login_email, login_password, authResultHandler);


/*// Authenticate users with a custom Firebase token
                ref.authWithCustomToken("<token>", authResultHandler);*/

/*// Alternatively, authenticate users anonymously
                ref.authAnonymously(authResultHandler);*/



/*// Or via popular OAuth providers ("facebook", "github", "google", or "twitter")
                ref.authWithOAuthToken("<provider>", "<oauth-token>", authResultHandler);*/






               /* Firebase ref = new Firebase("https://clovers.firebaseio.com");*/
                /*final Firebase ref = new Firebase("https://clovers.firebaseio.com");*/
                /*ref.authWithPassword(login_email, login_password,
                        new Firebase.AuthResultHandler() {

                            @Override
                            public void onAuthenticated(AuthData authData) {
                                // Authentication just completed successfully :)
                               *//* Map<String, String> map = new HashMap<String, String>();
                                map.put("provider", authData.getProvider());
                                if(authData.getProviderData().containsKey("displayName")) {
                                    map.put("displayName", authData.getProviderData().get("displayName").toString());     //login user and save the details into db
                                }

                                ref.child("users").child(authData.getUid()).setValue(map);*//*
                            }

                            @Override
                            public void onAuthenticationError(FirebaseError error) {
                                //\ Something went wrong :(
                                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();

                            }
                        });*/


























                /*ref.authWithPassword(login_email, login_password, new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {

                       *//* System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());*//*
                        *//*Toast.makeText(getApplicationContext(), "its working " , Toast.LENGTH_SHORT).show();*//*

                        Intent myIntent = new Intent(usr.this, landing.class);
                        usr.this.startActivity(myIntent);

                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // there was an error
                        Toast.makeText(getApplicationContext(), "ur dumb", Toast.LENGTH_SHORT).show();

                    }
                });*/













            }
        });











    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_usr, menu);
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
