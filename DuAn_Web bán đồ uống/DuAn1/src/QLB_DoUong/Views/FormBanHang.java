/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.DoUong;
import QLB_DoUong.DomainModels.DoUong_HoaDon;
import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.DomainModels.NhanVien;
import QLB_DoUong.Services.BanHangService;
import QLB_DoUong.Services.DoUong_HoaDonService;
import QLB_DoUong.Services.HoaDonService;
import QLB_DoUong.Services.Impl.BanHangServiceImpl;
import QLB_DoUong.Services.Impl.DoUong_HoaDonServicerIml;
import QLB_DoUong.Services.Impl.HoaDonServiceImpl;
import QLB_DoUong.ViewModel.DoUongVM;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author 0978078602
 */
public class FormBanHang extends javax.swing.JPanel {

    private BanHangService banHangService = new BanHangServiceImpl();
    private DefaultTableModel defaultTableModel;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private DoUong_HoaDonService doUong_HoaDonService = new DoUong_HoaDonServicerIml();

    /**
     * Creates new form FormBanHang
     */
    public FormBanHang() {
        initComponents();
        loadData(banHangService.getList());
        loadDataHoaDon(banHangService.getListHoaDon());
    }

    public void loadData(ArrayList<DoUongVM> listDoUong) {
        defaultTableModel = (DefaultTableModel) tbl_bangSanPham1.getModel();
        defaultTableModel.setRowCount(0);
        for (DoUongVM doUong : listDoUong) {
            defaultTableModel.addRow(new Object[]{
                doUong.getTenDoUong(),
                doUong.getDonGia(),
                doUong.getTrangThai() == 1 ? "Còn" : "Hết",
                doUong.getSize().getTenSize(),
                doUong.getDanhMuc().getTenDanhMuc(),});
        }
    }

