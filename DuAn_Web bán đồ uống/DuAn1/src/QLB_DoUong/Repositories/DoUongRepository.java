/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Utilities.DBConnection;
import QLB_DoUong.ViewModel.DoUongVM;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author THUONG DINH
 */
public class DoUongRepository {

    private DBConnection dBConnection;

    public List<DoUongVM> getList() {
        List<DoUongVM> list = new ArrayList<>();
        String sql = "SELECT du.Id,MaDoUong,TenDoUong,DonGia,TrangThai,dm.Id,dm.MaDanhMuc,dm.TenDanhMuc,dm.MoTa,sz.Id,sz.MaSize,sz.TenSize FROM dbo.DoUong AS du INNER JOIN dbo.Size AS sz ON du.IdSize=sz.Id INNER JOIN dbo.DanhMuc AS dm ON du.IdDanhMuc=dm.Id";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(6));
                dm.setMaDanhMuc(rs.getString(7));
                dm.setTenDanhMuc(rs.getString(8));
                dm.setMoTa(rs.getString(9));
                Size sz = new Size();
                sz.setId(rs.getString(10));
                sz.setMaSize(rs.getString(11));
                sz.setTenSize(rs.getString(12));
                DoUongVM du = new DoUongVM();
                du.setId(rs.getString(1));
                du.setMaDoUong(rs.getString(2));
                du.setTenDoUong(rs.getString(3));
                du.setDonGia(rs.getBigDecimal(4));
                du.setTrangThai(rs.getInt(5));
                du.setDanhMuc(dm);
                du.setSize(sz);

                list.add(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DoUongVM> getSearchMa(String ma) {
        List<DoUongVM> list = new ArrayList<>();
        String sql = "SELECT du.Id,MaDoUong,TenDoUong,DonGia,TrangThai,dm.Id,dm.MaDanhMuc,dm.TenDanhMuc,dm.MoTa,sz.Id,sz.MaSize,sz.TenSize FROM dbo.DoUong AS du INNER JOIN dbo.Size AS sz ON du.IdSize=sz.Id INNER JOIN dbo.DanhMuc AS dm ON du.IdDanhMuc=dm.Id where MaDoUong like ?";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(6));
                dm.setMaDanhMuc(rs.getString(7));
                dm.setTenDanhMuc(rs.getString(8));
                dm.setMoTa(rs.getString(9));
                Size sz = new Size();
                sz.setId(rs.getString(10));
                sz.setMaSize(rs.getString(11));
                sz.setTenSize(rs.getString(12));
                DoUongVM du = new DoUongVM();
                du.setId(rs.getString(1));
                du.setMaDoUong(rs.getString(2));
                du.setTenDoUong(rs.getString(3));
                du.setDonGia(rs.getBigDecimal(4));
                du.setTrangThai(rs.getInt(5));
                du.setDanhMuc(dm);
                du.setSize(sz);

                list.add(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DoUongVM> getSearchTen(String ten) {
        List<DoUongVM> list = new ArrayList<>();
        String sql = "SELECT du.Id,MaDoUong,TenDoUong,DonGia,TrangThai,dm.Id,dm.MaDanhMuc,dm.TenDanhMuc,dm.MoTa,sz.Id,sz.MaSize,sz.TenSize FROM dbo.DoUong AS du INNER JOIN dbo.Size AS sz ON du.IdSize=sz.Id INNER JOIN dbo.DanhMuc AS dm ON du.IdDanhMuc=dm.Id where TenDoUong like ?";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(6));
                dm.setMaDanhMuc(rs.getString(7));
                dm.setTenDanhMuc(rs.getString(8));
                dm.setMoTa(rs.getString(9));
                Size sz = new Size();
                sz.setId(rs.getString(10));
                sz.setMaSize(rs.getString(11));
                sz.setTenSize(rs.getString(12));
                DoUongVM du = new DoUongVM();
                du.setId(rs.getString(1));
                du.setMaDoUong(rs.getString(2));
                du.setTenDoUong(rs.getString(3));
                du.setDonGia(rs.getBigDecimal(4));
                du.setTrangThai(rs.getInt(5));
                du.setDanhMuc(dm);
                du.setSize(sz);

                list.add(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(DoUongVM du) {
        String sql = "INSERT INTO dbo.DoUong(MaDoUong,TenDoUong,DonGia,TrangThai,IdDanhMuc,IdSize)VALUES(?,?,?,?,?,?)";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, du.getMaDoUong());
            ps.setString(2, du.getTenDoUong());
            ps.setBigDecimal(3, du.getDonGia());
            ps.setInt(4, du.getTrangThai());
            ps.setString(5, du.getDanhMuc().getId());
            ps.setString(6, du.getSize().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(String ma, DoUongVM du) {
        String sql = "UPDATE dbo.DoUong SET MaDoUong=?,TenDoUong=?,DonGia=?,TrangThai=?,IdDanhMuc=?,IdSize=? WHERE Id=?";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, du.getMaDoUong());
            ps.setString(2, du.getTenDoUong());
            ps.setBigDecimal(3, du.getDonGia());
            ps.setInt(4, du.getTrangThai());
            ps.setString(5, du.getDanhMuc().getId());
            ps.setString(6, du.getSize().getId());
            ps.setString(7, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(String ma) {
        String sql = "DELETE FROM dbo.DoUong WHERE Id=?";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<DoUongVM> search(String kind, String txt) {
        List<DoUongVM> list = new ArrayList<>();
        txt = '%' + txt + '%';
        String sql = "SELECT du.Id,MaDoUong,TenDoUong,DonGia,TrangThai,dm.Id,dm.MaDanhMuc,dm.TenDanhMuc,dm.MoTa,sz.Id,sz.MaSize,sz.TenSize FROM dbo.DoUong AS du INNER JOIN dbo.Size AS sz ON du.IdSize=sz.Id INNER JOIN dbo.DanhMuc AS dm ON du.IdDanhMuc=dm.Id WHERE " + kind + " LIKE ? order by MaDoUong";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getString(6));
                dm.setMaDanhMuc(rs.getString(7));
                dm.setTenDanhMuc(rs.getString(8));
                dm.setMoTa(rs.getString(9));
                Size sz = new Size();
                sz.setId(rs.getString(10));
                sz.setMaSize(rs.getString(11));
                sz.setTenSize(rs.getString(12));
                DoUongVM du = new DoUongVM();
                du.setId(rs.getString(1));
                du.setMaDoUong(rs.getString(2));
                du.setTenDoUong(rs.getString(3));
                du.setDonGia(rs.getBigDecimal(4));
                du.setTrangThai(rs.getInt(5));
                du.setDanhMuc(dm);
                du.setSize(sz);
                list.add(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean check(String ma) {
        Boolean trangthai = true;
        String sql = "select* from DoUong where MaDoUong = ?";
        try ( Connection con = dBConnection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            trangthai = rs.next();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return trangthai;
    }

}
