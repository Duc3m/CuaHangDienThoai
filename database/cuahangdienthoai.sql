-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2024 at 10:44 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuahangdienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `baohanh`
--

CREATE TABLE `baohanh` (
  `id` int(11) NOT NULL,
  `soThang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chucnang`
--

CREATE TABLE `chucnang` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chucnang`
--

INSERT INTO `chucnang` (`id`, `ten`) VALUES
(1, 'Sản phẩm'),
(2, 'Phiếu nhập'),
(3, 'Hóa đơn'),
(4, 'Khách hàng'),
(5, 'Nhân viên'),
(6, 'Nhà cung cấp');

-- --------------------------------------------------------

--
-- Table structure for table `ctbaohanh`
--

CREATE TABLE `ctbaohanh` (
  `id` int(11) NOT NULL,
  `baoHanh_id` int(11) DEFAULT NULL,
  `hoaDon_id` int(11) DEFAULT NULL,
  `imei_sanPham` varchar(255) DEFAULT NULL,
  `ngayKetThuc` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `hoaDon_id` int(11) NOT NULL,
  `imei` varchar(255) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `giaBanRa` int(11) DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `phieuNhap_id` int(11) NOT NULL,
  `pbsanPham_id` int(11) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` int(11) DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctquyen`
--

CREATE TABLE `ctquyen` (
  `quyen_id` int(11) NOT NULL,
  `chucNang_id` int(11) NOT NULL,
  `hanhDong` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctsanpham`
--

CREATE TABLE `ctsanpham` (
  `imei` varchar(255) NOT NULL,
  `sanPham_id` int(11) DEFAULT NULL,
  `pbSanPham_id` int(11) DEFAULT NULL,
  `phieuNhap_id` int(11) DEFAULT NULL,
  `hoaDon_id` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(11) NOT NULL,
  `khacHang_id` int(11) DEFAULT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `khuyenMai_id` int(11) DEFAULT NULL,
  `ngayXuat` datetime DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id` int(11) NOT NULL,
  `ho` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `id` int(11) NOT NULL,
  `tiLe` float DEFAULT NULL,
  `pbSanPham_id` int(11) DEFAULT NULL,
  `dieuKien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`id`, `ten`, `diaChi`, `soDienThoai`, `email`) VALUES
(1, 'Công Ty TNHH Thế Giới Di Động', 'Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', '(028)35100100', 'lienhe@thegioididong.com'),
(2, 'Công ty TNHH Thương Mại Công Nghệ Bạch Long', '134 Trần Phú, phường 4, quận 5, Tp. Hồ Chí Minh', '869287135', 'marketing@bachlongmobile.com '),
(3, 'Viễn Thông Đức Huy', '187A Đường 3/2, P. 11, Q. 10, Tp. Hồ Chí Minh', '0971151515', 'duchuymobile2011@gmail.com ');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` int(11) NOT NULL,
  `ho` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `gioiTinh` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `chucVu` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `ho`, `ten`, `gioiTinh`, `soDienThoai`, `email`, `chucVu`, `trangThai`) VALUES
(1, 'Trần Đức', 'Em', 'Nam', '0374126105', '3122410091@sv.sgu.edu.vn', 'Quản lý', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pbsanpham`
--

CREATE TABLE `pbsanpham` (
  `id` int(11) NOT NULL,
  `sanPham_id` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `mau` varchar(255) DEFAULT NULL,
  `soLuong` int(11) DEFAULT 0,
  `giaNhap` int(11) DEFAULT NULL,
  `giaXuat` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pbsanpham`
--

INSERT INTO `pbsanpham` (`id`, `sanPham_id`, `ram`, `rom`, `mau`, `soLuong`, `giaNhap`, `giaXuat`, `trangThai`) VALUES
(1, 1, 6, 128, 'Đen', 0, 15000000, 22990000, 1),
(2, 1, 6, 256, 'Đen', 0, 20000000, 25990000, 1),
(3, 1, 6, 512, 'Đen', 0, 26000000, 31990000, 1),
(4, 2, 6, 128, 'Đen', 0, 20000000, 25990000, 1),
(5, 2, 6, 256, 'Đen', 0, 23000000, 28990000, 1),
(6, 2, 6, 512, 'Đen', 0, 29000000, 34990000, 1),
(7, 3, 8, 128, 'Titan đen', 0, 23000000, 28990000, 1),
(8, 3, 8, 256, 'Titan đen', 0, 26000000, 31990000, 1),
(9, 3, 8, 512, 'Titan đen', 0, 32000000, 37990000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `id` int(11) NOT NULL,
  `nhaCungCap_id` int(11) DEFAULT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `ngayNhap` datetime DEFAULT NULL,
  `tongTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`id`, `ten`) VALUES
(1, 'Quản lý');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `hinhAnh` varchar(255) DEFAULT NULL,
  `kichThuocMan` float DEFAULT NULL,
  `cameraSau` varchar(255) DEFAULT NULL,
  `cameraTruoc` varchar(255) DEFAULT NULL,
  `chipXuLy` varchar(255) DEFAULT NULL,
  `heDieuHanh` varchar(255) DEFAULT NULL,
  `dungLuongPin` int(11) DEFAULT NULL,
  `thuongHieu_id` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `ten`, `hinhAnh`, `kichThuocMan`, `cameraSau`, `cameraTruoc`, `chipXuLy`, `heDieuHanh`, `dungLuongPin`, `thuongHieu_id`, `trangThai`) VALUES
