package com.kenjin.hotelapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.kenjin.hotelapp.R;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Button kirimsurvey=(Button) findViewById(R.id.kirimsurvey);
        final EditText isisurvey=(EditText) findViewById(R.id.isisurvey);

        kirimsurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SurveyActivity.this,ResultSurveyActivity.class);
                intent.putExtra("datasurvey",isisurvey.getText().toString());
                intent.putExtra(ResultSurveyActivity.DATAKIRIM,3);
                startActivity(intent);
            }
        });
    }
}
