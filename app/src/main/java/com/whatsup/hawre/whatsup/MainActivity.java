package com.whatsup.hawre.whatsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import activities.InfinitViewActivity;
import activities.RegisterActivity;
import utils.LocaleHelper;
import utils.SharedConstants;

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

        Display display = getWindowManager().getDefaultDisplay();
        SharedConstants.screen_width = display.getWidth();
        SharedConstants.screen_height = display.getHeight();
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
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String language = item.getTitle().toString();
        LocaleHelper.changeLanguage(language, getResources());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
