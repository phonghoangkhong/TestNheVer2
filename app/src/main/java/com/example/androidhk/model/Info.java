package com.example.androidhk.model;

import java.util.Date;

public class Info {
    int id;
    String ten;
    String gioiTinh;
    String tuoi;
    String phongban;
    String username;
    String trangthai;
    String quequan;
    String hocvan;
    String quaTrinhDaoTao;
    String quaTrinhLamViec;
   String  date;
    String ngaysinh;


    public Info() {
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Info(String ten, String gioiTinh, String ngaysinh, String tuoi, String phongban, String username, String trangthai, String quequan, String hocvan, String quaTrinhDaoTao, String quaTrinhLamViec, String date) {
        this.gioiTinh=gioiTinh;

        this.ten = ten;
        this.ngaysinh=ngaysinh;
        this.tuoi = tuoi;
        this.phongban = phongban;
        this.username = username;
        this.trangthai = trangthai;
        this.quequan = quequan;
        this.hocvan = hocvan;
        this.quaTrinhDaoTao = quaTrinhDaoTao;
        this.quaTrinhLamViec = quaTrinhLamViec;
        this.date = date;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getHocvan() {
        return hocvan;
    }

    public void setHocvan(String hocvan) {
        this.hocvan = hocvan;
    }

    public String getQuaTrinhDaoTao() {
        return quaTrinhDaoTao;
    }

    public void setQuaTrinhDaoTao(String quaTrinhDaoTao) {
        this.quaTrinhDaoTao = quaTrinhDaoTao;
    }

    public String getQuaTrinhLamViec() {
        return quaTrinhLamViec;
    }

    public void setQuaTrinhLamViec(String quaTrinhLamViec) {
        this.quaTrinhLamViec = quaTrinhLamViec;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }



    public String getTrangthai() {
        return trangthai;
    }
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", tuoi='" + tuoi + '\'' +
                ", phongban='" + phongban + '\'' +
                ", username='" + username + '\'' +
                ", trangthai='" + trangthai + '\'' +
                ", quequan='" + quequan + '\'' +
                ", hocvan='" + hocvan + '\'' +
                ", quaTrinhDaoTao='" + quaTrinhDaoTao + '\'' +
                ", quaTrinhLamViec='" + quaTrinhLamViec + '\'' +
                ", date='" + date + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                '}';
    }
}
