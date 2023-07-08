/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thuong Nguyen
 */
public class TaiKhoanDAO {
    public static boolean kiemTraDangNhap(String user, String pass) {
        boolean kq = false;
        try {
            String sql = String.format("SELECT * FROM NhanVien WHERE TAIKHOAN = '%s' AND MATKHAU = '%s'", user, pass);
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    public static String getMaNV(String user) {
        try {
            ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
            String sql = "select MANV from NHANVIEN WHERE TAIKHOAN ='" + user + "'";
            ResultSet resultSet = cnn.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("MANV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
