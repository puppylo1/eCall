package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eCallServer.beans.Company;
import eCallServer.beans.User;
import eCallServer.beans.Worker;
import com.ecnu.lucky.ecallbeta0.tools.ServerConnector;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class SignupCountActivity extends AppCompatActivity
{
    private String registerResult;
    private boolean threadOver;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_count);

        Button confirm = (Button) findViewById(R.id.btn_count_init_confirm);
        confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Intent last  = getIntent();
                String str_userType = last.getStringExtra("userType");

                EditText edit_count = (EditText) findViewById(R.id.edit_count_name) ;
                EditText edit_pwd = (EditText) findViewById(R.id.edit_count_pwd);
                EditText edit_pwd2 = (EditText) findViewById(R.id.edit_count_pwd2);

                String str_count = edit_count.getText().toString();
                String str_pwd = edit_pwd.getText().toString();
                String str_pwd2 = edit_pwd2.getText().toString();

                if(str_count.equals(""))
                {
                    Toast.makeText(SignupCountActivity.this, "账户名不能为空", Toast.LENGTH_SHORT).show();
                }else if(!str_pwd.equals(str_pwd2))
                {
                    Toast.makeText(SignupCountActivity.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                }else
                    {
                        final User user = new User(str_count, str_pwd, str_userType);

                        Thread thread = new Thread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                ServerConnector serverConnector = new ServerConnector();
                                try {
                                    // put purpose of connection, user, and worker or company to server
                                    Map<String, Object> map = new HashMap<>();
                                    String connectType = "register";
                                    map.put("connectType", connectType);
                                    map.put("user", user);

                                    if (user.getType().compareTo("3") < 0) {
                                        map.put("worker", (Worker) last.getSerializableExtra("worker"));
                                    } else {
                                        map.put("company", (Company) last.getSerializableExtra("company"));
                                    }

                                    serverConnector.startConnect();
                                    serverConnector.postObject(map);
                                    // get registerResult from server
                                    Map<String, Object> mapBack = (Map<String, Object>) serverConnector.getObject();
                                    registerResult = (String) map.get("registerResult");

                                    serverConnector.closeConnect();

                                }catch (Exception e) {
                                    e.printStackTrace();
                                }finally{
                                    threadOver = true;
                                }
                            }
                        });

                        threadOver = false;
                        thread.start();
                        while(!threadOver)
                        {
                        }

                        if(registerResult.equals("success"))
                        {
                            Toast.makeText(SignupCountActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(SignupCountActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });
    }
}
