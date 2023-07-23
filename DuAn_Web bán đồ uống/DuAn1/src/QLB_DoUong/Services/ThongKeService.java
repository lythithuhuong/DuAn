/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.ViewModel.ThongkeVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSC
 */
public interface ThongKeService {

    public ArrayList<ThongkeVM> getList();

    public ArrayList<ThongkeVM> timKiemngay(int ngay, int thang, int nam);

    public ArrayList<ThongkeVM> timKiemthang(int thang, int nam);

    public ArrayList<Double> Sumhoadon();

    public ArrayList<Double> Sumhoadonnam(int nam);

    public ArrayList<Double> Sumhoadonthang(int nam, int thang);

    public ArrayList<Integer> Sumspnam(int nam);

    public ArrayList<Integer> Sumspngay(String ngaybd, String ngaykt);

    public ArrayList<Integer> Sumspthang(int nam, int thang);

    public ArrayList<ThongkeVM> timkiemnam(int nam);

    public ArrayList<DoUong_HoaDon> getListHoaDonChiTiet();

    public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma);

    public ArrayList<ThongkeVM> timKiemtngay1(String ngaybd, String ngaykt);

    public ArrayList<Double> Sumhoadon(String ngaybd, String ngaykt);

}
