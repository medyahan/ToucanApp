package com.cemre.toucanapp.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cemre.toucanapp.R;
import com.cemre.toucanapp.Start.StartUp;
import com.cemre.toucanapp.User.UserBoard;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;



    ImageView imgView1;
    TextView startekranslogan;

    Animation side_animasyon, bottom_animasyon;

    SharedPreferences onBoaringScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        imgView1 = findViewById(R.id.imgView1);
        startekranslogan = findViewById(R.id.startekranslogan);

        side_animasyon = AnimationUtils.loadAnimation(this, R.anim.side_animasyon);
        bottom_animasyon = AnimationUtils.loadAnimation(this, R.anim.bottom_animasyon);

        imgView1.setAnimation(side_animasyon);
        startekranslogan.setAnimation(bottom_animasyon);

        new Handler().postDelayed(() -> {
            onBoaringScreen = getSharedPreferences("onBoaringScreen", MODE_PRIVATE);

            boolean isFirstTime = onBoaringScreen.getBoolean("isFirsTime", true);


            if (isFirstTime) {


                SharedPreferences.Editor editor = onBoaringScreen.edit();
                editor.putBoolean("isFirstTime", false);
                editor.commit();


                Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(getApplicationContext(), UserBoard.class);
                startActivity(intent);
                finish();

            }


        }, SPLASH_TIMER);
/*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoaringScreen = getSharedPreferences("onBoaringScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoaringScreen.getBoolean("firsTime", true);

                if (isFirstTime) {

                    SharedPreferences.Editor editor = onBoaringScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), UserBoard.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_TIMER);

*/
    }
}