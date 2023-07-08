/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import POJO.LoaiMon;

/**
 *
 * @author Thuong Nguyen
 */
public class LoaiMonDAO {

    public static ArrayList<LoaiMon> loadLoai() {
        ArrayList<LoaiMon> dsLM = new ArrayList<>();
        try {
            String sql = "SELECT * FROM LOAIMONAN";
            ConnectionDB cnn = new ConnectionDB();
            cnn.getCn();
            ResultSet resultSet = cnn.executeQuery(sql);
            while (resultSet.next()) {
                LoaiMon l = new LoaiMon(resultSet.getInt("MALOAI"), resultSet.getString("TENLOAI"));
                dsLM.add(l);
            }
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLM;
    }
}
