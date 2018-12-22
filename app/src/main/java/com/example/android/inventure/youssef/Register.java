package com.example.android.inventure.youssef;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.inventure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button register_btn_register_page;
    EditText edemail, edpassword, edconpassword;


    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();

        edemail = findViewById(R.id.edite_email_register_page);
        edpassword = findViewById(R.id.edite_password_register_page);
        edconpassword = findViewById(R.id.edite_reenter_password_register_page);
        register_btn_register_page = findViewById(R.id.register_btn_register_page);

        register_btn_register_page.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.register_btn_register_page:

                register();
                break;

        }

    }


    private void register() {

        String email = edemail.getText().toString();
        String password = edpassword.getText().toString();
        String repassword = edconpassword.getText().toString();

        if (email.length() > 0 && password.length() > 0) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                                sendEmailVerification();

                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
        } else {
            edpassword.setHintTextColor(Color.RED);
            edemail.setHintTextColor(Color.RED);
            edconpassword.setHintTextColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Please fill all form", Toast.LENGTH_LONG).show();

        }

        if (repassword.length() != password.length()) {
            Toast.makeText(getApplicationContext(), "The password is not matching", Toast.LENGTH_LONG).show();
            edconpassword.setTextColor(Color.RED);

        }

        if (edpassword.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be more than 6 char.", Toast.LENGTH_LONG).show();

        }

    }

    private void sendEmailVerification(){

        FirebaseUser user = auth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    startActivity(new Intent(Register.this, Login.class));

                }else{
                    Toast.makeText(getApplicationContext(), "Please verify your Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


