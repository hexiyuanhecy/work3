package com.example.closetome.work3;

        import android.content.ContentValues;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;


public class Login extends AppCompatActivity {

    private  MyDatabaseHelper dbHelper;
    private EditText editText1,editText2;
    private  int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = (EditText)findViewById(R.id.et_userName);
        editText2 = (EditText)findViewById(R.id.et_password);
        String user_name = editText1.getText().toString();
        String password = editText2.getText().toString();
        dbHelper=new MyDatabaseHelper(this, "MyDiary", null, 1);
        dbHelper.getWritableDatabase();

        SQLiteDatabase db =dbHelper.getWritableDatabase();
       // ContentValues values = new ContentValues();

        Cursor cursor = db.query("USER",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("user_name"));
                String password_right = cursor.getString(cursor.getColumnIndex("password"));
                if(name==user_name && password==password_right){
                    check=1; Toast.makeText(Login.this,"123456",Toast.LENGTH_SHORT).show();
                }
            }while (cursor.moveToNext());
        }

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        TextView reg=(TextView)findViewById(R.id.reg);
        Button login=(Button)findViewById(R.id.btn_login) ;
        reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,index.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(check==1){
                    Intent intent=new Intent(Login.this,Reg.class);
                    startActivity(intent);}
                else {
                    Toast.makeText(Login.this,"密码或用户名不正确，请重新输入！",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
