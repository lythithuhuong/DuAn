/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author 0978078602
 */
public interface NhanVienService {

    List<NhanVien> getAll();

    String add(NhanVien nhanVien);

    String update(NhanVien nhanVien, String maNV);

    String delete(String maNV);

    List<NhanVien> search(String maNV);

    List<NhanVien> searchDiaChi(String diaChi);

    List<NhanVien> searchGioiTinh(String gioiTinh);
    
    String checkTrung(String maNV);

}
