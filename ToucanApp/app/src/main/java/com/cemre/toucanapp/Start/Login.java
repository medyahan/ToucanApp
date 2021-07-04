package com.cemre.toucanapp.Start;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email_giris);
        mPassword = findViewById(R.id.sifre_giris);
        mLoginBtn = findViewById(R.id.girisbutonu_giris);
        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email boş bırakılamaz.");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mPassword.setError("Şifre boş bırakılamaz.");
                    return;
                }
                if(password.length() < 6)
                {
                    mPassword.setError("Şifre en az 6 karakter içermeli.");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(getApplicationContext(), StartUp.class);
        startActivity(intent);
    }

}
