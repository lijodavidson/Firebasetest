package com.example.lijo.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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

public class creatuser extends AppCompatActivity {

    private Button crtuser;
    private EditText crteamil;
    private EditText crtpass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_creatuser);

        crtuser=(Button)findViewById(R.id.crtbubutton);
        crteamil=(EditText)findViewById(R.id.crtmail);
        crtpass=(EditText)findViewById(R.id.crtpassword);



        crtuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String crt_email=crteamil.getText().toString();
                final String crt_password=crtpass.getText().toString();


           final Firebase ref = new Firebase("https://clovers.firebaseio.com");

                ref.createUser(crt_email, crt_password, new Firebase.ValueResultHandler<Map<String, Object>>()

                {
                    @Override
                    public void onSuccess(Map<String, Object> result) {

                        Firebase postRef = ref.child("users");

                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("name", crt_email);
                        map.put("uid",result.get("uid"));

                        postRef.push().setValue(map);


                        Toast.makeText(getApplicationContext(), "user created", Toast.LENGTH_SHORT).show();

                      /*  System.out.println("Successfully created user account with uid: " + result.get("uid"));*/


                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                    }
                });




            }
        });









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_creatuser, menu);
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
