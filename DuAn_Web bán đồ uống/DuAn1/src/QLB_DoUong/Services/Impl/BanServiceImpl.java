/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.Ban;
import QLB_DoUong.Repositories.BanRepository;
import QLB_DoUong.Services.BanService;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BanServiceImpl implements BanService {

    private BanRepository banrp = new BanRepository();

    @Override
    public ArrayList<Ban> getlist() {
        return banrp.getFormDB();
    }

    @Override
    public Boolean Add(Ban ban) {
        return banrp.them(ban);
    }

    @Override
    public Boolean Delete(String ma) {
        return banrp.xoa(ma);
    }

    @Override
    public Boolean Update(String ma, Ban ban) {
        return banrp.sua(ma, ban);
    }

    @Override
    public ArrayList<Ban> timkiem(String ma) {
        return banrp.timkiem(ma);
    }

    @Override
    public Boolean check(String ma) {
        return banrp.check(ma);
    }

}
