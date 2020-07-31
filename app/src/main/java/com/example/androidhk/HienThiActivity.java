package com.example.androidhk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidhk.adapter.AdaterTest;

import com.example.androidhk.adapter.AdaterTest2;
import com.example.androidhk.database.Database;
import com.example.androidhk.model.Info;
import com.example.androidhk.model.User;

import java.util.ArrayList;

public class HienThiActivity extends AppCompatActivity {
    Database database;
    ListView nv;
    TextView cot1,cot2,cot3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi2);

        database = new Database(this);
        cot1 = findViewById(R.id.cot1);
        cot2 = findViewById(R.id.cot2);
        nv = findViewById(R.id.listnv);
        cot3=findViewById(R.id.cot3);
        if (getIntent().getStringExtra("state2").equals("0")) {
            ArrayList<Info> listInfo = database.getListInfoCNTT2();
            AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
            cot1.setText("Mã         ");
            cot2.setText("Tên");
            nv.setAdapter(adaterTest);
        } else {
            if (getIntent().getStringExtra("state2").equals("1")) {
                ArrayList<Info> listInfo = database.getDT();
                AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
                cot1.setText("số lượng       ");
                cot2.setText(" Tuổi");
                nv.setAdapter(adaterTest);
            } else {
                if (getIntent().getStringExtra("state2").equals("3")) {
                    ArrayList<Info> listInfo = database.getPB();
                    AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);

                    cot1.setText("số lượng       ");
                    cot2.setText(" Phòng ban");
                    nv.setAdapter(adaterTest);
                    nv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent();

                        }
                    });
                } else {
                    if (getIntent().getStringExtra("state2").equals("4")) {
                        ArrayList<Info> listInfo = database.getGT();
                        AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
                        cot1.setText("số lượng       ");
                        cot2.setText(" Gioi Tinh");
                        nv.setAdapter(adaterTest);
                    }else {
                        if (getIntent().getStringExtra("state2").equals("5")) {
                          final ArrayList<User> listInfo = database.getAll();
                            AdaterTest2 adaterTest = new AdaterTest2(listInfo, this, R.layout.hienthi);
                            cot1.setText("STT      ");
                            cot2.setText(" Username        ");

                            nv.setAdapter(adaterTest);
                            nv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent=new Intent(HienThiActivity.this,InfoActivity.class);
                                    intent.putExtra("username",listInfo.get(position).getUsername());
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                }
            }

        }
    }
}