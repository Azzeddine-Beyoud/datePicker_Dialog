package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogFragment datePicker = new DatePickerFragment();
//                datePicker.show(getSupportFragmentManager(), "date picker");
                String notificationDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
                TextView textView = findViewById(R.id.textView);
                textView.setText(notificationDate);
                //textView.setText(getTimeHour());
//                DialogFragment timePicker = new TimePickerFragment();
//                timePicker.show(getSupportFragmentManager(), "time picker" );

            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final int hour = 10;
        final int minute = 15;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        String notificationDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(c.getTime());

        String time = new SimpleDateFormat("hh:mm", Locale.getDefault()).format(Calendar.getInstance().getTime());
        String[] timeSplit = time.split(":");
        int notification = Integer.parseInt(timeSplit[0])+1;
        int notificationMinute = Integer.parseInt(timeSplit[1])+15;
        String fullTime = ""+notification+":"+notificationMinute;
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
        //String[] splitDate= currentDateString.split(" ");
//DateFormat.FULL
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(currentDateString));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText("Hour: " + i + " Minute: " + i1);
    }

    public String getTimeHour(){
        String time = new SimpleDateFormat("hh:mm", Locale.getDefault()).format(Calendar.getInstance().getTime());
        String[] splitTime= time.split(":");

        String hour = splitTime[0];
        String minute = splitTime[1];

        return splitTime[0];
    }
    public String getDate(){
        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
        String[] splitDate= date.split("/");

        String day = splitDate[0];
        String mount = splitDate[1];
        String year = splitDate[2];

        return splitDate[0];
    }

}