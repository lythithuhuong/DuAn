/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Repositories.HoaDonRepository;
import QLB_DoUong.Services.HoaDonService;
import QLB_DoUong.ViewModel.HoaDonView;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public ArrayList<HoaDonView> getList() {
        return hoaDonRepository.getList();
    }

    @Override
    public Boolean add(HoaDon hoaDon) {
        return hoaDonRepository.add(hoaDon);
    }

    @Override
    public Boolean update(HoaDon hoaDon, String ma) {
        return hoaDonRepository.update(hoaDon, ma);
    }

    @Override
    public ArrayList<HoaDonView> getList_ByMaHD(String ma) {
        return hoaDonRepository.getList_ByMaHD(ma);
    }

    @Override
    public ArrayList<HoaDonView> timKiemTheoTrangThai(int tinhTrang) {
        return hoaDonRepository.timKiemTheoTrangThai(tinhTrang);
    }

    @Override
    public ArrayList<HoaDonView> timKiemTheoTien(float tien1, float tien2) {
        return hoaDonRepository.timKiemTheoTien(tien1, tien2);
    }

    @Override
    public ArrayList<HoaDonView> timKiemTheoNgay(Date ngayBD, Date ngayKT) {
        return hoaDonRepository.timKiemTheoNgay(ngayBD, ngayKT);
    }

    @Override
    public ArrayList<HoaDonView> timKiemTheoMa(String ma) {
        return hoaDonRepository.timKiemTheoMa(ma);
    }

   

}
