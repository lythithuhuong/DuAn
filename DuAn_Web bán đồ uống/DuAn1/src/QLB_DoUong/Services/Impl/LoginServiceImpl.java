/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.Repositories.LoginRepository;
import QLB_DoUong.Services.LoginService;
import java.util.ArrayList;

/**
 *
 * @author 84987
 */
public class LoginServiceImpl implements LoginService {
     private LoginRepository loginRepository = new LoginRepository();

    @Override
    public ArrayList<NhanVien> getList(String sdt, String pw) {
        return loginRepository.getFormDb(sdt, pw);
    }

    @Override
    public boolean check(String sdt, String pw) {
        return loginRepository.check(sdt,pw);
    }
}
