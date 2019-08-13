package com.dmp.project.generalandroidstudy.scrollableradiobuttongroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dmp.project.generalandroidstudy.R;

public class ScrollableRadioButtonGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_radio_button_group);


        RadioGroup daily_weekly_button_view = findViewById(R.id.daily_weekly_button_view);

        final RadioButton radio0 = findViewById(R.id.radio0);
        radio0.setOnCheckedChangeListener(new CustomCheckChangedListener());

    }
}
