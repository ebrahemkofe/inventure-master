package com.example.android.inventure.youssef;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.example.android.inventure.Main;
import com.example.android.inventure.R;
import com.example.android.inventure.ali.Web;

public class Contact_Us extends AppCompatActivity {
    WebView webView ;
    EditText name,mail,phone,comment;
    String com;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        comment = findViewById(R.id.coment);




        FloatingActionButton float_contact_us = (FloatingActionButton) findViewById(R.id.home_floatcontact_us);
        float_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.home_floatcontact_us:
                        startActivity(new Intent(Contact_Us.this, Main.class));
                        break;
                }
            }
        });
    }

    public void gotoweb(View view) {
        startActivity(new Intent(this,Web.class));
    }

    public void mail(View view) {


        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("email"));
        emailIntent.setType("message/rfc822");
        String [] s={"info@myaquar.com"};

        emailIntent.putExtra(Intent.EXTRA_EMAIL,s);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "any info about homes");
        emailIntent.putExtra(Intent.EXTRA_TEXT , "my name is : " + name.getText().toString() + "\n" + "my phone is : " + phone.getText().toString()+"\n"
                +"my comment is : " +comment.getText().toString());
        Intent choose=Intent.createChooser(emailIntent,"Launch Email");
        startActivity(choose);


    }

}
