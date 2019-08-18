package com.dmp.project.generalandroidstudy.custom_date_picker_with_constraints;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.dmp.project.generalandroidstudy.MainActivity;
import com.dmp.project.generalandroidstudy.R;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import timber.log.Timber;

public class CustomDatePickerActivity2 extends AppCompatActivity {



    EditText etBirthday;


    private int MINIMUM_AGE = 13;
    private int month;
    private int year;
    private int day;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_date_picker2);

        etBirthday = findViewById(R.id.et_birthday);

        year = Calendar.getInstance().get(Calendar.YEAR) - MINIMUM_AGE;
        month = 1;
        day= 1;
        etBirthday.setOnClickListener(view -> {

            openDatePicker(year,month,day);
        });
    }


    public void openDatePicker(int year, int month,int day){


        int minimumAgeAllowed = Calendar.getInstance().get(Calendar.YEAR) - MINIMUM_AGE;
        Timber.d("minimum age allowed: %s",minimumAgeAllowed);
        new SpinnerDatePickerDialogBuilder()
                .context(CustomDatePickerActivity2.this)
                .callback(this::OnDateSet)
                .spinnerTheme(R.style.NumberPickerStyle)
                .showTitle(true)
                .showDaySpinner(true)
                .defaultDate(year, month, day)
                .maxDate(Calendar.getInstance().get(Calendar.YEAR) - MINIMUM_AGE, 12, 31)
                .minDate(        1950, 0, 1)
                .build().show();


    }

    private void OnDateSet(com.tsongkha.spinnerdatepicker.DatePicker datePicker, int year, int month, int day) {

        Timber.d("date is set: %s / %s / %s",year,month,day);
        String userFriendlyFormatBirthday = toUserFriendlyDateFormat(year,month+1   ,day);
        etBirthday.setText(userFriendlyFormatBirthday);


        this.month = month;
        this.day = day;
        this.year = year;




    }

    private String toUserFriendlyDateFormat(int year, int month, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM dd,yyyy");
        Timber.d("selected date; %s", day + "-" + (month) + "-" + year);
        String dayFormat = String.format("%02d", day);
        String monthFormat = String.format("%02d", month);


        String dateString = dayFormat + "-" + (monthFormat) + "-" + year;
        Timber.d("parsing: %s",dateString);
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatter2.format(date);
    }


    private void limitDate(){

    }

}
