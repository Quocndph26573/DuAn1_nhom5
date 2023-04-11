﻿use master
go
Drop database DuAn1_BanQuanAo
go

create database DuAn1_BanQuanAo_1
go
use  DuAn1_BanQuanAo_1
go

create table LoaiSP
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[LoaiSP] VALUES ('AC',N'Áo cộc tay' ,NULL ,NULL,1)
INSERT INTO [dbo].[LoaiSP] VALUES ('ATT',N'áo thể thao' ,NULL ,NULL,1)
INSERT INTO [dbo].[LoaiSP] VALUES ('AK',N'Áo khoác' ,NULL ,NULL,1)
go
create table ThuongHieu
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[ThuongHieu] VALUES('adam',N'Adam Store',NULL,NULL,1)
INSERT INTO [dbo].[ThuongHieu] VALUES('bil',N'Biluxury',NULL,NULL,1)
INSERT INTO [dbo].[ThuongHieu] VALUES('xanh',N'Xanh Exchange',NULL,NULL,1)
go
create table ChatLieu
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[ChatLieu] VALUES('cl1',N'vải',NULL,NULL,1)
INSERT INTO [dbo].[ChatLieu] VALUES('cl2',N'cotton',NULL,NULL,1)
INSERT INTO [dbo].[ChatLieu] VALUES('cl3',N'nhung',NULL,NULL,1)
INSERT INTO [dbo].[ChatLieu] VALUES('cl4',N'luạ',NULL,NULL,1)
INSERT INTO [dbo].[ChatLieu] VALUES('cl5',N'da thuộc',NULL,NULL,1)
go

create table Size
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Size NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[Size] VALUES ('s1','L',NULL,NULL,1)
INSERT INTO [dbo].[Size] VALUES ('s2','S',NULL,NULL,1)
INSERT INTO [dbo].[Size] VALUES ('s3','XL',NULL,NULL,1)
go
create table ChiTietSanPham
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) not null,
	Ten nvarchar(max) not null,
	IdLoaiSP int not null FOREIGN KEY REFERENCES LoaiSP(Id),
	IdThuongHieu int not null FOREIGN KEY REFERENCES ThuongHieu(Id),
	IdChatLieu int not null FOREIGN KEY REFERENCES ChatLieu(Id),
	IdSize int not null FOREIGN KEY REFERENCES Size(Id),
	Gia int,
    soLuong int,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP1',N'Áo Cộc polo',1,1,2,3,50000,50,NULL,NULL,1)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP3',N'Áo sơ mi hè nam',1,2,1,1,70000,10,NULL,NULL,1)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP2',N'Áo đồng phục fclb',2,1,3,2,55000,100,NULL,NULL,1)
go

CREATE TABLE ChucVu(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE, 
	TrangThai bit
) 
INSERT INTO [dbo].[ChucVu] VALUES('QL','ADMIN',NULL,NULL,1)
INSERT INTO [dbo].[ChucVu] VALUES('NV',N'Nhân Viên Bán Hàng',NULL,NULL,1)
go

CREATE TABLE NguoiDung(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT NOT NULL,
	NgaySinh DATE NOT NULL,
	Email VARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(MAX),
	IdChucVu int NOT NULL FOREIGN KEY REFERENCES dbo.ChucVu(Id),
	Anh varchar(max),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[NguoiDung] VALUES('NV1',N'Nguyễn Mạnh Hiếu',1,'2000-04-22','hieu@gmail.com',N'Ninh Bình',1,NULL,NULL,NULL,1)
INSERT INTO [dbo].[NguoiDung] VALUES('NV2',N'Nguyễn Đức Huy',1,'2003-04-22','Huyndph22893@fpt.edu.vn',N'Thái Bình',1,'D:\user\OneDrive\OneDrive - TRƯỜNG ĐẠI HỌC SƯ PHẠM THỂ DỤC THỂ THAO HÀ NỘI\Pictures',NULL,NULL,1)
go

CREATE TABLE HoaDon(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IDNguoiDung int NOT NULL FOREIGN KEY REFERENCES dbo.NguoiDung(Id),
	NgayMua DATE NOT NULL,
	Sdt VARCHAR(10) NULL,
	DiaChi NVARCHAR(MAX),
	TongTien bigint null,
	TinhTrang BIT
)


CREATE TABLE HoaDonChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdHoaDon int FOREIGN KEY REFERENCES dbo.HoaDon(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSanPham(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)

CREATE TABLE GioHang(
	Id int identity(1,1) PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	NgayTao DATE NOT NULL,
	TrangThai BIT not null 
)

CREATE TABLE GioHangChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdGioHang int FOREIGN KEY REFERENCES dbo.GioHang(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSanPham(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)
CREATE TABLE Account(
	Id int identity(1,1) PRIMARY KEY,
	UserName NVARCHAR(50) NOT NULL,
	Pass NVARCHAR(18) not null,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	TrangThai int
)

INSERT INTO [dbo].[Account] VALUES('quocndph26573@fpt.edu.vn','1',1,1)
INSERT INTO [dbo].[Account] VALUES('Huyndph22893@fpt.edu.vn','1',2,1)


select * from ChiTietSanPham
