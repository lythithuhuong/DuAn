/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thao Ngoc
 */
public class SizeRepository {

    public List<Size> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[MaSize]\n"
                + "      ,[TenSize]\n"
                + "  FROM [dbo].[Size]";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<Size> lstSizes = new ArrayList<>();
            while (rs.next()) {
                lstSizes.add(new Size(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return lstSizes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Size> getById(String ma) {
        String query = "SELECT [Id]\n"
                + "      ,[MaSize]\n"
                + "      ,[TenSize]\n"
                + "  FROM [dbo].[Size]";
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            ps.setObject(1, ma);
            List<Size> lstSizes = new ArrayList<>();
            while (rs.next()) {
                lstSizes.add(new Size(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return lstSizes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Size s) {
        String query = "INSERT INTO [dbo].[Size]\n"
                + "           ([MaSize]\n"
                + "           ,[TenSize])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, s.getMaSize());
            ps.setObject(2, s.getTenSize());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(Size s, String ma) {
        String query = "UPDATE [dbo].[Size]\n"
                + "   SET [TenSize] = ?\n"
                + " WHERE maSize = ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, s.getTenSize());
            ps.setObject(2, s.getMaSize());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Size]\n"
                + "      WHERE maSize = ?";
        int check = 0;
        try ( Connection conn = DBConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean check(String ma) {
 Boolean trangthai = true;
        String sql = "select* from Size where MaSize = ?";
        try (Connection con = DBConnection.getConnection();
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
