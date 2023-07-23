/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Repositories.BanHangRepository;
import QLB_DoUong.Services.BanHangService;
import QLB_DoUong.ViewModel.DoUongVM;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BanHangServiceImpl implements  BanHangService{
private BanHangRepository banHangRepository = new BanHangRepository();

    

    @Override
    public ArrayList<HoaDon> getListHoaDon() {
        return banHangRepository.getListHoaDon();
    }

    @Override
    public ArrayList<DoUongVM> getList() {
        return banHangRepository.getList();
    }

    @Override
    public String getByIDMaHD(String ma) {
        return banHangRepository.getByIDMaHD(ma);
    }

    @Override
    public String getByIDMaDU(String ma) {
        return banHangRepository.getByIDMaDU(ma);
    }

    @Override
    public ArrayList<DoUong_HoaDon> getListHoaDonChiTiet() {
        return banHangRepository.getListHoaDonChiTiet();
    }

    @Override
    public Boolean check(String ten,String ma) {
        return banHangRepository.check(ten,ma);
    }

    @Override
    public ArrayList<DoUongVM> timKiemDoUong(String ten) {
        return banHangRepository.timKiemDoUong(ten);
    }

    @Override
    public String idKhuyenMai() {
        return banHangRepository.idKhuyenMai();
    }

    @Override
    public String idNhanVien(String ma) {
        return banHangRepository.idNhanVien(ma);
    }

    @Override
    public String maNhanVien(String ma) {
        return banHangRepository.maNhanVien(ma);
    }

    @Override
    public String ngayTao(Date ngayTao) {
        return banHangRepository.ngayTao(ngayTao);
    }

 
    
}
