package com.example.tp_star;

//import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);

        // Animation sur le logo
        logo.animate().rotation(360f).setDuration(2000);
        logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
        logo.animate().translationYBy(1000f).setDuration(2000);
        logo.animate().alpha(0f).setDuration(6000);

        // Redirection vers ListActivity après 5 secondes
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, com.example.tp_star.ListActivity.class);
            startActivity(intent);
            finish();
        }, 5000);  // 5000 millisecondes = 5 secondes
    }
}
