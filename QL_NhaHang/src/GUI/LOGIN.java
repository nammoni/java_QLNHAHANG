/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tuan
 */
public class LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
      private String data;
      private String mk;
    private Connection cn;
    public void setTaikhoan(String data)
    {
        this.data= data;
         this.txtTK.setText(data);
    }
    public void stmatkhau(String mk)
    {
        this.mk= mk;
         this.txtPass.setText(mk);
        
    }
    public LOGIN() {

        initComponents();
        this.data= data;
        this.txtTK.setText(DOIMATKHAU.data);
         this.mk= mk;
         this.txtPass.setText(DOIMATKHAU.mk);

    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
        
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDn1 = new javax.swing.JButton();
        btnDk = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        check1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG NHẬP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Restaurant Ven");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tài Khoản");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mật Khẩu");

        btnDn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDn1.setText("Đăng Nhập");
        btnDn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDn1ActionPerformed(evt);
            }
        });

        btnDk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDk.setText("Đổi mật khẩu");
        btnDk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDkActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone: 0372113742");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mail:nguyenminhtuan281203@gmail.com");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address:140 Lê Trọng Tấn, Tân Phú TPHCM");

        txtTK.setBackground(new java.awt.Color(0, 0, 0));
        txtTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTK.setForeground(new java.awt.Color(255, 255, 255));

        txtPass.setBackground(new java.awt.Color(0, 0, 0));
        txtPass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));

        check1.setBackground(new java.awt.Color(0, 0, 0));
        check1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        check1.setForeground(new java.awt.Color(255, 255, 255));
        check1.setText("Hiển thị mật khẩu");
        check1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check1MouseClicked(evt);
            }
        });
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(check1)
                            .addComponent(txtTK)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDn1)
                        .addGap(56, 56, 56)
                        .addComponent(btnDk)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(check1)
                .addGap(90, 90, 90)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDk)
                    .addComponent(btnDn1))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 350, 460));

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\A\\DoAnMonHoc\\HinhAnh\\mau-khach-san-5-sao-05-decox-design.jpg")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDn1ActionPerformed
        // TODO add your handling code here:
          try {
            // Kết nối đến cơ sở dữ liệu SQL Server
            String url = "jdbc:sqlserver://SU:1433;databaseName=QLNHAHANG;encrypt=false;trustServerCertificate=true";
            String user = "sa";
            String pass = "123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            // Thực hiện truy vấn để kiểm tra thông tin đăng nhập
            String sql = "SELECT * FROM NHANVIEN WHERE TAIKHOAN = ? AND MATKHAU = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, txtTK.getText().trim());
            stmt.setString(2, txtPass.getText().trim());
            ResultSet rs = stmt.executeQuery();
            //Tiếp tục phần trước, sau khi thực hiện truy vấn để kiểm tra thông tin đăng nhập, bạn có thể xác định quyền truy cập của người dùng dựa trên bảng nhân viên và cho phép truy cập vào các chức năng của hệ thống.
            // Kiểm tra kết quả trả về từ truy vấn
            if (rs.next()) {
                // Nếu thông tin đăng nhập đúng, xác định quyền truy cập của người dùng dựa trên bảng nhân viên
                String quyen = rs.getString("QUYEN");
                if (quyen.equals("admin")) {
                    // Nếu quyền truy cập là ADMIN, hiển thị thông báo đăng nhập thành công và cho phép truy cập vào các chức năng của hệ thống
                    JOptionPane.showMessageDialog(this, "Bạn Đã Đăng Nhập Thành Công");
                    MENU a= new MENU();
                    
                    a.setMaNV(quyen);
                    a.setLocationRelativeTo(null);
                    a.setVisible(true);
                } else if (quyen.equals("user")) {
                    // Nếu quyền truy cập là USER, hiển thịthông báo lỗi và không cho phép truy cập vào các chức năng của hệ thống
                    JOptionPane.showMessageDialog(this, "Quyền của bạn không được đăng nhập!!!!");
                }
            } else {
                // Nếu thông tin đăng nhập sai, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(this, "Đăng Nhập Không Thành Công!! Vui Lòng Xem Lại Tài Khoản Hoặc Pass");
            }

            // Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đăng Nhập Không Thành Công!!");
        }
    

    
    }//GEN-LAST:event_btnDn1ActionPerformed

    private void btnDkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDkActionPerformed
        // TODO add your handling code here:
        DOIMATKHAU a= new DOIMATKHAU();
        a.setLocationRelativeTo(null);
        a.setVisible(true);

    }//GEN-LAST:event_btnDkActionPerformed

    private void check1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_check1MouseClicked

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
        if(check1.isSelected())
        {
            txtPass.setEchoChar((char)0);
        } else {
            txtPass.setEchoChar(('*'));

        }

    }//GEN-LAST:event_check1ActionPerformed

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDk;
    private javax.swing.JButton btnDn1;
    private javax.swing.JCheckBox check1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
