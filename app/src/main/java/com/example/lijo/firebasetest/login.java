package com.example.lijo.firebasetest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {


    private EditText editTextname;
    private EditText editTextemail;
    private EditText editTextpassword;
    private Button regbutton;
    private Button usr;
    private Button ctr;
    private Button ass;
    private CoordinatorLayout coordinatorLayout;
   /* private ProgressDialog proloading;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_login);

        editTextname=(EditText)findViewById(R.id.name);
        editTextemail=(EditText)findViewById(R.id.mail);
        editTextpassword=(EditText)findViewById(R.id.password);
        regbutton=(Button)findViewById(R.id.registerbutton);
        usr=(Button)findViewById(R.id.usr);
        ctr=(Button)findViewById(R.id.createuser);
        ass=(Button)findViewById(R.id.ASS);
      /*  proloading=(ProgressDialog)findViewById(R.id.loading);*/



        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = editTextname.getText().toString().toLowerCase().trim();
                String email = editTextemail.getText().toString().toLowerCase().trim();
                String password = editTextpassword.getText().toString().trim();

                //Store data in firebase



                Firebase ref = new Firebase("https://clovers.firebaseio.com");
                Firebase usersRef = ref.child("users");
                Firebase idref= usersRef.push();
                Map<String, String> alanisawesomeMap = new HashMap<String, String>();
                alanisawesomeMap.put("name", name);
                alanisawesomeMap.put("email", email);
                alanisawesomeMap.put("password", password);
                idref.setValue(alanisawesomeMap, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {

                        if(firebaseError!=null)
                        {


                            Snackbar snackbar = Snackbar
                                    .make(coordinatorLayout, "Unable to register", Snackbar.LENGTH_LONG)
                                    .setAction("UNDO", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                            snackbar1.show();
                                        }
                                    });

                            snackbar.show();



                        }

                        else
                        {







                            Intent myIntent = new Intent(login.this, landing.class);
                             login.this.startActivity(myIntent);


                        }


                    }
                });
                String uid=idref.getKey();







               /* usersRef.push().setValue(alanisawesomeMap);*/


               /* Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
                users.put("0", alanisawesomeMap);
                usersRef.setValue(users);*/






            }
        });

       /* Firebase rootRef = new Firebase("https://clovers.firebaseio.com");*/










usr.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent myIntent = new Intent(login.this, usr.class);
        login.this.startActivity(myIntent);


    }
});




        ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myIntent = new Intent(login.this, Asyn.class);
                login.this.startActivity(myIntent);


            }
        });



        ctr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myIntent = new Intent(login.this, creatuser.class);
                login.this.startActivity(myIntent);


            }
        });
























       /* Firebase alanRef = usersRef.child("0");
        Map<String, Object> fullname = new HashMap<String, Object>();


        fullname.put("Education", "MSC");
        alanRef.updateChildren(fullname);*/
/*
        Firebase postRef = ref.child("posts");

        Map<String, String> post1 = new HashMap<String, String>();
        post1.put("author", "gracehop");
        post1.put("title", "Announcing COBOL, a New Programming Language");
        postRef.push().setValue(post1);

        Map<String, String> post2 = new HashMap<String, String>();
        post2.put("author", "alanisawesome");
        post2.put("title", "The Turing Machine");
        postRef.push().setValue(post2);*/

/*
// Generate a reference to a new location and add some data using push()
        Firebase postRef = ref.child("posts");
        Firebase newPostRef = postRef.push();

// Add some data to the new location
        Map<String, String> post1 = new HashMap<String, String>();
        post1.put("author", "gracehop");
        post1.put("title", "Announcing COBOL, a New Programming Language");
        newPostRef.setValue(post1);

// Get the unique ID generated by push()
        String postId = newPostRef.getKey();
*/


    }


   /* void resister()
    {




    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
