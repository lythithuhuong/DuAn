/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Utilities.DBConnection;
import QLB_DoUong.ViewModel.ThongkeVM;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author OSC
 */
public class ThongKeRepository {

    private DBConnection dbConnect;

   public ArrayList<ThongkeVM> getformDB() {
        ArrayList<ThongkeVM> list = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,NhanVien.MaNhanVien,HoaDon.NgayTao,HoaDon.NgayThanhToan,DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia,KhuyenMai.GiaTriKhuyenMai\n" +
"               from HoaDon join NhanVien on HoaDon.IdNhanVien=NhanVien.id\n" +
"               join DoUong_HoaDon on DoUong_HoaDon.IdHoaDon=HoaDon.Id join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeVM tkvm = new ThongkeVM();
                tkvm.setMaHD(rs.getString(1));
                tkvm.setNgayThanhtoan(rs.getDate(4));
                tkvm.setMaNV(rs.getString(2));
                tkvm.setNgayban(rs.getDate(3));
                tkvm.setDongia(rs.getFloat(6));
                tkvm.setSoluong(rs.getInt(5));
                tkvm.setPtkhuyenmai(rs.getFloat(7));
                list.add(tkvm);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<ThongkeVM> findnam(int nam) {
        ArrayList<ThongkeVM> list = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,NhanVien.MaNhanVien,HoaDon.NgayTao,HoaDon.NgayThanhToan,DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia ,KhuyenMai.GiaTriKhuyenMai\n"
                + "from HoaDon join NhanVien on HoaDon.IdNhanVien=NhanVien.Id\n"
                + "			join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai\n"
                + "			where YEAR(HoaDon.NgayTao) =?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeVM tkvm = new ThongkeVM();
                tkvm.setMaHD(rs.getString(1));
                tkvm.setNgayThanhtoan(rs.getDate(4));
                tkvm.setMaNV(rs.getString(2));
                tkvm.setNgayban(rs.getDate(3));
                tkvm.setDongia(rs.getFloat(6));
                tkvm.setSoluong(rs.getInt(5));
                tkvm.setPtkhuyenmai(rs.getFloat(7));

                list.add(tkvm);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<ThongkeVM> findthang(int nam, int thang) {
        ArrayList<ThongkeVM> list = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,NhanVien.MaNhanVien,HoaDon.NgayTao,HoaDon.NgayThanhToan,DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia, KhuyenMai.GiaTriKhuyenMai\n"
                + "from HoaDon join NhanVien on HoaDon.IdNhanVien=NhanVien.Id\n"
                + "			join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai"
                + "			where YEAR(HoaDon.NgayTao) =? and MONTH(HoaDon.NgayTao)=?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeVM tkvm = new ThongkeVM();
                tkvm.setMaHD(rs.getString(1));
                tkvm.setNgayThanhtoan(rs.getDate(4));
                tkvm.setMaNV(rs.getString(2));
                tkvm.setNgayban(rs.getDate(3));
                tkvm.setDongia(rs.getFloat(6));
                tkvm.setSoluong(rs.getInt(5));
                tkvm.setPtkhuyenmai(rs.getFloat(7));

                list.add(tkvm);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<ThongkeVM> findngay(int nam, int thang, int ngay) {
        ArrayList<ThongkeVM> list = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,NhanVien.MaNhanVien,HoaDon.NgayTao,HoaDon.NgayThanhToan,DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia\n"
                + "from HoaDon join NhanVien on HoaDon.IdNhanVien=NhanVien.Id\n"
                + "			join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai\n"
                + "			where YEAR(HoaDon.NgayTao) =? and MONTH(HoaDon.NgayTao)=? and Day(HoaDon.NgayTao) =?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ps.setObject(3, ngay);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeVM tkvm = new ThongkeVM();
                tkvm.setMaHD(rs.getString(1));
                tkvm.setNgayThanhtoan(rs.getDate(4));
                tkvm.setMaNV(rs.getString(2));
                tkvm.setNgayban(rs.getDate(3));
                tkvm.setDongia(rs.getFloat(6));
                tkvm.setSoluong(rs.getInt(5));
                tkvm.setPtkhuyenmai(rs.getFloat(7));

                list.add(tkvm);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Double> sumHD() {
        ArrayList<Double> list = new ArrayList<>();
        String sql = "	select sum(DonGia*SoLuong-DonGia*SoLuong*GiaTriKhuyenMai)\n"
                + "		from HoaDon join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "			join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double db = rs.getDouble(1);
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
     public ArrayList<Double> sumHD1(String ngaybd, String ngaykt) {
        ArrayList<Double> list = new ArrayList<>();
        String sql = "	select Sum(DonGia*SoLuong-DonGia*SoLuong*GiaTriKhuyenMai)\n"
                + "		from HoaDon	 join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "			join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai\n"
                + "			where  HoaDon.NgayTao between ? and ? ";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
         ps.setObject(1, ngaybd);
            ps.setObject(2, ngaykt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double db = rs.getDouble(1);
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
     public ArrayList<Integer> sumspHD1(String ngaybd, String ngaykt) {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "	select sum(DoUong_HoaDon.SoLuong)\n"
                + "		from HoaDon	 join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "			where  HoaDon.NgayTao between ? and ? ";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
         ps.setObject(1, ngaybd);
            ps.setObject(2, ngaykt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer db = rs.getInt(1);
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Double> sumHDnam(int nam) {
        ArrayList<Double> list = new ArrayList<>();
        String sql = "	select sum(DonGia*SoLuong-DonGia*SoLuong*GiaTriKhuyenMai)\n"
                + "		from HoaDon join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "			join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai where year(HoaDon.NgayTao)=?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double db = rs.getDouble(1);
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Double> sumHDthang(int nam, int thang) {
        ArrayList<Double> list = new ArrayList<>();
        String sql = "	select sum(DonGia*SoLuong-DonGia*SoLuong*GiaTriKhuyenMai)\n"
                + "		from HoaDon	 join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "			join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai where year(HoaDon.NgayTao)=? and MONTH(HoaDon.NgayTao)=?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double db = rs.getDouble(1);
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Integer> sumspnam(int nam) {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "	select sum(DoUong_HoaDon.SoLuong)\n"
                + "		from HoaDon	 join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "	where year(HoaDon.NgayTao)=?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer it = rs.getInt(1);
                list.add(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public ArrayList<Integer> sumspthang(int nam,int thang) {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "	select sum(DoUong_HoaDon.SoLuong)\n"
                + "		from HoaDon	 join DoUong_HoaDon on HoaDon.Id=DoUong_HoaDon.IdHoaDon\n"
                + "	where year(HoaDon.NgayTao)=? and MONTH(HoaDon.NgayTao)=?";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nam);
            ps.setObject(2, thang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Integer it = rs.getInt(1);
                list.add(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<DoUong_HoaDon> getListHoaDonChiTiet() {
        ArrayList<DoUong_HoaDon> listDoUongHoaDon = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong.DonGia \n"
                + "from DoUong \n"
                + "join DoUong_HoaDon on DoUong_HoaDon.IdDoUong = DoUong.Id";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
 public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma) {
         ArrayList<DoUong_HoaDon> listDoUongHoaDon = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia \n" +
"from DoUong_HoaDon\n" +
"join DoUong on DoUong.Id = DoUong_HoaDon.IdDoUong\n" +
"join HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n" +
"where MaHoaDon = ?";
        try (Connection con = dbConnect.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
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
 
 public ArrayList<ThongkeVM> timkiemngay1(String ngaybd, String ngaykt) {
        ArrayList<ThongkeVM> list = new ArrayList<>();
        String sql = "select HoaDon.MaHoaDon,NhanVien.MaNhanVien,HoaDon.NgayTao,HoaDon.NgayThanhToan,DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia,KhuyenMai.GiaTriKhuyenMai\n" +
"               from HoaDon join NhanVien on HoaDon.IdNhanVien=NhanVien.id\n" +
"               join DoUong_HoaDon on DoUong_HoaDon.IdHoaDon=HoaDon.Id join KhuyenMai on KhuyenMai.Id=HoaDon.IdKhuyenMai  where  HoaDon.NgayTao between ' "+ngaybd+" ' and ' "+ ngaykt+" ' ";
      try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               ThongkeVM tkvm = new ThongkeVM();
                tkvm.setMaHD(rs.getString(1));
                tkvm.setNgayThanhtoan(rs.getDate(4));
                tkvm.setMaNV(rs.getString(2));
                tkvm.setNgayban(rs.getDate(3));
                tkvm.setDongia(rs.getFloat(6));
                tkvm.setSoluong(rs.getInt(5));
                tkvm.setPtkhuyenmai(rs.getFloat(7));
                list.add(tkvm);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

   
}
