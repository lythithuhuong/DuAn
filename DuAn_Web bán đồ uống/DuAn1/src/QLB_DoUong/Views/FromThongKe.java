/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.Services.Impl.ThongKeServiceImpl;
import QLB_DoUong.Services.ThongKeService;
import QLB_DoUong.ViewModel.ThongkeVM;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUONG DINH
 */
public class FromThongKe extends javax.swing.JPanel {
 private ThongKeService TKService = new ThongKeServiceImpl();
    private DefaultTableModel defaultTableModel;
    private boolean add = false, change = false;
    private boolean leapYear = false, Year = false, Month = false, Day = false;
    private DefaultComboBoxModel dcm;
    /**
     * Creates new form FromThongKe
     */
    public FromThongKe() {
        initComponents();
          loadData1(TKService.getList());
//        sumhd(TKService.Sumhoadon());
        checkYear();

        Refresh();
    }
    
        public void loadData1(ArrayList<ThongkeVM> listtk) {
        int count = 0;

        defaultTableModel = (DefaultTableModel) tableThongke.getModel();
        defaultTableModel.setRowCount(0);
        for (ThongkeVM thongkeVM : listtk) {
            count++;
            //  lblSoHoaDon.setText(String.valueOf(count));
            defaultTableModel.addRow(new Object[]{
                // thongkeVM.getMaHD(),
                thongkeVM.getMaNV(),
                thongkeVM.getNgayban(),
                thongkeVM.getNgayThanhtoan(),
                thongkeVM.getSoluong() * thongkeVM.getDongia(),
                thongkeVM.getSoluong() * thongkeVM.getDongia() * thongkeVM.getPtkhuyenmai(),
                thongkeVM.getSoluong() * thongkeVM.getDongia() - thongkeVM.getSoluong() * thongkeVM.getDongia() * thongkeVM.getPtkhuyenmai()

            });

        }
        lblSoHoaDon.setText(String.valueOf(count));

    }
private void sumhd1(ArrayList<Double> list) {
        for (Double double1 : list) {
            lbldoanhthu1.setText(String.valueOf(double1) + " " + "VND");
        }
    }
//    private void sumhd(ArrayList<Double> list) {
//        for (Double double1 : list) {
//            lblTongDoanhThu.setText(String.valueOf(double1) + " " + "VND");
//        }
//    }

    private void sumhdnam(ArrayList<Double> list) {
        for (Double double1 : list) {
            lbltongtheonam.setText(String.valueOf(double1) + " " + "VND");
        }
    }

    private void sumspthang(ArrayList<Integer> list) {
        for (Integer double1 : list) {
            lblsosp1.setText(String.valueOf(double1));
        }
    }

    private void sumspnam(ArrayList<Integer> list) {
        for (Integer double1 : list) {
            lblsosp2.setText(String.valueOf(double1));
        }
    }
    private void sumspngay(ArrayList<Integer> list) {
        for (Integer double1 : list) {
            lblsosp3.setText(String.valueOf(double1));
        }
    }

    private void sumhdthang(ArrayList<Double> list) {
        for (Double double1 : list) {
            lblthang.setText(String.valueOf(double1) + " " + "VND");
        }
    }

    private void checkYear() {
        if (Double.parseDouble(String.valueOf(cbxYear.getValue())) % 4 == 0 && Double.parseDouble(String.valueOf(cbxYear.getValue())) % 100 != 0 || Double.parseDouble(String.valueOf(cbxYear.getValue())) % 400 == 0) {
            leapYear = true;
        } else {
            leapYear = false;
        }
    }

    private void Refresh() {
        Year = false;
        Month = false;
        Day = false;
       // cbxDay.setEnabled(false);
        cbxMonth.setEnabled(false);
        cbxYear.setEnabled(false);
        cbxMonth.setSelectedIndex(0);
     //   cbxDay.setSelectedIndex(0);
    }
//public void loadDataHoaDonChiTiet(ArrayList<DoUong_HoaDon> listHoaDonChiTiet) {
//        defaultTableModel = (DefaultTableModel) tbl_gioHang1.getModel();
//        defaultTableModel.setRowCount(0);
//        for (DoUong_HoaDon doUong_HoaDon : listHoaDonChiTiet) {
//            defaultTableModel.addRow(new Object[]{
//                doUong_HoaDon.getDoUong().getTenDoUong(),
//                doUong_HoaDon.getSoLuong(),
//                doUong_HoaDon.getDonGia(),
//                doUong_HoaDon.thanhTien(),});
//        }
//    }

