﻿create database QLNhaHang
go
use QLNhaHang
go


CREATE TABLE LOAIMONAN
(
	MALOAI INT IDENTITY(1,1) NOT NULL,
	TENLOAI NVARCHAR(50),
	CONSTRAINT PK_LOAIMONAN PRIMARY KEY(MALOAI)
)

CREATE TABLE MonAn (
    MaMonAn INT IDENTITY(1,1) NOT NULL PRIMARY key,
    TenMonAn NVARCHAR(255),
	HINH NVARCHAR(30),
    DonGia INT CHECK (DONGIA > 0),
	MALOAI int,
	DonViTinh NVARCHAR(255), --Gram, dia, ly,..
    SOLUONG INT CHECK (SOLUONG >= 0),
	MOTA NVARCHAR(150),
	CONSTRAINT FK_MONAN_LOAIMONAN FOREIGN KEY (MALOAI) REFERENCES LOAIMONAN(MALOAI)
);


CREATE TABLE Ban (
    MaBan INT IDENTITY(1,1) NOT NULL,
    TenBan NVARCHAR(255),
    SoGhe INT,
	TrangThai Nvarchar(50),
	CONSTRAINT PK_BANAN PRIMARY KEY (MABAN),
);


CREATE TABLE KHACHHANG (
	MaKhachHang INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	TenKhachHang NVARCHAR(255),
	SDT INT,
	NGSINH DATE
);
CREATE TABLE BOPHAN
(
	MABP INT IDENTITY(1,1) NOT NULL,
	TENBP NVARCHAR (30),
	CHUCNANG NVARCHAR (30),
	CONSTRAINT PK_BOPHAN PRIMARY KEY (MABP)
)


CREATE TABLE NHANVIEN (
	MANV INT IDENTITY(1,1) NOT NULL,
	MABP INT NOT NULL,
	HINH NVARCHAR(30),
	HOTENNV NVARCHAR(30),
	SDT NCHAR (10),
	NGAYSINH  DATE,
	GIOITINH NVARCHAR (3) CHECK(GIOITINH = N'Nam' OR GIOITINH = N'Nữ') DEFAULT 'Nam',
	DIACHI NVARCHAR(30),
	TAIKHOAN Char(10),
	MATKHAU NVARCHAR (20),
	QUYEN NVARCHAR(20),
	CONSTRAINT PK_NHANVIEN PRIMARY KEY (MANV),
	CONSTRAINT FK_NHANVIEN_BOPHAN FOREIGN KEY (MABP) REFERENCES BOPHAN(MABP)

);

CREATE TABLE DatBan (
    MaDatBan INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaBan int,
	MaNV int,
    ThoiGian TIME,
	MaKhachHang int,
	SoLuongKhach int,
	TinhTrang nvarchar(50),
	TONGTIEN FLOAT CHECK (TONGTIEN > 0),
    CONSTRAINT FK_DatBan_Ban FOREIGN KEY (MaBan) REFERENCES Ban(MaBan),
	CONSTRAINT FK_KHACHHANG_DATBan FOREIGN KEY (MaKhachHang) REFERENCES KHACHHANG(MaKhachHang),
	CONSTRAINT FK_DatBan_NhanVien FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV)
);

CREATE TABLE HOADON
(
	MAHD int IDENTITY(1,1) NOT NULL ,
	MANV int NOT NULL,
	MaKhachHang int NOT NULL,
	NGAYTHANHTOAN DATE,
	TRANGTHAI NVARCHAR (30),
	TONGTIEN FLOAT CHECK (TONGTIEN > 0),
	CONSTRAINT PK_HOADON PRIMARY KEY (MAHD),
	CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MaKhachHang) REFERENCES KHACHHANG(MaKhachHang),
	CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)

CREATE TABLE CHITIETHOADON
(
	MAHD INT NOT NULL,
	MAMONAN INT NOT NULL,
	SOLUONG INT CHECK(SOLUONG > 0),
	CONSTRAINT PK_CHITIETHOADON PRIMARY KEY (MAHD, MAMONAN),
	CONSTRAINT FK_CHITIETHOADON_HOADON FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD),
	CONSTRAINT FK_CHITIETHOADON_MONAN FOREIGN KEY (MAMONAN) REFERENCES MONAN(MaMonAn)
)

