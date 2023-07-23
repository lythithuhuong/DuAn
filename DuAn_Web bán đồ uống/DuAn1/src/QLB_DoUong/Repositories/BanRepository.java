/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.Ban;
import java.sql.*;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BanRepository {

    private DBConnection connection;

    public ArrayList<Ban> getFormDB() {
        ArrayList<Ban> listdm = new ArrayList<>();
        String sql = "select * from Ban";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Ban ban = new Ban();
                ban.setId(rs.getString(1));
                ban.setMaBan(rs.getString(2));
                ban.setTenBan(rs.getString(3));
                ban.setTrangthai(rs.getInt(4));
                listdm.add(ban);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listdm;
    }

    public Boolean them(Ban ban) {
        String query = "insert into Ban (MaBan,TenBan,TrangThai) values (?,?,?)";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
            pr.setObject(1, ban.getMaBan());
            pr.setObject(2, ban.getTenBan());
            pr.setObject(3, ban.getTrangthai());

            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public Boolean xoa(String ma) {
        String query = "delete Ban where MaBan= ?";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
            pr.setObject(1, ma);

            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public Boolean sua(String ma, Ban ban) {
        String query = "update Ban set MaBan= ?,TenBan=?,TrangThai = ? where MaBan =?";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {

            pr.setObject(2, ban.getTenBan());
            pr.setObject(1, ban.getMaBan());
            pr.setObject(3, ban.getTrangthai());
            pr.setObject(4, ma);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public ArrayList<Ban> timkiem(String ma) {
        ArrayList<Ban> listdm = new ArrayList<>();
        String sql = "select * from Ban where MaBan like" + " '%" + ma + "%'";
        try (Connection con = connection.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Ban ban = new Ban();
                ban.setId(rs.getString(1));
                ban.setMaBan(rs.getString(2));
                ban.setTenBan(rs.getString(3));
                ban.setTrangthai(rs.getInt(4));
                listdm.add(ban);

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listdm;
    }

    public Boolean check(String ma) {
        Boolean trangthai = true;
        String sql = "select* from Ban where MaBan = ?";
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
