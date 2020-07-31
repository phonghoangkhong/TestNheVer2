package com.example.androidhk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.Info;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    Button btnTK,btnDT,btnGT,btnPB;
    Database database;
    Button btnview,btnadd;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnTK=findViewById(R.id.buttonTK);
        database=new Database(this);
        btnview=findViewById(R.id.xemuser);
        btnadd=findViewById(R.id.adduser2);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminActivity.this,AddUser.class);
                startActivity(intent);
            }
        });
         sharedPreferences=this.getSharedPreferences("add",MODE_PRIVATE);
         String data;
         SharedPreferences.Editor editor=sharedPreferences.edit();


         if(sharedPreferences.getString("add","").equals("")){
             database.add();
             editor.putString("add","ok");
             editor.apply();
         }
  btnGT =findViewById(R.id.buttonGT);

  btnPB=findViewById(R.id.buttonCM);
  btnview.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent=new Intent(AdminActivity.this,HienThiActivity.class);
          intent.putExtra("state2","5");
          startActivity(intent);
      }
  });
        btnGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminActivity.this,HienThiActivity.class);
                intent.putExtra("state2","4");
                startActivity(intent);
            }
        });
        btnPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminActivity.this,HienThiActivity.class);
                intent.putExtra("state2","3");
                startActivity(intent);
            }
        });

         btnTK.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent=new Intent(AdminActivity.this,HienThiActivity.class);
                 intent.putExtra("state2","0");
                 startActivity(intent);
             }
         });
         btnDT=findViewById(R.id.buttonDT);
         btnDT.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(AdminActivity.this,HienThiActivity.class);
                 intent.putExtra("state2","1");
                 startActivity(intent);
             }
         });
//         btnDT.setOnLongClickListener(new View.OnLongClickListener() {
//             @Override
//             public boolean onLongClick(View v) {
//                 Toast.makeText(AdminActivity.this,"PHong ok",Toast.LENGTH_LONG).show();
//                 return true;
//             }
//         });


    }
}