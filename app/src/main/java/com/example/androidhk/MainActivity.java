package com.example.androidhk;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.User;


public class MainActivity extends AppCompatActivity {
    Button btnDangNhap;
    Button btnDangKy;
    EditText username,password;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDangNhap=findViewById(R.id.button2);
        username=findViewById(R.id.textusername1);
        password=findViewById(R.id.textpassword1);
        database=new Database(this);


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User(username.getText().toString(),password.getText().toString());
                User out= database.findUserByName(username.getText().toString());
                if(user.equals(out)){
                    if(!user.getUsername().equals("admin")) {
                        Intent intent = new Intent();
                        intent.putExtra("username", username.getText().toString());
                        intent.setClass(MainActivity.this,UserActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent();
                        intent.putExtra("username", username.getText().toString());
                        intent.setClass(MainActivity.this, AdminActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}