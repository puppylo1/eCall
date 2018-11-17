package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eCallServer.beans.Company;

public class SignupCompanyActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_company);

        Button btn_next = (Button) findViewById(R.id.btn_next_company);
        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText edit_name = (EditText) findViewById(R.id.edit_company_name);
                EditText edit_type = (EditText) findViewById(R.id.edit_company_type);
                EditText edit_scale = (EditText) findViewById(R.id.edit_company_scale);
                EditText edit_disc = (EditText) findViewById(R.id.edit_company_disc);

                String str_name = edit_name.getText().toString();
                String str_type = edit_type.getText().toString();
                String str_scale = edit_scale.getText().toString();
                String str_disc = edit_disc.getText().toString();

                Company company = new Company(str_name, str_type, str_scale, str_disc);

                Intent last = getIntent();

                Intent next = new Intent(SignupCompanyActivity.this, SignupCountActivity.class);
                next.putExtra("userType", last.getStringExtra("userType"));
                next.putExtra("company", company);
                startActivity(next);
            }
        });
    }
}