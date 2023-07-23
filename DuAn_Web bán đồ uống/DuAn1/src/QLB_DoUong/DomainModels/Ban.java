/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

/**
 *
 * @author DELL
 */
public class Ban {

    private String id;
    private String maBan;
    private String tenBan;
    private int trangthai;

    public Ban() {
    }

    public Ban(String id, String maBan, String tenBan, int trangthai) {
        this.id = id;
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", maBan=" + maBan + ", tenBan=" + tenBan + '}';
    }

}
