# Lab 1 - Mã hóa đối xứng cổ điển

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- Java Swing (NetBeans GUI Builder) + Maven; JDK 17; thư viện Microsoft JDBC Driver (mssql-jdbc)
- Project LAB1_MaHoaCoDien, package week_01, lớp chính week_01.frm_Menu
- Microsoft SQL Server 2022 Express, instance SQLEXPRESS, giao thức TCP/IP cổng 14333
- Database LAB1_MaHoaCoDien (bảng dbo.history), tài khoản ứng dụng lab1_user

## Kết quả
- Cài đặt sáu mật mã cổ điển (Caesar, Vigenère, Rail Fence, Playfair, hoán vị cột, Autokey); kết quả trùng từng ký tự với bộ dữ liệu kiểm thử (HELLO với k=3 ra KHOOR, ...)
- Chương trình tổng hợp chọn thuật toán bằng JComboBox và lưu lịch sử mỗi lần mã hóa/giải mã vào SQL Server (bảng dbo.history, dùng PreparedStatement chống SQL Injection), xem lại trên JTable và trong SSMS
- Phân tích tấn công mật mã cổ điển: vét cạn khóa Caesar, phân tích tần suất chữ cái, biết trước bản rõ suy ra khóa Vigenère
- Menu chính mở từng form; chạy toàn bộ chương trình bằng Run Project (F6)
