/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

/**
 *
 * @author DELL
 */
public class User {
    private String id;
    private String chucVu;

    public User() {
    }

    public User(String id, String chucVu) {
        this.id = id;
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", chucVu=" + chucVu + '}';
    }
    
}
