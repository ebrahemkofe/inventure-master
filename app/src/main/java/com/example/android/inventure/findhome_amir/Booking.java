package com.example.android.inventure.findhome_amir;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.android.inventure.R;

public class Booking extends AppCompatActivity {

    int day, year;
    String month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);


    }

    public String monthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";

            default:
                return "";
        }
    }

    public void book_now(View view) {

        EditText etName, etPhone, etEmail;
        etName = findViewById(R.id.book_now_Name);
        etPhone = findViewById(R.id.book_now_Phone);
        etEmail = findViewById(R.id.book_now_Email);

        DatePicker datePicker = (DatePicker) findViewById(R.id.book_now_DatePicker);
        int day = datePicker.getDayOfMonth();
        String month = monthName((datePicker.getMonth() + 1));
        int year = datePicker.getYear();

        TimePicker timePicker = findViewById(R.id.book_now_TimePicker);
        String AM_PM = ""; int hour = 0 ;
        int hourEdit = timePicker.getCurrentHour();
        if (hourEdit > 12) {
            AM_PM = "PM";
            hour = hourEdit - 12;
        } else {
            AM_PM = "AM";
            hour = hourEdit;
        }
        int minute = timePicker.getCurrentMinute();

        String Name  = etName.getText().toString();
        String Phone = etPhone.getText().toString();
        String Email = etEmail.getText().toString();


        String Date = day +" "+ month +" "+ year ;

        String Time = hour +" : "+ minute +" "+ AM_PM ;



        showDialog(this, Name, Phone, Email, Date, Time);

        //Toast.makeText(this, Name + Phone + Email +  DateTime , Toast.LENGTH_SHORT).show();
    }




    public void showDialog(Activity activity, String Name, String Phone, String Email, String Date, String Time){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_book_now);

        TextView txtName =  dialog.findViewById(R.id.dialog_book_now_Name);
        txtName.setText(Name);

        TextView txtPhone =  dialog.findViewById(R.id.dialog_book_now_Phone);
        txtPhone.setText(Phone);

        TextView txtEmail =  dialog.findViewById(R.id.dialog_book_now_Email);
        txtEmail.setText(Email);

        TextView txtDate =  dialog.findViewById(R.id.dialog_book_now_Date);
        txtDate.setText(Date);

        TextView txtTime =  dialog.findViewById(R.id.dialog_book_now_Time);
        txtTime.setText(Time);


        Button dialogButton = dialog.findViewById(R.id.dialog_book_now_btn_Confirm);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }



}

