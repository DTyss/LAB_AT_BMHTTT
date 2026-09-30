# LAB4 - Khảo sát bề mặt mạng bằng Nmap

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT
- Báo cáo: [11THMT-LAB4_1150080046-NguyenThanhDanh.docx](11THMT-LAB4_1150080046-NguyenThanhDanh.docx)
- Video demo: https://youtu.be/5OM3Lwc_DeY

## Môi trường
- Máy thật: Windows 11 + Nmap 7.94
- VirtualBox Host-Only 192.168.56.0/24
- Kali (192.168.56.10) quét Metasploitable 2 (192.168.56.101)

## Nội dung đã làm
- Host discovery `-sn`, so sánh `-sT` và `-sS`
- FIN/Xmas/NULL, ACK scan, quét UDP
- `-sV`, `-O`, `-A`

## Kết quả
- Metasploitable 2 mở khoảng 23 cổng (21, 22, 80, 445, 3306...), OS đoán Linux 2.6.x
- `-sT` và `-sS` ra cùng danh sách cổng, `-sS` cần sudo
- Ảnh minh chứng đã chèn trực tiếp trong báo cáo

## Lỗi gặp
- Windows báo `nmap is not recognized`: đóng mở lại Terminal cho nạp PATH
- `-sS` báo thiếu quyền: thêm `sudo`
