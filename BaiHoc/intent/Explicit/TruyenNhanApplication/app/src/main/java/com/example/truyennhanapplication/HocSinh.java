package com.example.truyennhanapplication;

import java.io.Serializable;

public class HocSinh implements Serializable {
    private String ten;
    private int ngaySinh;

    public HocSinh(String ten, int ngaySinh) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "HocSinh{" + "ten='" + ten + '\'' + ", ngaySinh=" + ngaySinh + '}';
    }
}
