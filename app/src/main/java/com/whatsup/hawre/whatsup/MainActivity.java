package com.whatsup.hawre.whatsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activities.HorizontalRecyclerView;
import activities.InfinitViewActivity;
import activities.MainMenuActivity;

public class MainActivity extends AppCompatActivity {

    Button facebook_button;
    Button email_button;
    Button test_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook_button = findViewById(R.id.facebook_btn);
        email_button = findViewById(R.id.email_btn);
        test_btn = findViewById(R.id.test);
        facebook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfinitViewActivity.class);
                startActivity(intent);
            }
        });

        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfinitViewActivity.class);
                startActivity(intent);
            }
        });

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfinitViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
