/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.Ban;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface BanService {

    public ArrayList<Ban> getlist();

    public Boolean Add(Ban ban);

    public Boolean Delete(String ma);

    public Boolean Update(String ma, Ban ban);

    public ArrayList<Ban> timkiem(String ma);

    public Boolean check(String ma);


}
