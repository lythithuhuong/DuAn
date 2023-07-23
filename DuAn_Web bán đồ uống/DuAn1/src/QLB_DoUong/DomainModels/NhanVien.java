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
public class NhanVien {

    private String id;
    private String maNhanVien;
    private String tenNhanVien;
    private String email;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private int trangThai;
    private String matKhau;
    private int chucVu;

    public NhanVien() {
    }

    public NhanVien(String id, String maNhanVien, String tenNhanVien, String email, int gioiTinh, Date ngaySinh, String diaChi, String sdt, int trangThai, String matKhau, int chucVu) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", email=" + email + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", trangThai=" + trangThai + ", matKhau=" + matKhau + ", chucVu=" + chucVu + '}';
    }
    
   

    public Object[] toData() {
        return new Object[]{id, maNhanVien, tenNhanVien, email, gioiTinh == 1 ? "Nam" : "Nữ", ngaySinh, diaChi, sdt, trangThai == 1 ? "Đang làm việc" : "Nghỉ việc", matKhau};
    }
}
