package com.ebeatsz.rectempastqa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseScreen extends AppCompatActivity implements View.OnClickListener {

    TextView  course_title, course_name;
    CardView card_view;
    ImageView btn_back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_course_screen);

        course_title = (TextView) findViewById(R.id.course_title);

        String name = getIntent().getStringExtra("department_name");
        course_title.setText(name);

        card_view = (CardView) findViewById(R.id.course_card);
        course_name = findViewById(R.id.course_name);
        btn_back = findViewById(R.id.btn_back);
        home = findViewById(R.id.home);


        card_view.setOnClickListener(this);
        course_name.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            course_name = (TextView) findViewById(R.id.course_name);
                Intent i;

        switch (v.getId()) {
            case R.id.course_card:
                // Assigning a value to TextView
                String name = course_name.getText().toString();

                i = new Intent(CourseScreen.this, DetailScreen.class);
                i.putExtra("name", name);
                startActivity(i);
                break;

            case R.id.btn_back:
                i = new Intent(this, DepartmentScreen.class);
                startActivity(i);
                break;

            case R.id.home:

                i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}