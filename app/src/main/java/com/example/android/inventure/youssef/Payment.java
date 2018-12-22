package com.example.android.inventure.youssef;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventure.R;

public class Payment extends AppCompatActivity {

    int sum = 0 ;

    Button buy_now , done ;

    Dialog dialog ;

    TextView Enter_serial_num ;

    TextInputEditText edite_serial_num ;

    TextView count_index ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__page);

       android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        count_index = findViewById(R.id.count_index);
        dialog = new Dialog(this);

        buy_now = findViewById(R.id.buy_now);
    }

    public void ShowPopUp(){
        dialog.setContentView(R.layout.dialog_pay);
        done = dialog.findViewById(R.id.done);
        edite_serial_num = dialog.findViewById(R.id.edite_serial_num);
        Enter_serial_num = dialog.findViewById(R.id.Enter_serial_num);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void buynow(View view) {


        ShowPopUp();
    }

    public void doneee(View view) {

        if (edite_serial_num.length() < 16 || edite_serial_num.length() > 16){

            edite_serial_num.setError("please enter valid serial");
            edite_serial_num.setHintTextColor(Color.RED);

        }
        else {
            dialog.dismiss();
            Toast.makeText(Payment.this, "Payment Done", Toast.LENGTH_SHORT).show();
        }

    }

    public void increment(View view) {
        count_index.setText(String.valueOf(++sum));

    }

    public void decrement(View view) {

        if (sum >= 1) {

            count_index.setText(String.valueOf(--sum));

        }
    }

}