--Mỗi đặt bàn phải có ít nhất một món ăn được đặt.
CREATE TABLE ChiTietDatBan (
  MaDatBan int,
  MaBan int NOT NULL,
  MaNV int NOT NULL,
  MaMonAn int NOT NULL,
  SOLUONG INT CHECK (SOLUONG > 0),
  
  CONSTRAINT FK_CTDatBan_DatBan FOREIGN KEY (MaBan) REFERENCES Ban(MaBan),
  CONSTRAINT FK_CTDatBan_MonAn FOREIGN KEY (MaMonAn) REFERENCES MonAn(MaMonAn),
  CONSTRAINT FK_CTDatBan_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
);

CREATE TABLE Phong (
	MaPhong int identity(1,1) PRIMARY KEY,
	TenPhong NVARCHAR(255),
	SoLuongKhachToiDa int,
	DonGiaThue Float,
	TrangThai Nvarchar(50)
);


CREATE TABLE DatPhong(
	MaDatPhong int identity(1,1) Primary key,
	MaPhong int,
	MaNV int,
	ThoiGian DATE,
    MaKhachHang int,
	SoLuongKhach int,
	SDT INT,
    CONSTRAINT FK_DatPhong_Phong FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
	CONSTRAINT FK_DatPhong_Khachhang FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
	CONSTRAINT FK_DatPhong_NhanVien FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV)
);

--Mỗi đặt phòng phải có ít nhất một món ăn được đặt.
CREATE TABLE ChiTietDatPhong (
  MaDatPhong int NOT NULL,
  MaMonAn int NOT NULL,
  SoLuong INT NOT NULL,
  PRIMARY KEY (MaDatPhong, MaMonAn),
  FOREIGN KEY (MaDatPhong) REFERENCES DatPhong(MaDatPhong),
  FOREIGN KEY (MaMonAn) REFERENCES MonAn(MaMonAn)
);


CREATE TABLE NguyenLieu (
    MaNguyenLieu int identity(1,1) PRIMARY KEY,
    TenNguyenLieu NVARCHAR(255),
	DonViTinh NVARCHAR(255), -- GRAM, KG, LIT,...
    SoLuong INT
);

--Bảng trung gian này được sử dụng để lưu trữ thông tin về nguyên liệu cần dùng để chế biến món ăn
--Mỗi món ăn có thể sử dụng nhiều nguyên liệu.
CREATE TABLE MonAn_NguyenLieu (
    MaMonAn int,
    MaNguyenLieu int,
    SoLuong INT,
    PRIMARY KEY (MaMonAn, MaNguyenLieu),
    FOREIGN KEY (MaMonAn) REFERENCES MonAn(MaMonAn),
    FOREIGN KEY (MaNguyenLieu) REFERENCES NguyenLieu(MaNguyenLieu)
);

--Mỗi nhập kho áp dụng cho một nguyên liệu.
CREATE TABLE PhieuNhapKho (
    MaPhieuNhap int identity(1,1) PRIMARY KEY,
    NgayNhap DATE,
    TongTien INT
);


CREATE TABLE ChiTietPhieuNhap (
    MaPhieuNhap int,
    MaNguyenLieu int,
    SoLuong INT,
    DonGia int,
    PRIMARY KEY (MaPhieuNhap, MaNguyenLieu),
    FOREIGN KEY (MaPhieuNhap) REFERENCES PhieuNhapKho(MaPhieuNhap),
    FOREIGN KEY (MaNguyenLieu) REFERENCES NguyenLieu(MaNguyenLieu)
);

--Mỗi xuất kho áp dụng cho một nguyên liệu.
CREATE TABLE PhieuXuatKho (
    MaPhieuXuat int identity(1,1) PRIMARY KEY,
    NgayXuat DATE,
    TongTien INT
);


CREATE TABLE ChiTietPhieuXuat (
    MaPhieuXuat int,
    MaNguyenLieu int,
    SoLuong INT,
    DonGia INT,
    PRIMARY KEY (MaPhieuXuat, MaNguyenLieu),
    FOREIGN KEY (MaPhieuXuat) REFERENCES PhieuXuatKho(MaPhieuXuat),
    FOREIGN KEY (MaNguyenLieu) REFERENCES NguyenLieu(MaNguyenLieu)
);


CREATE TABLE CALAMVIEC
(
	MACA INT IDENTITY(1,1) NOT NULL,
	TENCA NVARCHAR (30),
	GIOBD VARCHAR (30),
	GIOKT VARCHAR (30),
	CONSTRAINT PK_CALAMVIEC PRIMARY KEY (MACA),
)