    public void loadDataHoaDon(ArrayList<HoaDon> listHoaDon) {
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : listHoaDon) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getMaHoaDon(),
                hoaDon.getNgayTao(),
                hoaDon.getNgayThanhToan(),
                hoaDon.getTinhTrang() == 1 ? "Chờ thanh toán" : "Đã thanh toán",
                hoaDon.getNhanVien().getMaNhanVien(),
                hoaDon.getKhuyenMai().getPhamTramKhuyenMai(), //                hoaDon.getBan().getMaBan(),
            //                hoaDon.getKhuyenMai().getPhamTramKhuyenMai() + "%",
            });
        }

    }

    public void loadDataHoaDonChiTiet(ArrayList<DoUong_HoaDon> listHoaDonChiTiet) {
        defaultTableModel = (DefaultTableModel) tbl_gioHang1.getModel();
        defaultTableModel.setRowCount(0);
        for (DoUong_HoaDon doUong_HoaDon : listHoaDonChiTiet) {
            defaultTableModel.addRow(new Object[]{
                doUong_HoaDon.getDoUong().getTenDoUong(),
                doUong_HoaDon.getSoLuong(),
                doUong_HoaDon.getDonGia(),
                doUong_HoaDon.thanhTien(),});
        }
    }

    private void getSum() {
        float sum = 0;
        for (int i = 0; i < tbl_gioHang1.getRowCount(); i++) {
            float abs = (float) (tbl_gioHang1.getValueAt(i, 3));
            sum = sum + abs;
        }
        txtTongTien.setText(Float.toString(sum));
    }
    private void tienGiamGia(){
        int row = tblHoaDon.getSelectedRow();
        if(row == -1) return ;
        float sum = 0;
        for (int i = 0; i < tbl_gioHang1.getRowCount(); i++) {
            float abs = (float) (tbl_gioHang1.getValueAt(i, 3));
            sum = sum + abs;
        }
        String phanTramGG = tblHoaDon.getValueAt(row, 5).toString();
        float tienGiamGia = sum * Float.parseFloat(phanTramGG);
        txtGiamGia.setText(Float.toString(tienGiamGia));   
    }
    private void tongTienTT(){
        String tongTien = txtTongTien.getText();
        String tienGiamGia = txtGiamGia.getText();
        float tongTienTT = Float.parseFloat(tongTien) - Float.parseFloat(tienGiamGia);
        txtTongTienThanhToan.setText(Float.toString(tongTienTT));
    }
    private void getTienTraKhach() {
        String tienKhachDua = txtTienKhachDua.getText();
        String tongTienTT = txtTongTienThanhToan.getText();
        float tienThua = Float.parseFloat(tienKhachDua) - Float.parseFloat(tongTienTT);
        txtTienThua.setText(Float.toString(tienThua));
    }

    private Date genNgay() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }

    private String genMa(ArrayList<HoaDon> listHoaDon) {
        int count = 1;
        for (HoaDon hoaDon : listHoaDon) {
            count++;
        }
        int ma = count + 1;

        return "HD" + ma;
    }

    public void clearForm() {
        txtMaHoaDon.setText("");
        txtNgayTao.setText("");
        txtMaNV.setText("");
        txtTongTien.setText("");
        txtGiamGia.setText("");
        txtTongTienThanhToan.setText("");
        txtTienKhachDua.setText("");
        

    }
    public String idKhuyenMai(){
        String idKhuyenMai = banHangService.idKhuyenMai() ;
        if(banHangService.idKhuyenMai() == null){
            idKhuyenMai = "0306DD1E-A581-42A1-9E06-F49CC520A156";
        }
        return idKhuyenMai;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_gioHang = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_bangSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        cb_mau = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_gioHang1 = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnCapNhatSoLuong = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnClearForm = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtTongTienThanhToan = new javax.swing.JTextField();
        btnXuatHoaDon = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_bangSanPham1 = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        txt_tenSP1 = new javax.swing.JTextField();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Giảm Giá", "Thành Tiền"
            }
        ));
        jScrollPane4.setViewportView(tbl_gioHang);

        jButton2.setBackground(new java.awt.Color(153, 255, 204));
        jButton2.setText("Xóa");

        jButton3.setBackground(new java.awt.Color(153, 255, 204));
        jButton3.setText("Xóa tất cả");

        jButton4.setBackground(new java.awt.Color(153, 255, 204));
        jButton4.setText("Thêm SL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Mã khách hàng");

        jLabel7.setText("KH01");

        jLabel8.setText("Tên khách hàng");

        jLabel9.setText("Đỗ Anh Tuấn");

        jButton1.setBackground(new java.awt.Color(153, 255, 204));
        jButton1.setText("Chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 204));
        jButton5.setText("Thay đổi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jButton5))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setText("Tổng tiền:");

        jLabel4.setText("Giảm giá:");

        jLabel10.setText("Thanh toán:");

        jLabel11.setText("Tiền khách đưa:");

        jLabel12.setText("Tiền thừa trả khách:");

        jLabel13.setText("HD01");

        jButton6.setBackground(new java.awt.Color(153, 255, 204));
        jButton6.setText("Tạo");

        jLabel14.setText("10.000.000");

        jLabel15.setText("VNĐ");

        jLabel16.setText("120.000");

        jLabel17.setText("VNĐ");

        jLabel18.setText("9.880.000");

        jLabel19.setText("VNĐ");

        jLabel20.setText("VNĐ");

        jLabel21.setText("120.000");

        jLabel22.setText("VNĐ");

        jLabel23.setText("Ghi chú:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jButton7.setBackground(new java.awt.Color(153, 255, 204));
        jButton7.setText("Hủy hóa đơn");

        jButton8.setBackground(new java.awt.Color(153, 255, 204));
        jButton8.setText("Làm mới");

        jButton9.setBackground(new java.awt.Color(153, 255, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("Thanh toán");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(8, 8, 8))
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(78, 78, 78))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(jButton6))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(27, 27, 27)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_bangSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Đơn Giá", "Giảm Giá", "Màu Sắc", "NSX", "Kích Thước", "Trọng Lượng", "Số Lượng"
            }
        ));
        tbl_bangSanPham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_bangSanPhamFocusGained(evt);
            }
        });
        tbl_bangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_bangSanPham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tìm kiếm sản phẩm:");

        txt_tenSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tenSPFocusGained(evt);
            }
        });
        txt_tenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyTyped(evt);
            }
        });

        cb_mau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cb_mau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mauActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Lọc màu sắc:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        setPreferredSize(new java.awt.Dimension(1190, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Ngày tạo", "Ngày TT", "Tình trạng", "Nhân viên", "Khuyến mãi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_gioHang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tbl_gioHang1);

        btnXoa.setBackground(new java.awt.Color(228, 245, 194));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhatSoLuong.setBackground(new java.awt.Color(228, 245, 194));
        btnCapNhatSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/them.png"))); // NOI18N
        btnCapNhatSoLuong.setText("Thêm SL");
        btnCapNhatSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSoLuongActionPerformed(evt);
            }
        });

        btnXoaTatCa.setBackground(new java.awt.Color(228, 245, 194));
        btnXoaTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/xoa.png"))); // NOI18N
        btnXoaTatCa.setText("Xóa tất cả");
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapNhatSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaTatCa)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhatSoLuong)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel28.setText("Mã hóa đơn:");

        jLabel29.setText("Tổng tiền:");

        jLabel30.setText("Giảm giá:");

        jLabel32.setText("Tiền khách đưa:");

        jLabel33.setText("Tiền thừa :");

        btnTaoHoaDon.setBackground(new java.awt.Color(228, 245, 194));
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/them.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel36.setText("VNĐ");

        jLabel38.setText("VNĐ");

        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });
        txtMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyTyped(evt);
            }
        });

        jLabel41.setText("VNĐ");

        jLabel43.setText("VNĐ");

        jLabel44.setText("Ghi chú:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane9.setViewportView(jTextArea2);

        btnClearForm.setBackground(new java.awt.Color(228, 245, 194));
        btnClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/lamMoi.png"))); // NOI18N
        btnClearForm.setText("Làm mới");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(228, 245, 194));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/thanhToan 2.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiamGiaActionPerformed(evt);
            }
        });

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseClicked(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });

        jLabel34.setText("Ngày tạo :");

        jLabel35.setText("Mã NV :");

        jLabel42.setText("VNĐ");

        jLabel25.setText("Tiền phải trả");

        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHoaDon)
                        .addGap(9, 9, 9)
                        .addComponent(btnTaoHoaDon)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTongTien)
                                                .addComponent(txtMaNV)
                                                .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtGiamGia)))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel32)
                                                .addComponent(jLabel25))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTienKhachDua)
                                                .addComponent(txtTongTienThanhToan)
                                                .addComponent(txtTienThua))))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(316, 316, 316)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(btnXuatHoaDon))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(jLabel28)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel36)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel38)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel25)
                    .addComponent(txtTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(31, 31, 31)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatHoaDon)
                    .addComponent(btnClearForm))
                .addGap(9, 9, 9)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đồ uống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_bangSanPham1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Đơn giá", "Trạng thái", "Size", "Danh mục"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bangSanPham1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_bangSanPham1FocusGained(evt);
            }
        });
        tbl_bangSanPham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangSanPham1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbl_bangSanPham1);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("Tìm kiếm sản phẩm:");

        txt_tenSP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tenSP1FocusGained(evt);
            }
        });
        txt_tenSP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tenSP1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tenSP1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tenSP1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(txt_tenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tbl_bangSanPhamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_bangSanPhamFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bangSanPhamFocusGained

    private void tbl_bangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangSanPhamMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tbl_bangSanPhamMouseClicked

    private void txt_tenSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tenSPFocusGained

    }//GEN-LAST:event_txt_tenSPFocusGained

    private void txt_tenSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tenSPKeyPressed

    private void txt_tenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSPKeyReleased

    private void txt_tenSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_tenSPKeyTyped

    private void cb_mauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mauActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cb_mauActionPerformed

    private void tbl_bangSanPham1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_bangSanPham1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bangSanPham1FocusGained

    private void tbl_bangSanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangSanPham1MouseClicked
        int row = tbl_bangSanPham1.getSelectedRow();
        if (row == -1) {
            return;
        }
        if(txtMaHoaDon.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để thêm đồ uống");
            return;
        }
        
        String ten = tbl_bangSanPham1.getValueAt(row, 0).toString();
        String donGia = tbl_bangSanPham1.getValueAt(row, 1).toString();
        String soLuong = JOptionPane.showInputDialog(null, "Số lượng");
        String tinhTrang = tbl_bangSanPham1.getValueAt(row, 2).toString();
        
        if(tinhTrang.equals("Hết")){
            JOptionPane.showMessageDialog(this, "Đồ uống đã hết, vui lòng chọn đồ uống khác");
            return ;
        }
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(banHangService.getByIDMaHD(txtMaHoaDon.getText()));
        DoUong doUong = new DoUong();
        doUong.setId(banHangService.getByIDMaDU(ten));
        DoUong_HoaDon doUong_HoaDon = new DoUong_HoaDon();
        doUong_HoaDon.setHoaDon(hoaDon);
        doUong_HoaDon.setDoUong(doUong);
        doUong_HoaDon.setSoLuong(Integer.parseInt(soLuong));
        doUong_HoaDon.setDonGia(Float.parseFloat(donGia));
        Boolean check = banHangService.check(ten,txtMaHoaDon.getText());
        if (check) {
            JOptionPane.showMessageDialog(this, "Đồ uống đã có ở hóa đơn chi tiết, vui lòng chọn đồ uống khác");
            return;
        } else if (doUong_HoaDonService.add(doUong_HoaDon)) {
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText()));
            getSum();
            tienGiamGia();
            tongTienTT();
            getTienTraKhach();
        }


    }//GEN-LAST:event_tbl_bangSanPham1MouseClicked

    private void txt_tenSP1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tenSP1FocusGained

    }//GEN-LAST:event_txt_tenSP1FocusGained

    private void txt_tenSP1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSP1KeyPressed
        ArrayList<DoUongVM> list = banHangService.timKiemDoUong(txt_tenSP1.getText());
        loadData(list);
        
    }//GEN-LAST:event_txt_tenSP1KeyPressed

    private void txt_tenSP1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSP1KeyReleased

    }//GEN-LAST:event_txt_tenSP1KeyReleased

    private void txt_tenSP1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSP1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSP1KeyTyped

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maHD = tblHoaDon.getValueAt(row, 0).toString();
        loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(maHD));
        txtMaHoaDon.setText(tblHoaDon.getValueAt(row, 0).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 1).toString());
        txtMaNV.setText(tblHoaDon.getValueAt(row, 4).toString());
        getSum();
        tienGiamGia();
        tongTienTT();
        getTienTraKhach();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row1 = tblHoaDon.getSelectedRow();
        if(row1 == -1) return ;
        if(tblHoaDon.getValueAt(row1, 3).equals("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán không được xóa đồ uống");
            return;
        }
        int row = tbl_gioHang1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn đồ uống mà bạn muốn xóa");
            return;
        }
        String tenDoUong = banHangService.getByIDMaDU(tbl_gioHang1.getValueAt(row, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa bản ghi này không");
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Xóa đồ uống thành công");
            doUong_HoaDonService.delete(tenDoUong);
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText()));
            getSum();
            tienGiamGia();
            tongTienTT();
            getTienTraKhach();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSoLuongActionPerformed
        int row1 = tblHoaDon.getSelectedRow();
        if(row1 == -1) return ;
        if(tblHoaDon.getValueAt(row1, 3).equals("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán không được cập nhật số lượng đồ uống");
            return;
        }
        int row = tbl_gioHang1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn cập nhập số lượng");
            return;
        }
        String tenDoUong = banHangService.getByIDMaDU(tbl_gioHang1.getValueAt(row, 0).toString());
        String ten = tbl_bangSanPham1.getValueAt(row, 0).toString();
        String donGia = tbl_bangSanPham1.getValueAt(row, 1).toString();
        String soLuong = JOptionPane.showInputDialog(null, "Số lượng");
        DoUong doUong = new DoUong();
        doUong.setTenDoUong(ten);
        DoUong_HoaDon doUong_HoaDon = new DoUong_HoaDon();
        doUong_HoaDon.setDoUong(doUong);
        doUong_HoaDon.setSoLuong(Integer.parseInt(soLuong));
        doUong_HoaDon.setDonGia(Float.parseFloat(donGia));
        if (Integer.parseInt(soLuong) == 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật số lượng thành công");
            doUong_HoaDonService.delete(tenDoUong);
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText()));
            getSum();
            tongTienTT();
            getTienTraKhach();
        }
        if (doUong_HoaDonService.update(doUong_HoaDon, tenDoUong)) {
            JOptionPane.showMessageDialog(this, "Cập nhật số lượng thành công");
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText()));
            getSum();
            tienGiamGia();
            tongTienTT();
            getTienTraKhach();
        }
    }//GEN-LAST:event_btnCapNhatSoLuongActionPerformed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        getTienTraKhach();
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseClicked

    }//GEN-LAST:event_txtTienKhachDuaMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tblHoaDon.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần thanh toán");
            return ;
        }
        String maHD = "";
        String trangThai = tblHoaDon.getValueAt(row, 3).toString();
        if(txtMaHoaDon.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn trước khi thanh toán");
            return ;
        }
        
        ArrayList<DoUong_HoaDon> list = doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText());
        loadDataHoaDonChiTiet(list);
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đồ uống trước khi thanh toán");
            return ;
        }
        if(trangThai.equals("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán, vui lòng chọn hóa đơn khác");
            return;
        }
        if(txtTienThua.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách đưa trước khi thanh toán");
            return ;
        }
        try {
            Float.parseFloat(txtTienKhachDua.getText());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa phải là số");
            return ;
        }
        if(Float.parseFloat(txtTienKhachDua.getText()) < Float.parseFloat(txtTongTienThanhToan.getText())){
                JOptionPane.showMessageDialog(this, "Tiền khách đưa phải lớn hơn hoặc bằng tổng tiền");
                return ;
            }
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayThanhToan(genNgay());
        hoaDon.setTinhTrang(0);
        if (hoaDonService.update(hoaDon, txtMaHoaDon.getText())) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            JOptionPane.showMessageDialog(this, "Bạn cần trả lại khách" + txtTienThua.getText() +" VNĐ");
            loadDataHoaDon(banHangService.getListHoaDon());
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(maHD));
            loadData(banHangService.getList());
            clearForm();
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setId(idKhuyenMai());
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId("18A9D972-F191-4055-96F3-7E7861371C3E");
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon(genMa(banHangService.getListHoaDon()));
        hoaDon.setNgayTao(genNgay());
        hoaDon.setNgayThanhToan(null);
        hoaDon.setTinhTrang(1);
        hoaDon.setKhuyenMai(khuyenMai);
        hoaDon.setNhanVien(nhanVien);
        txtMaHoaDon.setText(genMa(banHangService.getListHoaDon()));
        txtNgayTao.setText(banHangService.ngayTao(genNgay()));
        txtMaNV.setText(banHangService.maNhanVien("18A9D972-F191-4055-96F3-7E7861371C3E"));
        
        if (hoaDonService.add(hoaDon)) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
            loadDataHoaDon(banHangService.getListHoaDon());
        }
        
        
        

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        getTienTraKhach();
        String tienThua = txtTienThua.getText();
        
        if(tienThua.equals("")){
            txtTienThua.setText("");
        }
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void txtMaHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyPressed
        String idDU = txtMaHoaDon.getText();
        ArrayList<DoUong_HoaDon> listTimKiem = doUong_HoaDonService.timKiemDoUongHoaDon(idDU);
        loadDataHoaDonChiTiet(listTimKiem);
        getSum();
        tienGiamGia();
        tongTienTT();
        getTienTraKhach();
    }//GEN-LAST:event_txtMaHoaDonKeyPressed

    private void txtMaHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyReleased
