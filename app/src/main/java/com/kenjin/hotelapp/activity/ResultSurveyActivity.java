package com.kenjin.hotelapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kenjin.hotelapp.R;

public class ResultSurveyActivity extends AppCompatActivity {
    public  static  String DATAKIRIM="DataKirim";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_survey);
        TextView hasil=(TextView) findViewById(R.id.hasilsurvey);
        String pesan=getIntent().getStringExtra("datasurvey");
        int pesan1=(int)getIntent().getSerializableExtra(DATAKIRIM);
        hasil.setText(pesan+"\n"+pesan1);

    }
}
