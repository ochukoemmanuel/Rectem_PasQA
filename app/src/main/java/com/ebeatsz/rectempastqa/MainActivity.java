
package com.ebeatsz.rectempastqa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView schoolOf_name;
    CardView card_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        setViews();
    }

    private void setViews() {
        // creating a CardView and assigning a value.
        card_view = (CardView) findViewById(R.id.card);
        schoolOf_name = (TextView) findViewById(R.id.schoolOf_name);

        // Onclick Listeners
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Disable cardview and enable after 200ms
                card_view.setEnabled(false);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        card_view.setEnabled(true);
                    }
                }, 200);

                // Assigning a value to TextView
                String name = schoolOf_name.getText().toString();

                // intent to department page
                Intent intent = new Intent (MainActivity.this, DepartmentScreen.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}