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
public class HoaDon {

    private String id;
    private String maHoaDon;
    private String tenHoaDon;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tinhTrang;
    private NhanVien nhanVien;
    private Ban ban;
    private KhuyenMai khuyenMai;

    public HoaDon() {
    }

    public HoaDon(String id, String maHoaDon, String tenHoaDon, Date ngayTao, Date ngayThanhToan, int tinhTrang, NhanVien nhanVien, Ban ban, KhuyenMai khuyenMai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.tenHoaDon = tenHoaDon;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.nhanVien = nhanVien;
        this.ban = ban;
        this.khuyenMai = khuyenMai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", maHoaDon=" + maHoaDon + ", tenHoaDon=" + tenHoaDon + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + ", nhanVien=" + nhanVien + ", ban=" + ban + ", khuyenMai=" + khuyenMai + '}';
    }

}
