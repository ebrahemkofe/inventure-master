package com.example.android.inventure.youssef;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.inventure.Main;
import com.example.android.inventure.R;

public class Fillter extends AppCompatActivity {
    Dialog dialog ;
    ImageView btn_close_popup ;
    TextView filter_title , start_price , end_price , include;
    ImageView filter_img ;
    Button search , reset , save ;
    CheckBox apartment , duplex , pension , studio ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillter);
        dialog = new Dialog(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopUp();
            }
        });

        FloatingActionButton fab_home = (FloatingActionButton) findViewById(R.id.fab_home_filter);
        fab_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab_home_filter:
                        startActivity(new Intent(Fillter.this, Main.class));
                        break;
                }
            }
        });
    }

    public void ShowPopUp(){

        dialog.setContentView(R.layout.filter_tab);
        btn_close_popup = (ImageView) dialog.findViewById(R.id.close_filter);
        filter_title = dialog.findViewById(R.id.filter);
        start_price = dialog.findViewById(R.id.start_price);
        end_price = dialog.findViewById(R.id.end_price);
        include = dialog.findViewById(R.id.include);
        filter_img = dialog.findViewById(R.id.filter_img);
        search = dialog.findViewById(R.id.search);
        reset = dialog.findViewById(R.id.reset);
        save = dialog.findViewById(R.id.save);
        apartment = dialog.findViewById(R.id.apartment);
        duplex = dialog.findViewById(R.id.duplex);
        pension = dialog.findViewById(R.id.pension);
        studio = dialog.findViewById(R.id.studio);


        btn_close_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }
}
