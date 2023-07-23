/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.ViewModel.HoaDonView;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public interface HoaDonService {

    public ArrayList<HoaDonView> getList();

    public Boolean add(HoaDon hoaDon);

    public Boolean update(HoaDon hoaDon, String ma);

    public ArrayList<HoaDonView> timKiemTheoTrangThai(int tinhTrang);

    public ArrayList<HoaDonView> timKiemTheoTien(float tien1, float tien2);

    public ArrayList<HoaDonView> timKiemTheoNgay(Date ngayBD, Date ngayKT);

    public ArrayList<HoaDonView> getList_ByMaHD(String ma);

    public ArrayList<HoaDonView> timKiemTheoMa(String ma);
}
