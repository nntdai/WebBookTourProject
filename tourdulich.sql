-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 25, 2024 lúc 04:28 PM
-- Phiên bản máy phục vụ: 8.3.0
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `tourdulich`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietlichtrinh`
--

CREATE TABLE `chitietlichtrinh` (
  `idTour` int NOT NULL,
  `tenChiTiet` varchar(50) NOT NULL,
  `ngayThu` int NOT NULL,
  `buaSang` tinyint(1) NOT NULL,
  `buaTrua` tinyint(1) NOT NULL,
  `buaChieu` tinyint(1) NOT NULL,
  `buaToi` tinyint(1) NOT NULL,
  `hinhAnh` varchar(100) DEFAULT NULL,
  `mota` tinytext,
  `ten_chi_tiet` varchar(50) NOT NULL,
  `bua_chieu` bit(1) NOT NULL,
  `bua_sang` bit(1) NOT NULL,
  `bua_toi` bit(1) NOT NULL,
  `bua_trua` bit(1) NOT NULL,
  `hinh_anh` varchar(100) DEFAULT NULL,
  `ngay_thu` int NOT NULL,
  `id_tour` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucnang`
--

CREATE TABLE `chucnang` (
  `id` int NOT NULL,
  `ten` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucnangquyen`
--

CREATE TABLE `chucnangquyen` (
  `id` int NOT NULL,
  `idChucNang` int NOT NULL,
  `idQuyen` int NOT NULL,
  `id_chuc_nang` int NOT NULL,
  `id_quyen` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `id` int NOT NULL,
  `ten` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`id`, `ten`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datchotour`
--

CREATE TABLE `datchotour` (
  `id` int NOT NULL,
  `tongTien` decimal(15,3) NOT NULL,
  `ngayDatCho` datetime NOT NULL,
  `diemTLCong` int DEFAULT NULL,
  `diemTLDung` int DEFAULT NULL,
  `idTour` int NOT NULL,
  `sdtKhachHang` int NOT NULL,
  `idKhuyenMai` varchar(10) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `ngay_dat_cho` datetime(6) NOT NULL,
  `tong_tien` decimal(15,3) NOT NULL,
  `id_khuyen_mai` varchar(10) DEFAULT NULL,
  `id_tour` int NOT NULL,
  `sdt_khach_hang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diadiem`
--

CREATE TABLE `diadiem` (
  `id` int NOT NULL,
  `ten` varchar(100) NOT NULL,
  `idVungMien` int DEFAULT NULL,
  `id_vung_mien` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dieukienhuytour`
--

CREATE TABLE `dieukienhuytour` (
  `id` int NOT NULL,
  `thoiGianTu` int DEFAULT NULL,
  `thoiGianDen` int DEFAULT NULL,
  `phanTramChiPhi` int DEFAULT NULL,
  `ghiChu` text,
  `ghi_chu` tinytext,
  `phan_tram_chi_phi` int DEFAULT NULL,
  `thoi_gian_den` int DEFAULT NULL,
  `thoi_gian_tu` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoivien`
--

CREATE TABLE `hoivien` (
  `id` int NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idKhachHang` int DEFAULT NULL,
  `ngaySinh` datetime NOT NULL,
  `cmnd` varchar(12) NOT NULL,
  `diaChi` varchar(70) NOT NULL,
  `ngayTao` datetime NOT NULL,
  `status` tinyint(1) NOT NULL,
  `dia_chi` varchar(70) NOT NULL,
  `ngay_sinh` datetime(6) NOT NULL,
  `ngay_tao` datetime(6) NOT NULL,
  `id_khach_hang` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `huydatchotour`
--

CREATE TABLE `huydatchotour` (
  `id` int NOT NULL,
  `idDatCho` int NOT NULL,
  `idDKHuy` int NOT NULL,
  `ghiChu` text,
  `chiPhiHuyTour` decimal(15,3) DEFAULT NULL,
  `chiPhiHoan` decimal(15,3) DEFAULT NULL,
  `chi_phi_hoan` decimal(15,3) DEFAULT NULL,
  `chi_phi_huy_tour` decimal(15,3) DEFAULT NULL,
  `ghi_chu` tinytext,
  `id_dat_cho` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `soDienThoai` int NOT NULL,
  `ten` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `diemTichLuy` int NOT NULL,
  `status` tinyint(1) NOT NULL,
  `so_dien_thoai` int NOT NULL,
  `diem_tich_luy` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`soDienThoai`, `ten`, `email`, `diemTichLuy`, `status`, `so_dien_thoai`, `diem_tich_luy`) VALUES
(904814457, 'Nguyễn Ngọc Thành Đại', 'nguyenngocthanhdai@gmail.com', 0, 1, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `id` varchar(10) NOT NULL,
  `ten` varchar(40) NOT NULL,
  `phanTram` int NOT NULL,
  `soLuong` int NOT NULL,
  `soLuongCon` int NOT NULL,
  `giaTriDonTu` decimal(15,3) NOT NULL,
  `ngayBatDau` datetime NOT NULL,
  `ngayKetThuc` datetime NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `gia_tri_don_tu` decimal(15,3) NOT NULL,
  `ngay_bat_dau` datetime(6) NOT NULL,
  `ngay_ket_thuc` datetime(6) NOT NULL,
  `phan_tram` int NOT NULL,
  `so_luong` int NOT NULL,
  `so_luong_con` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhansu`
--

CREATE TABLE `nhansu` (
  `id` int NOT NULL,
  `ten` varchar(50) NOT NULL,
  `diaChi` varchar(100) DEFAULT NULL,
  `cmnd` varchar(12) NOT NULL,
  `soDienThoai` int NOT NULL,
  `email` varchar(40) NOT NULL,
  `hinhAnh` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `dia_chi` varchar(100) DEFAULT NULL,
  `hinh_anh` varchar(100) DEFAULT NULL,
  `so_dien_thoai` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `nhansu`
--

INSERT INTO `nhansu` (`id`, `ten`, `diaChi`, `cmnd`, `soDienThoai`, `email`, `hinhAnh`, `status`, `dia_chi`, `hinh_anh`, `so_dien_thoai`) VALUES
(1, 'Nguyễn Ngọc Thành Đại', 'Xuân Thới Đông 2', '079203040332', 904814457, 'nguyenngocthanhdai@gmail.com', NULL, 1, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomtuoi`
--

CREATE TABLE `nhomtuoi` (
  `id` int NOT NULL,
  `ten` varchar(50) NOT NULL,
  `tuoiTu` int DEFAULT NULL,
  `tuoiDen` int DEFAULT NULL,
  `phanTram` int DEFAULT NULL,
  `phan_tram` int DEFAULT NULL,
  `tuoi_den` int DEFAULT NULL,
  `tuoi_tu` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `idChucVu` int NOT NULL,
  `idChucNangQuyen` int NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `id_chuc_nang_quyen` int NOT NULL,
  `id_chuc_vu` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quyen`
--

CREATE TABLE `quyen` (
  `id` int NOT NULL,
  `ten` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoanadmin`
--

CREATE TABLE `taikhoanadmin` (
  `id` int NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ngayCap` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `idChucVu` int NOT NULL,
  `idNhanVien` int NOT NULL,
  `ngay_cap` datetime(6) DEFAULT NULL,
  `id_chuc_vu` int NOT NULL,
  `id_nhan_vien` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoanadmin`
--

INSERT INTO `taikhoanadmin` (`id`, `username`, `password`, `ngayCap`, `status`, `idChucVu`, `idNhanVien`, `ngay_cap`, `id_chuc_vu`, `id_nhan_vien`) VALUES
(1, 'nntdai', '$2y$10$J8EohJojKjcMy68545GwQ.o9cb2psLeBq.KvJSb9zRxaGfOc//AYe', '2024-10-22 15:24:01', 1, 1, 1, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinhanhkhach`
--

CREATE TABLE `thongtinhanhkhach` (
  `idDatCho` int NOT NULL,
  `tenHanhKhach` int NOT NULL,
  `gioiTinh` tinyint(1) DEFAULT NULL,
  `nhomTuoi` int DEFAULT NULL,
  `ten_hanh_khach` int NOT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `id_dat_cho` int NOT NULL,
  `nhom_tuoi` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tourdulich`
--

CREATE TABLE `tourdulich` (
  `id` int NOT NULL,
  `ten` varchar(150) NOT NULL,
  `giaTour` decimal(15,3) NOT NULL,
  `phuongTienDiChuyen` varchar(50) DEFAULT NULL,
  `soCho` int NOT NULL,
  `soChoCon` int NOT NULL,
  `ngayKH` datetime NOT NULL,
  `ngayVe` datetime NOT NULL,
  `idHDV` int NOT NULL,
  `diaDiemKH` int NOT NULL,
  `diaDiemThamQuan` int NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `gia_tour` decimal(15,3) NOT NULL,
  `ngay_ve` datetime(6) NOT NULL,
  `phuong_tien_di_chuyen` varchar(50) DEFAULT NULL,
  `so_cho` int NOT NULL,
  `so_cho_con` int NOT NULL,
  `dia_diemkh` int NOT NULL,
  `dia_diem_tham_quan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vungmien`
--

CREATE TABLE `vungmien` (
  `id` int NOT NULL,
  `ten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietlichtrinh`
--
ALTER TABLE `chitietlichtrinh`
  ADD PRIMARY KEY (`idTour`,`tenChiTiet`),
  ADD KEY `FKjxgp38psishbbn2j731rqhb5t` (`id_tour`);

--
-- Chỉ mục cho bảng `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chucnangquyen`
--
ALTER TABLE `chucnangquyen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idChucNang` (`idChucNang`),
  ADD KEY `idQuyen` (`idQuyen`),
  ADD KEY `FKr2d9sho3jlmxi3lxcubiwiocs` (`id_chuc_nang`),
  ADD KEY `FKt29e51dlrabd5bpgr0vopmi4w` (`id_quyen`);

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `datchotour`
--
ALTER TABLE `datchotour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTour` (`idTour`),
  ADD KEY `sdtKhachHang` (`sdtKhachHang`),
  ADD KEY `idKhuyenMai` (`idKhuyenMai`),
  ADD KEY `FK3t1pqgokcwx56e23h9646obvf` (`id_khuyen_mai`),
  ADD KEY `FKp1kckpmvq6o9qui17pkl6f05o` (`id_tour`);

--
-- Chỉ mục cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idVungMien` (`idVungMien`),
  ADD KEY `FK1etyxfscviq6kpad4mre15nld` (`id_vung_mien`);

--
-- Chỉ mục cho bảng `dieukienhuytour`
--
ALTER TABLE `dieukienhuytour`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoivien`
--
ALTER TABLE `hoivien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idKhachHang` (`idKhachHang`);

--
-- Chỉ mục cho bảng `huydatchotour`
--
ALTER TABLE `huydatchotour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idDatCho` (`idDatCho`),
  ADD KEY `idDKHuy` (`idDKHuy`),
  ADD KEY `FK9kcjir24kv4xbpy3bpnc6kw3f` (`id_dat_cho`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`soDienThoai`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nhansu`
--
ALTER TABLE `nhansu`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cmnd` (`cmnd`),
  ADD UNIQUE KEY `soDienThoai` (`soDienThoai`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Chỉ mục cho bảng `nhomtuoi`
--
ALTER TABLE `nhomtuoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`idChucVu`,`idChucNangQuyen`),
  ADD KEY `idChucNangQuyen` (`idChucNangQuyen`),
  ADD KEY `FKdegbv0aoupic3p03ctbogqp7v` (`id_chuc_nang_quyen`),
  ADD KEY `FKi7s7nlhltvioftre77uqcj4kl` (`id_chuc_vu`);

--
-- Chỉ mục cho bảng `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `idNhanVien` (`idNhanVien`),
  ADD UNIQUE KEY `UK5qqb1l9m3e4lln5t0mni7vy4j` (`id_nhan_vien`),
  ADD KEY `idChucVu` (`idChucVu`),
  ADD KEY `FKe6avk1m8jdljth85x5hshju3g` (`id_chuc_vu`);

--
-- Chỉ mục cho bảng `thongtinhanhkhach`
--
ALTER TABLE `thongtinhanhkhach`
  ADD PRIMARY KEY (`idDatCho`,`tenHanhKhach`),
  ADD KEY `nhomTuoi` (`nhomTuoi`),
  ADD KEY `FK6uigscpjjtltohu6vi0jq6snw` (`id_dat_cho`),
  ADD KEY `FKlvmmnt3iau5e4jfwkadrx1gpr` (`nhom_tuoi`);

--
-- Chỉ mục cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idHDV` (`idHDV`),
  ADD KEY `diaDiemKH` (`diaDiemKH`),
  ADD KEY `diaDiemThamQuan` (`diaDiemThamQuan`),
  ADD KEY `FKcpvhx9x0cjp3wtvbn1lg7lskj` (`dia_diemkh`),
  ADD KEY `FKsx1l50l72hq2ynialnmo0a3eu` (`dia_diem_tham_quan`);

--
-- Chỉ mục cho bảng `vungmien`
--
ALTER TABLE `vungmien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chucnang`
--
ALTER TABLE `chucnang`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chucnangquyen`
--
ALTER TABLE `chucnangquyen`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `datchotour`
--
ALTER TABLE `datchotour`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `dieukienhuytour`
--
ALTER TABLE `dieukienhuytour`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoivien`
--
ALTER TABLE `hoivien`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `huydatchotour`
--
ALTER TABLE `huydatchotour`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhansu`
--
ALTER TABLE `nhansu`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `nhomtuoi`
--
ALTER TABLE `nhomtuoi`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `vungmien`
--
ALTER TABLE `vungmien`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietlichtrinh`
--
ALTER TABLE `chitietlichtrinh`
  ADD CONSTRAINT `chitietlichtrinh_ibfk_1` FOREIGN KEY (`idTour`) REFERENCES `tourdulich` (`id`),
  ADD CONSTRAINT `FKjxgp38psishbbn2j731rqhb5t` FOREIGN KEY (`id_tour`) REFERENCES `tourdulich` (`id`);

--
-- Các ràng buộc cho bảng `chucnangquyen`
--
ALTER TABLE `chucnangquyen`
  ADD CONSTRAINT `chucnangquyen_ibfk_1` FOREIGN KEY (`idChucNang`) REFERENCES `chucnang` (`id`),
  ADD CONSTRAINT `chucnangquyen_ibfk_2` FOREIGN KEY (`idQuyen`) REFERENCES `quyen` (`id`),
  ADD CONSTRAINT `FKr2d9sho3jlmxi3lxcubiwiocs` FOREIGN KEY (`id_chuc_nang`) REFERENCES `chucnang` (`id`),
  ADD CONSTRAINT `FKt29e51dlrabd5bpgr0vopmi4w` FOREIGN KEY (`id_quyen`) REFERENCES `quyen` (`id`);

--
-- Các ràng buộc cho bảng `datchotour`
--
ALTER TABLE `datchotour`
  ADD CONSTRAINT `datchotour_ibfk_1` FOREIGN KEY (`idTour`) REFERENCES `tourdulich` (`id`),
  ADD CONSTRAINT `datchotour_ibfk_2` FOREIGN KEY (`sdtKhachHang`) REFERENCES `khachhang` (`soDienThoai`),
  ADD CONSTRAINT `datchotour_ibfk_3` FOREIGN KEY (`idKhuyenMai`) REFERENCES `khuyenmai` (`id`),
  ADD CONSTRAINT `FK3t1pqgokcwx56e23h9646obvf` FOREIGN KEY (`id_khuyen_mai`) REFERENCES `khuyenmai` (`id`),
  ADD CONSTRAINT `FKp1kckpmvq6o9qui17pkl6f05o` FOREIGN KEY (`id_tour`) REFERENCES `tourdulich` (`id`);

--
-- Các ràng buộc cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  ADD CONSTRAINT `diadiem_ibfk_1` FOREIGN KEY (`idVungMien`) REFERENCES `vungmien` (`id`),
  ADD CONSTRAINT `FK1etyxfscviq6kpad4mre15nld` FOREIGN KEY (`id_vung_mien`) REFERENCES `vungmien` (`id`);

--
-- Các ràng buộc cho bảng `hoivien`
--
ALTER TABLE `hoivien`
  ADD CONSTRAINT `hoivien_ibfk_1` FOREIGN KEY (`idKhachHang`) REFERENCES `khachhang` (`soDienThoai`);

--
-- Các ràng buộc cho bảng `huydatchotour`
--
ALTER TABLE `huydatchotour`
  ADD CONSTRAINT `FK9kcjir24kv4xbpy3bpnc6kw3f` FOREIGN KEY (`id_dat_cho`) REFERENCES `datchotour` (`id`),
  ADD CONSTRAINT `huydatchotour_ibfk_1` FOREIGN KEY (`idDatCho`) REFERENCES `datchotour` (`id`),
  ADD CONSTRAINT `huydatchotour_ibfk_2` FOREIGN KEY (`idDKHuy`) REFERENCES `dieukienhuytour` (`id`);

--
-- Các ràng buộc cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD CONSTRAINT `FKdegbv0aoupic3p03ctbogqp7v` FOREIGN KEY (`id_chuc_nang_quyen`) REFERENCES `chucnangquyen` (`id`),
  ADD CONSTRAINT `FKi7s7nlhltvioftre77uqcj4kl` FOREIGN KEY (`id_chuc_vu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `phanquyen_ibfk_1` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `phanquyen_ibfk_2` FOREIGN KEY (`idChucNangQuyen`) REFERENCES `chucnangquyen` (`id`);

--
-- Các ràng buộc cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  ADD CONSTRAINT `FKe6avk1m8jdljth85x5hshju3g` FOREIGN KEY (`id_chuc_vu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `FKnr4x3as8s5v7w89cdswnr9xrn` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhansu` (`id`),
  ADD CONSTRAINT `taikhoanadmin_ibfk_1` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `taikhoanadmin_ibfk_2` FOREIGN KEY (`idNhanVien`) REFERENCES `nhansu` (`id`);

--
-- Các ràng buộc cho bảng `thongtinhanhkhach`
--
ALTER TABLE `thongtinhanhkhach`
  ADD CONSTRAINT `FK6uigscpjjtltohu6vi0jq6snw` FOREIGN KEY (`id_dat_cho`) REFERENCES `tourdulich` (`id`),
  ADD CONSTRAINT `FKlvmmnt3iau5e4jfwkadrx1gpr` FOREIGN KEY (`nhom_tuoi`) REFERENCES `nhomtuoi` (`id`),
  ADD CONSTRAINT `thongtinhanhkhach_ibfk_1` FOREIGN KEY (`idDatCho`) REFERENCES `tourdulich` (`id`),
  ADD CONSTRAINT `thongtinhanhkhach_ibfk_2` FOREIGN KEY (`nhomTuoi`) REFERENCES `nhomtuoi` (`id`);

--
-- Các ràng buộc cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  ADD CONSTRAINT `FKcpvhx9x0cjp3wtvbn1lg7lskj` FOREIGN KEY (`dia_diemkh`) REFERENCES `diadiem` (`id`),
  ADD CONSTRAINT `FKsx1l50l72hq2ynialnmo0a3eu` FOREIGN KEY (`dia_diem_tham_quan`) REFERENCES `diadiem` (`id`),
  ADD CONSTRAINT `tourdulich_ibfk_1` FOREIGN KEY (`idHDV`) REFERENCES `nhansu` (`id`),
  ADD CONSTRAINT `tourdulich_ibfk_2` FOREIGN KEY (`diaDiemKH`) REFERENCES `diadiem` (`id`),
  ADD CONSTRAINT `tourdulich_ibfk_3` FOREIGN KEY (`diaDiemThamQuan`) REFERENCES `diadiem` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
