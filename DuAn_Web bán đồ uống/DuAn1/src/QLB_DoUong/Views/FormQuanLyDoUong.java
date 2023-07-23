/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Services.DanhmucSevice;
import QLB_DoUong.Services.DoUongService;
import QLB_DoUong.Services.Impl.DanhmucImpl;
import QLB_DoUong.Services.Impl.DoUongServiceImpl;
import QLB_DoUong.Services.Impl.SizeServiceImpl;
import QLB_DoUong.Services.SizeService;
import QLB_DoUong.ViewModel.DoUongVM;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUONG DINH
 */
public class FormQuanLyDoUong extends javax.swing.JPanel {
    private DefaultTableModel dtm;
    private DoUongService doUongService = new DoUongServiceImpl();
    private DanhmucSevice danhMucService = new DanhmucImpl();
    private SizeService sizeService = new SizeServiceImpl();

    
    public FormQuanLyDoUong() {
        initComponents();
      //  txtID.setEnabled(false);
        loadTable(doUongService.getList());
        loadCbbKindOfDrink();
        loadCbbSize();
    }
    
    public void loadTable(List<DoUongVM> list) {
        dtm = (DefaultTableModel) tblDrink.getModel();
        dtm.setRowCount(0);
        for (DoUongVM du : list) {
            Object[] row = {
               // du.getId(),
                du.getMaDoUong(),
                du.getTenDoUong(),
                du.getDonGia(),
                du.getTrangThai() == 1 ? "Còn" : "Hết",
                du.getDanhMuc(),
                du.getSize(),};
            dtm.addRow(row);
        }
    }
//    
//    public String kind() {
//        if (cbbKind.getSelectedIndex() == 0) {
//            return "MaDoUong";
//        } else {
//            return "TenDoUong";
//        }
//    }
    
    public DoUongVM getData() {
        DoUongVM du = new DoUongVM();
        du.setMaDoUong(txtCode.getText());
        du.setTenDoUong(txtName.getText());
        du.setDonGia(new BigDecimal(txtPrice.getText()));
        if (rdo0.isSelected() == true) {
            du.setTrangThai(0);
        }
        if (rdo1.isSelected() == true) {
            du.setTrangThai(1);
        }
        du.setDanhMuc((DanhMuc)cbbKindOfDrink.getSelectedItem());
        du.setSize((Size)cbbSize.getSelectedItem());
        
        return du;
    }
    
    
    private void loadCbbKindOfDrink() {
        cbbKindOfDrink.removeAllItems();
        List<DanhMuc> listDM = danhMucService.getlist();
        for (DanhMuc dm : listDM) {
            cbbKindOfDrink.addItem(dm);
        }
    }
    
    private void loadCbbSize() {
        cbbSize.removeAllItems();
        List<Size> listSZ = sizeService.getAll();
        for (Size sz : listSZ) {
            cbbSize.addItem(sz);
        }
    }
    
