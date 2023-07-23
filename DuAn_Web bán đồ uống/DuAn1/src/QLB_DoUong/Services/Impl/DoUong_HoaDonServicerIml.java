/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.Repositories.DoUong_HoaDonRepository;
import QLB_DoUong.Services.DoUong_HoaDonService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DoUong_HoaDonServicerIml implements DoUong_HoaDonService{
private DoUong_HoaDonRepository doUong_HoaDonRepository = new DoUong_HoaDonRepository();
    

 

    @Override
    public Boolean delete(String ma) {
        return doUong_HoaDonRepository.delete(ma);
    }

    @Override
    public Boolean add(DoUong_HoaDon doUong_HoaDon) {
        return doUong_HoaDonRepository.add(doUong_HoaDon);
    }

    @Override
    public Boolean update(DoUong_HoaDon doUong_HoaDon, String ma) {
        return doUong_HoaDonRepository.update(doUong_HoaDon, ma);
    }

    @Override
    public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma) {
        return doUong_HoaDonRepository.timKiemDoUongHoaDon(ma);
    }

    @Override
    public ArrayList<DoUong_HoaDon> getListDoUongHoaDon() {
        return doUong_HoaDonRepository.getListDoUongHoaDon();
    }

    @Override
    public Boolean deleteTable(String ma) {
        return doUong_HoaDonRepository.deleteTable(ma);
    }
    
}
