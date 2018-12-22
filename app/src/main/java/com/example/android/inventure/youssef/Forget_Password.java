package com.example.android.inventure.youssef;

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
import com.google.firebase.auth.FirebaseAuth;

public class Forget_Password extends AppCompatActivity implements View.OnClickListener {

    EditText Email ;

    Button send_pass ;

    FirebaseAuth auth ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget__password);

        Email = findViewById(R.id.enter_email_forgot_page);
        send_pass = findViewById(R.id.send_pass_btn_forget_page);

        auth = FirebaseAuth.getInstance();

        send_pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.send_pass_btn_forget_page :
                auth.sendPasswordResetEmail(Email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Forget_Password.this, "Password send to your email",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Forget_Password.this, "Please check your email",Toast.LENGTH_LONG).show();
                        }
                    }
                });break;


        }
    }
}