(1, 'iPhone 15', 'iphone15.jpg', 6.1, 'Chính 48 MP & Phụ 12 MP', '12 MP', 'Apple A16 Bionic', 'iOS', 3349, 1, 1),
(2, 'iPhone 15 Plus', 'iphone15plus.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP', '12 MP ', 'Apple A16 Bionic', 'iOS', 4383, 1, 1),
(3, 'iPhone 15 Pro', 'iphone15pro.jpg', 6.1, 'Chính 48 MP & Phụ 12 MP, 12 MP', '12 MP', 'Apple A17 Pro', 'iOS', 3274, 1, 1),
(4, 'iPhone 15 Pro Max', 'iphone15promax.jpg', 6.7, 'Chính 48 MP & Phụ 12 MP, 12 MP', '12 MP', 'Apple A17 Pro', 'iOS', 4422, 1, 1),
(5, 'Xiaomi 14 5G', 'xiaomi14.jpg', 6.36, 'Chính 50 MP & Phụ 50 MP, 50 MP', '32 MP', 'Snapdragon 8 Gen 3', 'Android', 4610, 3, 1),
(6, 'Xiaomi Redmi Note 13', 'redminote13.jpg', 6.67, 'Chính 108 MP & Phụ 8 MP, 2 MP', '16 MP', 'Snapdragon 685', 'Android', 5000, 3, 1),
(7, 'Xiaomi Redmi Note 13 Pro', 'redminote13pro.jpg', 6.67, 'Chính 200 MP & Phụ 8 MP, 2 MP', '16 MP', 'MediaTek Helio G99-Ultra', 'Android', 5000, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `nhanVien_id` int(11) DEFAULT NULL,
  `quyen_id` int(11) DEFAULT NULL,
  `tenTaiKhoan` varchar(255) DEFAULT NULL,
  `matKhau` varchar(255) DEFAULT NULL,
  `trangThai` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `nhanVien_id`, `quyen_id`, `tenTaiKhoan`, `matKhau`, `trangThai`) VALUES
(1, 1, 1, 'ducem', '123456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`id`, `ten`) VALUES
(1, 'Apple'),
(2, 'Samsung'),
(3, 'Xiaomi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `baoHanh_id` (`baoHanh_id`),
  ADD KEY `hoaDon_id` (`hoaDon_id`),
  ADD KEY `imei_sanPham` (`imei_sanPham`);

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`hoaDon_id`,`imei`),
  ADD KEY `imei` (`imei`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`phieuNhap_id`,`pbsanPham_id`),
  ADD KEY `pbsanPham_id` (`pbsanPham_id`);

--
-- Indexes for table `ctquyen`
--
ALTER TABLE `ctquyen`
  ADD PRIMARY KEY (`quyen_id`,`chucNang_id`),
  ADD KEY `chucNang_id` (`chucNang_id`);

--
-- Indexes for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD PRIMARY KEY (`imei`),
  ADD KEY `hoaDon_id` (`hoaDon_id`),
  ADD KEY `sanPham_id` (`sanPham_id`),
  ADD KEY `pbSanPham_id` (`pbSanPham_id`),
  ADD KEY `phieuNhap_id` (`phieuNhap_id`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `khacHang_id` (`khacHang_id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`),
  ADD KEY `khuyenMai_id` (`khuyenMai_id`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pbSanPham_id` (`pbSanPham_id`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanPham_id` (`sanPham_id`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhaCungCap_id` (`nhaCungCap_id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `thuongHieu_id` (`thuongHieu_id`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhanVien_id` (`nhanVien_id`),
  ADD KEY `quyen_id` (`quyen_id`);

--
-- Indexes for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `baohanh`
--
ALTER TABLE `baohanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `chucnang`
--
ALTER TABLE `chucnang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quyen`
--
ALTER TABLE `quyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctbaohanh`
--
ALTER TABLE `ctbaohanh`
  ADD CONSTRAINT `ctbaohanh_ibfk_1` FOREIGN KEY (`baoHanh_id`) REFERENCES `baohanh` (`id`),
  ADD CONSTRAINT `ctbaohanh_ibfk_2` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ctbaohanh_ibfk_3` FOREIGN KEY (`imei_sanPham`) REFERENCES `ctsanpham` (`imei`);

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`imei`) REFERENCES `ctsanpham` (`imei`);

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`),
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`pbsanPham_id`) REFERENCES `pbsanpham` (`id`);

--
-- Constraints for table `ctquyen`
--
ALTER TABLE `ctquyen`
  ADD CONSTRAINT `ctquyen_ibfk_1` FOREIGN KEY (`chucNang_id`) REFERENCES `chucnang` (`id`),
  ADD CONSTRAINT `ctquyen_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`);

--
-- Constraints for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD CONSTRAINT `ctsanpham_ibfk_1` FOREIGN KEY (`hoaDon_id`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ctsanpham_ibfk_2` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`),
  ADD CONSTRAINT `ctsanpham_ibfk_3` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`),
  ADD CONSTRAINT `ctsanpham_ibfk_4` FOREIGN KEY (`phieuNhap_id`) REFERENCES `phieunhap` (`id`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`khacHang_id`) REFERENCES `khachhang` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`khuyenMai_id`) REFERENCES `khuyenmai` (`id`);

--
-- Constraints for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD CONSTRAINT `khuyenmai_ibfk_1` FOREIGN KEY (`pbSanPham_id`) REFERENCES `pbsanpham` (`id`);

--
-- Constraints for table `pbsanpham`
--
ALTER TABLE `pbsanpham`
  ADD CONSTRAINT `pbsanpham_ibfk_1` FOREIGN KEY (`sanPham_id`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`nhaCungCap_id`) REFERENCES `nhacungcap` (`id`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`thuongHieu_id`) REFERENCES `thuonghieu` (`id`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`nhanVien_id`) REFERENCES `nhanvien` (`id`),
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`quyen_id`) REFERENCES `quyen` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;