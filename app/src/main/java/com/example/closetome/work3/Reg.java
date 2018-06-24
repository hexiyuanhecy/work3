package com.example.closetome.work3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reg extends AppCompatActivity {

    private  MyDatabaseHelper dbHelper;
    private EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        editText1 = (EditText)findViewById(R.id.et_userName);
        editText2 = (EditText)findViewById(R.id.et_password);

        dbHelper=new MyDatabaseHelper(this, "MyDiary", null, 1);
        dbHelper.getWritableDatabase();
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        Button reg=(Button)findViewById(R.id.btn_reg);
        TextView login=(TextView)findViewById(R.id.login);
        reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user_name = editText1.getText().toString();
                String password = editText2.getText().toString();

                SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日  HH:mm:ss ");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String logintime = formatter.format(curDate);

                SQLiteDatabase db =dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始装数据
                values.put("user_name",user_name);
                values.put("password",password);
                values.put("days", 0);
                values.put("logintime",logintime);
                values.put("items",0);
                db.insert("USER",null,values);

                Intent intent=new Intent(Reg.this,Login.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Reg.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
