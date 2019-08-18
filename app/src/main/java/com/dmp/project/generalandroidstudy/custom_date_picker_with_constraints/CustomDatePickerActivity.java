package com.dmp.project.generalandroidstudy.custom_date_picker_with_constraints;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import com.dmp.project.generalandroidstudy.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import timber.log.Timber;

public class CustomDatePickerActivity extends AppCompatActivity {

    //for date picker
    private int mYear;
    private int mMonth;
    private int mDay;

    EditText etBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_date_picker);

        etBirthday = findViewById(R.id.et_birthday);

    }
    public void pickDate() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(CustomDatePickerActivity.this,
                (view, year, monthOfYear, dayOfMonth) -> etBirthday.setText(toUserFriendlyDateFormat(year, monthOfYear, dayOfMonth)), mYear, mMonth+1, mDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        datePickerDialog.show();
    }

    private String toUserFriendlyDateFormat(int year, int month, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy");

        SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM dd,yyyy");
        Timber.d("format is: ");
        Date date = null;
        try {
            date = formatter.parse(day + "-" + (month + 1) + "-" + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatter2.format(date);
    }
}
