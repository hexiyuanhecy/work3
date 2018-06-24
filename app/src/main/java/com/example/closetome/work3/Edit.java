package com.example.closetome.work3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        Button back=(Button)findViewById(R.id.button_backward);
        final ImageButton remind=(ImageButton)findViewById(R.id.remind_btn) ;
        boolean remindme=false;
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });
        remind.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                if(remindme==false){
                    remind.setImageResource(R.mipmap.check_green);
//                    remindme=true;
//                }
//                else
            }
        });

    }
}
