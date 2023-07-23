/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.Repositories.DanhmucRepository;
import QLB_DoUong.Services.DanhmucSevice;
import java.util.ArrayList;

/**
 *
 * @author 84987
 */
public class DanhmucImpl implements DanhmucSevice {

    private DanhmucRepository danhmuc = new DanhmucRepository();

    @Override
    public ArrayList<DanhMuc> getlist() {
        return danhmuc.getFormDB();
    }

    @Override
    public Boolean Add(DanhMuc Danhmuc) {
        return danhmuc.them(Danhmuc);
    }

    @Override
    public Boolean Delete(String ma) {
        return danhmuc.xoa(ma);
    }

    @Override
    public Boolean Update(String ma, DanhMuc Danhmuc) {
        return danhmuc.sua(ma, Danhmuc);
    }

    @Override
    public ArrayList<DanhMuc> timkiem(String ma) {
return danhmuc.timkiem(ma);}

    @Override
    public Boolean check(String ma) {
return danhmuc.check(ma);}

}
