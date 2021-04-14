package com.example.resumie;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;

        import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}