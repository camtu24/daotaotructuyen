-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 20, 2019 lúc 06:07 PM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `daotaotructuyen`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihoc`
--

CREATE TABLE `baihoc` (
  `id_baihoc` int(5) NOT NULL,
  `tenbaihoc` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `mota` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `chitiet` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `video` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nguoitao` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_dmb` int(5) DEFAULT NULL,
  `id_khoahoc` int(5) NOT NULL,
  `id_level` int(5) NOT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baihoc`
--

INSERT INTO `baihoc` (`id_baihoc`, `tenbaihoc`, `mota`, `chitiet`, `video`, `ngaytao`, `nguoitao`, `id_dmb`, `id_khoahoc`, `id_level`, `storage`) VALUES
(1, 'Bài 1', 'Serving Web Content with Spring MVC\r\n\r\nHandling Form Submission\r\n\r\nSecuring a Web Application\r\n\r\nBuilding an Application with Spring Boot\r\n\r\nWant to write a new guide or contribute to an existing one? Check out our contribution guidelines.', '<p>Although it is possible to package this service as a traditional WAR file for deployment to an external application server, the simpler approach demonstrated below creates a standalone application. You package everything in a single, executable JAR file, driven by a good old Java main() method. And along the way, you use Spring&rsquo;s support for embedding the Tomcat servlet container as the HTTP runtime, instead of deploying to an external instance.</p>\r\n\r\n<p>You also want a target folder to upload files to, so let&rsquo;s enhance the basic Application class and add a Boot CommandLineRunner which deletes and re-creates that folder at startup:</p>\r\n', 'outro-370643784128673.mp4', '2019-03-20 16:11:51', 'b', 1, 2, 1, 1),
(2, 'bai 2', 'Bootstrap đã xây dựng sẵn một vài lớp Css để tạo một Button, với một vài kiểu ... Có một vài lớp Css bổ xung để thiết lập màu sắc cho Button, hoặc làm cho ...', '<h3><a href=\"http://arduino.vn/bai-viet/284-button-nut-bam\">Button - N&uacute;t bấm | Cộng đồng Arduino Việt Nam</a></h3>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><a href=\"http://arduino.vn/bai-viet/284-button-nut-bam\"><cite>arduino.vn &rsaquo; Điện tử cơ bản</cite></a></p>\r\n\r\n<ol>\r\n	<li>&nbsp;</li>\r\n	<li>&nbsp;</li>\r\n</ol>\r\n\r\n<p>30 thg 7, 2014 -&nbsp;Giới thiệu.&nbsp;<em>C&oacute;</em>&nbsp;lẽ ch&uacute;ng ta đ&atilde; qu&aacute; quen với c&aacute;c loại&nbsp;<em>button</em>, n&uacute;t nhấn rồi. Tuy nhi&ecirc;n,&nbsp;<em>c&oacute;</em>&nbsp;thể, chỉ&nbsp;<em>c&oacute;</em>&nbsp;thể th&ocirc;i nh&eacute;, bạn vẫn chưa biết hết về c&aacute;c loại&nbsp;...</p>\r\n\r\n<h3><a href=\"https://v1study.com/bootstrap-nut-buttons.html\">N&uacute;t (Buttons) - | V1Study</a></h3>\r\n', 'outro-329222744117621.mp4', '2019-03-20 04:27:42', 'b', 2, 2, 1, 1),
(6, 'sad', 'dfasf', 'dsfffffd', 'sdf', '2019-03-20 10:07:06', 'dsf', NULL, 3, 1, 1),
(7, 'Bài 1', 'sdfgvgbn', '<p>sdfcvb</p>\r\n', NULL, '2019-03-20 14:02:30', 'b', NULL, 3, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binhluan`
--

CREATE TABLE `binhluan` (
  `id_binhluan` int(5) NOT NULL,
  `noidung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hoten` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_tintuc` int(5) NOT NULL,
  `id_baiviet` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

CREATE TABLE `chude` (
  `id_chude` int(5) NOT NULL,
  `tenchude` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`id_chude`, `tenchude`) VALUES
(1, 'JAVA');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhgiahocvien`
--

CREATE TABLE `danhgiahocvien` (
  `id_dghv` int(5) NOT NULL,
  `id_hocvien` int(5) NOT NULL,
  `id_khoahoc` int(5) NOT NULL,
  `id_giangvien` int(5) NOT NULL,
  `id_lophoc` int(5) NOT NULL,
  `diemtrungbinh` float NOT NULL,
  `diemchitiet` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thaido` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `danhgia` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmucbaigiang`
--

CREATE TABLE `danhmucbaigiang` (
  `id_dmb` int(5) NOT NULL,
  `tendanhmuc` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `motachung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_khoahoc` int(5) NOT NULL,
  `ngaytao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nguoitao` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_level` int(5) DEFAULT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmucbaigiang`
--

INSERT INTO `danhmucbaigiang` (`id_dmb`, `tendanhmuc`, `motachung`, `id_khoahoc`, `ngaytao`, `nguoitao`, `id_level`, `storage`) VALUES
(1, 'Phần 1.1', '<h3><a href=\"http://arduino.vn/bai-viet/284-button-nut-bam\">Button - N&uacute;t bấm | Cộng đồng Arduino Việt Nam</a></h3>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><a href=\"http://arduino.vn/bai-viet/284-button-nut-bam\"><cite>arduino.vn &rsaquo; Điện tử cơ bản</cite></a></p>\r\n\r\n<ol>\r\n	<li>&nbsp;</li>\r\n	<li>&nbsp;</li>\r\n</ol>\r\n\r\n<p>30 thg 7, 2014 -&nbsp;Giới thiệu.&nbsp;<em>C&oacute;</em>&nbsp;lẽ ch&uacute;ng ta đ&atilde; qu&aacute; quen với c&aacute;c loại&nbsp;<em>button</em>, n&uacute;t nhấn rồi. Tuy nhi&ecirc;n,&nbsp;<em>c&oacute;</em>&nbsp;thể, chỉ&nbsp;<em>c&oacute;</em>&nbsp;thể th&ocirc;i nh&eacute;, bạn vẫn chưa biết hết về c&aacute;c loại&nbsp;...</p>\r\n\r\n<h3><a href=\"https://v1study.com/bootstrap-nut-buttons.html\">N&uacute;t (Buttons) - | V1Study</a></h3>\r\n', 2, '2019-03-20 05:07:25', 'a', 1, 1),
(2, 'Phần 1', '<h2>Make the application executable</h2>\r\n\r\n<p>Although it is possible to package this service as a traditional&nbsp;<a href=\"https://spring.io/understanding/WAR\">WAR</a>&nbsp;file for deployment to an external application server, the simpler approach demonstrated below creates a&nbsp;<em>standalone application</em>. You package everything in a single, executable JAR file, driven by a good old Java&nbsp;<code>main()</code>&nbsp;method. And along the way, you use Spring&rsquo;s support for embedding the&nbsp;<a href=\"https://spring.io/understanding/Tomcat\">Tomcat</a>servlet container as the HTTP runtime, instead of deploying to an external instance.</p>\r\n\r\n<p>You also want a target folder to upload files to, so let&rsquo;s enhance the basic&nbsp;<code>Application</code>&nbsp;class and add a Boot&nbsp;<code>CommandLineRunner</code>&nbsp;which deletes and re-creates that folder at startup:</p>\r\n', 3, '2019-03-20 03:45:59', 'a', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhsachcauhoi`
--

CREATE TABLE `danhsachcauhoi` (
  `id_cauhoi` int(5) NOT NULL,
  `cauhoi` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `option1` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `option2` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `option3` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `option4` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dapandung` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_baihoc` int(5) NOT NULL,
  `id_khoahoc` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhsachhocvien`
--

CREATE TABLE `danhsachhocvien` (
  `id_dshv` int(5) NOT NULL,
  `madanhsach` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_khoahoc` int(5) NOT NULL,
  `id_lophoc` int(5) NOT NULL,
  `id_hocvien` int(5) NOT NULL,
  `id_giangvien` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diendan`
--

CREATE TABLE `diendan` (
  `id_baiviet` int(5) NOT NULL,
  `chude` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `noidung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaydang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nguoidang` int(5) NOT NULL,
  `id_khoahoc` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `id_giangvien` int(5) NOT NULL,
  `hoten` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `SDT` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `trinhdo` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `motathem` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `bangcap` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `chuyemonchinh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enable` int(5) NOT NULL,
  `id_role` int(5) NOT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`id_giangvien`, `hoten`, `email`, `SDT`, `diachi`, `hinhanh`, `trinhdo`, `gioitinh`, `ngaysinh`, `motathem`, `bangcap`, `chuyemonchinh`, `username`, `password`, `enable`, `id_role`, `storage`) VALUES
(1, 'a', 'a@gmail.com', '012255678', 'b', '', 'dh', 'nu', '2019-03-03', 'd', 'd', '', 'an', '123456', 1, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinhthucthanhtoan`
--

CREATE TABLE `hinhthucthanhtoan` (
  `id_thanhtoan` int(5) NOT NULL,
  `tenthanhtoan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocvien`
--

CREATE TABLE `hocvien` (
  `id_hocvien` int(5) NOT NULL,
  `hoten` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `SDT` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `trinhdohocvan` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `motathem` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_plhv` int(5) NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enable` int(5) NOT NULL,
  `id_role` int(5) NOT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ketqua`
--

CREATE TABLE `ketqua` (
  `id_ketqua` int(5) NOT NULL,
  `cauhoi` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `traloi` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ketqua` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem` float NOT NULL,
  `id_hocvien` int(5) NOT NULL,
  `id_cauhoi` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoahoc`
--

CREATE TABLE `khoahoc` (
  `id_khoahoc` int(5) NOT NULL,
  `tenkhoahoc` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `thongtinchung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `video` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `muctieu` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ketqua` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hocphi` float NOT NULL,
  `id_giangvien` int(5) NOT NULL,
  `nguoitao` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaytao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_chude` int(5) NOT NULL,
  `phathanh` int(5) NOT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khoahoc`
--

INSERT INTO `khoahoc` (`id_khoahoc`, `tenkhoahoc`, `thongtinchung`, `hinhanh`, `video`, `muctieu`, `ketqua`, `hocphi`, `id_giangvien`, `nguoitao`, `ngaytao`, `id_chude`, `phathanh`, `storage`) VALUES
(2, 'Java từ a-z 1', ' All guides are released with an ASLv2 license for the code, and an Attribution, NoDerivatives creative commons license for the writing.', '5-322769002927077.jpg', NULL, 'Although it is possible to package this service as a traditional WAR file for deployment to an external application server, the simpler approach demonstrated below creates a standalone ', ' You package everything in a single, executable JAR file, driven by a good old Java main() method.', 4000000, 1, '4-38247965942805.jpg', '2019-03-20 04:26:07', 1, 0, 1),
(3, 'Java từ a-z 1', ' All guides are released with an ASLv2 license for the code, and an Attribution, NoDerivatives creative commons license for the writing.', '5-322769002927077.jpg', NULL, 'Although it is possible to package this service as a traditional WAR file for deployment to an external application server, the simpler approach demonstrated below creates a standalone ', ' You package everything in a single, executable JAR file, driven by a good old Java main() method.', 4000000, 1, '4-282765839675402.jpg', '2019-03-20 03:45:48', 1, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `level`
--

CREATE TABLE `level` (
  `id_level` int(5) NOT NULL,
  `level` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `level`
--

INSERT INTO `level` (`id_level`, `level`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lienhe`
--

CREATE TABLE `lienhe` (
  `id_lienhe` int(5) NOT NULL,
  `hoten` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `chude` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `noidung` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lienhe`
--

INSERT INTO `lienhe` (`id_lienhe`, `hoten`, `chude`, `noidung`, `email`, `sdt`) VALUES
(1, 'Nguyễn Văn A', 'Câu hỏi JAVA', 'Cách sử dụng eclipse', 'anguyen@gmail.com', '077665485');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lophoc`
--

CREATE TABLE `lophoc` (
  `id_lophoc` int(5) NOT NULL,
  `malophoc` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaytao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nguoitao` int(5) NOT NULL,
  `id_pllh` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phaloailophoc`
--

CREATE TABLE `phaloailophoc` (
  `id_pllh` int(5) NOT NULL,
  `loailop` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanloaihocvien`
--

CREATE TABLE `phanloaihocvien` (
  `id_plhv` int(5) NOT NULL,
  `loaihocvien` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phanloaihocvien`
--

INSERT INTO `phanloaihocvien` (`id_plhv`, `loaihocvien`) VALUES
(1, 'Học viên nội bộ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quangcao`
--

CREATE TABLE `quangcao` (
  `id_quangcao` int(5) NOT NULL,
  `tenquangcao` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lienket` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `tencongty` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quantrivien`
--

CREATE TABLE `quantrivien` (
  `id_qtv` int(5) NOT NULL,
  `hoten` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `SDT` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `enable` int(5) NOT NULL,
  `id_role` int(5) NOT NULL,
  `storage` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quantrivien`
--

INSERT INTO `quantrivien` (`id_qtv`, `hoten`, `email`, `SDT`, `username`, `password`, `hinhanh`, `enable`, `id_role`, `storage`) VALUES
(1, 'Hoàng Thị Cấm Tú', 'camtu.qn24@gmail.com', '778816134', 'admin', '123456', 'DSC_5271-373342125511674.jpg', 1, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quatrinhhoc`
--

CREATE TABLE `quatrinhhoc` (
  `id_qth` int(5) NOT NULL,
  `tenhoatdong` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoigian` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_hocvien` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id_role` int(5) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id_role`, `name`) VALUES
(1, 'Administrator'),
(2, 'Editor'),
(3, 'User');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slider`
--

CREATE TABLE `slider` (
  `id_slide` int(5) NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mota` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thangdodanhgia`
--

CREATE TABLE `thangdodanhgia` (
  `id_thangdo` int(5) NOT NULL,
  `thangdiem` int(5) NOT NULL,
  `loai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tintuc`
--

CREATE TABLE `tintuc` (
  `id_tintuc` int(5) NOT NULL,
  `tentin` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `mota` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `chitiet` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaydang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nguoidang` int(5) NOT NULL,
  `hinhanh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_khoahoc` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baihoc`
--
ALTER TABLE `baihoc`
  ADD PRIMARY KEY (`id_baihoc`),
  ADD KEY `id_chude` (`id_dmb`),
  ADD KEY `id_dmb` (`id_dmb`),
  ADD KEY `id_level` (`id_level`),
  ADD KEY `id_khoahoc` (`id_khoahoc`);

--
-- Chỉ mục cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD PRIMARY KEY (`id_binhluan`),
  ADD KEY `id_tintuc` (`id_tintuc`),
  ADD KEY `id_baiviet` (`id_baiviet`);

--
-- Chỉ mục cho bảng `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`id_chude`);

--
-- Chỉ mục cho bảng `danhgiahocvien`
--
ALTER TABLE `danhgiahocvien`
  ADD PRIMARY KEY (`id_dghv`),
  ADD KEY `id_hocvien` (`id_hocvien`,`id_khoahoc`,`id_giangvien`,`id_lophoc`),
  ADD KEY `id_giangvien` (`id_giangvien`),
  ADD KEY `id_khoahoc` (`id_khoahoc`),
  ADD KEY `id_lophoc` (`id_lophoc`);

--
-- Chỉ mục cho bảng `danhmucbaigiang`
--
ALTER TABLE `danhmucbaigiang`
  ADD PRIMARY KEY (`id_dmb`),
  ADD KEY `id_khoahoc` (`id_khoahoc`),
  ADD KEY `id_level` (`id_level`);

--
-- Chỉ mục cho bảng `danhsachcauhoi`
--
ALTER TABLE `danhsachcauhoi`
  ADD PRIMARY KEY (`id_cauhoi`),
  ADD KEY `id_baihoc` (`id_baihoc`),
  ADD KEY `id_khoahoc` (`id_khoahoc`);

--
-- Chỉ mục cho bảng `danhsachhocvien`
--
ALTER TABLE `danhsachhocvien`
  ADD PRIMARY KEY (`id_dshv`),
  ADD KEY `id_khoahoc` (`id_khoahoc`),
  ADD KEY `id_lophoc` (`id_lophoc`),
  ADD KEY `id_hocvien` (`id_hocvien`),
  ADD KEY `id_giangvien` (`id_giangvien`);

--
-- Chỉ mục cho bảng `diendan`
--
ALTER TABLE `diendan`
  ADD PRIMARY KEY (`id_baiviet`),
  ADD KEY `id_khoahoc` (`id_khoahoc`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`id_giangvien`);

--
-- Chỉ mục cho bảng `hinhthucthanhtoan`
--
ALTER TABLE `hinhthucthanhtoan`
  ADD PRIMARY KEY (`id_thanhtoan`);

--
-- Chỉ mục cho bảng `hocvien`
--
ALTER TABLE `hocvien`
  ADD PRIMARY KEY (`id_hocvien`),
  ADD KEY `id_plhv` (`id_plhv`);

--
-- Chỉ mục cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD PRIMARY KEY (`id_ketqua`),
  ADD KEY `id_hocvien` (`id_hocvien`),
  ADD KEY `id_cauhoi` (`id_cauhoi`);

--
-- Chỉ mục cho bảng `khoahoc`
--
ALTER TABLE `khoahoc`
  ADD PRIMARY KEY (`id_khoahoc`),
  ADD KEY `id_giangvien` (`id_giangvien`),
  ADD KEY `id_chude` (`id_chude`);

--
-- Chỉ mục cho bảng `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Chỉ mục cho bảng `lienhe`
--
ALTER TABLE `lienhe`
  ADD PRIMARY KEY (`id_lienhe`);

--
-- Chỉ mục cho bảng `lophoc`
--
ALTER TABLE `lophoc`
  ADD PRIMARY KEY (`id_lophoc`),
  ADD KEY `id_pllh` (`id_pllh`);

--
-- Chỉ mục cho bảng `phaloailophoc`
--
ALTER TABLE `phaloailophoc`
  ADD PRIMARY KEY (`id_pllh`);

--
-- Chỉ mục cho bảng `phanloaihocvien`
--
ALTER TABLE `phanloaihocvien`
  ADD PRIMARY KEY (`id_plhv`);

--
-- Chỉ mục cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`id_quangcao`);

--
-- Chỉ mục cho bảng `quantrivien`
--
ALTER TABLE `quantrivien`
  ADD PRIMARY KEY (`id_qtv`);

--
-- Chỉ mục cho bảng `quatrinhhoc`
--
ALTER TABLE `quatrinhhoc`
  ADD PRIMARY KEY (`id_qth`),
  ADD KEY `id_hocvien` (`id_hocvien`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_role`);

--
-- Chỉ mục cho bảng `slider`
--
ALTER TABLE `slider`
  ADD PRIMARY KEY (`id_slide`);

--
-- Chỉ mục cho bảng `thangdodanhgia`
--
ALTER TABLE `thangdodanhgia`
  ADD PRIMARY KEY (`id_thangdo`);

--
-- Chỉ mục cho bảng `tintuc`
--
ALTER TABLE `tintuc`
  ADD PRIMARY KEY (`id_tintuc`),
  ADD KEY `id_khoahoc` (`id_khoahoc`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `baihoc`
--
ALTER TABLE `baihoc`
  MODIFY `id_baihoc` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  MODIFY `id_binhluan` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `chude`
--
ALTER TABLE `chude`
  MODIFY `id_chude` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `danhgiahocvien`
--
ALTER TABLE `danhgiahocvien`
  MODIFY `id_dghv` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `danhmucbaigiang`
--
ALTER TABLE `danhmucbaigiang`
  MODIFY `id_dmb` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `danhsachcauhoi`
--
ALTER TABLE `danhsachcauhoi`
  MODIFY `id_cauhoi` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `danhsachhocvien`
--
ALTER TABLE `danhsachhocvien`
  MODIFY `id_dshv` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `diendan`
--
ALTER TABLE `diendan`
  MODIFY `id_baiviet` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  MODIFY `id_giangvien` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `hinhthucthanhtoan`
--
ALTER TABLE `hinhthucthanhtoan`
  MODIFY `id_thanhtoan` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `hocvien`
--
ALTER TABLE `hocvien`
  MODIFY `id_hocvien` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  MODIFY `id_ketqua` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `khoahoc`
--
ALTER TABLE `khoahoc`
  MODIFY `id_khoahoc` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `level`
--
ALTER TABLE `level`
  MODIFY `id_level` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `lienhe`
--
ALTER TABLE `lienhe`
  MODIFY `id_lienhe` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `lophoc`
--
ALTER TABLE `lophoc`
  MODIFY `id_lophoc` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `phaloailophoc`
--
ALTER TABLE `phaloailophoc`
  MODIFY `id_pllh` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `phanloaihocvien`
--
ALTER TABLE `phanloaihocvien`
  MODIFY `id_plhv` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `id_quangcao` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `quantrivien`
--
ALTER TABLE `quantrivien`
  MODIFY `id_qtv` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `quatrinhhoc`
--
ALTER TABLE `quatrinhhoc`
  MODIFY `id_qth` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id_role` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `slider`
--
ALTER TABLE `slider`
  MODIFY `id_slide` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `thangdodanhgia`
--
ALTER TABLE `thangdodanhgia`
  MODIFY `id_thangdo` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT cho bảng `tintuc`
--
ALTER TABLE `tintuc`
  MODIFY `id_tintuc` int(5) NOT NULL AUTO_INCREMENT;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baihoc`
--
ALTER TABLE `baihoc`
  ADD CONSTRAINT `baihoc_ibfk_1` FOREIGN KEY (`id_dmb`) REFERENCES `danhmucbaigiang` (`id_dmb`),
  ADD CONSTRAINT `baihoc_ibfk_2` FOREIGN KEY (`id_level`) REFERENCES `level` (`id_level`),
  ADD CONSTRAINT `baihoc_ibfk_3` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`);

--
-- Các ràng buộc cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD CONSTRAINT `binhluan_ibfk_1` FOREIGN KEY (`id_baiviet`) REFERENCES `diendan` (`id_baiviet`),
  ADD CONSTRAINT `binhluan_ibfk_2` FOREIGN KEY (`id_tintuc`) REFERENCES `tintuc` (`id_tintuc`);

--
-- Các ràng buộc cho bảng `danhgiahocvien`
--
ALTER TABLE `danhgiahocvien`
  ADD CONSTRAINT `danhgiahocvien_ibfk_1` FOREIGN KEY (`id_giangvien`) REFERENCES `giangvien` (`id_giangvien`),
  ADD CONSTRAINT `danhgiahocvien_ibfk_2` FOREIGN KEY (`id_hocvien`) REFERENCES `hocvien` (`id_hocvien`),
  ADD CONSTRAINT `danhgiahocvien_ibfk_3` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`),
  ADD CONSTRAINT `danhgiahocvien_ibfk_4` FOREIGN KEY (`id_lophoc`) REFERENCES `lophoc` (`id_lophoc`);

--
-- Các ràng buộc cho bảng `danhmucbaigiang`
--
ALTER TABLE `danhmucbaigiang`
  ADD CONSTRAINT `danhmucbaigiang_ibfk_1` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`),
  ADD CONSTRAINT `danhmucbaigiang_ibfk_2` FOREIGN KEY (`id_level`) REFERENCES `level` (`id_level`);

--
-- Các ràng buộc cho bảng `danhsachcauhoi`
--
ALTER TABLE `danhsachcauhoi`
  ADD CONSTRAINT `danhsachcauhoi_ibfk_1` FOREIGN KEY (`id_baihoc`) REFERENCES `baihoc` (`id_baihoc`),
  ADD CONSTRAINT `danhsachcauhoi_ibfk_2` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`);

--
-- Các ràng buộc cho bảng `danhsachhocvien`
--
ALTER TABLE `danhsachhocvien`
  ADD CONSTRAINT `danhsachhocvien_ibfk_1` FOREIGN KEY (`id_giangvien`) REFERENCES `giangvien` (`id_giangvien`),
  ADD CONSTRAINT `danhsachhocvien_ibfk_2` FOREIGN KEY (`id_hocvien`) REFERENCES `hocvien` (`id_hocvien`),
  ADD CONSTRAINT `danhsachhocvien_ibfk_3` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`),
  ADD CONSTRAINT `danhsachhocvien_ibfk_4` FOREIGN KEY (`id_lophoc`) REFERENCES `lophoc` (`id_lophoc`);

--
-- Các ràng buộc cho bảng `diendan`
--
ALTER TABLE `diendan`
  ADD CONSTRAINT `diendan_ibfk_1` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`);

--
-- Các ràng buộc cho bảng `hocvien`
--
ALTER TABLE `hocvien`
  ADD CONSTRAINT `hocvien_ibfk_1` FOREIGN KEY (`id_plhv`) REFERENCES `phanloaihocvien` (`id_plhv`);

--
-- Các ràng buộc cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD CONSTRAINT `ketqua_ibfk_1` FOREIGN KEY (`id_hocvien`) REFERENCES `hocvien` (`id_hocvien`),
  ADD CONSTRAINT `ketqua_ibfk_2` FOREIGN KEY (`id_cauhoi`) REFERENCES `danhsachcauhoi` (`id_cauhoi`);

--
-- Các ràng buộc cho bảng `khoahoc`
--
ALTER TABLE `khoahoc`
  ADD CONSTRAINT `khoahoc_ibfk_1` FOREIGN KEY (`id_chude`) REFERENCES `chude` (`id_chude`),
  ADD CONSTRAINT `khoahoc_ibfk_2` FOREIGN KEY (`id_giangvien`) REFERENCES `giangvien` (`id_giangvien`);

--
-- Các ràng buộc cho bảng `lophoc`
--
ALTER TABLE `lophoc`
  ADD CONSTRAINT `lophoc_ibfk_1` FOREIGN KEY (`id_pllh`) REFERENCES `phaloailophoc` (`id_pllh`);

--
-- Các ràng buộc cho bảng `quatrinhhoc`
--
ALTER TABLE `quatrinhhoc`
  ADD CONSTRAINT `quatrinhhoc_ibfk_1` FOREIGN KEY (`id_hocvien`) REFERENCES `hocvien` (`id_hocvien`);

--
-- Các ràng buộc cho bảng `tintuc`
--
ALTER TABLE `tintuc`
  ADD CONSTRAINT `tintuc_ibfk_1` FOREIGN KEY (`id_khoahoc`) REFERENCES `khoahoc` (`id_khoahoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
