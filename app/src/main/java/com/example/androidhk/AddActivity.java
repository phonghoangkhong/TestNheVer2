package com.example.androidhk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.Info;

import java.text.ParseException;
import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {
   EditText name2, tuoi2,quequan2,daotao2,lamviec2,date;
   EditText ngaysinh;
    Spinner hocvan2;
    Spinner trangthai2;
    Spinner phongban;
    LinearLayout linearLayout;
    Button btnThem;
    String hocvan;
String phongban3;
Database database;
String trangthaiuser;
Spinner gioitinh;
String gioitinh2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name2=findViewById(R.id.ten2);
        btnThem=findViewById(R.id.btncn);
        database=new Database(this);
        quequan2=findViewById(R.id.quequan2);
     gioitinh=findViewById(R.id.gioitinh2);
        tuoi2=findViewById(R.id.tuoi2);
        hocvan2=findViewById(R.id.hocvan2);
        phongban=(Spinner)findViewById(R.id.phong2);
        linearLayout=findViewById(R.id.layouttt2);
        trangthai2=findViewById(R.id.trangthai2);
        ngaysinh=findViewById(R.id.ngaysinh2);
        final ArrayList<String> listhocvan;
        final ArrayList<String> listphongBan;

        final ArrayList<String> listtrangThai;
        listtrangThai=new ArrayList<>();
        listtrangThai.add("Đang làm việc");
        listtrangThai.add("Nghỉ việc");
        listhocvan=new ArrayList<>();
        listhocvan.add("CD");
        listhocvan.add("DH");
        listhocvan.add("TC");
        listphongBan=new ArrayList<>();
        listphongBan.add("CNTT");
        listphongBan.add("Sale");
        listphongBan.add("Mar");
        final ArrayList<String > listGioiTinh=new ArrayList<>();
        listGioiTinh.add("Nam");
        listGioiTinh.add("Nữ");
        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listGioiTinh
                );
        gioitinh.setAdapter(adapter4);
        gioitinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 gioitinh2=listGioiTinh.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                   gioitinh2="Nam";
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        listhocvan
                );

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item ,
                        listphongBan
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item ,
                        listtrangThai
                );
        adapter3.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        adapter2.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        hocvan2.setAdapter(adapter);
        phongban.setAdapter(adapter2);
        date=findViewById(R.id.date2);
        daotao2=findViewById(R.id.daotao2);
        lamviec2=findViewById(R.id.lamviec2);
        trangthai2.setAdapter(adapter3);
        trangthai2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               trangthaiuser=listtrangThai.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               trangthaiuser=listtrangThai.get(0);
            }
        });
        hocvan2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hocvan=listhocvan.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                  hocvan=listhocvan.get(0);
            }
        });
        phongban.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phongban3=listphongBan.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                phongban3=listphongBan.get(0);
            }
        });
        if(getIntent().getStringExtra("state").equals("1")){
            String username=getIntent().getStringExtra("username");
            database=new Database(this);
            Info info= null;
            try {
                info = database.getInfo(username);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            name2.setText(info.getTen());
            tuoi2.setText(info.getTuoi());
            quequan2.setText(info.getQuequan());
            daotao2.setText(info.getQuaTrinhDaoTao());
            lamviec2.setText(info.getQuaTrinhLamViec());
            date.setText(info.getDate().toString());
            ngaysinh.setText(info.getNgaysinh());
        }
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameADD=name2.getText().toString();
                String tuoiADD=tuoi2.getText().toString();
                String phongban=phongban3;
                String hocvan2=hocvan;
                String quequan=quequan2.getText().toString();

                String trangthai2=trangthaiuser;
                String thoigian=date.getText().toString();
                String daotao=daotao2.getText().toString();
                String lamviec=lamviec2.getText().toString();
                String ngaysinh2=ngaysinh.getText().toString();
               String gioiTinh=gioitinh2;
                String username=getIntent().getStringExtra("username");


                Info info=new Info(nameADD,gioiTinh,ngaysinh2,tuoiADD,phongban,username,trangthai2,quequan,hocvan2,daotao,lamviec,thoigian);
                System.out.println(info);


                if(getIntent().getStringExtra("state").equals("0")) {
                    Intent intent=new Intent();
                    database.addInfo(info);
                    setResult(100, intent);
                    finish();
                }
                else {
                    Intent intent=new Intent();
                    database.updateInfo(info);
                    setResult(101, intent);
                    finish();
                }


            }
        });
    }
}