CREATE TABLE NHANVIENCA
(
	MANV int NOT NULL,
	MACA INT NOT NULL,
	CONSTRAINT PK_NHANVIENCA PRIMARY KEY (MANV, MACA),
	CONSTRAINT FK_NHANVIENCA_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
	CONSTRAINT FK_NHANVIENCA_CALAMVIEC FOREIGN KEY (MACA) REFERENCES CALAMVIEC(MACA)
)


INSERT INTO LOAIMONAN
VALUES
(N'MÓN CHÍNH'), 
(N'MÓN PHỤ'),
(N'TRÁNG MIỆNG')

INSERT INTO MonAn
VALUES
(N'THỊT KHO TÀU', 'thitkhotau.jpg', 70000, '1', N'ĐĨA', 10, N'Thịt heo béo ngậy nấu cùng với trứng cút kết hợp với nước dừa ngọt thanh'),
(N'NUI XÀO', 'nuixao.jpg', 45000, '2', N'ĐĨA', 20, N'Nui được nấu cùng với thịt băm kết hợp với nước xốt cà chua và hành tây'),
(N'MÌ SPAGHETTI', 'mispagetti.jpg', 50000, '2', N'ĐĨA', 15, N'Mì được nấu cùng với thịt băm kết hợp với nước xốt cà chua và hành tây'),
(N'THỊT XÀO CHUA NGỌT', 'thitxaochuangot.jpg', 90000, '1', N'ĐĨA', 20, N'Thịt được xào với cà chua được tẩm ướp chua ngọt'),
(N'BÁNH XÈO', 'banhxeo.jpg', 35000, '2', N'ĐĨA', 30, N'Bánh được nấu với nhân giá đỗ, thịt heo, tôm và hành tây'),
(N'PHỞ BÒ', 'phobo.jpg', 35000, '1', N'TÔ', 20, N'Nước phở được nấu từ nước cốt thịt heo, những sợi phở được hòa quyện với thịt bò dai thơm ngon'),
(N'TÔM HÙM ALASKA', 'tomhum.jpg', 200000, '1', N'ĐĨA', 5, N'Mắc tiền chỉ đại gia mới ăn được'),
(N'TRÀ SỮA', 'trasua.jpg', 30000, '3', N'LY', 30, N'Trà được pha với sữa, kết hợp với các loại thạch và trân châu'),
(N'CHÈ THÁI', 'chethai.jpg', 20000, '3', N'CHÉN', 40, N'Chè với các loại topping trái cây ăn kèm theo')



INSERT INTO Ban
VALUES
( N'BÀN 1', 10, N'CÒN TRỐNG'),
(N'BÀN 2', 20, N'ĐỦ CHỖ'),
(N'BÀN 3', 20, N'CÒN TRỐNG'),
(N'BÀN 4', 15, N'ĐỦ CHỖ'),
(N'BÀN 5', 10, N'ĐỦ CHỖ'),
(N'BÀN 6', 15, N'CÒN TRỐNG'),
(N'BÀN 7', 15, N'ĐỦ CHỖ'),
(N'BÀN 8', 20, N'CÒN TRỐNG')

INSERT INTO BOPHAN VALUES
(N'Quản Lý', N'Quản lý nhà hàng'),
(N'Phục vụ', N'Bưng dọn đồ ăn'),
(N'Kế toán', N'Thanh toán tiền'),
(N'Bảo vệ', N'Giữ xe'),
(N'Nhân sự', N'Tuyển và kiểm soát nhân viên'),
(N'Lao công', N'Quét dọn'),
(N'Đầu bếp', N'Chế biến món ăn')

