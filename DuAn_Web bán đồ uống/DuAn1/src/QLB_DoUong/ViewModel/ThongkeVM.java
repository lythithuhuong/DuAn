/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.ViewModel;

import java.util.Date;

/**
 *
 * @author 84987
 */
public class ThongkeVM {
    
    private String maNV,MaHD;
    private Date Ngayban,NgayThanhtoan;
   // private float tongtienhoadon;
    private float dongia;
    private int soluong;
    private float ptkhuyenmai;

    public ThongkeVM() {
    }

    public ThongkeVM(String maNV, String MaHD, Date Ngayban, Date NgayThanhtoan, float dongia, int soluong, float ptkhuyenmai) {
        this.maNV = maNV;
        this.MaHD = MaHD;
        this.Ngayban = Ngayban;
        this.NgayThanhtoan = NgayThanhtoan;
        this.dongia = dongia;
        this.soluong = soluong;
        this.ptkhuyenmai = ptkhuyenmai;
    }

    public float getPtkhuyenmai() {
        return ptkhuyenmai;
    }

    public void setPtkhuyenmai(float ptkhuyenmai) {
        this.ptkhuyenmai = ptkhuyenmai;
    }

    

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayThanhtoan() {
        return NgayThanhtoan;
    }

    public void setNgayThanhtoan(Date NgayThanhtoan) {
        this.NgayThanhtoan = NgayThanhtoan;
    }

   

   

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayban() {
        return Ngayban;
    }

    public void setNgayban(Date Ngayban) {
        this.Ngayban = Ngayban;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

  

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
