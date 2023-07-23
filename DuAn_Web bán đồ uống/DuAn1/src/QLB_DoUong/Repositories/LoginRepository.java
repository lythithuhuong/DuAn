/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author 84987
 */
public class LoginRepository {
       public DBConnection connection;
       
    public ArrayList<NhanVien> getFormDb(String sdt, String pw) {
         ArrayList<NhanVien> list = new ArrayList<>();        
        String sql = "select nhanvien.sdt, nhanvien.matkhau,nhanvien.TrangThai, nhanvien.ChucVu, nhanvien.manhanvien, nhanvien.tennhanvien from nhanvien where sdt = ? and matkhau = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sdt);
            ps.setString(2, pw);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                NhanVien nhanVien = new NhanVien();
                nhanVien.setSdt(rs.getString(1));
                nhanVien.setMatKhau(rs.getString(2));
                nhanVien.setTrangThai(rs.getInt(3));
                nhanVien.setChucVu(rs.getInt(4));
                nhanVien.setMaNhanVien(rs.getString(5));
                nhanVien.setTenNhanVien(rs.getString(6));
                list.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return list;
    }

    public boolean check(String sdt, String pw) {
            boolean trangthai = true;
                    
         String sql = "select nhanvien.sdt, nhanvien.matkhau,nhanvien.TrangThai from nhanvien where sdt = ? and matkhau = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sdt);
            ps.setString(2, pw);
            
          ResultSet rs = ps.executeQuery();
          trangthai = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangthai;
   
    
    }
    
}
