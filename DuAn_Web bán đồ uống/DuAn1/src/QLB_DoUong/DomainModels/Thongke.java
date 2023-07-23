/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

/**
 *
 * @author DELL
 */
public class Thongke {

    private String id;
    private String maDoUong;
    private String tenDoUong;
    private float donGia;
    private int trangThai;
    private DanhMuc danhMuc;
    private Size size;

    public Thongke() {
    }

    public Thongke(String id, String maDoUong, String tenDoUong, float donGia, int trangThai, DanhMuc danhMuc, Size size) {
        this.id = id;
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.danhMuc = danhMuc;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DoUong{" + "id=" + id + ", maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", donGia=" + donGia + ", trangThai=" + trangThai + ", danhMuc=" + danhMuc + ", size=" + size + '}';
    }

}
