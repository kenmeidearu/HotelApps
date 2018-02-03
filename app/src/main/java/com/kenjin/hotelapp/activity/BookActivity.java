package com.kenjin.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kenjin.hotelapp.R;
import com.kenjin.hotelapp.database.HotelDb;
import com.kenjin.hotelapp.model.Pesanan;

public class BookActivity extends AppCompatActivity {
    private EditText nama, email, phone, lama;
    private Button cancel, done;
    private HotelDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        db = HotelDb.getInstance(this);

        nama = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        phone = (EditText) findViewById(R.id.input_phone);
        lama = (EditText) findViewById(R.id.input_lama);
        cancel = (Button) findViewById(R.id.btn_cancel);
        done = (Button) findViewById(R.id.btn_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtemail = "null";
                String hari="1";
                if (!TextUtils.isEmpty(nama.getText().toString())
                        && !TextUtils.isEmpty(phone.getText().toString())) {
                    if (!TextUtils.isEmpty(email.getText().toString()))
                        txtemail = email.getText().toString();
                    if(!TextUtils.isEmpty(lama.getEditableText()))
                        hari=lama.getEditableText().toString();
                    Pesanan data=new Pesanan(nama.getText().toString(), phone.getText().toString(),
                                             txtemail, hari);
                    if (db.addPesanan(data)) {
                        startActivity(new Intent(BookActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(BookActivity.this, "Error On Order", Toast.LENGTH_SHORT)
                                .show();
                    }
                } else {
                    Toast.makeText(BookActivity.this, "Lengkapi Data", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookActivity.this, MainActivity.class));
                finish();
            }
        });
    }

}
