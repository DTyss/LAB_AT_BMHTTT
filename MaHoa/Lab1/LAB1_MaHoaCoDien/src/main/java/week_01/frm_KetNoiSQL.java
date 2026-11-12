package week_01;

import java.awt.Font;
import javax.swing.JOptionPane;

public class frm_KetNoiSQL extends javax.swing.JFrame {

    private javax.swing.JTextField txt_server, txt_port, txt_database, txt_user;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JButton btn_test, btn_history;
    private javax.swing.JLabel lbl_status;

    public frm_KetNoiSQL() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kết nối Microsoft SQL Server");
        getContentPane().setLayout(null);

        javax.swing.JLabel t = new javax.swing.JLabel("KẾT NỐI MICROSOFT SQL SERVER");
        t.setFont(new Font("Segoe UI", Font.BOLD, 18)); t.setBounds(16, 10, 450, 34); add(t);

        String[][] rows = {{"Server:", "127.0.0.1"}, {"Port:", "14333"}, {"Database:", "LAB1_MaHoaCoDien"}, {"User:", "lab1_user"}, {"Password:", ""}};
        int y = 56;
        javax.swing.JTextField[] fields = new javax.swing.JTextField[4];
        for (int i = 0; i < rows.length; i++) {
            javax.swing.JLabel lb = new javax.swing.JLabel(rows[i][0]); lb.setBounds(16, y, 100, 22); add(lb);
            if (i < 4) { fields[i] = new javax.swing.JTextField(rows[i][1]); fields[i].setBounds(120, y - 2, 320, 28); add(fields[i]); }
            else { txt_password = new javax.swing.JPasswordField(); txt_password.setBounds(120, y - 2, 320, 28); add(txt_password); }
            y += 36;
        }
        txt_server = fields[0]; txt_port = fields[1]; txt_database = fields[2]; txt_user = fields[3];

        btn_test = new javax.swing.JButton("Test Connection"); btn_test.setBounds(120, y + 4, 150, 30); add(btn_test);
        btn_history = new javax.swing.JButton("Xem lịch sử"); btn_history.setBounds(290, y + 4, 150, 30); add(btn_history);
        lbl_status = new javax.swing.JLabel("Chưa kết nối."); lbl_status.setBounds(16, y + 44, 450, 40); add(lbl_status);

        btn_test.addActionListener(e -> testAction());
        btn_history.addActionListener(e -> new frm_LichSu().setVisible(true));

        getContentPane().setPreferredSize(new java.awt.Dimension(470, y + 96));
        pack();
    }

    private void testAction() {
        try {
            int port = Integer.parseInt(txt_port.getText().trim());
            DbConfig.set(txt_server.getText().trim(), port, txt_database.getText().trim(),
                    txt_user.getText().trim(), txt_password.getPassword());
            lbl_status.setText("<html>" + DbConfig.test() + "</html>");
        } catch (Exception ex) {
            DbConfig.clear();
            lbl_status.setText("<html>Kết nối thất bại: " + ex.getMessage() + "</html>");
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Không kết nối được SQL Server", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frm_KetNoiSQL().setVisible(true));
    }
}
