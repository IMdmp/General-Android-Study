package com.dmp.project.generalandroidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShareSomethingActivity extends AppCompatActivity {


    EditText etShareSomething;
    Button btnShareIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_something);

        etShareSomething = findViewById(R.id.et_share_this);
        btnShareIt = findViewById(R.id.btn_share_something);

        btnShareIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SHARE();
            }
        });
    }

    public void SHARE() {

        // Do something in response to button

        String shareBody = etShareSomething.getText().toString();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "\n\n");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent,  "Title?"));

    }
}
