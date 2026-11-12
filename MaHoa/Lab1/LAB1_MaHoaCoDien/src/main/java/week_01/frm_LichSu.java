package week_01;

import java.awt.Font;

public class frm_LichSu extends javax.swing.JFrame {

    private javax.swing.JTable tbl_history;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel lbl_status;

    public frm_LichSu() {
        initComponents();
        setLocationRelativeTo(null);
        tbl_history.setModel(HistoryDao.emptyModel());
        loadData();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lịch sử thao tác (SQL Server)");
        getContentPane().setLayout(null);

        javax.swing.JLabel t = new javax.swing.JLabel("LỊCH SỬ THAO TÁC - BẢNG DBO.HISTORY");
        t.setFont(new Font("Segoe UI", Font.BOLD, 18)); t.setBounds(16, 10, 760, 34); add(t);

        tbl_history = new javax.swing.JTable();
        javax.swing.JScrollPane sp = new javax.swing.JScrollPane(tbl_history);
        sp.setBounds(16, 50, 788, 300); add(sp);

        btn_refresh = new javax.swing.JButton("Tải lại"); btn_refresh.setBounds(16, 360, 110, 30); add(btn_refresh);
        lbl_status = new javax.swing.JLabel("Đang tải..."); lbl_status.setBounds(140, 362, 664, 22); add(lbl_status);

        btn_refresh.addActionListener(e -> loadData());

        getContentPane().setPreferredSize(new java.awt.Dimension(820, 404));
        pack();
    }

    private void loadData() {
        try {
            tbl_history.setModel(HistoryDao.loadLatest(50));
            lbl_status.setText("Đã tải " + tbl_history.getRowCount() + " dòng mới nhất từ dbo.history.");
        } catch (java.sql.SQLException ex) {
            lbl_status.setText("Không đọc được lịch sử: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frm_LichSu().setVisible(true));
    }
}
