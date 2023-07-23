/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.Repositories.NhanVienRepository;
import QLB_DoUong.Services.NhanVienService;
import java.util.List;

/**
 *
 * @author 0978078602
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public String add(NhanVien nhanVien) {
        boolean add = nhanVienRepository.add(nhanVien);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(NhanVien nhanVien, String maNV) {
        boolean update = nhanVienRepository.update(nhanVien, maNV);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String maNV) {
        boolean delete = nhanVienRepository.delete(maNV);
        if (delete) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<NhanVien> search(String maNV) {
        return nhanVienRepository.search(maNV);
    }

    @Override
    public List<NhanVien> searchDiaChi(String diaChi) {
        return nhanVienRepository.searchDiaChi(diaChi);
    }

    @Override
    public List<NhanVien> searchGioiTinh(String gioiTinh) {
        return nhanVienRepository.searchGioiTinh(gioiTinh);
    }

    @Override
    public String checkTrung(String maNV) {
        return nhanVienRepository.checkTrung(maNV);
    }

}
