/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author 0978078602
 */
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MatKhau]\n"
                + "      ,[ChucVu]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "   Order by MaNhanVien desc";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

//    public List<NhanVien> getNV_NghiViec() {
//        List<NhanVien> listNhanVien = new ArrayList<>();
//        String sql = "SELECT [Id]\n"
//                + "      ,[MaNhanVien]\n"
//                + "      ,[TenNhanVien]\n"
//                + "      ,[Email]\n"
//                + "      ,[GioiTinh]\n"
//                + "      ,[NgaySinh]\n"
//                + "      ,[DiaChi]\n"
//                + "      ,[Sdt]\n"
//                + "      ,[TrangThai]\n"
//                + "      ,[MatKhau]\n"
//                + "  FROM [dbo].[NhanVien]\n"
//                + "  WHERE TrangThai = 0\n"
//                + "  Order by MaNhanVien ASC";
//        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
//                listNhanVien.add(nv);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listNhanVien;
//    }
    public List<NhanVien> search(String maNV) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MatKhau]\n"
                + "      ,[ChucVu]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "where MaNhanVien like ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public List<NhanVien> searchDiaChi(String diaChi) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MatKhau]\n"
                + "      ,[ChucVu]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "where DiaChi like ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, diaChi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public List<NhanVien> searchGioiTinh(String gioiTinh) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[MaNhanVien]\n"
                + "      ,[TenNhanVien]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MatKhau]\n"
                + "      ,[ChucVu]\n"
                + "  FROM [dbo].[NhanVien]\n"
                + "where GioiTinh like ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gioiTinh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getInt(11));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public boolean add(NhanVien nhanVien) {
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           (\n"
                + "           [MaNhanVien]\n"
                + "           ,[TenNhanVien]\n"
                + "           ,[Email]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[TrangThai]\n"
                + "           ,[MatKhau]\n"
                + "           ,[ChucVu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nhanVien.getMaNhanVien());
            ps.setObject(2, nhanVien.getTenNhanVien());
            ps.setObject(3, nhanVien.getEmail());
            ps.setObject(4, nhanVien.getGioiTinh());
            ps.setObject(5, nhanVien.getNgaySinh());
            ps.setObject(6, nhanVien.getDiaChi());
            ps.setObject(7, nhanVien.getSdt());
            ps.setObject(8, nhanVien.getTrangThai());
            ps.setObject(9, nhanVien.getMatKhau());
            ps.setObject(10, nhanVien.getChucVu());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVien nhanVien, String maNV) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [MaNhanVien] = ?\n"
                + "      ,[TenNhanVien] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + " WHERE MaNhanVien = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nhanVien.getMaNhanVien());
            ps.setObject(2, nhanVien.getTenNhanVien());
            ps.setObject(3, nhanVien.getEmail());
            ps.setObject(4, nhanVien.getGioiTinh());
            ps.setObject(5, nhanVien.getNgaySinh());
            ps.setObject(6, nhanVien.getDiaChi());
            ps.setObject(7, nhanVien.getSdt());
            ps.setObject(8, nhanVien.getTrangThai());
            ps.setObject(9, nhanVien.getMatKhau());
            ps.setObject(10, maNV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maNV) {
        String query = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE MaNhanVien = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<NhanVien> listNhanVien = new NhanVienRepository().search("NV003");
        for (NhanVien nhanVien : listNhanVien) {
            System.out.println(nhanVien.toString());
        }
//        NhanVien nv = new NhanVien("NV04", "Lý Thị Thu Hương", "huong@gmail.com", 0, null, "Bắc Giang", "0998822234", 1, "123");
//        boolean add = new NhanVienRepository().add(nv);
//        System.out.println(add);
    }

    public String checkTrung(String maNV) {
        
        String query = "SELECT MaNhanVien FROM NhanVien WHERE MaNhanVien = ?";
        String text = null;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                text = rs.getString(1);
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    
    }
}
