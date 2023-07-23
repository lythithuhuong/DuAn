/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Repositories.SizeRepository;
import QLB_DoUong.Services.SizeService;
import java.util.List;

/**
 *
 * @author Thao Ngoc
 */
public class SizeServiceImpl implements SizeService {

    private SizeRepository sr = new SizeRepository();

    @Override
    public List<Size> getAll() {
        return sr.getAll();
    }

    @Override
    public String add(Size s) {
        if (sr.add(s)) {
            return "Thêm thành công";
        } else {
            return "Fail";
        }
    }

    @Override
    public String update(Size s, String ma) {
        if (sr.update(s, ma)) {
            return "Sửa thành công";
        } else {
            return "Fail";
        }
    }

    @Override
    public String delete(String ma) {
        if (sr.delete(ma)) {
            return "Xóa thành công";
        } else {
            return "Fail";
        }
    }

    @Override
    public List<Size> search(String ma) {
        return sr.getById(ma);
    }

    @Override
    public Boolean check(String ma) {
        return sr.check(ma);
    }

}
