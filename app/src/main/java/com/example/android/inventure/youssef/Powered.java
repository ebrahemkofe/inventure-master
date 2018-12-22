package com.example.android.inventure.youssef;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android.inventure.Main;
import com.example.android.inventure.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Powered extends AppCompatActivity {

    TextView txt_mission ;

    Animation animation ;

    CircleImageView circleImageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powered);

        circleImageView = findViewById(R.id.powered);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim3);
        circleImageView.setAnimation(animation);

        txt_mission = findViewById(R.id.txt_mission);

        Typeface tf = Typeface.createFromAsset(getAssets(),"BRUSHSCI.TTF");
        txt_mission.setTypeface(tf);
        txt_mission.setTextSize(50);

        FloatingActionButton home_powered = (FloatingActionButton) findViewById(R.id.home_powered);
        home_powered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.home_powered :
                        Intent intent1 = new Intent(Powered.this, Main.class);
                        startActivity(intent1);
                }
            }
        });



    }
}
