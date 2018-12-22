package com.example.android.inventure.youssef;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.inventure.Main;
import com.example.android.inventure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button register_btn_login_page , login_btn_login_page , forgot_btn_login_page , phone_num_btn;

    TextInputEditText edaccount_login_page , edpassword_login_page ;

    FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        edaccount_login_page = findViewById(R.id.edite_account_login_page);
        edpassword_login_page = findViewById(R.id.edite_password_login_page);
        register_btn_login_page = findViewById(R.id.register_btn_login_page);
        login_btn_login_page = findViewById(R.id.login_btn_login_page);
        forgot_btn_login_page = findViewById(R.id.forgot_btn_login_page);
        //phone_num_btn = findViewById(R.id.login_by_phone_num_btn_login_page);

        register_btn_login_page.setOnClickListener(this);
        login_btn_login_page.setOnClickListener(this);
        forgot_btn_login_page.setOnClickListener(this);
        // phone_num_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.login_btn_login_page :
                login();  break;

            case R.id.register_btn_login_page :
                startActivity(new Intent(Login.this, Register.class)); break;

            case R.id.forgot_btn_login_page :
                startActivity(new Intent(this, Forget_Password.class)); break;

        }
    }

    private void login(){


        String account = edaccount_login_page.getText().toString();
        String pass = edpassword_login_page.getText().toString();

        if(account.length()> 0  && pass.length()>0) {



            auth.signInWithEmailAndPassword(account , pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        verifyEmail();

                    }else {
                        Toast.makeText(getApplicationContext(), "Email or Password is invalid" , Toast.LENGTH_LONG).show();

                    }
                }
            });

        }else{
            edaccount_login_page.setHintTextColor(Color.RED);
            edpassword_login_page.setHintTextColor(Color.RED);
            Toast.makeText(getApplicationContext(),"Please fill all form" ,Toast.LENGTH_LONG).show();

        }
    }
    private void verifyEmail(){

        FirebaseUser user = auth.getCurrentUser();

        if (user.isEmailVerified()){
            startActivity(new Intent(Login.this, Main.class));
        }else {

            Toast.makeText(getApplicationContext(),"Please verify your account" ,Toast.LENGTH_LONG).show();
        }
    }
}