/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author 84987
 */
public interface DanhmucSevice {

    public ArrayList<DanhMuc> getlist();

    public Boolean Add(DanhMuc Danhmuc);

    public Boolean Delete(String ma);

    public Boolean Update(String ma, DanhMuc Danhmuc);

    public ArrayList<DanhMuc> timkiem(String ma);

    public Boolean check(String ma);


}
