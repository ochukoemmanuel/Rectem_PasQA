package com.ebeatsz.rectempastqa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.Inet4Address;

public class DetailScreen extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ImageView btn_back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_detail_screen);

        textView = (TextView) findViewById(R.id.detail_title);

        String name = getIntent().getStringExtra("name");
        textView.setText(name);

        btn_back = findViewById(R.id.btn_back);
        home = findViewById(R.id.home);

        btn_back.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.btn_back:
                i = new Intent(this, CourseScreen.class);
                startActivity(i);
                break;

            case R.id.home:
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}