package com.example.androidhk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.Info;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class  InfoActivity extends AppCompatActivity {
final private int THEM=100;
final private int SUA=101;
Button btnThem;
Button btnSua;
Button btnChuyenPhong;
Button btnNghi;
TextView name, tuoi,phongban,trangthai,quequan,daotao,lamviec,date;
TextView ngaysinh;
 Info info;
LinearLayout linearLayout;
TextView cm;
String username;
TextView gioitinh;
Database database;
TextView hocvan;
    Date c = Calendar.getInstance().getTime();

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    String formattedDate = df.format(c);
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    btnThem=findViewById(R.id.btnThem);
    btnSua=findViewById(R.id.btnSua);
    btnChuyenPhong=findViewById(R.id.btnchuyenPhong);
    name=findViewById(R.id.ten1);
    tuoi=findViewById(R.id.tuoi1);
    cm=findViewById(R.id.cm);
    btnNghi=findViewById(R.id.btnNghi);
    phongban=findViewById(R.id.phong1);
    trangthai=findViewById(R.id.trangthai1);
    quequan=findViewById(R.id.quequan1);
    hocvan=findViewById(R.id.hocvan);
    ngaysinh=findViewById(R.id.ngaysinh1);
    lamviec=findViewById(R.id.lamviec1);
    daotao=findViewById(R.id.daotao1);
    cm.setVisibility(View.GONE);
    linearLayout=findViewById(R.id.layouttt);
    date=findViewById(R.id.date1);
    gioitinh=findViewById(R.id.gioitinh);
    database=new Database(this);


    username=getIntent().getStringExtra("username");
    try {
        info=database.getInfo(username);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if(info==null){
        linearLayout.setVisibility(View.GONE);
    }else {
        System.out.println(info);
        name.setText(info.getTen());
        tuoi.setText(info.getTuoi());
        phongban.setText(info.getPhongban());
        trangthai.setText(info.getTrangthai());
        quequan.setText(info.getQuequan());
        hocvan.setText(info.getHocvan());
        daotao.setText(info.getQuaTrinhDaoTao());
        lamviec.setText(info.getQuaTrinhLamViec());
        String ngay=info.getDate().toString();
        date.setText(ngay);
        gioitinh.setText(info.getGioiTinh());
        ngaysinh.setText(info.getNgaysinh());

        String[] dob = info.getNgaysinh().split("-");

        String[] today = formattedDate.split("-");

if(dob.length!=1) {
    if ((Integer.parseInt(dob[0]) == Integer.parseInt(today[0]) && Integer.parseInt(dob[1]) == Integer.parseInt(today[1]))) {
        cm.setVisibility(View.VISIBLE);
    }
}
    }




    btnNghi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (info != null&&info.getTrangthai().equals("Đang làm việc")) {

                info.setTrangthai("Nghỉ việc");

                info.setQuaTrinhLamViec(info.getQuaTrinhLamViec()+",Nghi Viec : "+ formattedDate);
                database.updateInfo(info);
                recreate();
            } else {
                Toast.makeText(InfoActivity.this, "Khong the sửa", Toast.LENGTH_LONG).show();
            }
        }
    });
    btnChuyenPhong.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (info != null) {
                final CharSequence[] items = {"CNTT", "Sale", "Mar"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(InfoActivity.this);
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                            System.out.println(info);
                            boolean t =info.getPhongban().equals(items[which].toString());

                            if(t==false) {
                                info.setPhongban(items[which].toString());

                                info.setQuaTrinhLamViec(info.getQuaTrinhLamViec() + ",Chuyen phong : "+items[which].toString() + formattedDate);
                                database.updateInfo(info);
                                recreate();
                                Toast.makeText(InfoActivity.this, "Chuyen Phong ", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(InfoActivity.this,"Phong ban trung",Toast.LENGTH_LONG).show();
                            }


                    }
                });
                dialog.show();
            } else {
                Toast.makeText(InfoActivity.this, "Khong the sửa", Toast.LENGTH_LONG).show();
            }
        }
    });
    btnSua.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (info != null) {
                Intent intent=new Intent();
                intent.putExtra("username",username);
                intent.setClass(InfoActivity.this,AddActivity.class);
                intent.putExtra("state","1");

                startActivityForResult(intent,SUA);
            }else{
                Toast.makeText(InfoActivity.this,"Khong the sửa",Toast.LENGTH_LONG).show();
            }
        }
    });
    btnThem.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (info == null) {
                Intent intent=new Intent();
                intent.putExtra("username",username);
                intent.setClass(InfoActivity.this,AddActivity.class);
                intent.putExtra("state","0");
              startActivityForResult(intent,THEM);

            }else{
                Toast.makeText(InfoActivity.this,"Khong the them",Toast.LENGTH_LONG).show();
            }
        }
    });


}

@Override
protected void onStart() {
    super.onStart();
}


@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode==THEM){
        Toast.makeText(InfoActivity.this,"Them thanh cong",Toast.LENGTH_LONG).show();
          recreate();

    }else{
        if(requestCode==SUA){
            Toast.makeText(InfoActivity.this,"Sua thanh cong",Toast.LENGTH_LONG).show();
            recreate();
        }
    }
}
}