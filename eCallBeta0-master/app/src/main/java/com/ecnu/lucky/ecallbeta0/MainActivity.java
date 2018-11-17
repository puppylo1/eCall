package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ecnu.lucky.ecallbeta0.tools.ServerConnector;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import eCallServer.beans.User;

public class MainActivity extends AppCompatActivity
{
    private User user;
    private String checkResult;
    private boolean threadOver;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Waiting for Tomcat(Server) and Navicat(MySQL) to generate a local server.


        // Input Username & Password
        final EditText edtusername = (EditText)findViewById(R.id.ipt_username);
        final EditText edtpassword = (EditText)findViewById(R.id.ipt_password);


        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();

                if(username.equals(""))
                {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }else if(password.equals(""))
                {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else
                {
                    checkCount(username, password);
                    if(checkResult.equals("success"))
                    {
                        Intent intentToIndex = new Intent(MainActivity.this, IndexActivity.class);
                        intentToIndex.putExtra("user", user);
                        startActivity(intentToIndex);
                    }else
                        {
                            Toast.makeText(MainActivity.this, "用户名不存在或密码错误", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });

        Button btnsignup = (Button) findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentToSignup = new Intent(MainActivity.this, SignupInitActivity.class);
                startActivity(intentToSignup);
            }
        });
        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }

    private void checkCount(final String name, final String pwd)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ServerConnector serverConnector = new ServerConnector();
                try
                {
                    user = new User(name, pwd, "");
                    // First tell server the purpose is login, then put user to server
                    Map<String, Object> map = new HashMap<>();
                    String connectType = "login";
                    map.put("connectType", connectType);
                    map.put("user", user);

                    serverConnector.startConnect();

                    serverConnector.postObject(map);
                    // get result of login check from server
                    Map<String, Object> mapResult = (Map<String, Object>) serverConnector.getObject();
                    checkResult = (String) mapResult.get("checkResult");

                    serverConnector.closeConnect();

                    if(checkResult.equals("success"))
                    {
                        // login success, get the userType from server
                        user.setType((String)mapResult.get("userType"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    threadOver = true;
                }
            }
        });
        // threadOver is to make main thread pause when connecting to server
        threadOver = false;
        thread.start();
        while(!threadOver)
        {
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

}
