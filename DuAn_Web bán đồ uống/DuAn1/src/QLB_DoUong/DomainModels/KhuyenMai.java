/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class KhuyenMai {

    private String id;
    private String maKhuyenMai;
    private float PhamTramKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int trangThai;
    public KhuyenMai() {
    }

    public KhuyenMai(String id, String maKhuyenMai, float PhamTramKhuyenMai, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.id = id;
        this.maKhuyenMai = maKhuyenMai;
        this.PhamTramKhuyenMai = PhamTramKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public float getPhamTramKhuyenMai() {
        return PhamTramKhuyenMai;
    }

    public void setPhamTramKhuyenMai(float PhamTramKhuyenMai) {
        this.PhamTramKhuyenMai = PhamTramKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "id=" + id + ", maKhuyenMai=" + maKhuyenMai + ", PhamTramKhuyenMai=" + PhamTramKhuyenMai + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + '}';
    }

    public int tinhtrang(){
        if(ngayBatDau.before(genNgay()) && genNgay().before(ngayKetThuc)) {
            trangThai = 1;
        }else {
            trangThai = 0;
        }
     
        return trangThai;
    }
    public Date genNgay() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
}
