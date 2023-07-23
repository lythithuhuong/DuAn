/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.Ban;
import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Utilities.DBConnection;
import QLB_DoUong.ViewModel.DoUongVM;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class BanHangRepository {
private DBConnection connection;
    
    
    public ArrayList<DoUongVM> getList() {
        ArrayList<DoUongVM> listDoUong = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong.DonGia ,DoUong.TrangThai, Size.TenSize,DanhMuc.TenDanhMuc\n" +
"from DoUong\n" +
"join Size on Size.Id = DoUong.IdSize\n" +
"join DanhMuc on DanhMuc.Id = DoUong.IdDanhMuc";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DoUongVM doUong = new DoUongVM();
                doUong.setTenDoUong(rs.getString(1));
                doUong.setDonGia(rs.getBigDecimal(2));
                doUong.setTrangThai(rs.getInt(3));
                Size size = new Size();
                size.setTenSize(rs.getString(4));
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setTenDanhMuc(rs.getString(5));
                doUong.setSize(size);
                doUong.setDanhMuc(danhMuc);
                listDoUong.add(doUong);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDoUong;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan, HoaDon.TinhTrang, NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai\n" +
"from HoaDon\n" +
"join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n" +
"join NhanVien on NhanVien.Id = HoaDon.IdNhanVien order by MaHoaDon desc";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               NhanVien nhanVien = new NhanVien();
               nhanVien.setMaNhanVien(rs.getString(5));
               KhuyenMai khuyenMai = new KhuyenMai();
               khuyenMai.setPhamTramKhuyenMai(rs.getFloat(6));
               HoaDon hoaDon = new HoaDon();
               hoaDon.setMaHoaDon(rs.getString(1));
               hoaDon.setNgayTao(rs.getDate(2));
               hoaDon.setNgayThanhToan(rs.getDate(3));
               hoaDon.setTinhTrang(rs.getInt(4));
               hoaDon.setNhanVien(nhanVien);
               hoaDon.setKhuyenMai(khuyenMai);
               listHoaDon.add(hoaDon);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listHoaDon;
    }

    public String getByIDMaHD(String ma) {
    
        String sql = "select HoaDon.Id from HoaDon where HoaDon.MaHoaDon = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }   

    public String getByIDMaDU(String ma) {
        String sql = "select DoUong.Id from DoUong where DoUong.TenDoUong = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DoUong_HoaDon> getListHoaDonChiTiet() {
        ArrayList<DoUong_HoaDon> listDoUongHoaDon = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong.DonGia \n" +
"from DoUong \n" +
"join DoUong_HoaDon on DoUong_HoaDon.IdDoUong = DoUong.Id";
        try (Connection con = connection.getConnection();
                PreparedStatement pst =con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DoUong doUong = new DoUong();
                doUong.setTenDoUong(rs.getString(1));
                DoUong_HoaDon doUong_HoaDon = new DoUong_HoaDon();
                doUong_HoaDon.setDoUong(doUong);
                doUong_HoaDon.setSoLuong(rs.getInt(2));
                doUong_HoaDon.setDonGia(rs.getFloat(3));
                listDoUongHoaDon.add(doUong_HoaDon);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDoUongHoaDon;
    }
    public static void main(String[] args) {
        ArrayList<HoaDon> list = new BanHangRepository().getListHoaDon();
        for (HoaDon hoaDon : list) {
            System.out.println(hoaDon.toString());
        }
    }

    public Boolean check(String ten ,String ma) {
         Boolean trangthai = true;
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia \n" +
"from DoUong_HoaDon\n" +
"join DoUong on DoUong.Id = DoUong_HoaDon.IdDoUong\n" +
"join HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n" +
"where TenDoUong = ? and MaHoaDon = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ten); 
            pst.setString(2, ma); 
            ResultSet rs = pst.executeQuery();
            trangthai = rs.next();
            
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return trangthai;
    
    }

    public ArrayList<DoUongVM> timKiemDoUong(String ten) {
        ArrayList<DoUongVM> listDoUong = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong.DonGia ,DoUong.TrangThai, Size.TenSize,DanhMuc.TenDanhMuc\n" +
"from DoUong\n" +
"join Size on Size.Id = DoUong.IdSize\n" +
"join DanhMuc on DanhMuc.Id = DoUong.IdDanhMuc\n" +
"where TenDoUong like N'%"+ten+"%'";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DoUongVM doUong = new DoUongVM();
                doUong.setTenDoUong(rs.getString(1));
                doUong.setDonGia(rs.getBigDecimal(2));
                doUong.setTrangThai(rs.getInt(3));
                Size size = new Size();
                size.setTenSize(rs.getString(4));
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setTenDanhMuc(rs.getString(5));
                doUong.setSize(size);
                doUong.setDanhMuc(danhMuc);
                listDoUong.add(doUong);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listDoUong;
    }

    public String idKhuyenMai() {
        String sql ="select KhuyenMai.Id from KhuyenMai where TrangThai = 1";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String idNhanVien(String ma) {
        String sql ="select NhanVien.Id from NhanVien where MaNhanVien = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String maNhanVien(String ma) {
        String sql ="select NhanVien.MaNhanVien from NhanVien where Id = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ngayTao(Date ngayTao) {
        String sql ="select convert (varchar , ? , 120)";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDate(1, ngayTao);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
