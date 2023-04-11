package view;

import com.sun.mail.imap.ACL;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.ChiTietSanPham;
import model.ThuongHieu;
import model.LoaiSP;
import model.Size;
import reopsitory.ExcelHelper;
import service.QuanLyChatLieu;
import service.QuanLyChiTietSanPham;
import service.QuanLySize;
import service.ServiceImpl.ChiTietSanPhamServiceImpl;
import service.ServiceImpl.ThuongHieuServiceImpl;
import service.ServiceImpl.LoaiSPServiceImpl;
import service.ServiceImpl.SizeServiceImlp;
import service.QuanLyLoaiSP;
import service.QuanLyThuongHieu;
import service.ServiceImpl.ChatLieuServiceImpl;

public class ChiTietSanPhamView extends javax.swing.JFrame {

    private ExcelHelper excelHelper = new ExcelHelper();
    private QuanLyChiTietSanPham ctspS = new ChiTietSanPhamServiceImpl();
    private QuanLySize qlsize = new SizeServiceImlp();
    private QuanLyLoaiSP qlMtt = new LoaiSPServiceImpl();
    private QuanLyThuongHieu qlMs = new ThuongHieuServiceImpl();
    private QuanLyChatLieu qlCL = new ChatLieuServiceImpl();
    DefaultComboBoxModel dcbb_LoaiSP;
    DefaultComboBoxModel dcbb_Size;
    DefaultComboBoxModel dcbb_ThuongHieu;
    DefaultComboBoxModel dcbb_ChatLieu;
    DefaultTableModel dtm;
    ChiTietSanPham ctsp = new ChiTietSanPham();
    private int firtRecordSP = 0, soTrangSP, countSP, tempSP = 1;
    private ArrayList<ChiTietSanPham> listSP = new ArrayList<>();

    public ChiTietSanPhamView() {
        initComponents();
        setLocationRelativeTo(null);
        loadCBBCL();
        loadCBBTH();
        loadCBBLoaiSP();
        loadCBBSize();
        load(firtRecordSP, this.ctspS.getList());
        listSP = ctspS.getList();
        setPageSP(ctspS.getList().size());
        setAnimationSP(tempSP, soTrangSP);
    }

    public void setPageSP(int size) {
        countSP = size;
        if (countSP % 8 == 0) {
            soTrangSP = countSP / 8;
        } else {
            soTrangSP = countSP / 8 + 1;
        }
    }

    public void setAnimationSP(int tempSP, int soTrangSP) {
        lblTrangSP.setText(tempSP + " / " + soTrangSP);
    }

    private void loadCBBLoaiSP() {
        dcbb_LoaiSP = (DefaultComboBoxModel) this.cbbLoaiSP.getModel();
        dcbb_LoaiSP.addAll(qlMtt.getList());
        cbbLoaiSP.setSelectedIndex(0);
    }

    private void loadCBBSize() {
        dcbb_Size = (DefaultComboBoxModel) this.CbbSize.getModel();
        dcbb_Size.addAll(qlsize.getList());
        CbbSize.setSelectedIndex(0);
    }

    private void loadCBBTH() {
        dcbb_ThuongHieu = (DefaultComboBoxModel) this.cbbThuongHieu.getModel();
        dcbb_ThuongHieu.addAll(qlMs.getList());
        cbbThuongHieu.setSelectedIndex(0);
    }

    private void loadCBBCL() {
        dcbb_ChatLieu = (DefaultComboBoxModel) this.CbbCL.getModel();
        dcbb_ChatLieu.addAll(qlCL.getList());
        CbbCL.setSelectedIndex(0);
    }

