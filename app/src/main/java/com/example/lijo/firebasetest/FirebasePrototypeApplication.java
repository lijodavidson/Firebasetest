package com.example.lijo.firebasetest;
import android.app.Application;

import com.firebase.client.Firebase;
/**
 * Created by LIJO on 12/3/2015.
 */
public class FirebasePrototypeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