SET DATEFORMAT DMY
INSERT INTO NHANVIEN VALUES
('1','Anh1.jpg', N'TRẦN THANH NAM', '0919567327', '12/02/2000', N'Nam', N'TP.HCM', 'Admin123', 'Nam123', 'admin'),
('1','Anh2.jpg', N'BÙI LÊ THANH NGÂN', '0123445786', '19/08/2001', N'Nữ', N'Long An', 'Admin234', 'Ngan123', 'admin'),
('1','Anh3.jpg', N'NGUYỄN MINH TUẤN', '0871254638', '27/11/1998', N'Nam', N'Bình Phước', 'Admin345', 'Tung123', 'admin'),
('1','Anh4.jpg', N'NGUYỄN THỊ THƯƠNG', '0912325610', '08/03/2002', N'Nữ', N'Lâm Đồng', 'Admin168', 'Su123', 'admin'),
('2','Anh5.jpg', N'PHẠM TRẦN BẢO NHI', '0123789254', '02/12/1999', N'Nữ', N'TP.HCM', 'User123', 'Nhi123', 'user'),
('3','Anh6.jpg', N'NGUYỄN NGỌC PHÚC', '0264873920', '14/09/1997', N'Nam', N'Phú Yên', 'User234', 'Phuc123', 'user'),
('4','Anh7.jpg', N'DƯƠNG HUỲNH MAI LINH', '0127592530', '27/06/1999', N'Nữ', N'TP.HCM', 'User345', 'Linh123', 'user'),
('5','Anh8.jpg', N'MAI NGUYỄN NHƯ TIÊN', '0897645327', '17/05/2000', N'Nữ', N'Bạc Liêu', 'User456', 'Tien123', 'user'),
('5','Anh9.jpg', N'TỐNG THÀNH LÂM', '0546378924', '24/11/1996', N'Nam', N'Hải Phòng', 'User567', 'Lam123', 'user'),
('6','Anh10.jpg', N'ĐINH VÃN MAI ANH', '0164728940', '09/03/1998', N'Nữ', N'TP.HCM', 'User678', 'Anh123', 'user'),
('5','Anh11.jpg', N'MAI MINH LONG', '0987564537', '13/03/1990', N'Nam', N'TP.HCM', 'User789', 'Long123', 'user'),
('6','Anh12.jpg', N'LÊ HUỲNH KHÁNH NHÂN', '0945367128', '07/09/1993', N'Nam', N'TP.HCM', 'User890', 'Nhan123', 'user'),
('3','Anh13.jpg', N'MAI TỐ BẢO NGỌC', '0174635286', '27/11/1987', N'Nữ', N'TP.HCM', 'User135', 'Ngoc123', 'user')


SET DATEFORMAT DMY
INSERT INTO KHACHHANG
VALUES
(N'NGUYỄN ĐỨC AN', 0357291857, '22/10/2000'),
(N'TRẦN PHẠM MAI ANH', 0385618732, '12/12/2001'),
(N'LÊ THANH PHONG', 0357291857, '02/02/1992'),
(N'NGUYỄN CAO QUÝ', 0357291857, '26/03/1996'),
(N'NGUYỄN MAI PHƯƠNG', 0357291857, '14/11/2001'),
(N'HUỲNH TRÚC LIÊN', 0357291857, '12/02/1998'),
(N'TRẦN ĐỨC QUÝ', 0357291857, '02/11/2002'),
(N'NGUYỄN THÀNH ĐẠT', 0357291857, '25/07/2001')

INSERT INTO DatBan
VALUES
('1', '2', '09:05:34', '2', 10, N'ĐÃ THANH TOÁN',450000),
('8', '4', '16:08:02', '1', 1, N'ĐÃ THANH TOÁN', 1500000),
('2', '4', '10:56:44', '1', 10, N'CHƯA THANH TOÁN', 780000),
('4', '3', '14:43:22', '8', 20, N'ĐÃ THANH TOÁN', 560000),
('3', '1', '13:10:21', '6', 15, N'CHƯA THANH TOÁN', 2403000),
('6', '2', '21:10:00', '5', 10, N'ĐÃ THANH TOÁN', 320000),
('5', '3', '12:55:12', '3', 20, N'CHƯA THANH TOÁN', 400000),
('2', '1', '17:56:32', '7', 10, N'ĐÃ THANH TOÁN', 829000)


INSERT INTO ChiTietDatBan
VALUES
('1','1', '3', '2', 4),
('4','4', '4', '1', 4),
('2','2', '1', '6', 1),
('4','5', '2', '2', 6),
('3','5', '4', '2', 4),
('6','3', '2', '4', 9)


--('BAN008', 'NV003', 'MA003', 7),
--('DB00','BAN005', 'NV001', 'MA005', 3),
--('','BAN001', 'NV004', 'MA001', 4),
--('','BAN005', 'NV002', 'MA006', 5),
--('','BAN004', 'NV004', 'MA006', 6),
--('','BAN007', 'NV004', 'MA002', 5),
--('BAN008', 'NV001', 'MA004', 2),
--('','BAN003', 'NV002', 'MA003', 3),
--('','BAN001', 'NV003', 'MA005', 4)