    private void checkOption() {
        Refresh();
        if (radXemnam.isSelected()) {
            cbxYear.setEnabled(true);
            Year = true;
        } else if (radXemthang.isSelected()) {
            cbxMonth.setEnabled(true);
            cbxYear.setEnabled(true);
            Month = true;
//        } else if (radXemngay.isSelected()) {
//            cbxDay.setEnabled(true);
//            cbxMonth.setEnabled(true);
//            cbxYear.setEnabled(true);
//            Day = true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongke = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        radXemngay = new javax.swing.JRadioButton();
        radXemthang = new javax.swing.JRadioButton();
        radXemnam = new javax.swing.JRadioButton();
        cbxMonth = new javax.swing.JComboBox<>();
        cbxYear = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        datengaybd = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        datengaykt = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        lblSoHoaDon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltongtheonam = new javax.swing.JLabel();
        lblsosp2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblthang = new javax.swing.JLabel();
        lblsosp1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbldoanhthu1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblsosp3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 700));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tableThongke.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Ngày tạo", "Ngày bán", "Tổng Tiền", "Tổng Tiền Giảm", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThongkeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableThongke);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        radXemngay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radXemngay);
        radXemngay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemngay.setText("Xem theo ngày");
        radXemngay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemngayItemStateChanged(evt);
            }
        });

        radXemthang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radXemthang);
        radXemthang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemthang.setText("Xem theo tháng");
        radXemthang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemthangItemStateChanged(evt);
            }
        });

        radXemnam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radXemnam);
        radXemnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemnam.setText("Xem theo năm");
        radXemnam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemnamItemStateChanged(evt);
            }
        });

        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbxMonthPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbxYear.setEditor(new javax.swing.JSpinner.NumberEditor(cbxYear, "####"));

        jLabel15.setText("Ngày Bắt Đầu");

        datengaybd.setDateFormatString("yyyy-MM-dd");

        jLabel16.setText("Ngày Kết Thúc");

        datengaykt.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radXemthang)
                                    .addComponent(radXemnam))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(datengaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datengaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radXemngay)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radXemthang)
                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radXemnam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radXemngay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(datengaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datengaykt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng Số Hóa Đơn Bán Ra:");

        lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSoHoaDon.setText("0");

        jPanel3.setBackground(new java.awt.Color(228, 245, 194));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Doanh thu theo năm ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tổng tiền: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Số sản phẩm đã bán: ");

        lbltongtheonam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbltongtheonam.setText("0 VND");

        lblsosp2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsosp2.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblsosp2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(lbltongtheonam, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbltongtheonam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblsosp2))
                .addGap(53, 53, 53))
        );

        jPanel4.setBackground(new java.awt.Color(228, 245, 194));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Doanh thu theo tháng ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tổng tiền: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số sản phẩm đã bán: ");

        lblthang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblthang.setText("0 VND");

        lblsosp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsosp1.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblthang, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(lblsosp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addGap(57, 57, 57))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblthang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblsosp1))
                .addGap(57, 57, 57))
        );

        btnFind.setBackground(new java.awt.Color(228, 245, 194));
        btnFind.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/search.png"))); // NOI18N
        btnFind.setText("Tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(228, 245, 194));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/quayLai.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(228, 245, 194));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Doanh thu theo ngày");

        lbldoanhthu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbldoanhthu1.setText("0 VND");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số sản phẩm đã bán:  ");

        lblsosp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsosp3.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(lbldoanhthu1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsosp3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbldoanhthu1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblsosp3))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoHoaDon))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableThongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThongkeMouseClicked
        //        int row =tableThongke.getSelectedRow();
        //        if(row ==-1){
            //            return;
            //        }
        //        String maHD = tableThongke.getValueAt(row, 0).toString();
        //        loadDataHoaDonChiTiet(TKService.timKiemDoUongHoaDon(maHD));
    }//GEN-LAST:event_tableThongkeMouseClicked

    private void radXemngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemngayItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemngayItemStateChanged

    private void radXemthangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemthangItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemthangItemStateChanged

    private void radXemnamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemnamItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemnamItemStateChanged

    private void cbxMonthPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxMonthPopupMenuWillBecomeInvisible
        //        checkYear();
        //        if (Day == true)
        //            addDay();
        //        else
        //            return;
    }//GEN-LAST:event_cbxMonthPopupMenuWillBecomeInvisible

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (radXemnam.isSelected()) {
            int nam = (int) cbxYear.getValue();
            ArrayList<ThongkeVM> listtk = TKService.timkiemnam(nam);
            loadData1(listtk);
            sumhdnam(TKService.Sumhoadonnam(nam));
            sumspnam(TKService.Sumspnam(nam));
        } else if (radXemthang.isSelected()) {
            int nam = (int) cbxYear.getValue();
            String thang = cbxMonth.getSelectedItem().toString();
            ArrayList<ThongkeVM> listtk = TKService.timKiemthang(Integer.parseInt(thang), nam);
            sumhdthang(TKService.Sumhoadonthang(nam, Integer.parseInt(thang)));
            loadData1(listtk);
            sumspthang(TKService.Sumspthang(nam, Integer.parseInt(thang)));
        } else if (radXemngay.isSelected()) {
            String ngaybd = ((JTextField) datengaybd.getDateEditor().getUiComponent()).getText();
            String ngaykt = ((JTextField) datengaykt.getDateEditor().getUiComponent()).getText();
            ArrayList<ThongkeVM> listTk = TKService.timKiemtngay1(ngaybd, ngaykt);
            loadData1(listTk);
            sumhd1(TKService.Sumhoadon(ngaybd, ngaykt));
            sumspngay(TKService.Sumspngay(ngaybd, ngaykt));
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadData1(TKService.getList());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JSpinner cbxYear;
    private com.toedter.calendar.JDateChooser datengaybd;
    private com.toedter.calendar.JDateChooser datengaykt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoHoaDon;
    private javax.swing.JLabel lbldoanhthu1;
    private javax.swing.JLabel lblsosp1;
    private javax.swing.JLabel lblsosp2;
    private javax.swing.JLabel lblsosp3;
    private javax.swing.JLabel lblthang;
    private javax.swing.JLabel lbltongtheonam;
    private javax.swing.JRadioButton radXemnam;
    private javax.swing.JRadioButton radXemngay;
    private javax.swing.JRadioButton radXemthang;
    private javax.swing.JTable tableThongke;
    // End of variables declaration//GEN-END:variables
}
