/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Repositories.DoUongRepository;
import QLB_DoUong.Services.DoUongService;
import QLB_DoUong.ViewModel.DoUongVM;
import java.util.List;

/**
 *
 * @author THUONG DINH
 */
public class DoUongServiceImpl implements DoUongService {

    private DoUongRepository doUongRepository = new DoUongRepository();

    @Override
    public List<DoUongVM> getList() {
        return doUongRepository.getList();
    }

    @Override
    public boolean add(DoUongVM du) {
        return doUongRepository.add(du);
    }

    @Override
    public boolean update(String ma, DoUongVM du) {
        return doUongRepository.update(ma, du);
    }

    @Override
    public boolean delete(String ma) {
        return doUongRepository.delete(ma);
    }

    @Override
    public List<DoUongVM> search(String kind, String txt) {
        return doUongRepository.search(kind, txt);
    }

    @Override
    public Boolean check(String ma) {
        return doUongRepository.check(ma);
    }

    @Override
    public List<DoUongVM> getSearchTen(String ten) {
        return doUongRepository.getSearchTen(ten);
    }

    @Override
    public List<DoUongVM> getSearchMa(String ma) {
        return doUongRepository.getSearchMa(ma);
    }
}
