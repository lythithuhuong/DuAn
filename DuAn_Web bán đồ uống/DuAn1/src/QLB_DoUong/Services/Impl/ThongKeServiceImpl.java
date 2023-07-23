/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.Repositories.ThongKeRepository;
import java.util.List;
import QLB_DoUong.Services.ThongKeService;
import QLB_DoUong.ViewModel.ThongkeVM;
import java.util.ArrayList;

/**
 *
 * @author OSC
 */
public class ThongKeServiceImpl implements ThongKeService{

    private ThongKeRepository doUongRepository = new ThongKeRepository();
    private ThongKeRepository TKRepository = new ThongKeRepository();

    @Override
    public ArrayList<ThongkeVM> getList() {
        return TKRepository.getformDB();
    }

    @Override
    public ArrayList<Double> Sumhoadon() {
        return TKRepository.sumHD();
    }

    @Override
    public ArrayList<ThongkeVM> timKiemngay(int ngay, int thang, int nam) {
        return TKRepository.findngay(nam, thang, ngay);
    }

    @Override
    public ArrayList<ThongkeVM> timKiemthang(int thang, int nam) {
        return TKRepository.findthang(nam, thang);
    }

    @Override
    public ArrayList<ThongkeVM> timkiemnam(int nam) {
        return TKRepository.findnam(nam);
    }

    @Override
    public ArrayList<Double> Sumhoadonnam(int nam) {
        return TKRepository.sumHDnam(nam);
    }

    @Override
    public ArrayList<Double> Sumhoadonthang(int nam, int thang) {
        return TKRepository.sumHDthang(nam, thang);
    }

    @Override
    public ArrayList<Integer> Sumspnam(int nam) {
        return TKRepository.sumspnam(nam);
    }

    @Override
    public ArrayList<Integer> Sumspthang(int nam, int thang) {
        return TKRepository.sumspthang(nam, thang);
    }

    @Override
    public ArrayList<DoUong_HoaDon> getListHoaDonChiTiet() {
return TKRepository.getListHoaDonChiTiet();}

    @Override
    public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma) {
return TKRepository.timKiemDoUongHoaDon(ma);}

    @Override
    public ArrayList<ThongkeVM> timKiemtngay1(String ngaybd, String ngaykt) {
return TKRepository.timkiemngay1(ngaybd, ngaykt);}

    @Override
    public ArrayList<Double> Sumhoadon(String ngaybd, String ngaykt) {
return TKRepository.sumHD1(ngaybd, ngaykt);}

    @Override
    public ArrayList<Integer> Sumspngay(String ngaybd, String ngaykt) {
return TKRepository.sumspHD1(ngaybd, ngaykt);}
}
