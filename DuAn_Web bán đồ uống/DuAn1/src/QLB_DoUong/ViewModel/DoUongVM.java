/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.ViewModel;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.Size;
import java.math.BigDecimal;

/**
 *
 * @author OSC
 */
public class DoUongVM {
    private String id;
    private String maDoUong;
    private String tenDoUong;
    private BigDecimal donGia;
    private int trangThai;
    private DanhMuc danhMuc;
    private Size size;

    public DoUongVM() {
    }

    public DoUongVM(String id, String maDoUong, String tenDoUong, BigDecimal donGia, int trangThai, DanhMuc danhMuc, Size size) {
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

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
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
}