    private void load(int page, ArrayList<ChiTietSanPham> list) {
        dtm = (DefaultTableModel) this.tblChiTietSP.getModel();
        dtm.setRowCount(0);
        for (int i = page; i < page + 8; i++) {
            try {
                Object[] row = {
                    list.get(i).getId(),
                    list.get(i).getMa(),
                    list.get(i).getTen(),
                    list.get(i).getIdLoaiSP().getTen(),
                    list.get(i).getIdThuongHieu().getTen(),
                    list.get(i).getIdChatLieu().getTen(),
                    list.get(i).getIdSize().getSize(),
                    list.get(i).getSoLuong(),
                    list.get(i).getGia()
                };
                dtm.addRow(row);
            } catch (Exception e) {
                break;
            }
        }
    }

    private ChiTietSanPham getForm() {
        String ma = this.txtMa.getText().trim();
        String ten = this.txtTen.getText().trim();
        if (ma.length() == 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập mã");
            return null;
        }
        int gia;
        int sl;
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa nhập tên");
            return null;
        }
        try {
            gia = Integer.parseInt(txtGia.getText().trim());
            if (gia < 0) {
                JOptionPane.showMessageDialog(this, "Giá không được là số âm");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số");
            return null;
        }
        try {
            sl = Integer.parseInt(txtSoLuong.getText().trim());
            if (sl < 0) {
                JOptionPane.showMessageDialog(this, "số lượng không được là số âm");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "số lượng phải là số");
            return null;
        }
        return new ChiTietSanPham(null, ma, ten, (LoaiSP) cbbLoaiSP.getSelectedItem(), (ThuongHieu) cbbThuongHieu.getSelectedItem(), (ChatLieu) CbbCL.getSelectedItem(), (Size) CbbSize.getSelectedItem(), 1, gia, sl, null, null);
    }

    private void clear() {
        this.txtID.setText("");
        this.txtTen.setText("");
        this.txtMa.setText("");
        this.txtGia.setText("");
        this.txtSoLuong.setText("");
        this.cbbThuongHieu.setSelectedIndex(0);
        this.CbbSize.setSelectedIndex(0);
        this.cbbLoaiSP.setSelectedIndex(0);
        this.CbbCL.setSelectedIndex(0);
    }

    private void loadData(int row) {
        dcbb_LoaiSP = (DefaultComboBoxModel) this.cbbLoaiSP.getModel();
        dcbb_Size = (DefaultComboBoxModel) this.CbbSize.getModel();
        dcbb_ThuongHieu = (DefaultComboBoxModel) this.cbbThuongHieu.getModel();
        dcbb_ChatLieu = (DefaultComboBoxModel) this.CbbCL.getModel();
        
        txtID.setText(tblChiTietSP.getValueAt(row, 0).toString());
        txtMa.setText(tblChiTietSP.getValueAt(row, 1).toString());
        txtTen.setText(tblChiTietSP.getValueAt(row, 2).toString());
        dcbb_LoaiSP.setSelectedItem(tblChiTietSP.getValueAt(row, 3));
        dcbb_ThuongHieu.setSelectedItem(tblChiTietSP.getValueAt(row, 4));
        dcbb_ChatLieu.setSelectedItem(tblChiTietSP.getValueAt(row, 5));
        dcbb_Size.setSelectedItem(tblChiTietSP.getValueAt(row, 6));
        txtSoLuong.setText(tblChiTietSP.getValueAt(row, 7).toString());
        txtGia.setText(tblChiTietSP.getValueAt(row, 8).toString());
        
        CbbSize.setSelectedItem(tblChiTietSP.getValueAt(row, 6));
        CbbCL.setSelectedItem(tblChiTietSP.getValueAt(row,5));
        cbbThuongHieu.setSelectedItem(tblChiTietSP.getValueAt(row, 4));
        cbbLoaiSP.setSelectedItem(tblChiTietSP.getValueAt(row, 3));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        CbbSize = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnTienSP = new javax.swing.JButton();
        lblTrangSP = new javax.swing.JLabel();
        btnLuiSP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CbbCL = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Quản Lý Sản Phẩm");

        jLabel2.setText("ID :");

        jLabel3.setText("Mã :");

        jLabel4.setText("Loại SP");

        jLabel5.setText("Thương Hiêu");

        jLabel6.setText("Size :");

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên", "Loại SP", "Thuong hiệu", "Chất Liêu", "Size", "Số Lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSP);

