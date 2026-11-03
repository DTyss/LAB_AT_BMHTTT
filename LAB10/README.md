# LAB10 - Remote DNS Cache Poisoning (mô phỏng tấn công Kaminsky)

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- Kế thừa mạng DNS-LAB 10.9.0.0/24; bổ sung mạng tấn công ATTACKNET 10.10.0.0/24
- DNS-SERVER: Ubuntu Server 24.04, BIND9 resolver, 10.9.0.10
- VICTIM 10.9.0.100; ATTACKER Kali chuyển sang 10.10.0.200 (không còn cùng mạng DNS-LAB)
- AUTH-DNS/RELAY mô phỏng 172.16.6.20, DMZ-WEB 172.16.6.10, miền example.lab10.test

## Kết quả
- Dựng BIND9 baseline: recursion ACL chỉ 10.9.0.0/24, forward example.lab10.test tới AUTH-DNS, validate-except cho miền .test; kiểm tra bằng named-checkconf
- Hardening thật: BIND9 dùng cổng nguồn UDP ngẫu nhiên mỗi truy vấn (đối lập cổng cố định 33333 của resolver mô phỏng); recursion ACL từ chối (REFUSED) truy vấn từ mạng ATTACKNET 10.10.0.200
- Phân tích pha tấn công Kaminsky: resolver mô phỏng có lỗ hổng chủ đích, đoán transaction ID 16-bit qua kênh race, NS giả + glue trỏ về attacker, cache poisoning và so sánh baseline/attack/restore
- Ruleset cô lập DNSLAB và ATTACKNET trên pfSense (thiết kế)
