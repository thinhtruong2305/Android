package com.example.gridviewnangcao;

public class HinhAnhPandoru {
    private String ten;
    private int hinh;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public HinhAnhPandoru() {
    }

    public HinhAnhPandoru(String ten, int hinh) {
        this.ten = ten;
        this.hinh = hinh;
    }
}
