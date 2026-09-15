# Lab 1 - Bắt gói tin Telnet & SSH bằng Wireshark

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11_ĐH_THMT
- Tên bài Lab: Lab 1 - Examining SSH & Telnet in Wireshark
- Báo cáo: [Lab1_11THMT_1150080046_NguyenThanhDanh.docx](Lab1_11THMT_1150080046_NguyenThanhDanh.docx)
- Video demo: https://youtu.be/uNSa05ZmaD8

## Nội dung đã thực hiện
- Trên máy ảo đã tạo port 22 tương ứng với ssh và port 23 tương ứng với telnet.
- Sử dụng putty connect với 2 port 22 và 23 đã tạo và chạy vài lệnh terminal cơ bản
- Kiểm tra các pack trên wireshark.

## Kết quả thực hiện
- Trên máy ảo đã tạo được và lắng nghe thành công với port 22 (SSH) và port 23 (Telnet).
- Sử dụng PuTTY connect thành công với cả port 22 và port 23 và cũng đã chạy được các lệnh terminal cơ bản.
- Kiểm tra TCP.Stream trên wireshark đối với port 23 (telnet) các thông tin đều hiển thị dưới dạng có thể đọc được, đối với port 22(SSH) thì nội dung đã bị mã hoá và không thể đọc được

## Lưu ý để giảng viên kiểm tra / chạy lại
