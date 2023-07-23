/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 84987
 */
public class DanhmucRepository {

    private DBConnection connection;

    public ArrayList<DanhMuc> getFormDB() {
        ArrayList<DanhMuc> listdm = new ArrayList<>();
        String sql = "select DanhMuc.Id,DanhMuc.MaDanhMuc,DanhMuc.TenDanhMuc from DanhMuc";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(1));
                dm.setMaDanhMuc(rs.getString(2));
                dm.setTenDanhMuc(rs.getString(3));

                listdm.add(dm);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listdm;
    }

    public Boolean them(DanhMuc Danhmuc) {
        String query = "insert into danhmuc (MaDanhMuc,TenDanhMuc) values (?,?)";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
            pr.setObject(1, Danhmuc.getMaDanhMuc());
            pr.setObject(2, Danhmuc.getTenDanhMuc());

            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public Boolean xoa(String ma) {
        String query = "delete DanhMuc where MaDanhMuc= ?";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
            pr.setObject(1, ma);

            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public Boolean sua(String ma, DanhMuc Danhmuc) {
        String query = "update DanhMuc set MaDanhMuc= ?,TenDanhMuc=? where MaDanhMuc =?";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {

            pr.setObject(2, Danhmuc.getTenDanhMuc());
            pr.setObject(1, Danhmuc.getMaDanhMuc());
            pr.setObject(3, ma);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public ArrayList<DanhMuc> timkiem(String ma) {
        ArrayList<DanhMuc> listdm = new ArrayList<>();
        String sql = "select DanhMuc.Id,DanhMuc.MaDanhMuc,DanhMuc.TenDanhMuc from DanhMuc where MaDanhMuc like" + " '%" + ma + "%'";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(1));
                dm.setMaDanhMuc(rs.getString(2));
                dm.setTenDanhMuc(rs.getString(3));

                listdm.add(dm);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listdm;
    }

    public Boolean check(String ma) {
        Boolean trangthai = true;
        String sql = "select DanhMuc.Id,DanhMuc.MaDanhMuc,DanhMuc.TenDanhMuc from DanhMuc where MaDanhMuc = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            trangthai = rs.next();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return trangthai;
    }
}
