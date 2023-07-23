/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Utilities.DBConnection;
import QLB_DoUong.ViewModel.HoaDonView;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class HoaDonRepository {

    private DBConnection connection;

    public ArrayList<HoaDonView> getList() {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,"
                + "KhuyenMai.GiaTriKhuyenMai,SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n"
                + "		    join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n"
                + "            join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n"
                + "group by HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,"
                + "KhuyenMai.GiaTriKhuyenMai";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), 
                        rs.getFloat(6), rs.getFloat(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonView> getList_ByMaHD(String ma) {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select DoUong.MaDoUong,DoUong.TenDoUong,DanhMuc.TenDanhMuc,TenSize,DoUong_HoaDon.DonGia,DoUong_HoaDon.SoLuong\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon \n"
                + "		    join DoUong on DoUong_HoaDon.IdDoUong = DoUong.Id \n"
                + "			join Size on DoUong.IdSize = Size.Id\n"
                + "			join DanhMuc on DoUong.IdDanhMuc = DanhMuc.Id\n"
                + "			where HoaDon.MaHoaDon = ?";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getInt(6)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public Boolean add(HoaDon hoaDon) {
        String sql = "insert into HoaDon(MaHoaDon,NgayTao,NgayThanhToan,TinhTrang,IdNhanVien,IdKhuyenMai) values (?,?,?,?,?,?)";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, hoaDon.getMaHoaDon());
            pst.setDate(2, hoaDon.getNgayTao());
            pst.setDate(3, hoaDon.getNgayThanhToan());
            pst.setInt(4, hoaDon.getTinhTrang());
            pst.setString(5, hoaDon.getNhanVien().getId());
            pst.setString(6, hoaDon.getKhuyenMai().getId());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    public Boolean update(HoaDon hoaDon, String ma) {
        String sql = "update HoaDon set NgayThanhToan = ? ,TinhTrang = ? where MaHoaDon= ? ";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDate(1, hoaDon.getNgayThanhToan());
            pst.setInt(2, hoaDon.getTinhTrang());
            pst.setString(3, ma);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    public ArrayList<HoaDonView> timKiemTheoTrangThai(int trangThai) {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,"
                + "KhuyenMai.GiaTriKhuyenMai,SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n"
                + "		    join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n"
                + "            join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n"
                + "			where HoaDon.TinhTrang = " + trangThai + "\n"
                + "            group by HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonView> timKiemTheoTien(float tien1, float tien2) {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,"
                + "KhuyenMai.GiaTriKhuyenMai,SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n"
                + "		    join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n"
                + "            join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n"
                + "            group by HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai\n"
                + "			having (SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)) between " + tien1 + " and " + tien2 + "";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonView> timKiemTheoNgay(Date ngayBD, Date ngayKT) {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai,"
                + "SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n"
                + "		    join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n"
                + "            join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n"
                + "			where HoaDon.NgayTao between ? and ? \n"
                + "            group by HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDate(1, ngayBD);
            pst.setDate(2, ngayKT);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonView> timKiemTheoMa(String ma) {
        ArrayList<HoaDonView> listHoaDon = new ArrayList<>();
        String query = "select HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,"
                + "KhuyenMai.GiaTriKhuyenMai,SUM(DoUong_HoaDon.DonGia*DoUong_HoaDon.SoLuong) * (1-GiaTriKhuyenMai)\n"
                + "from HoaDon join DoUong_HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n"
                + "		    join KhuyenMai on KhuyenMai.Id = HoaDon.IdKhuyenMai\n"
                + "            join NhanVien on NhanVien.Id = HoaDon.IdNhanVien\n"
                + "			where HoaDon.MaHoaDon = ? \n"
                + "            group by HoaDon.MaHoaDon,HoaDon.NgayTao,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.MaNhanVien,KhuyenMai.GiaTriKhuyenMai";
        try ( Connection con = connection.getConnection();  PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonView(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getFloat(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    

}
