package com.cemre.toucanapp.Common.LoginSignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cemre.toucanapp.R;
import com.cemre.toucanapp.User.UserBoard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword1, mPassword2;
    Button mRegisterBtn;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);

        mFullName = findViewById(R.id.ad_kayit);
        mEmail= findViewById(R.id.email_kayit);
        mPassword1 = findViewById(R.id.sifre_kayit);
        mPassword2 = findViewById(R.id.sifre2_kayit);
        mRegisterBtn = findViewById(R.id.kayitolbutonu_kayit);


        fAuth = FirebaseAuth.getInstance();
/*
        if(fAuth.getCurrentUser() != null)
        {
            //FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), UserBoard.class));
            finish();
        }*/

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password1 = mPassword1.getText().toString().trim();
                String password2 = mPassword2.getText().toString().trim();

                System.out.printf(password1);
                System.out.printf(password2);
                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email boş bırakılamaz.");
                    return;
                }
                if(TextUtils.isEmpty(password1))
                {
                    mPassword1.setError("Şifre boş bırakılamaz.");
                    return;
                }
                if(password1.length() < 6)
                {
                    mPassword1.setError("Şifre en az 6 karakter içermeli.");
                    return;
                }
                if(TextUtils.isEmpty(password1) == false && TextUtils.isEmpty(password2))
                {
                    mPassword2.setError("Şifreyi tekrar giriniz.");
                    return;
                }
                /*
                if(password1 != password2 && TextUtils.isEmpty(password1) == false && TextUtils.isEmpty(password2) == false)
                {
                    mPassword2.setError("Şifreler eşleşmiyor. Kontrol ediniz.");
                    return;
                }*/


                fAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Kayıt başarılı!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserBoard.class));
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Hata! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }

    public  void  BackToStartUp(View view)
    {
        Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);
        startActivity(intent);
    }
}