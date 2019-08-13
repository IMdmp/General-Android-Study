package com.dmp.project.generalandroidstudy.scrollableradiobuttongroup;

import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.dmp.project.generalandroidstudy.R;

    public class CustomCheckChangedListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            Resources resources = compoundButton.getResources();
            if(isChecked){
                compoundButton.setTextColor(resources.getColor(R.color.white));
            }else{
                compoundButton.setTextColor(resources.getColor(R.color.blue));

            }
        }
    }
