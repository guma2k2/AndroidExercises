package com.example.myapplication;

public class SanPham {
    private String tenSanPham;
    private String giaSanPham;

    public SanPham(String tenSanPham, String giaSanPham) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
    }

    public SanPham() {
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }
}
