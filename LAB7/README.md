# LAB7 - Xây dựng chính sách Web Protection trên pfSense + Web Proxy

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- Kế thừa Lab 6: pfSense-LAB6, DC01 (10.6.0.10), Client-A/B (10.6.0.21/22), DMZ-WEB (172.16.6.10)
- Bổ sung WEB-PROXY: Ubuntu Server 24.04, 10.6.0.30 - E2Guardian (8080) -> Squid (3128) -> ClamAV
- Website mô phỏng .lab7.test trỏ về 172.16.6.10, DNS trên DC01
- Không cài Squid trực tiếp trên pfSense (Netgate đánh dấu deprecated)

## Kết quả
- pfSense ép Client-A/B đi qua proxy (alias + ruleset chống bypass: chặn direct 80/443, chỉ cho proxy ra web)
- Chính sách Web: Hard block (Geo-Sim China/Mideast, Job Search, blockedgame), Warning/temporary bypass (weapons/politics/religion/streaming), Exception (normal/education/download)
- Kiểm thử các kịch bản baseline, Geo-Sim, Job Search, warning content, education; đối chiếu log pfSense + E2Guardian + Squid
