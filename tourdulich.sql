-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 29, 2024 lúc 09:45 AM
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
  `mota` text
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
  `idQuyen` int NOT NULL
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
  `idToChucTour` int NOT NULL,
  `sdtKhachHang` varchar(12) NOT NULL,
  `idKhuyenMai` varchar(10) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diadiem`
--

CREATE TABLE `diadiem` (
  `id` int NOT NULL,
  `ten` varchar(100) NOT NULL,
  `idVungMien` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `diadiem`
--

INSERT INTO `diadiem` (`id`, `ten`, `idVungMien`) VALUES
(1, 'Hà Giang', 1),
(2, 'Quảng Ninh', 1),
(3, 'Lào Cao', 1),
(4, 'Ninh Bình', 1),
(5, 'Đà Nẵng', 2),
(6, 'Huế', 2),
(7, 'Quảng Bình', 2),
(8, 'Quy Nhơn', 2),
(9, 'Tây Ninh', 3),
(10, 'TP. Hồ Chí Minh', 3),
(11, 'Đồng Nai', 3),
(12, 'Bà Rịa - Vũng Tàu', 3),
(13, 'Phú Quốc', 4),
(14, 'Cần Thơ', 4),
(15, 'Cà Mau', 4),
(16, 'Bạc Liêu', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dieukienhuytour`
--

