package com.example.androidhk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.User;

public class AddUser extends AppCompatActivity {
EditText use,pass;
Button btnX;
Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        use=findViewById(R.id.use);
        pass=findViewById(R.id.pass);
        database=new Database(this);
        btnX=findViewById(R.id.adduser);
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=use.getText().toString();
                String password=pass.getText().toString();
                User user1=new User(user,password);
               database.addUser(user1);

                   Toast.makeText(AddUser.this,"Add user OK",Toast.LENGTH_LONG).show();

            }
        });
    }
}