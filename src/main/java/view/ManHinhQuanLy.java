
package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.NguoiDung;

public class ManHinhQuanLy extends javax.swing.JFrame {
    private NguoiDung ng;
    public ManHinhQuanLy() {
        initComponents();
    }
    public ManHinhQuanLy(NguoiDung ng) {
        this.ng = ng;
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Màn Hình Quản Lý");
        fillData(ng);     
    }
    public ImageIcon resizeImage(String imgPath) {
        ImageIcon imageIcon = new ImageIcon(imgPath);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    public void fillData(NguoiDung nguoiDung){
        lblCHucVu.setText(nguoiDung.getIdChucVu().toString());
        lblMa.setText(nguoiDung.getMa());
        lblTenNV.setText(nguoiDung.getHoTen());
        lblNgaySinh.setText(nguoiDung.getNgaySinh().toString());
        lblEmai.setText(nguoiDung.getEmail());
        lblDiaChi.setText(nguoiDung.getDiaChi());
        lblAnh.setIcon(resizeImage(nguoiDung.getAnh()));
        lblGT.setText(nguoiDung.getGioiTinh()==1?"Nam":"Nữ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JButton();
        lblMa = new javax.swing.JLabel();
        lblCHucVu = new javax.swing.JLabel();
        lblGT = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblEmai = new javax.swing.JLabel();
        btnDoiMK1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuThuongHieu = new javax.swing.JMenuItem();
        menuSize = new javax.swing.JMenuItem();
        menuLoaiSP = new javax.swing.JMenuItem();
        menuChatLieu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCV = new javax.swing.JMenuItem();
        menuNhanVien = new javax.swing.JMenuItem();
        menuBanHang = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuDoanhThuHangThang = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Mã :");

        jLabel3.setText("Chức Vụ :");

        jLabel4.setText("Ngày Sinh :");

        jLabel5.setText("Địa Chỉ :");

        jLabel6.setText("Email :");

        jLabel7.setText("Giới Tính :");

        btnDoiMK.setText("Đổi Mật Khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        btnDoiMK1.setText("Đăng Xuất");
        btnDoiMK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMK1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCHucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiMK1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel2)
                                                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel3))
                                                    .addComponent(lblCHucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7))
                                            .addComponent(lblGT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(lblEmai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiMK)
                    .addComponent(btnDoiMK1))
                .addGap(19, 19, 19))
        );

        jMenu1.setText("Sản Phẩm");

        menuThuongHieu.setText("Thương hiệu");
        menuThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThuongHieuMouseClicked(evt);
            }
        });
        menuThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThuongHieuActionPerformed(evt);
            }
        });
        jMenu1.add(menuThuongHieu);

        menuSize.setText("Size");
        menuSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSizeMouseClicked(evt);
            }
        });
        menuSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSizeActionPerformed(evt);
            }
        });
        jMenu1.add(menuSize);

        menuLoaiSP.setText("Loại SP");
        menuLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLoaiSPMouseClicked(evt);
            }
        });
        menuLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoaiSPActionPerformed(evt);
            }
        });
        jMenu1.add(menuLoaiSP);

        menuChatLieu.setText("Chất Liệu");
        menuChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChatLieuActionPerformed(evt);
            }
        });
        jMenu1.add(menuChatLieu);

        jMenuItem1.setText("Chi Tiết Sản Phẩm");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Nhân Viên ");

        menuCV.setText("Chức Vụ");
        menuCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCVMouseClicked(evt);
            }
        });
        menuCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCVActionPerformed(evt);
            }
        });
        jMenu2.add(menuCV);

        menuNhanVien.setText("Người Dùng");
        menuNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNhanVienMouseClicked(evt);
            }
        });
        menuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhanVienActionPerformed(evt);
            }
        });
        jMenu2.add(menuNhanVien);

        jMenuBar1.add(jMenu2);

        menuBanHang.setText("Bán Hàng");
        menuBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBanHangMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuBanHang);

        jMenu3.setText("Thống Kê");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        menuDoanhThuHangThang.setText("Doanh Thu Hàng Tháng");
        menuDoanhThuHangThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoanhThuHangThangActionPerformed(evt);
            }
        });
        jMenu3.add(menuDoanhThuHangThang);

        jMenuItem2.setText("Thống Kê");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCVMouseClicked

        new ChucVuView().setVisible(true);
    }//GEN-LAST:event_menuCVMouseClicked

    private void menuNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNhanVienMouseClicked

    }//GEN-LAST:event_menuNhanVienMouseClicked

    private void menuBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBanHangMouseClicked

        new BanHangView(ng).setVisible(true);
        
    }//GEN-LAST:event_menuBanHangMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked

    }//GEN-LAST:event_jMenu3MouseClicked

    private void menuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhanVienActionPerformed
        new NguoiDungView().setVisible(true);
    }//GEN-LAST:event_menuNhanVienActionPerformed

    private void menuCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCVActionPerformed
        new ChucVuView().setVisible(true);
    }//GEN-LAST:event_menuCVActionPerformed

    private void menuDoanhThuHangThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoanhThuHangThangActionPerformed
        DoanhThu dt = new DoanhThu();
        dt.setVisible(true);
    }//GEN-LAST:event_menuDoanhThuHangThangActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ThongKeChiTiet().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnDoiMK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMK1ActionPerformed
        dispose();
        new DangNhapView().setVisible(true);
    }//GEN-LAST:event_btnDoiMK1ActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        dispose();
        new ChangePass().setVisible(true);
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ChiTietSanPhamView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        new ChiTietSanPhamView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void menuLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoaiSPActionPerformed

        new LoaiSPView().setVisible(true);
    }//GEN-LAST:event_menuLoaiSPActionPerformed

    private void menuLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLoaiSPMouseClicked

        new LoaiSPView().setVisible(true);
    }//GEN-LAST:event_menuLoaiSPMouseClicked

    private void menuSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSizeActionPerformed
        // TODO add your handling code here:

        new SizeView().setVisible(true);
    }//GEN-LAST:event_menuSizeActionPerformed

    private void menuSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSizeMouseClicked

        new SizeView().setVisible(true);
    }//GEN-LAST:event_menuSizeMouseClicked

    private void menuThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThuongHieuActionPerformed
        // TODO add your handling code here:

        new ThuongHieuView().setVisible(true);
    }//GEN-LAST:event_menuThuongHieuActionPerformed

    private void menuThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThuongHieuMouseClicked

        new ThuongHieuView().setVisible(true);
    }//GEN-LAST:event_menuThuongHieuMouseClicked

    private void menuChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChatLieuActionPerformed
        // TODO add your handling code here:
        new ChatLieuView().setVisible(true);
    }//GEN-LAST:event_menuChatLieuActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManHinhQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManHinhQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManHinhQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManHinhQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManHinhQuanLy().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnDoiMK1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCHucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmai;
    private javax.swing.JLabel lblGT;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JMenu menuBanHang;
    private javax.swing.JMenuItem menuCV;
    private javax.swing.JMenuItem menuChatLieu;
    private javax.swing.JMenuItem menuDoanhThuHangThang;
    private javax.swing.JMenuItem menuLoaiSP;
    private javax.swing.JMenuItem menuNhanVien;
    private javax.swing.JMenuItem menuSize;
    private javax.swing.JMenuItem menuThuongHieu;
    // End of variables declaration//GEN-END:variables
}
