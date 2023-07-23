/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class DoUong_HoaDon {

    private HoaDon hoaDon;
    private DoUong doUong;
    private int soLuong;
    private float donGia;
    private float thanhTien;

    public DoUong_HoaDon() {
    }

    public DoUong_HoaDon(HoaDon hoaDon, DoUong doUong, int soLuong, float donGia) {
        this.hoaDon = hoaDon;
        this.doUong = doUong;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DoUong getDoUong() {
        return doUong;
    }

    public void setDoUong(DoUong doUong) {
        this.doUong = doUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "DoUong_HoaDon{" + "hoaDon=" + hoaDon.getId() + ", doUong=" + doUong.getId() + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public float thanhTien() {
        return soLuong * donGia;
    }

}
