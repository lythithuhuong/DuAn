/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class DoUong_HoaDonRepository {
private DBConnection connection;
   

    public Boolean add(DoUong_HoaDon doUong_HoaDon) {
        int checkInsert =0;
        String sql = "insert into DoUong_HoaDon(IdHoaDon,IdDoUong,SoLuong,DonGia) values (?,?,?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, doUong_HoaDon.getHoaDon().getId());
            pst.setString(2, doUong_HoaDon.getDoUong().getId());
            pst.setInt(3, doUong_HoaDon.getSoLuong());
            pst.setFloat(4, doUong_HoaDon.getDonGia());
            checkInsert = pst.executeUpdate();
            return checkInsert > 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            
        }
        
        return null;
        
    }

    public Boolean update(DoUong_HoaDon doUong_HoaDon, String ma) {
         String sql = "update DoUong_HoaDon set SoLuong = ?  where  IdDoUong = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            
           
            pst.setInt(1, doUong_HoaDon.getSoLuong());
           
            pst.setString(2, ma);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        
        return true;
    }

    public Boolean delete(String ma) {
         String sql = "delete from DoUong_HoaDon where IdDoUong = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        
        return true;
    }

    public ArrayList<DoUong_HoaDon> timKiemDoUongHoaDon(String ma) {
         ArrayList<DoUong_HoaDon> listDoUongHoaDon = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia \n" +
"from DoUong_HoaDon\n" +
"join DoUong on DoUong.Id = DoUong_HoaDon.IdDoUong\n" +
"join HoaDon on HoaDon.Id = DoUong_HoaDon.IdHoaDon\n" +
"where MaHoaDon = ?";
        try (Connection con = connection.getConnection();
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

    public ArrayList<DoUong_HoaDon> getListDoUongHoaDon() {
 ArrayList<DoUong_HoaDon> listDoUongHoaDon = new ArrayList<>();
        String sql = "select DoUong.TenDoUong, DoUong_HoaDon.SoLuong,DoUong_HoaDon.DonGia \n" +
"from DoUong_HoaDon\n" +
"join DoUong on DoUong.Id = DoUong_HoaDon.IdDoUong\n";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
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

    public Boolean deleteTable(String ma) {
        String sql = "delete from DoUong_HoaDon where IdHoaDon = ?";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, ma);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        
        return true;
    }
    
}
