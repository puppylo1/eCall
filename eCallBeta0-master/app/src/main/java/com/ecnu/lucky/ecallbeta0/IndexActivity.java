package com.ecnu.lucky.ecallbeta0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import eCallServer.beans.User;

public class IndexActivity extends AppCompatActivity
{
    private User user;
    private Button btn_findjob;
    private Button btn_findworker;
    private Button btn_checkproject;
    private Button btn_checksalary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Intent last = getIntent();
        user = (User) last.getSerializableExtra("user");

        btn_findjob = (Button) findViewById(R.id.btn_findjob);
        btn_findworker = (Button) findViewById(R.id.btn_findworker);
        btn_checkproject = (Button) findViewById(R.id.btn_checkproject);
        btn_checksalary = (Button) findViewById(R.id.btn_checksalary);

        if(user.getType().equals("1")){
            indexGongren();
        }else if(user.getType().equals("2")){
            indexBanzuzhang();
        }else if(user.getType().equals("3")){
            indexLaowugongsi();
        }else{
            indexShigongdanwei();
        }
    }

    private void indexGongren()
    {
        btn_findjob.setVisibility(View.VISIBLE);
        btn_checkproject.setVisibility(View.VISIBLE);
        btn_checksalary.setVisibility(View.VISIBLE);


    }
    private void indexBanzuzhang()
    {
        btn_findjob.setVisibility(View.VISIBLE);
        btn_findworker.setVisibility(View.VISIBLE);
        btn_checkproject.setVisibility(View.VISIBLE);
        btn_checksalary.setVisibility(View.VISIBLE);


    }
    private void indexLaowugongsi()
    {
        btn_findworker.setVisibility(View.VISIBLE);
        btn_checkproject.setVisibility(View.VISIBLE);
        btn_checksalary.setVisibility(View.VISIBLE);

        
    }
    private void indexShigongdanwei()
    {
        btn_findworker.setVisibility(View.VISIBLE);
        btn_checkproject.setVisibility(View.VISIBLE);
        btn_checksalary.setVisibility(View.VISIBLE);


    }
}
