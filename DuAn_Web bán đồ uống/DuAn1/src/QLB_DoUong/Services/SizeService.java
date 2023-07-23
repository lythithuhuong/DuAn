/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.Size;
import java.util.List;

/**
 *
 * @author Thao Ngoc
 */
public interface SizeService {

    List<Size> getAll();

    String add(Size s);

    String update(Size s, String ma);

    String delete(String ma);

    List<Size> search(String ma);
    Boolean check(String ma);
}
