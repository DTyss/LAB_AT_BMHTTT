package week_01;

import java.awt.Font;
import javax.swing.JOptionPane;

public class frm_TongHop extends javax.swing.JFrame {

    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel5, lbl_hint, lbl_status;
    private javax.swing.JComboBox<String> cbo_algorithm;
    private javax.swing.JTextArea txt_plaintext, txt_ciphertext;
    private javax.swing.JTextField txt_key;
    private javax.swing.JButton btn_encrypt, btn_decrypt, btn_open, btn_save, btn_sql, btn_history;
    private javax.swing.JScrollPane sp1, sp2;

    public frm_TongHop() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chương trình tổng hợp - 6 thuật toán");
        getContentPane().setLayout(null);

        jLabel1 = new javax.swing.JLabel("CHƯƠNG TRÌNH TỔNG HỢP 6 THUẬT TOÁN CỔ ĐIỂN");
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel1.setBounds(16, 10, 640, 34); add(jLabel1);

        jLabel2 = new javax.swing.JLabel("Thuật toán:"); jLabel2.setBounds(16, 56, 90, 22); add(jLabel2);
        cbo_algorithm = new javax.swing.JComboBox<>(CipherTongHop.ALGORITHMS);
        cbo_algorithm.setBounds(112, 54, 200, 28); add(cbo_algorithm);
        cbo_algorithm.addActionListener(e -> cbo_algorithmAction());

        lbl_hint = new javax.swing.JLabel("Khóa mẫu: 3"); lbl_hint.setBounds(330, 56, 320, 22); add(lbl_hint);

        jLabel3 = new javax.swing.JLabel("Plaintext:"); jLabel3.setBounds(16, 92, 90, 22); add(jLabel3);
        txt_plaintext = new javax.swing.JTextArea(3, 20); txt_plaintext.setLineWrap(true);
        sp1 = new javax.swing.JScrollPane(txt_plaintext); sp1.setBounds(112, 90, 538, 70); add(sp1);

        javax.swing.JLabel jLabel4 = new javax.swing.JLabel("Key:"); jLabel4.setBounds(16, 172, 90, 22); add(jLabel4);
        txt_key = new javax.swing.JTextField("3"); txt_key.setBounds(112, 170, 200, 28); add(txt_key);

        jLabel5 = new javax.swing.JLabel("Ciphertext:"); jLabel5.setBounds(16, 212, 90, 22); add(jLabel5);
        txt_ciphertext = new javax.swing.JTextArea(3, 20); txt_ciphertext.setLineWrap(true);
        sp2 = new javax.swing.JScrollPane(txt_ciphertext); sp2.setBounds(112, 210, 538, 70); add(sp2);

        btn_encrypt = new javax.swing.JButton("Encrypt"); btn_encrypt.setBounds(112, 296, 100, 30); add(btn_encrypt);
        btn_decrypt = new javax.swing.JButton("Decrypt"); btn_decrypt.setBounds(222, 296, 100, 30); add(btn_decrypt);
        btn_open = new javax.swing.JButton("Open File"); btn_open.setBounds(332, 296, 110, 30); add(btn_open);
        btn_save = new javax.swing.JButton("Save File"); btn_save.setBounds(452, 296, 110, 30); add(btn_save);
        btn_sql = new javax.swing.JButton("Kết nối SQL Server"); btn_sql.setBounds(112, 336, 180, 30); add(btn_sql);
        btn_history = new javax.swing.JButton("Xem lịch sử"); btn_history.setBounds(302, 336, 140, 30); add(btn_history);

        lbl_status = new javax.swing.JLabel("Sẵn sàng."); lbl_status.setBounds(16, 376, 640, 22); add(lbl_status);

        btn_encrypt.addActionListener(e -> encryptAction());
        btn_decrypt.addActionListener(e -> decryptAction());
        btn_open.addActionListener(e -> { String p = FileTextIO.openText(this, txt_ciphertext); if (p != null) lbl_status.setText("Đã mở tệp: " + p); });
        btn_save.addActionListener(e -> { String p = FileTextIO.saveText(this, txt_ciphertext, "ciphertext.txt"); if (p != null) lbl_status.setText("Đã lưu tệp: " + p); });
        btn_sql.addActionListener(e -> new frm_KetNoiSQL().setVisible(true));
        btn_history.addActionListener(e -> new frm_LichSu().setVisible(true));

        getContentPane().setPreferredSize(new java.awt.Dimension(666, 410));
        pack();
    }

    private void cbo_algorithmAction() {
        String algorithm = (String) cbo_algorithm.getSelectedItem();
        txt_key.setText(CipherTongHop.sampleKey(algorithm));
        lbl_hint.setText("Khóa mẫu: " + CipherTongHop.sampleKey(algorithm));
    }

    private void encryptAction() {
        String algorithm = (String) cbo_algorithm.getSelectedItem();
        String input = txt_plaintext.getText();
        try {
            String result = CipherTongHop.encrypt(algorithm, input, txt_key.getText());
            txt_ciphertext.setText(result);
            String saved = HistoryDao.tryInsert(algorithm, "ENCRYPT", input, result);
            lbl_status.setText("Đã mã hóa " + algorithm + ". " + saved);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Dữ liệu không hợp lệ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decryptAction() {
        String algorithm = (String) cbo_algorithm.getSelectedItem();
        String input = txt_ciphertext.getText();
        try {
            String result = CipherTongHop.decrypt(algorithm, input, txt_key.getText());
            txt_plaintext.setText(result);
            String saved = HistoryDao.tryInsert(algorithm, "DECRYPT", input, result);
            lbl_status.setText("Đã giải mã " + algorithm + ". " + saved);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Dữ liệu không hợp lệ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frm_TongHop().setVisible(true));
    }
}
