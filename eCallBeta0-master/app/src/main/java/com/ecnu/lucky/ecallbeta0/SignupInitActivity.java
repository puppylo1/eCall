package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignupInitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_init);

        Button btnSignupGongren = (Button) findViewById(R.id.btn_signup_gongren);
        btnSignupGongren.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"登录中...", Toast.LENGTH_SHORT).show();
               signUp("1");
            }
        });
        Button btnSignupBanzuzhang = (Button) findViewById(R.id.btn_signup_banzuzhang);
        btnSignupBanzuzhang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"登录中...", Toast.LENGTH_SHORT).show();
                signUp("2");
            }
        });
        Button btnSignupLaowugongsi = (Button) findViewById(R.id.btn_signup_laowugongsi);
        btnSignupLaowugongsi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"登录中...", Toast.LENGTH_SHORT).show();
                signUp("3");
            }
        });
        Button btnSignupShigongdanwei = (Button) findViewById(R.id.btn_signup_shigongdanwei);
        btnSignupShigongdanwei.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"登录中...", Toast.LENGTH_SHORT).show();
                signUp("4");
            }
        });
    }

    private void signUp(String userType)
    {
        Intent intentToSignup;
        if(userType.compareTo("3")<0)
        {
            intentToSignup = new Intent(SignupInitActivity.this, SignupWorkerActivity.class);
        }else
        {
            intentToSignup = new Intent(SignupInitActivity.this, SignupCompanyActivity.class);
        }
        intentToSignup.putExtra("userType",userType);
        startActivity(intentToSignup);
    }
}
