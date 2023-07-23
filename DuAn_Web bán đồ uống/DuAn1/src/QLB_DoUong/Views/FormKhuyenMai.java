/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.Services.BanHangService;
import QLB_DoUong.Services.Impl.BanHangServiceImpl;
import QLB_DoUong.Services.Impl.KhuyenMaiServiceImpl;
import QLB_DoUong.Services.KhuyenMaiService;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUONG DINH
 */
public class FormKhuyenMai extends javax.swing.JPanel {

    public KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
private BanHangService banHangService = new BanHangServiceImpl();
    /**
     * Creates new form FormKhuyenMai
     */
    public FormKhuyenMai() {
        initComponents();
        loadData(khuyenMaiService.getList());
        tinhTrang();
        tinhTrang1();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công ");
    }

    public void loadData(ArrayList<KhuyenMai> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblKhuyenMai.getModel();
        dtm.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            Object[] rowData = new Object[]{
                //khuyenMai.getId(),
                khuyenMai.getMaKhuyenMai(),
                khuyenMai.getPhamTramKhuyenMai(),
                khuyenMai.getNgayBatDau(),
                khuyenMai.getNgayKetThuc(),
                khuyenMai.getTrangThai() == 1 ? "Đang khuyến mãi" : "Hết khuyến mãi",};

            dtm.addRow(rowData);

        }

    }

    private void tinhTrang() {
        ArrayList<Date> ngayBatDau = khuyenMaiService.ngayBatDau();
        ArrayList<Date> ngayKetThuc = khuyenMaiService.ngayKetThuc();
        Date ngayTao = genNgay();
        ArrayList<KhuyenMai> list = khuyenMaiService.loc(ngayTao);
        loadData(list);
        for (KhuyenMai khuyenMai : list) {
            khuyenMai.setNgayBatDau(khuyenMai.getNgayBatDau());
            khuyenMai.setNgayKetThuc(khuyenMai.getNgayKetThuc());
            khuyenMai.setTrangThai(1);
            if (khuyenMaiService.updateTinhTrang(khuyenMai, khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc())) {
                loadData(khuyenMaiService.getList());
                clearForm();
            }
        }
        

    }
     private void tinhTrang1() {
        ArrayList<Date> ngayBatDau = khuyenMaiService.ngayBatDau();
        ArrayList<Date> ngayKetThuc = khuyenMaiService.ngayKetThuc();
        Date ngayTao = genNgay();
        ArrayList<KhuyenMai> list = khuyenMaiService.loc1(ngayTao);
        loadData(list);
        for (KhuyenMai khuyenMai : list) {
            khuyenMai.setNgayBatDau(khuyenMai.getNgayBatDau());
            khuyenMai.setNgayKetThuc(khuyenMai.getNgayKetThuc());
            khuyenMai.setTrangThai(0);
            if (khuyenMaiService.updateTinhTrang(khuyenMai, khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc())) {
                loadData(khuyenMaiService.getList());
                clearForm();
            }
        }

    }
     
    private void clearForm() {
        txtmaKM.setText("");
     //   txtid.setText("");
        lblTrangThai.setText("");
        txtphantramKM.setText("");
        txtNgayBatDau.setText("");
        txtNgayKetThuc.setText("");
    }

    private KhuyenMai getFormData() {
        String maKM = txtmaKM.getText();
        String PhanTramKM = txtphantramKM.getText();
        Date date = null;
        Date date1 = null;
        String ngayBatDau = txtNgayBatDau.getText();
        String ngayKetThuc = txtNgayKetThuc.getText();
        int trangThai = 0;
        if (maKM.trim().length() == 0
                || PhanTramKM.trim().length() == 0
                || ngayBatDau.trim().length() == 0
                || ngayKetThuc.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống");
            return null;
        }
        
        if(Float.parseFloat(PhanTramKM)<0&&Float.parseFloat(PhanTramKM)>1){
            JOptionPane.showMessageDialog(this, "Giá trị khuyến mại phải nhỏ hơn 1 lớn hơn bằng 0");
            return null;
        }
        
        try {
            date = Date.valueOf(ngayBatDau);
            date1 = Date.valueOf(ngayKetThuc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày");
            return null;
        }
        
        if (Date.valueOf(ngayBatDau).before(genNgay()) && genNgay().before(Date.valueOf(ngayKetThuc))) {
            trangThai = 1;
        }
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMaKhuyenMai(maKM);
        khuyenMai.setPhamTramKhuyenMai(Float.parseFloat(PhanTramKM));
        khuyenMai.setNgayBatDau(date);
        khuyenMai.setNgayKetThuc(date1);
        khuyenMai.setTrangThai(trangThai);
        return khuyenMai;

    }
 private String genMa(ArrayList<KhuyenMai> listHoaDon) {
        int count = 1;
        for (KhuyenMai khuyenmai : listHoaDon) {
            count++;
        }
        int ma = count + 1;

        return "KM" + ma;
    }
    public Date genNgay() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmaKM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtphantramKM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnlamMoi = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 700));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KM", "Phần trăm KM", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã KM");

        jLabel4.setText("% KM");

        txtphantramKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphantramKMActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày Bắt Đầu");

        jLabel6.setText("Ngày Kết Thúc");

        jLabel8.setText("Trạng thái");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnthem.setBackground(new java.awt.Color(228, 245, 194));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/them.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(228, 245, 194));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/thanhDoi.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(228, 245, 194));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/xoa.png"))); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnlamMoi.setBackground(new java.awt.Color(228, 245, 194));
        btnlamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/timKiem.png"))); // NOI18N
        btnlamMoi.setText("Tìm kiếm");
        btnlamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlamMoi)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtphantramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(67, 67, 67)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtmaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtphantramKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        String ma=txtmaKM.getText();
        int confim = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa bản ghi này");
        if (confim == JOptionPane.NO_OPTION) {
            return;
        } else if (confim == JOptionPane.CANCEL_OPTION) {
            return;
        } else {

            if (khuyenMaiService.delete(ma)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadData(khuyenMaiService.getList());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        KhuyenMai khuyenMai = getFormData();
        String ma =txtmaKM.getText();
        if (khuyenMai == null) {
            return;
        }
        if (khuyenMaiService.update(khuyenMai, ma)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadData(khuyenMaiService.getList());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        KhuyenMai khuyenMai = getFormData();
        String ma = txtmaKM.getText();
        if (khuyenMai == null) {
            return;
        }
           Boolean check = khuyenMaiService.check(ma);

        if (check) {
            JOptionPane.showMessageDialog(this, "Mã tồn tại");
            return;
        }
        else if(khuyenMaiService.addNew(khuyenMai)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadData(khuyenMaiService.getList());

        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtmaKM.setText(tblKhuyenMai.getValueAt(row, 0).toString());
        txtphantramKM.setText(tblKhuyenMai.getValueAt(row, 1).toString());
        txtNgayBatDau.setText(tblKhuyenMai.getValueAt(row, 2).toString());
        txtNgayKetThuc.setText(tblKhuyenMai.getValueAt(row, 3).toString());
        lblTrangThai.setText(tblKhuyenMai.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void txtphantramKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphantramKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphantramKMActionPerformed

    private void btnlamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamMoiActionPerformed
        ArrayList<KhuyenMai> list = khuyenMaiService.timKiem(txtmaKM.getText());
       loadData(list);
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(this, "Không tìm thấy ");
            return ;
        }
    }//GEN-LAST:event_btnlamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlamMoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtmaKM;
    private javax.swing.JTextField txtphantramKM;
    // End of variables declaration//GEN-END:variables
}