INSERT INTO Phong
VALUES
(N'PHÒNG 1', 4, 250000, N'HẾT PHÒNG'),
(N'PHÒNG 2', 2, 450000, N'CÒN PHÒNG'),
(N'PHÒNG 3', 7, 350000, N'HẾT PHÒNG'),
(N'PHÒNG 4', 1, 250000, N'HẾT PHÒNG'),
(N'PHÒNG 5', 2, 250000, N'CÒN PHÒNG'),
(N'PHÒNG 6', 4, 350000, N'HẾT PHÒNG'),
(N'PHÒNG 7', 5, 450000, N'HẾT PHÒNG'),
(N'PHÒNG 8', 4, 550000, N'CÒN PHÒNG')



INSERT INTO DatPhong
VALUES
('3', '3', '12:05:11', '7', 6, 0348275618),
('1', '1', '17:10:21', '4', 4, 0947164824),
('4', '4', '13:05:22', '1', 1, 0311774683),
('6', '3', '17:05:16', '6', 7, 0345678912),
('7', '2', '20:05:05', '3', 4, 0987654321),
('3', '1', '09:05:28', '5', 5, 0346483795),
('4', '2', '16:34:50', '8', 1, 0395533676)



INSERT INTO ChiTietDatPhong
VALUES
('1', '4', 6),
('2', '8', 4),
('4', '3', 5),
('2', '6', 6),
('6', '5', 4),
('7', '1', 2),
('5', '2', 3),
('3', '8', 1),
('1', '3', 5),
('3', '6', 1),
('5', '5', 4),
('3', '1', 2),
('6', '2', 3)

INSERT INTO NguyenLieu
VALUES
( N'NUI', N'BỊCH', 10),
( N'HÀNH TÂY', 'KG', 5),
(N'THỊT BĂM', 'KG', 7),
(N'CÀ CHUA', 'KG', 12),
(N'THỊT HEO', 'KG', 6),
(N'TRỨNG CÚT', 'KG', 4),
(N'MÌ', 'GRAM', 5),
(N'BỘT GẠO', 'GRAM', 5),
(N'BỘT NGHỆ', 'GRAM', 2),
(N'TÔM', 'KG', 4),
(N'GIÁ ĐỖ', 'GRAM', 5),
(N'MUỐI', 'GRAM', 7),
(N'ĐƯỜNG', 'GRAM', 5),
(N'HẠT NÊM', 'GRAM', 2),
(N'HÀNH LÁ', 'GRAM', 6),
(N'BÒ', 'GRAM', 10),
(N'TÔM HÙM ALASKA', 'CON', 10),
(N'TRÀ', N'HỘP', 5),
(N'SỮA TƯƠI', N'LÍT', 10),
(N'TRÂN CHÂU', 'GRAM', 10),
(N'THẠCH', 'GRAM', 10),
(N'MÍT', 'KG', 3),
(N'NHÃN', 'KG', 4),
(N'XOÀI', 'KG', 6),
(N'BỘT RAU CÂU', N'BỊCH', 7),
(N'BỘT CỐT DỪA', N'BỊCH', 10),
(N'THẠCH DỪA', 'LON', 4),
(N'PHỞ', 'KG', 6)

INSERT INTO MonAn_NguyenLieu
VALUES
('1', '5', 2),
('1', '6', 4),
('1', '12', 2),
('1', '13', 2),
('1', '14', 2),
('1', '15', 3),
('2', '1', 3),
('2', '2', 4),
('2', '3', 6),
('2', '4', 6),
('2', '12', 2),
('2', '13', 2),
('2', '14', 2),
('3', '7', 2),
('3', '3', 5),
('3', '4', 7),
('3', '12', 2),
('3', '13', 2),
('3', '14', 2),
('4', '5', 4),
('4', '12', 2),
('4', '13', 2),
('4', '14', 2),
('4', '15', 3),
('5', '8', 3),
('5', '9', 1),
('5', '10', 3),
('5', '11', 3),
('5', '12', 2),
('5', '13', 2),
('5', '14', 2),
('5', '15', 3),
('5', '5', 5),
('6', '16', 2),
('6', '28', 5),
('6', '12', 2),
('6', '13', 3),
('6', '14', 2),
('6', '15', 2),
('7', '17', 8),
('8', '18', 3),
('8', '19', 8),
('8', '20', 9),
('8', '21', 9),
('8', '13', 3),
('9', '19', 8),
('9', '22', 2),
('9', '23', 2),
('9', '24', 2),
('9', '25', 4),
('9', '26', 8),
('9', '27', 3),
('9', '13', 3)

