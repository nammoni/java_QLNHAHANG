/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thuong Nguyen
 */
public class NhanVienDAO {

    public static ArrayList<NhanVien> layDanhSachNhanVien(String keys) {
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        String sql;
        try {
            if (keys.isEmpty()) {
                sql = "SELECT * FROM NHANVIEN nv, BOPHAN bp WHERE nv.MABP = bp.MABP";
            } else {
                sql = "SELECT * FROM NHANVIEN nv, BOPHAN bp WHERE nv.MABP = bp.MABP AND (MANV LIKE N'%" + keys + "%' OR HOTENNV LIKE N'%" + keys + "%' OR TENBP LIKE N'%" + keys + "%')";

            }

            ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
            ResultSet rs = cnn.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MANV"));
                nv.setMaBP(rs.getString("MABP"));
                nv.setHinh(rs.getString("HINH"));
                nv.setHoTen(rs.getString("HOTENNV"));
                nv.setSdt(rs.getString("SDT"));
                nv.setNgaysinh(rs.getString("NGAYSINH"));
                nv.setGioitinh(rs.getString("GIOITINH"));
                nv.setDiachi(rs.getString("DIACHI"));
                nv.setTaikhoan(rs.getString("TAIKHOAN"));
                nv.setMatkhau(rs.getString("MATKHAU"));
                nv.setQuyen(rs.getString("QUYEN"));
                nv.setTenBP(rs.getString("TENBP"));
                dsNV.add(nv);
            }
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNV;
    }

    public static boolean themNhanVien(String maBP, String hinh, String ten, String sdt, String ngaysinh, String gioitinh, String dc, String tk, String mk, String quyen) {
        boolean kq = false;
        String sql = String.format("INSERT INTO NHANVIEN VALUES('%s','%s', N'%s', '%s', '%s', N'%s', N'%s', '%s', '%s', '%s')",
                maBP, hinh, ten, sdt, ngaysinh, gioitinh, dc, tk, mk, quyen);
        ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
        if (cnn.executeUpdate(sql)) {
            kq = true;
        }
        cnn.close();
        return kq;
    }

    public static boolean capnhatNhanVien(NhanVien nv) {
        boolean kq = false;
        String sql = String.format("UPDATE NHANVIEN SET MABP = '%s', HINH=N'%s', "
                + "HOTENNV=N'%s', SDT='%s', NGAYSINH='%s', GIOITINH=N'%s', DIACHI = N'%s', "
                + "TAIKHOAN = '%s', MATKHAU = '%s', QUYEN = '%s' WHERE MANV='%s'", 
                nv.getMaBP(), nv.getHinh(),nv.getHoTen(), nv.getSdt(), 
                nv.getNgaysinh(), nv.getGioitinh(), nv.getDiachi(),nv.getTaikhoan(),
                nv.getMatkhau(), nv.getQuyen(), nv.getMaNV());
        ConnectionDB cnn = new ConnectionDB();
        cnn.getCn();
        if (cnn.executeUpdate(sql)) {
            kq = true;
        }
        cnn.close();
        return kq;
    }

    public static boolean xoaNhanVien(String maNV) {
        boolean kq = false;
        String sql = String.format("DELETE FROM NHANVIEN WHERE MANV ='%s'", maNV);
        ConnectionDB cnn = new ConnectionDB();
        cnn.getCn();
        if (cnn.executeUpdate(sql)) {
            kq = true;
        }
        cnn.close();
        return kq;
    }

    public static String getTenNV(String ma) {
        try {
            ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
            String sql = "SELECT HOTENNV FROM NHANVIEN WHERE MANV='" + ma + "'";
            ResultSet resultSet = cnn.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("HOTENNV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getNhanVienByMa(String tennv) {
        try {
            ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
            String sql = "SELECT * FROM NHANVIEN N, ChiTietDatBan C WHERE N.HOTENNV  = N'" + tennv + "' and C.MaNV = N.MANV";
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
