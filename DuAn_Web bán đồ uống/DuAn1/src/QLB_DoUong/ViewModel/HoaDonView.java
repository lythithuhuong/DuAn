/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.ViewModel;

import java.sql.Date;

/**
 *
 * @author Thao Ngoc
 */
public class HoaDonView {

    private String maHD;
    private Date ngayTao;
    private Date ngayTT;
    private int tinhTrang;
    private String maNV;
    private float giaTri;
    private float tongTien;

    public HoaDonView(String maHD, Date ngayTao, Date ngayTT, int tinhTrang, String maNV, float giaTri, float tongTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayTT = ngayTT;
        this.tinhTrang = tinhTrang;
        this.maNV = maNV;
        this.giaTri = giaTri;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(Date ngayTT) {
        this.ngayTT = ngayTT;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    private String maDoUong;
    private String tenDoUong;
    private String tenDM;
    private String tenSize;
    private float donGia;
    private int soLuong;

    public HoaDonView() {
    }

    public HoaDonView(String maDoUong, String tenDoUong, String tenDM, String tenSize, float donGia, int soLuong) {
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.tenDM = tenDM;
        this.tenSize = tenSize;
        this.donGia = donGia;
        this.soLuong = soLuong;
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

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "HoaDonView{" + "maHD=" + maHD + ", ngayTao=" + ngayTao + ", ngayTT=" + ngayTT + ", tinhTrang=" + tinhTrang + ", maNV=" + maNV + ", giaTri=" + giaTri + ", tongTien=" + tongTien + ", maDoUong=" + maDoUong + ", tenDoUong=" + tenDoUong + ", tenDM=" + tenDM + ", tenSize=" + tenSize + ", donGia=" + donGia + ", soLuong=" + soLuong + '}';
    }

}