    public void clearForm() {
     //   txtID.setText("");
        txtCode.setText("");
        txtName.setText("");
        txtPrice.setText("");
        rdo0.setSelected(false);
        rdo1.setSelected(false);
        cbbKindOfDrink.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrink = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        rdo1 = new javax.swing.JRadioButton();
        rdo0 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        cbbKindOfDrink = new javax.swing.JComboBox<DanhMuc>();
        cbbSize = new javax.swing.JComboBox<Size>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchMa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSearchTen = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách đồ uống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 700));

        tblDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đồ uống", "Tên đồ uống", "Đơn giá", "Trạng thái", "Danh mục", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDrinkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDrink);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin đồ uống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel4.setText("Mã đồ uống:");

        jLabel5.setText("Tên đồ uống:");

        jLabel7.setText("Trạng thái:");

        jLabel6.setText("Đơn giá:");

        rdo1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo1);
        rdo1.setText("Còn");

        rdo0.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo0);
        rdo0.setText("Hết");

        jLabel8.setText("Danh mục:");

        cbbKindOfDrink.setModel(new javax.swing.DefaultComboBoxModel<DanhMuc>());

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<Size>());

        jLabel9.setText("Size:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setBackground(new java.awt.Color(228, 245, 194));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/them.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(228, 245, 194));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/thanhDoi.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(228, 245, 194));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/xoa.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClearForm.setBackground(new java.awt.Color(228, 245, 194));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/lamMoi.png"))); // NOI18N
        btnClearForm.setText("Xoá form");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearForm, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnClearForm)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addComponent(txtPrice))
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbKindOfDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdo1)
                        .addGap(68, 68, 68)
                        .addComponent(rdo0)))
                .addGap(119, 119, 119)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdo1)
                    .addComponent(rdo0))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbKindOfDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã đồ uống:");

        txtSearchMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchMaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchMaKeyTyped(evt);
            }
        });

        jLabel1.setText("Tên đồ uống:");

        txtSearchTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchTenKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchTenKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(368, 368, 368)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String madu=txtCode.getText();
        String tendu=txtName.getText();
        String giadu=txtPrice.getText();
        if(madu.equals("")||
                tendu.equals("")||
                giadu.equals("")
                ){
            JOptionPane.showMessageDialog(this, "Không được để trống");
           return ;
       }
        try {
           Float.parseFloat(giadu);
           if(Float.parseFloat(giadu)<0){
               JOptionPane.showMessageDialog(this, "Giá lớn hơn 0");
               return;
               
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số");
        }
        Boolean check =doUongService.check(madu);
        if(check){
            JOptionPane.showMessageDialog(this, "mã đã tồn tại");
            return;
        }
        else{    
        doUongService.add(getData());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblDrink.getSelectedRow();
        String madu=txtCode.getText();
        String tendu=txtName.getText();
        String giadu=txtPrice.getText();
        if(madu.equals("")||
                tendu.equals("")||
                giadu.equals("")
                ){
            JOptionPane.showMessageDialog(this, "Không được để trống");
           return ;
       }
        try {
           Float.parseFloat(giadu);
           if(Float.parseFloat(giadu)<0){
               JOptionPane.showMessageDialog(this, "Giá lớn hơn 0");
               return;
               
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số");
        }
        Boolean check =doUongService.check(madu);
        if(check){
            JOptionPane.showMessageDialog(this, "mã đã tồn tại");
            return;
        }
        else{ 
        doUongService.update(tblDrink.getValueAt(row, 0).toString(), getData());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Sửa thành công");}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblDrink.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
                String madu=txtCode.getText();

         Boolean check =doUongService.check(madu);
        if(!check){
            JOptionPane.showMessageDialog(this, "mã không tồn tại");
            return;
        }
        else{ 
        doUongService.delete(tblDrink.getValueAt(row, 0).toString());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Xoá thành công");}
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDrinkMouseClicked
        int row = tblDrink.getSelectedRow();
      //  txtID.setText(tblDrink.getValueAt(row, 0).toString());
        txtCode.setText(tblDrink.getValueAt(row, 0).toString());
        txtName.setText(tblDrink.getValueAt(row, 1).toString());
        txtPrice.setText(tblDrink.getValueAt(row, 2).toString());
        if (tblDrink.getValueAt(row, 3).toString().equals("Còn")) {
            rdo1.setSelected(true);
        }
        if (tblDrink.getValueAt(row, 3).toString().equals("Hết")) {
            rdo0.setSelected(true);
        }
        for (int i = 0; i < cbbKindOfDrink.getItemCount(); i++) {
            if (cbbKindOfDrink.getItemAt(i).getId().equals(((DanhMuc) tblDrink.getValueAt(row, 4)).getId())) {
                cbbKindOfDrink.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < cbbSize.getItemCount(); i++) {
            if (cbbSize.getItemAt(i).getId().equals(((Size) tblDrink.getValueAt(row, 5)).getId())) {
                cbbSize.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tblDrinkMouseClicked

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void txtSearchMaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaKeyPressed
        // TODO add your handling code here:
        String ma = "%"+ txtSearchMa.getText() + "%";
        List<DoUongVM> listSearch = doUongService.getSearchMa(ma);
        loadTable(listSearch);
    }//GEN-LAST:event_txtSearchMaKeyPressed

    private void txtSearchMaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaKeyReleased
        // TODO add your handling code here:
        String ma = "%"+ txtSearchMa.getText() + "%";
        List<DoUongVM> listSearch = doUongService.getSearchMa(ma);
        loadTable(listSearch);
    }//GEN-LAST:event_txtSearchMaKeyReleased

    private void txtSearchMaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaKeyTyped
        // TODO add your handling code here:
        String ma = "%"+ txtSearchMa.getText() + "%";
        List<DoUongVM> listSearch = doUongService.getSearchMa(ma);
        loadTable(listSearch);
    }//GEN-LAST:event_txtSearchMaKeyTyped

    private void txtSearchTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenKeyPressed
        // TODO add your handling code here:
        String ten = "%"+ txtSearchTen.getText() + "%";
        List<DoUongVM> listSearch1 = doUongService.getSearchTen(ten);
        loadTable(listSearch1);
    }//GEN-LAST:event_txtSearchTenKeyPressed

    private void txtSearchTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenKeyReleased
        // TODO add your handling code here:
        String ten = "%"+ txtSearchTen.getText() + "%";
        List<DoUongVM> listSearch1 = doUongService.getSearchTen(ten);
        loadTable(listSearch1);
    }//GEN-LAST:event_txtSearchTenKeyReleased

    private void txtSearchTenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenKeyTyped
        // TODO add your handling code here:
        String ten = "%"+ txtSearchTen.getText() + "%";
        List<DoUongVM> listSearch1 = doUongService.getSearchTen(ten);
        loadTable(listSearch1);
    }//GEN-LAST:event_txtSearchTenKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<DanhMuc> cbbKindOfDrink;
    private javax.swing.JComboBox<Size> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JTable tblDrink;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSearchTen;
    // End of variables declaration//GEN-END:variables
}