CREATE TABLE `dieukienhuytour` (
  `id` int NOT NULL,
  `thoiGianTu` int DEFAULT NULL,
  `thoiGianDen` int DEFAULT NULL,
  `phanTramChiPhi` int DEFAULT NULL,
  `ghiChu` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoivien`
--

CREATE TABLE `hoivien` (
  `id` int NOT NULL,
  `password` varchar(100) NOT NULL,
  `idKhachHang` varchar(12) DEFAULT NULL,
  `ngaySinh` datetime NOT NULL,
  `cmnd` varchar(12) NOT NULL,
  `diaChi` varchar(70) NOT NULL,
  `ngayTao` datetime NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `huydatchotour`
--

CREATE TABLE `huydatchotour` (
  `id` int NOT NULL,
  `idDatCho` int NOT NULL,
  `ngayHuy` datetime NOT NULL,
  `idDKHuy` int NOT NULL,
  `ghiChu` text,
  `chiPhiHuyTour` decimal(15,3) DEFAULT NULL,
  `chiPhiHoan` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `soDienThoai` varchar(12) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `diemTichLuy` int NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`soDienThoai`, `ten`, `email`, `diemTichLuy`, `status`) VALUES
('904814457', 'Nguyễn Ngọc Thành Đại', 'nguyenngocthanhdai@gmail.com', 0, 1);

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
  `status` tinyint(1) DEFAULT NULL
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
  `soDienThoai` varchar(12) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hinhAnh` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `nhansu`
--

INSERT INTO `nhansu` (`id`, `ten`, `diaChi`, `cmnd`, `soDienThoai`, `email`, `hinhAnh`, `status`) VALUES
(1, 'Nguyễn Ngọc Thành Đại', 'Xuân Thới Đông 2', '079203040332', '904814457', 'nguyenngocthanhdai@gmail.com', NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomtuoi`
--

CREATE TABLE `nhomtuoi` (
  `id` int NOT NULL,
  `ten` varchar(50) NOT NULL,
  `tuoiTu` int DEFAULT NULL,
  `tuoiDen` int DEFAULT NULL,
  `phanTram` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `idChucVu` int NOT NULL,
  `idChucNangQuyen` int NOT NULL,
  `status` tinyint(1) DEFAULT NULL
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
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ngayCap` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `idChucVu` int NOT NULL,
  `idNhanVien` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoanadmin`
--

INSERT INTO `taikhoanadmin` (`id`, `username`, `password`, `ngayCap`, `status`, `idChucVu`, `idNhanVien`) VALUES
(1, 'nntdai', '$2y$10$Fj/GcGzWi.GoHtGrXURpreSddxDVNxlHPhhAFcLqoOcnbWhhTRGru', '2024-10-22 15:24:01', 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinhanhkhach`
--

CREATE TABLE `thongtinhanhkhach` (
  `idDatCho` int NOT NULL,
  `tenHanhKhach` int NOT NULL,
  `gioiTinh` tinyint(1) DEFAULT NULL,
  `nhomTuoi` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tochuctour`
--

CREATE TABLE `tochuctour` (
  `id` int NOT NULL,
  `idTourDuLich` int NOT NULL,
  `idHDV` int NOT NULL,
  `ngayKH` datetime NOT NULL,
  `ngayVe` datetime NOT NULL,
  `soCho` int NOT NULL,
  `soChoCon` int NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tourdulich`
--

CREATE TABLE `tourdulich` (
  `id` int NOT NULL,
  `ten` varchar(150) NOT NULL,
  `giaTour` decimal(15,3) NOT NULL,
  `thoiGian` varchar(10) NOT NULL,
  `phuongTienDiChuyen` varchar(50) DEFAULT NULL,
  `diaDiemKH` int NOT NULL,
  `diaDiemThamQuan` int NOT NULL,
  `status` tinyint(1) DEFAULT NULL
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
-- Đang đổ dữ liệu cho bảng `vungmien`
--

INSERT INTO `vungmien` (`id`, `ten`) VALUES
(1, 'Miền Bắc'),
(2, 'Miền Trung'),
(3, 'Miền Đông Nam Bộ'),
(4, 'Miền Tây Nam Bộ');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietlichtrinh`
--
ALTER TABLE `chitietlichtrinh`
  ADD PRIMARY KEY (`idTour`,`tenChiTiet`);

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
  ADD KEY `idQuyen` (`idQuyen`);

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
  ADD KEY `idTour` (`idToChucTour`),
  ADD KEY `sdtKhachHang` (`sdtKhachHang`),
  ADD KEY `idKhuyenMai` (`idKhuyenMai`);

--
-- Chỉ mục cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idVungMien` (`idVungMien`);

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
  ADD KEY `idDKHuy` (`idDKHuy`);

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
  ADD KEY `idChucNangQuyen` (`idChucNangQuyen`);

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
  ADD KEY `idChucVu` (`idChucVu`);

--
-- Chỉ mục cho bảng `thongtinhanhkhach`
--
ALTER TABLE `thongtinhanhkhach`
  ADD PRIMARY KEY (`idDatCho`,`tenHanhKhach`),
  ADD KEY `nhomTuoi` (`nhomTuoi`);

--
-- Chỉ mục cho bảng `tochuctour`
--
ALTER TABLE `tochuctour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tochuc_tour` (`idTourDuLich`),
  ADD KEY `tochuc_tour_hdv` (`idHDV`);

--
-- Chỉ mục cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  ADD PRIMARY KEY (`id`),
  ADD KEY `diaDiemKH` (`diaDiemKH`),
  ADD KEY `diaDiemThamQuan` (`diaDiemThamQuan`);

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
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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
-- AUTO_INCREMENT cho bảng `tochuctour`
--
ALTER TABLE `tochuctour`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `vungmien`
--
ALTER TABLE `vungmien`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietlichtrinh`
--
ALTER TABLE `chitietlichtrinh`
  ADD CONSTRAINT `chitietlichtrinh_ibfk_1` FOREIGN KEY (`idTour`) REFERENCES `tourdulich` (`id`);

--
-- Các ràng buộc cho bảng `chucnangquyen`
--
ALTER TABLE `chucnangquyen`
  ADD CONSTRAINT `chucnangquyen_ibfk_1` FOREIGN KEY (`idChucNang`) REFERENCES `chucnang` (`id`),
  ADD CONSTRAINT `chucnangquyen_ibfk_2` FOREIGN KEY (`idQuyen`) REFERENCES `quyen` (`id`);

--
-- Các ràng buộc cho bảng `datchotour`
--
ALTER TABLE `datchotour`
  ADD CONSTRAINT `datchotour_ibfk_1` FOREIGN KEY (`idToChucTour`) REFERENCES `tochuctour` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `datchotour_ibfk_2` FOREIGN KEY (`sdtKhachHang`) REFERENCES `khachhang` (`soDienThoai`),
  ADD CONSTRAINT `datchotour_ibfk_3` FOREIGN KEY (`idKhuyenMai`) REFERENCES `khuyenmai` (`id`);

--
-- Các ràng buộc cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  ADD CONSTRAINT `diadiem_ibfk_1` FOREIGN KEY (`idVungMien`) REFERENCES `vungmien` (`id`);

--
-- Các ràng buộc cho bảng `hoivien`
--
ALTER TABLE `hoivien`
  ADD CONSTRAINT `hoivien_ibfk_1` FOREIGN KEY (`idKhachHang`) REFERENCES `khachhang` (`soDienThoai`);

--
-- Các ràng buộc cho bảng `huydatchotour`
--
ALTER TABLE `huydatchotour`
  ADD CONSTRAINT `huydatchotour_ibfk_1` FOREIGN KEY (`idDatCho`) REFERENCES `datchotour` (`id`),
  ADD CONSTRAINT `huydatchotour_ibfk_2` FOREIGN KEY (`idDKHuy`) REFERENCES `dieukienhuytour` (`id`);

--
-- Các ràng buộc cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD CONSTRAINT `phanquyen_ibfk_1` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `phanquyen_ibfk_2` FOREIGN KEY (`idChucNangQuyen`) REFERENCES `chucnangquyen` (`id`);

--
-- Các ràng buộc cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  ADD CONSTRAINT `taikhoanadmin_ibfk_1` FOREIGN KEY (`idChucVu`) REFERENCES `chucvu` (`id`),
  ADD CONSTRAINT `taikhoanadmin_ibfk_2` FOREIGN KEY (`idNhanVien`) REFERENCES `nhansu` (`id`);

--
-- Các ràng buộc cho bảng `thongtinhanhkhach`
--
ALTER TABLE `thongtinhanhkhach`
  ADD CONSTRAINT `thongtinhanhkhach_ibfk_1` FOREIGN KEY (`idDatCho`) REFERENCES `tourdulich` (`id`),
  ADD CONSTRAINT `thongtinhanhkhach_ibfk_2` FOREIGN KEY (`nhomTuoi`) REFERENCES `nhomtuoi` (`id`);

--
-- Các ràng buộc cho bảng `tochuctour`
--
ALTER TABLE `tochuctour`
  ADD CONSTRAINT `tochuc_tour` FOREIGN KEY (`idTourDuLich`) REFERENCES `tourdulich` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `tochuc_tour_hdv` FOREIGN KEY (`idHDV`) REFERENCES `nhansu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Các ràng buộc cho bảng `tourdulich`
--
ALTER TABLE `tourdulich`
  ADD CONSTRAINT `tourdulich_ibfk_2` FOREIGN KEY (`diaDiemKH`) REFERENCES `diadiem` (`id`),
  ADD CONSTRAINT `tourdulich_ibfk_3` FOREIGN KEY (`diaDiemThamQuan`) REFERENCES `diadiem` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
