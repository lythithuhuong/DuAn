/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author THUONG DINH
 */
public class DoUong {

    private String id;
    private String maDoUong;
    private String tenDoUong;
    private BigDecimal donGia;
    private int trangThai;
    private String idDanhMuc;
    private String idSize;

    public DoUong(String id, String maDoUong, String tenDoUong, BigDecimal donGia, int trangThai, String idDanhMuc, String idSize) {
        this.id = id;
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.idDanhMuc = idDanhMuc;
        this.idSize = idSize;
    }

    public DoUong() {
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

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

}
