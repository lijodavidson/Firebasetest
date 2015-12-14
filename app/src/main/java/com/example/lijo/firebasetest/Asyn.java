package com.example.lijo.firebasetest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

public class Asyn extends AppCompatActivity {

   private Button asbutt;
    private EditText asemail;
    private EditText aspassword;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_asyn);

asbutt=(Button)findViewById(R.id.crtbubuttonas);
 asemail=(EditText)findViewById(R.id.crtmailas);
        aspassword=(EditText)findViewById(R.id.crtpasswordas);




        asbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Asattempt ().execute();



            }
        });

    }



    class Asattempt extends AsyncTask<String,String,String>{
        final String crt_email=asemail.getText().toString();
        final String crt_password=aspassword.getText().toString();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();



            final ProgressDialog progressDialog = new ProgressDialog(Asyn.this,
                    R.style.AppCompatAlertDialogStyle);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating User...");
            progressDialog.show();


            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onSignupSuccess or onSignupFailed
                            // depending on success
                            // doInBackground();
                            // onSignupFailed();
                            progressDialog.dismiss();

                        }
                    }, 5000);




        }












        @Override
        protected String doInBackground(String... strings) {


            final Firebase ref = new Firebase("https://clovers.firebaseio.com");


            ref.createUser(crt_email,crt_password, new Firebase.ValueResultHandler<Map<String, Object>>()

            {
                @Override
                public void onSuccess(Map<String, Object> result) {

                    Firebase postRef = ref.child("users");

                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", crt_email);
                    map.put("uid", result.get("uid"));

                    postRef.push().setValue(map);


                  /*  Toast.makeText(getApplicationContext(), "ACTIVITY IS COMPLETED", Toast.LENGTH_SHORT).show();
*/
                      /*  System.out.println("Successfully created user account with uid: " + result.get("uid"));*/


                    Intent myIntent = new Intent(Asyn.this, usr.class);
                    Asyn.this.startActivity(myIntent);



                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    // there was an error
                }
            });



































            return null;
        }
    }










}
