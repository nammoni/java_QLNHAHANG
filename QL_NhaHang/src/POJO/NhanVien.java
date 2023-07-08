/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Thuong Nguyen
 */
public class NhanVien extends BoPhan{
    private String maNV;
    private String hinh;
    private String hoTen;
    private String sdt;
    private String ngaysinh;
    private String gioitinh;
    private String diachi;
    private String taikhoan;
    private String matkhau;
    private String quyen; 

    public NhanVien(String maNV, String hinh, String hoTen, String sdt, String ngaysinh, String gioitinh, String diachi, String taikhoan, String matkhau, String quyen) {
        this.maNV = maNV;
        this.hinh = hinh;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.quyen = quyen;
    }

    public NhanVien(String maNV, String hinh, String hoTen, String sdt, String ngaysinh, String gioitinh, String diachi, String taikhoan, String matkhau, String quyen, String maBP, String tenBP) {
        super(maBP, tenBP);
        this.maNV = maNV;
        this.hinh = hinh;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.quyen = quyen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public NhanVien() {
    }

    
    
}
