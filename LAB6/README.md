# LAB6 - Xác thực Active Directory và chính sách truy cập trên pfSense

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- VirtualBox - pfSense CE, 4 interface: WAN, MGMT, LAN, DMZ
- WAN (NAT Network), MGMT 192.168.56.0/24, LAN 10.6.0.0/24, DMZ 172.16.6.0/24
- DC01 10.6.0.10 (Windows Server 2022, AD DS + DNS, domain lab6.test)

## Kết quả
- Dựng pfSense-Lab6 với 4 interface, cài đặt và cấu hình IP các vùng
- Dựng Domain Controller (Lab6-DC): cài Windows Server, đặt IP tĩnh 10.6.0.10, cài AD DS + DNS, thăng cấp forest lab6.test
- Phần tích hợp LDAP và các kịch bản chính sách (chặn site theo máy, chặn nhóm site, cho phép theo khung giờ) trình bày ở mức thiết kế và phân tích
