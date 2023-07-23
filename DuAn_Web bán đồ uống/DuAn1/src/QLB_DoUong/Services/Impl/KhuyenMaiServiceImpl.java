/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.Repositories.KhuyenMaiRepository;
import QLB_DoUong.Services.KhuyenMaiService;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author THUONG DINH
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    public KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMai> getList() {
        return khuyenMaiRepository.getFormDB();
    }

    @Override
    public boolean addNew(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.addNew(khuyenMai);
    }

    @Override
    public boolean update(KhuyenMai khuyenMai, String ma) {
        return khuyenMaiRepository.update(khuyenMai, ma);
    }

    @Override
    public boolean delete(String ma) {
        return khuyenMaiRepository.delete(ma);
    }

    @Override
    public Boolean updateTinhTrang(KhuyenMai khuyenMai, Date ngayBatDau, Date ngayKetThuc) {
        return khuyenMaiRepository.updateTinhTrang(khuyenMai, ngayBatDau, ngayKetThuc);
    }

    @Override
    public ArrayList<Date> ngayBatDau() {
        return khuyenMaiRepository.ngayBatDau();
    }

    @Override
    public ArrayList<Date> ngayKetThuc() {
        return khuyenMaiRepository.ngayKetThuc();
    }

    @Override
    public ArrayList<KhuyenMai> loc(Date ngayTao) {
        return khuyenMaiRepository.loc(ngayTao);
    }

    @Override
    public ArrayList<KhuyenMai> loc1(Date ngayTao) {
        return khuyenMaiRepository.loc1(ngayTao);
    }

    @Override
    public Boolean check(String ma) {
        return khuyenMaiRepository.check(ma);
    }

    @Override
    public Boolean checkngay(Date ngaykt, Date ngaybd) {
        return khuyenMaiRepository.check(ngaykt, ngaybd);
    }

    @Override
    public ArrayList<KhuyenMai> timKiem(String ma) {
        return khuyenMaiRepository.timkiem(ma);
    }

}