INSERT INTO PhieuNhapKho
VALUES
('20/09/2017', NULL),
('24/07/2015', NULL),
('15/04/2018', NULL),
('02/01/2014', NULL),
('14/10/2020', NULL),
('09/05/2021', NULL),
('23/03/2020', NULL),
('11/05/2019', NULL),
('05/12/2016', NULL),
('25/10/2017', NULL)

INSERT INTO ChiTietPhieuNhap
VALUES
('1', '2', 5, 75000),
('2', '11', 10, 75000),
('3', '22', 12, 50000),
('4', '8', 19, 95000),
('5', '6', 13, 55000),
('6', '27', 11, 40000),
('7', '14', 9, 35000),
('8', '19', 10, 50000),
('9', '23', 20, 90000),
('10', '1', 23, 45000),
('3', '24', 10, 30000),
('5', '17', 14, 20000),
('2', '5', 7, 30000),
('3', '20', 30, 65000),
('9', '4', 15, 25000)

INSERT INTO PhieuXuatKho
VALUES
('20/11/2020', NULL),
('24/09/2020', NULL),
('15/06/2021', NULL),
('02/03/2022', NULL),
('14/12/2020', NULL),
('09/07/2021', NULL),
('23/05/2020', NULL),
('11/07/2022', NULL),
('05/02/2021', NULL),
('25/12/2020', NULL),
( '14/12/2021', NULL)

INSERT INTO ChiTietPhieuXuat
VALUES
('1', '2', 5, 75000),                            
('2', '11', 10, 75000),
('3', '22', 7, 50000),
('4', '8', 9, 95000),
('5', '6', 7, 55000),
('6', '27', 4, 40000),
('7', '14', 3, 35000),
('8', '19', 10, 50000),
('9', '23', 20, 90000),
('10', '1', 13, 45000),
('11', '24', 10, 30000),
('5', '17', 4, 20000),
('2', '15', 7, 30000),
('8', '1', 10, 65000),
('9', '6', 5, 25000),
('5', '14', 5, 65000),
('2', '22', 5, 65000),
('4', '27', 5, 65000),
('8', '17', 8, 65000),
('10', '8', 10, 65000)


INSERT INTO CALAMVIEC VALUES
('ParTime', N'17:00:00', N'22:00:00'),
('FullTime', N'7:00:00', N'17:00:00'),
('ParTime', N'7:00:00', N'12:00:00'),
('FullTime', N'16:00:00', N'22:00:00'),
('ParTime', N'12:00:00', N'17:00:00')

INSERT INTO NHANVIENCA VALUES
('1', '1'),
('2', '2'),
('3', '3'),
('4', '5'),
('1', '4'),
('3', '1'),
('2', '3'),
('1', '5'),
('4', '1'),
('4', '3')



SET DATEFORMAT DMY
INSERT INTO HOADON VALUES
('1', '3', '09/10/2022', N'Thanh toán', 2500000),
('1', '7', '19/11/2021', N'Thanh toán', 3250000),
('3', '2', '14/12/2023', N'Chưa thanh toán', 10000000),
('2', '4', '07/09/2022', N'Thanh toán', 9700000),
('2', '3', '02/05/2021', N'Chưa thanh toán', 7800000),
('4', '1', '10/01/2023', N'Thanh toán', 6500000),
('4', '7', '27/03/2021', N'Thanh toán', 6780000),
('4', '8', '24/07/2022', N'Chưa thanh toán', 7690000)


SET DATEFORMAT DMY
INSERT INTO HOADON VALUES
('1', '5', '09/10/2022', N'Thanh toán', 2500000),
('2', '5', '19/11/2021', N'Thanh toán', 3250000),
('3', '5', '14/12/2023', N'Chưa thanh toán', 10000000),
('4', '5', '07/09/2022', N'Thanh toán', 9700000),
('5', '8', '02/05/2021', N'Chưa thanh toán', 7800000),
('6', '8', '10/01/2023', N'Thanh toán', 6500000),
('7', '8', '27/03/2021', N'Thanh toán', 6780000),
('8', '8', '24/07/2022', N'Chưa thanh toán', 7690000)

INSERT INTO CHITIETHOADON VALUES
('1', '1', 10),
('2', '3', 13),
('3', '7', 5),
('3', '5', 8),
('5', '1', 7),
('4', '9', 12),
('7', '4', 11),
('8', '9', 10)