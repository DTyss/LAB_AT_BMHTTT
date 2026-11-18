# Lab 2 - Mã hóa đối xứng hiện đại

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- Java Swing (NetBeans GUI Builder) + Maven; JDK 17
- Thư viện: Microsoft JDBC Driver (mssql-jdbc 12.8.1), BouncyCastle (bcprov-jdk18on 1.78.1 — thuật toán Twofish)
- Project `LAB2_MaHoaHienDai`, package `week_02`, lớp chính `week_02.frm_Menu`
- Microsoft SQL Server 2022 Express, instance SQLEXPRESS, giao thức TCP/IP cổng 14333, chế độ xác thực hỗn hợp
- Database `LAB2_MaHoaHienDai` (bảng `dbo.app_users`, `dbo.crypto_history`), tài khoản ứng dụng `lab2_user`
- Phần nâng cao 02 (AES-CBC) viết bằng Python 3 + thư viện `cryptography`

## Cấu trúc thư mục
- `LAB2_MaHoaHienDai/` — mã nguồn Java NetBeans (pom.xml, các lớp `.java` và tệp giao diện `.form`)
  - `src/main/java/week_02/` — lớp dùng chung, sáu lớp thuật toán, mười form
  - `03_SQL_SERVER/01_Tao_CSDL.sql` — tạo database và hai bảng
  - `03_SQL_SERVER/03_Kiem_Tra_Du_Lieu.sql` — kiểm tra dữ liệu đã lưu
- `LAB2_Python/aes_cbc_gui.py` — bài nâng cao AES-256-CBC (Tkinter), có tham số `--self-test`
- `HinhAnh_KetQua/` — ảnh kết quả chạy thật của từng bài
- `11THMT-Lab2_1150080046-NguyenThanhDanh.docx` — báo cáo

## Kết quả
- Cài đặt sáu thuật toán mã hóa đối xứng hiện đại: DES, TripleDES (CBC + IV ngẫu nhiên + đệm PKCS5), AES-GCM (có thẻ xác thực), RC4 (mã dòng, kết quả HEX), Twofish (BouncyCastle, CBC), AES-CTR (không đệm).
- Kết quả trùng với bộ dữ liệu kiểm thử: RC4 với `Plaintext`/`Key` cho `BBF316E8D940AF0AD3`; mọi thuật toán giải mã lại đúng dữ liệu ban đầu; AES-GCM phát hiện khi bản mã bị sửa.
- Đăng ký và đăng nhập có băm mật khẩu bằng PBKDF2 + salt (không lưu mật khẩu gốc), cấp vé phiên sau khi đăng nhập.
- Lưu lịch sử mỗi lần mã hóa/giải mã vào SQL Server bằng `PreparedStatement` (chống SQL Injection), xem lại trên JTable và kiểm tra bằng `03_Kiem_Tra_Du_Lieu.sql`.
- Bài nâng cao Python: AES-256-CBC với PKCS7, `--self-test` in `SELF-TEST OK`.

## Cách chạy
1. Mở `LAB2_MaHoaHienDai` bằng NetBeans, chọn Clean and Build (lần đầu Maven tải thư viện).
2. Trong SSMS chạy `01_Tao_CSDL.sql`, sau đó tạo tài khoản đăng nhập `lab2_user` với mật khẩu lab trên máy cá nhân (kịch bản chứa mật khẩu nên không đưa lên kho mã).
3. Run Project (F6) để mở menu chính; bấm Kết nối SQL Server rồi làm lần lượt từng bài.
4. Bài nâng cao Python: `py -m pip install cryptography` rồi `py aes_cbc_gui.py` (hoặc `py aes_cbc_gui.py --self-test`).

## Lưu ý bảo mật
- Không đăng mật khẩu hay thông tin bảo mật cá nhân lên GitHub: kịch bản tạo tài khoản đăng nhập SQL (chứa mật khẩu) được giữ ngoài kho mã.
- Bảng lịch sử chỉ lưu độ dài dữ liệu, không lưu bản rõ hay khóa; mật khẩu tài khoản lưu dạng băm PBKDF2 + salt.
