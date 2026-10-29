# LAB8 - Local DNS Attack (DNS spoofing và cache poisoning)

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- Mạng DNS-LAB 10.9.0.0/24 đặt phía sau pfSense, cô lập khỏi LAN-DOMAIN
- DNS-SERVER: Ubuntu Server 24.04, BIND9 đệ quy/cache, 10.9.0.10
- VICTIM 10.9.0.100, ATTACKER Kali 10.9.0.200
- AUTH-DNS mô phỏng 172.16.6.20, DMZ-WEB 172.16.6.10, miền thử nghiệm lab9.test

## Kết quả
- Dựng DNS-SERVER BIND9: zone thuận lab9.test (www/portal -> 172.16.6.10, ns -> 10.9.0.10) và zone nghịch 9.10.in-addr.arpa; kiểm tra bằng named-checkconf và named-checkzone
- Baseline: zone nội bộ trả đúng địa chỉ; authoritative mô phỏng trả www.external.lab9.test -> 172.16.6.10
- Task 1: thay đổi /etc/hosts chuyển hướng www.lab9.test về 10.9.0.200 trong khi dig trực tiếp vẫn trả 172.16.6.10, rồi khôi phục
- Phân tích Task 2 (direct DNS spoofing), Task 3 (DNS cache poisoning), ruleset cô lập interface DNSLAB và các biện pháp phòng thủ