//        String idDU = txtMaHoaDon.getText();
//        ArrayList<DoUong_HoaDon> listTimKiem = doUong_HoaDonService.timKiemDoUongHoaDon(idDU);
//        loadDataHoaDonChiTiet(listTimKiem);
    }//GEN-LAST:event_txtMaHoaDonKeyReleased

    private void txtMaHoaDonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyTyped
//       String idDU = txtMaHoaDon.getText();
//        ArrayList<DoUong_HoaDon> listTimKiem = doUong_HoaDonService.timKiemDoUongHoaDon(idDU);
//        loadDataHoaDonChiTiet(listTimKiem);
    }//GEN-LAST:event_txtMaHoaDonKeyTyped

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        int row1 = tblHoaDon.getSelectedRow();
        if(row1 == -1) return ;
        if(tblHoaDon.getValueAt(row1, 3).equals("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán không được xóa đồ uống");
            return;
        }
        String maHD = banHangService.getByIDMaHD(txtMaHoaDon.getText());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn tất cả bản ghi không");
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Xóa đồ uống thành công");
            doUong_HoaDonService.deleteTable(maHD);
            loadDataHoaDonChiTiet(doUong_HoaDonService.timKiemDoUongHoaDon(txtMaHoaDon.getText()));
            getSum();
            tienGiamGia();
            tongTienTT();
            getTienTraKhach();
        }
    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void txtGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamGiaActionPerformed

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = j.showSaveDialog(this);
        if(i == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document document = new Document();
       
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "hoadon.pdf"));
            document.open(); 
            PdfPTable table  = new PdfPTable(3) ;
            table.addCell("Mã HĐ");
            table.addCell("Mã NV");
            table.addCell("NgayTao");
            String maHD = txtMaHoaDon.getText();
            String maNV = txtMaNV.getText();
            String ngayTao = txtNgayTao.getText();
            table.addCell(maHD);
            table.addCell(maNV);
            table.addCell(ngayTao);
            document.add(table);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(FormBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
            document.close();
         
        
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSoLuong;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JComboBox<String> cb_mau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tbl_bangSanPham;
    private javax.swing.JTable tbl_bangSanPham1;
    private javax.swing.JTable tbl_gioHang;
    private javax.swing.JTable tbl_gioHang1;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTongTienThanhToan;
    private javax.swing.JTextField txt_tenSP;
    private javax.swing.JTextField txt_tenSP1;
    // End of variables declaration//GEN-END:variables
}
