/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.ViewModel.DoUongVM;

import java.util.List;

/**
 *
 * @author THUONG DINH
 */
public interface DoUongService {

    public List<DoUongVM> getList();

    public boolean add(DoUongVM du);

    public boolean update(String ma, DoUongVM du);

    public boolean delete(String ma);

    public List<DoUongVM> search(String kind, String txt);

    public Boolean check(String ma);

    List<DoUongVM> getSearchTen(String ten);

    List<DoUongVM> getSearchMa(String ma);
}
