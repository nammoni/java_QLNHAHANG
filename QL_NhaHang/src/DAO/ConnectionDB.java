/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Thuong Nguyen
 */
public class ConnectionDB {
    Connection cn;

    public Connection getCn() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QlNhaHang;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối csdl thành công");
        } catch (Exception e) {
            System.out.println("Kết nối csdl không thành công");
        }
        return cn;
    }
    
    public void close(){
        try {
            this.cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void open()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://" +
                    "SU;" +
                    "databaseName=QLNHAHANG;" +
                    "encrypt=true;" +
                    "trustServerCertificate=true;" +
                    "user=sa;" +
                    "password=123");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int executeUpdatee(String sql)
    {
        try {
            Statement s = cn.createStatement();
            return s.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean executeUpdate(String sql){
        try {
            Statement statement = cn.createStatement();
            int n = statement.executeUpdate(sql);
            if (n > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean excuteCallable(String sql) {
        try {
            CallableStatement callStatement = cn.prepareCall(sql);
            callStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
