/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.DoUong_HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface DoUong_HoaDonService {
    public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma);
    public ArrayList<DoUong_HoaDon> getListDoUongHoaDon();
    public Boolean add(DoUong_HoaDon doUong_HoaDon);
    public Boolean update(DoUong_HoaDon doUong_HoaDon,String ma);
    public Boolean delete(String ma);
    public Boolean deleteTable(String ma);
}
