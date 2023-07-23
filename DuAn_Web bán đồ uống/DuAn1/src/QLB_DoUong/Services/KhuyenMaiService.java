/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.KhuyenMai;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author THUONG DINH
 */
public interface KhuyenMaiService {
    public ArrayList<KhuyenMai> getList();
    public ArrayList<KhuyenMai> loc(Date ngayTao);
    public ArrayList<KhuyenMai> loc1(Date ngayTao);
    public boolean addNew(KhuyenMai khuyenMai);
    public boolean update(KhuyenMai khuyenMai, String ma);
    public Boolean updateTinhTrang(KhuyenMai khuyenMai,Date ngayBatDau , Date ngayKetThuc);
    public boolean delete(String ma);
    public ArrayList<Date> ngayBatDau();
    public ArrayList<Date> ngayKetThuc();
    public ArrayList<KhuyenMai> timKiem(String ma);
    public Boolean check(String ma);
    public Boolean checkngay(Date ngaykt,Date ngaybd);
    
    
}
