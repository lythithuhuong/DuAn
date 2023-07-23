/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Date;

/**
 *
 * @author THUONG DINH
 */
public class KhuyenMaiRepository {

    public DBConnection Connection;

    public ArrayList<KhuyenMai> getFormDB() {
        ArrayList<KhuyenMai> listdb = new ArrayList<>();
        String sql = "select * from khuyenmai";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(rs.getString(1));
                khuyenMai.setMaKhuyenMai(rs.getString(2));
                khuyenMai.setPhamTramKhuyenMai(rs.getFloat(3));
                khuyenMai.setNgayBatDau(rs.getDate(4));
                khuyenMai.setNgayKetThuc(rs.getDate(5));
                khuyenMai.setTrangThai(rs.getInt(6));
                listdb.add(khuyenMai);

            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return listdb;
    }

    public boolean addNew(KhuyenMai khuyenMai) {
        String sql = "insert into KhuyenMai (MaKhuyenMai,GiaTriKhuyenMai,NgayBatDau,NgayKetThuc,TrangThai) values (?,?,?,?,?)";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, khuyenMai.getMaKhuyenMai());
            ps.setObject(2, khuyenMai.getPhamTramKhuyenMai());
            ps.setObject(3, khuyenMai.getNgayBatDau());
            ps.setObject(4, khuyenMai.getNgayKetThuc());
            ps.setObject(5, khuyenMai.getTrangThai());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public boolean update(KhuyenMai khuyenMai, String ma) {
        String sql = "update KhuyenMai set MaKhuyenMai = ?, GiaTriKhuyenMai = ? , "
                + "NgayBatDau = ?, NgayKetThuc = ?,TrangThai = ? where MaKhuyenMai = ?";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, khuyenMai.getMaKhuyenMai());
            ps.setObject(2, khuyenMai.getPhamTramKhuyenMai());
            ps.setObject(3, khuyenMai.getNgayBatDau());
            ps.setObject(4, khuyenMai.getNgayKetThuc());
            ps.setObject(5, khuyenMai.getTrangThai());
            ps.setObject(6, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public boolean delete(String ma) {
        String sql = "delete KhuyenMai where MaKhuyenMai = ?";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;

    }

    public Boolean updateTinhTrang(KhuyenMai khuyenMai, Date ngayBatDau, Date ngayKetThuc) {
        String sql = "update KhuyenMai set TrangThai = ? where NgayBatDau = ? and NgayKetThuc = ? ";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, khuyenMai.getTrangThai());
            ps.setObject(2, ngayBatDau);
            ps.setObject(3, ngayKetThuc);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public ArrayList<Date> ngayBatDau() {
        ArrayList<Date> listBD = new ArrayList<>();
        String sql = "select KhuyenMai.NgayBatDau from KhuyenMai";
        try ( Connection con = Connection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate(1);
                listBD.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBD;
    }

    public ArrayList<Date> ngayKetThuc() {
        ArrayList<Date> listKT = new ArrayList<>();
        String sql = "select KhuyenMai.NgayKetThuc from KhuyenMai";
        try ( Connection con = Connection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate(1);
                listKT.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKT;
    }

    public ArrayList<KhuyenMai> loc(Date ngayTao) {
        ArrayList<KhuyenMai> listdb = new ArrayList<>();
        String sql = "select NgayBatDau, NgayKetThuc  from KhuyenMai where NgayBatDau <= ? and NgayKetThuc >= ? ";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, ngayTao);
            ps.setDate(2, ngayTao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setNgayBatDau(rs.getDate(1));
                khuyenMai.setNgayKetThuc(rs.getDate(2));
                listdb.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return listdb;
    }

    public ArrayList<KhuyenMai> loc1(Date ngayTao) {
        ArrayList<KhuyenMai> listdb = new ArrayList<>();
        String sql = "select NgayBatDau, NgayKetThuc  from KhuyenMai where NgayBatDau > ? or NgayKetThuc < ?";
        try ( Connection con = Connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, ngayTao);
            ps.setDate(2, ngayTao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setNgayBatDau(rs.getDate(1));
                khuyenMai.setNgayKetThuc(rs.getDate(2));
                listdb.add(khuyenMai);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return listdb;
    }

    public Boolean check(String ma) {
        Boolean trangthai = true;
        String sql = "select* from KhuyenMai where MaKhuyenMai = ?";
        try ( Connection con = Connection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            trangthai = rs.next();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return trangthai;
    }

    public Boolean check(Date ngaykt, Date ngaybd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<KhuyenMai> timkiem(String ma) {
        ArrayList<KhuyenMai> listdm = new ArrayList<>();
        String sql = "select * from KhuyenMai where MaKhuyenMai like" + " '%" + ma + "%'";
        try ( Connection con = Connection.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(rs.getString(1));
                khuyenMai.setMaKhuyenMai(rs.getString(2));
                khuyenMai.setPhamTramKhuyenMai(rs.getFloat(3));
                khuyenMai.setNgayBatDau(rs.getDate(4));
                khuyenMai.setNgayKetThuc(rs.getDate(5));
                khuyenMai.setTrangThai(rs.getInt(6));
                listdm.add(khuyenMai);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listdm;
    }

}
