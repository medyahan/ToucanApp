package com.cemre.toucanapp.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.cemre.toucanapp.R;
import com.cemre.toucanapp.User.UserBoard;
import com.google.firebase.auth.FirebaseAuth;

public class RetailerStartUpScreen extends AppCompatActivity {

    //FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_start_up_screen);

        // düzenlenecek
        /*
        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null)
        {
            FirebaseAuth.getInstance().signOut();
            //startActivity(new Intent(getApplicationContext(), UserBoard.class));
            //finish();
        }*/
        //
    }

    public  void  CallLoginScreen(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
    public  void  CallSignUpScreen(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }
}