/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Thuong Nguyen
 */
public class TaiKhoan {
    private String user;
    private String password;

    public TaiKhoan(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public TaiKhoan() {
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
