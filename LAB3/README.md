# LAB3 — Nhận diện và ứng phó các mối đe dọa đến An toàn Thông tin

## Thông tin sinh viên
- Họ và tên: Nguyễn Thành Danh
- MSSV: 1150080046
- Lớp: 11THMT
- Lab: LAB3 — NHẬN DIỆN VÀ ỨNG PHÓ CÁC MỐI ĐE DỌA ĐẾN AN TOÀN THÔNG TIN


## Phiên bản môi trường
- Windows 11 25H2 x64 (OS build 26200)
- Windows PowerShell 5.1
- Python 3.14 (HTTP server loopback + local load test)
- Microsoft Defender Antivirus — Real-time protection & Tamper Protection
- Wireshark 4.6.8 + Npcap / Sysmon 15.22 / Autoruns 14.3 / Process Explorer 17.14

## Các tình huống đã thực hiện & kết quả PASS/FAIL
- Baseline: ghi trạng thái OS/Defender/Firewall. PASS
- TH1: risk register + phân loại 5 tình huống. PASS
- TH2: EICAR, Defender bắt và quarantine. PASS
- TH3: tạo lab3user, sinh login đúng/sai, xem Event 4624/4625/4648. PASS
- TH4: listener 127.0.0.1:8080 ánh xạ về python.exe. PASS
- TH5: bắt gói HTTP loopback, đọc được plaintext. PASS
- TH6: DoS local, DDoS dataset, mail bombing. PASS
- TH7: phân tích phishing và 6 case social engineering. PASS
- Cleanup: dừng server, xoá lab3user, tính SHA-256 bằng chứng. PASS

## Kết quả số liệu chính
- Defender: Real-time = True, Tamper = True.
- TH4 listener: 127.0.0.1:8080, chủ tiến trình python.exe.
- TH6.1 load test: 50 request, 0 lỗi.
- TH6.2 DDoS: 20 SourceIP khác nhau, IP nhiều nhất 10 gói.
- TH6.3 mail bomb: 1 sender gửi 60/80 thư.

## Lỗi gặp phải & cách khắc phục
- Paste cả khối lệnh nhiều dòng bị gãy (auditpol báo sai tham số). Khắc phục: paste từng dòng hoặc dùng PowerShell ISE.
- Lúc đầu không thấy EICAR trong Protection history. Khắc phục: bật Filters, hoặc kiểm tra bằng Get-MpThreatDetection.