        txtID.setEditable(false);

        cbbThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThuongHieuActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 255, 102));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(0, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 0, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel7.setText("Giá :");

        jLabel8.setText("Số Lượng:");

        btnTienSP.setText(">");
        btnTienSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienSPActionPerformed(evt);
            }
        });

        lblTrangSP.setText("0/0");

        btnLuiSP.setText("<");
        btnLuiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiSPActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Xuất File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên :");

        jLabel10.setText("Chất Liêu");

        CbbCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbCLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbbLoaiSP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbThuongHieu, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE)
                                            .addComponent(CbbCL, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(CbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnLuiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTrangSP)
                                .addGap(18, 18, 18)
                                .addComponent(btnTienSP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton1)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnClear))
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuiSP)
                            .addComponent(btnTienSP)
                            .addComponent(lblTrangSP)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CbbCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChiTietSanPham ct = this.getForm();
        if (ct == null) {
            return;
        }
        for (String string : this.ctspS.selectMa()) {
            if (this.txtMa.getText().equals(string)) {
                JOptionPane.showMessageDialog(this, "Trùng mã");
                return;
            }
        }
        this.ctspS.insert(ct);
        JOptionPane.showMessageDialog(this, "thêm thành công");
        load(firtRecordSP, this.ctspS.getList());
        clear();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn sửa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }
        ChiTietSanPham ct = this.getForm();
        if (ct == null) {
            return;
        }

        this.ctspS.update(ct, Integer.valueOf(txtID.getText()));
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        load(firtRecordSP, this.ctspS.getList());
        clear();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "bạn chăc chắn muốn xóa?");
        if (c != JOptionPane.OK_OPTION) {
            return;
        }

        this.ctspS.delete(Integer.valueOf(txtID.getText()));
        JOptionPane.showMessageDialog(this, "xóa thành công");
        load(firtRecordSP, this.ctspS.getList());
        clear();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        int row = this.tblChiTietSP.getSelectedRow();
        loadData(row);
    }//GEN-LAST:event_tblChiTietSPMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTienSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienSPActionPerformed
        firtRecordSP += 8;
        tempSP++;
        if (firtRecordSP <= countSP) {
            load(firtRecordSP, listSP);
            setAnimationSP(tempSP, soTrangSP);
        } else {
            if (countSP % 8 == 0) {
                firtRecordSP = countSP - 8;
            } else {
                firtRecordSP = countSP - (countSP % 8);
            }
            tempSP = soTrangSP;
        }
    }//GEN-LAST:event_btnTienSPActionPerformed

    private void btnLuiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiSPActionPerformed
        firtRecordSP -= 8;
        tempSP--;
        if (firtRecordSP >= 0) {
            load(firtRecordSP, listSP);
            setAnimationSP(tempSP, soTrangSP);
        } else {
            firtRecordSP = 0;
            tempSP = 1;
        }
    }//GEN-LAST:event_btnLuiSPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn Muốn Xuất File ?");
        if (choose == JOptionPane.YES_OPTION) {
            JFileChooser Excel = new JFileChooser();
            Excel.setDialogTitle("SAVE AS");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx");
            Excel.setFileFilter(fnef);
            int ex = Excel.showSaveDialog(null);
            if (ex == JFileChooser.APPROVE_OPTION) {
                excelHelper.writeFileExcel(ctspS.getList(), Excel);
                JOptionPane.showMessageDialog(rootPane, "Xuất thành công !");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Hủy Xuất File !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThuongHieuActionPerformed

    private void CbbCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbCLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbCLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietSanPhamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbCL;
    private javax.swing.JComboBox<String> CbbSize;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLuiSP;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTienSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTrangSP;
    private javax.swing.JTable tblChiTietSP;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
