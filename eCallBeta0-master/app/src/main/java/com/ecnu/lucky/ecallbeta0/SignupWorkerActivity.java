package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eCallServer.beans.Worker;

public class SignupWorkerActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_worker);

        Button btn_next = (Button) findViewById(R.id.btn_next_worker);
        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText edit_name = (EditText) findViewById(R.id.edit_worker_name);
                EditText edit_age = (EditText) findViewById(R.id.edit_worker_age);
                EditText edit_province = (EditText) findViewById(R.id.edit_worker_province);
                EditText edit_city = (EditText) findViewById(R.id.edit_worker_city);
                EditText edit_tel = (EditText) findViewById(R.id.edit_worker_tel);
                EditText edit_pro = (EditText) findViewById(R.id.edit_worker_pro);

                String str_name = edit_name.getText().toString();
                String str_age = edit_age.getText().toString();
                String str_province = edit_province.getText().toString();
                String str_city = edit_city.getText().toString();
                String str_tel = edit_tel.getText().toString();
                String str_pro = edit_pro.getText().toString();

                Worker worker = new Worker(str_name, str_age, str_province, str_city, str_tel, str_pro);

                Intent last = getIntent();

                Intent next = new Intent(SignupWorkerActivity.this, SignupCountActivity.class);
                next.putExtra("userType", last.getStringExtra("userType"));
                next.putExtra("worker", worker);
                startActivity(next);
            }
        });
    }
}
