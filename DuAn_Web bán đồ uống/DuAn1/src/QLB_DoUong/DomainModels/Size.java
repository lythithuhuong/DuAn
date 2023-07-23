/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.DomainModels;

/**
 *
 * @author DELL
 */
public class Size {

    private String id;
    private String maSize;
    private String tenSize;

    public Size() {
    }

    public Size(String id, String maSize, String tenSize) {
        this.id = id;
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return tenSize;
    }

    public Object[] toData() {
        return new Object[]{maSize, tenSize};
    }
}
