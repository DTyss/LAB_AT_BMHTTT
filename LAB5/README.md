# LAB5 - Thiết lập tường lửa pfSense

- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT

## Môi trường
- VirtualBox - pfSense CE 2.7.2
- WAN (NAT Network lab5-wan), LAN 10.0.0.0/8, DMZ 172.16.0.0/16

## Kết quả
- pfSense cài xong, LAN 10.0.0.1/8, WAN có internet qua NAT (192.168.250.x)
- DMZ interface 172.16.0.1/16 đã Apply; Outbound NAT tự sinh cho LAN 10.0.0.0/8 và DMZ 172.16.0.0/16
- Rule Block phải nằm trên rule Pass; pfSense là stateful nên phải Reset States khi test
