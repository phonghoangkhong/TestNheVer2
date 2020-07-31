package com.example.androidhk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidhk.model.User;

import com.example.androidhk.model.Info;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Database extends SQLiteOpenHelper {
 private static String DB_NAME="qlnv";
 private String User_table="User";
 private String ID="id";
 private String Username="username";
 private  String Password="password";
 Context context;
    public Database(Context context) {



           super(context,DB_NAME,null,1);
         this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate1=String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY,%s TEXT)",User_table,Username,Password);
        String queryCreate2="CREATE TABLE info(id INTEGER PRIMARY KEY AUTOINCREMENT,ten TEXT, tuoi INTEGER, phongban TEXT," +
                "username TEXT ,trangthai TEXT,quequan TEXT,hocvan TEXT, quaTrinhDaoTao TEXT, quaTrinhLamviec TEXT, " +
                "date Date ,ngaysinh text,gioitinh TEXT,FOREIGN KEY(username) references User(username))";
        String inserQuery="INSERT INTO User(username,password) values('phongkh','phongkh123')";
        String inserQuery2="INSERT INTO User(username,password) values('admin','phongkh123')";

        db.execSQL(queryCreate1);
        db.execSQL(inserQuery);
        db.execSQL(queryCreate2);
        db.execSQL(inserQuery2);

    }
    public void  add(){
              User user=new User("ph","111111");
            Info info=new Info("phongkh","Nam","15-02-1999","21","CNTT","ph","Đang làm việc","HP","Đại hoc","","","2016-10-15");
            User user2=new User("ph2","111111");
            Info info2=new Info("phongkh2","Nữ","15-02-2000","20","Mar","ph2","Đang làm việc","HP","Đại hoc","","","2017-10-15");
            User user3=new User("ph3","111111");
            Info info3=new Info("phongkh3","Nam","15-02-1999","21","Mar","ph","Đang làm việc","HP","Đại hoc","","","2018-10-15");
            User user4=new User("ph4","111111");
            Info info4=new Info("phongkh4","Nữ","15-02-1999","21","Sale","ph","Đang làm việc","HP","Đại hoc","","","2019-10-15");
            User user5=new User("ph5","111111");
            Info info5=new Info("phongkh5","Nam","15-02-1999","21","CNTT","ph","Đang làm việc","HP","Đại hoc","","","2016-10-15");
       addUser(user);
        addUser(user2);    addUser(user3);    addUser(user4);    addUser(user5);
    addInfo(info);
        addInfo(info2);   addInfo(info3);   addInfo(info4);   addInfo(info5);
    }
    public void addUser(User user ){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Username,user.getUsername());
        contentValues.put(Password,user.getPassword());
        database.insert(User_table,null,contentValues);
        database.close();

    }
    public User findUserByName(String username ){
        SQLiteDatabase database=getReadableDatabase();
        User user=new User();
        String [] cot={Username,Password};
        String clause=Username + "=?";
        String args[]=new String[]{username};
        Cursor cursor=database.query(User_table,cot,clause,args,null,null,null);
        if(cursor.moveToFirst()){
                user.setUsername(cursor.getString(0));
                user.setPassword(cursor.getString(1));
        }
        database.close();
        return user;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String drop_user_table = String.format("drop table if exist %s", User_table);
        onCreate(db);
        db.close();
    }

    public void addInfo(Info info){
         SQLiteDatabase database=getWritableDatabase();
         ContentValues contentValues=new ContentValues();
         contentValues.put("ten",info.getTen());
         contentValues.put("tuoi",info.getTuoi());
         contentValues.put("gioitinh",info.getGioiTinh());
         contentValues.put("phongban",info.getPhongban());
         contentValues.put("username",info.getUsername());
         contentValues.put("trangthai",info.getTrangthai());
         contentValues.put("quequan",info.getQuequan());
         contentValues.put("hocvan",info.getHocvan());
         contentValues.put("quaTrinhDaoTao",info.getQuaTrinhDaoTao());
         contentValues.put("quaTrinhLamViec",info.getQuaTrinhLamViec());
         contentValues.put("date",info.getDate().toString());
         contentValues.put("ngaysinh",info.getNgaysinh());
         database.insert("info",null,contentValues);
         database.close();
    }

    public Info getInfo(String username) throws ParseException {
        SQLiteDatabase database=getReadableDatabase();
        String [] cot={"id","ten","tuoi","phongban","trangThai","quequan","hocvan" ,"quaTrinhDaoTao" ,"quaTrinhLamviec" ,
                "date","username","ngaysinh","gioitinh"};
         String clause="username= ?";
         String args[]=new String[]{username};
         Cursor cursor=database.query("info",cot,clause,args,null,null,null);
         Info info=new Info();
         if(cursor.moveToFirst()){
             info.setId(cursor.getInt(0));
             info.setTen(cursor.getString(1));
             info.setTuoi(cursor.getString(2));
             info.setPhongban(cursor.getString(3));
             info.setTrangthai(cursor.getString(4));
             info.setQuequan(cursor.getString(5));
             info.setHocvan(cursor.getString(6));
             info.setQuaTrinhDaoTao(cursor.getString(7));
             info.setQuaTrinhLamViec(cursor.getString(8));
             String date=cursor.getString(9);

           info.setDate(date);
             info.setUsername(cursor.getString(10));
             info.setNgaysinh(cursor.getString(11));
             info.setGioiTinh(cursor.getString(12));
             System.out.println(info);
             return info;
         }else{
             return null;

         }

    }
    public void updateInfo(Info info){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ten",info.getTen());
        contentValues.put("gioitinh",info.getGioiTinh());
        contentValues.put("tuoi",info.getTuoi());
        contentValues.put("phongban",info.getPhongban());
        contentValues.put("username",info.getUsername());
        contentValues.put("trangthai",info.getTrangthai());
        contentValues.put("quequan",info.getQuequan());
        contentValues.put("hocvan",info.getHocvan());
        contentValues.put("quaTrinhDaoTao",info.getQuaTrinhDaoTao());
        contentValues.put("quaTrinhLamViec",info.getQuaTrinhLamViec());
        contentValues.put("ngaysinh",info.getNgaysinh());
        String clause="username = ?";
        String []args=new String[]{info.getUsername()};
      int a=  database.update("info",contentValues,clause,args);
        System.out.println(a);
        database.close();
    }
    public ArrayList<Info> getListInfoCNTT(){
        ArrayList<Info> listInfo=new ArrayList<>();
       String query="SELECT id,ten from info where phongban=?";
       SQLiteDatabase sqLiteDatabase=getReadableDatabase();

         Cursor cursor=  sqLiteDatabase.rawQuery(query,new String[]{"CNTT"});
         if(cursor.moveToFirst()) {
             do {
                 Info info = new Info();
                 info.setId(cursor.getInt(0));
                 info.setTen(cursor.getString(1));
                 listInfo.add(info);

             } while (cursor.moveToNext());
         }
return listInfo;
    }
    public ArrayList<User> getAll(){
        ArrayList<User> list=new ArrayList<>();
        String query="SELECT username,password FROM user";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=  sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst()) {
            do {
                User user=new User();
                user.setUsername(cursor.getString(0));
                list.add(user);

            } while (cursor.moveToNext());
        }
        return list;
    }


    public ArrayList<Info> getListInfoCNTT2(){
        ArrayList<Info> listInfo=new ArrayList<>();
        String query="SELECT id,ten from info where phongban=? and  cast((julianday() - julianday(date)) as integer) >365*3";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=  sqLiteDatabase.rawQuery(query,new String[]{"CNTT"});
        if(cursor.moveToFirst()) {
            do {
                Info info = new Info();
                info.setId(cursor.getInt(0));
                info.setTen(cursor.getString(1));
                listInfo.add(info);

            } while (cursor.moveToNext());
        }
        return listInfo;
    }
    public ArrayList<Info> getGT(){
        ArrayList<Info> listInfo=new ArrayList<>();
        String query="SELECT count(*) , gioitinh from info group by gioitinh ";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=  sqLiteDatabase.rawQuery(query,new String[]{});
        if(cursor.moveToFirst()) {
            do {
                Info info = new Info();
                info.setId(cursor.getInt(0));
                info.setTen(cursor.getString(1));
                listInfo.add(info);

            } while (cursor.moveToNext());
        }
        return listInfo;
    }

    public ArrayList<Info> getDT(){
        ArrayList<Info> listInfo=new ArrayList<>();
        String query="SELECT count(*),tuoi from info group by tuoi ";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=  sqLiteDatabase.rawQuery(query,new String[]{});
        if(cursor.moveToFirst()) {
            do {
                Info info = new Info();
                info.setId(cursor.getInt(0));
                info.setTen(cursor.getString(1));
                listInfo.add(info);

            } while (cursor.moveToNext());
        }
        return listInfo;
    }

    public ArrayList<Info> getPB(){
        ArrayList<Info> listInfo=new ArrayList<>();
        String query="SELECT count(*), phongban from info group by phongban";
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=  sqLiteDatabase.rawQuery(query,new String[]{});
        if(cursor.moveToFirst()) {
            do {
                Info info = new Info();
                info.setId(cursor.getInt(0));
                info.setTen(cursor.getString(1));
                listInfo.add(info);

            } while (cursor.moveToNext());
        }
        return listInfo;
    }

}

