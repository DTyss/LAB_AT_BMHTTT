package week_01;

import java.awt.Font;
import javax.swing.JOptionPane;

public class frm_TanCong extends javax.swing.JFrame {

    private javax.swing.JTextArea txt_cipher, txt_result;
    private javax.swing.JTextField txt_known_plain, txt_known_cipher;
    private javax.swing.JButton btn_bruteforce, btn_frequency, btn_known;
    private javax.swing.JLabel lbl_status;

    public frm_TanCong() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Phân tích mật mã cổ điển");
        getContentPane().setLayout(null);

        javax.swing.JLabel t = new javax.swing.JLabel("PHÂN TÍCH (TẤN CÔNG) MẬT MÃ CỔ ĐIỂN");
        t.setFont(new Font("Segoe UI", Font.BOLD, 18)); t.setBounds(16, 10, 620, 34); add(t);

        javax.swing.JLabel l1 = new javax.swing.JLabel("Ciphertext:"); l1.setBounds(16, 54, 130, 22); add(l1);
        txt_cipher = new javax.swing.JTextArea(2, 20); txt_cipher.setLineWrap(true);
        javax.swing.JScrollPane sp1 = new javax.swing.JScrollPane(txt_cipher); sp1.setBounds(150, 52, 480, 50); add(sp1);

        btn_bruteforce = new javax.swing.JButton("Brute Force Caesar"); btn_bruteforce.setBounds(150, 110, 170, 30); add(btn_bruteforce);
        btn_frequency = new javax.swing.JButton("Frequency Analysis"); btn_frequency.setBounds(330, 110, 170, 30); add(btn_frequency);

        javax.swing.JLabel l2 = new javax.swing.JLabel("Bản rõ đã biết:"); l2.setBounds(16, 150, 130, 22); add(l2);
        txt_known_plain = new javax.swing.JTextField("HELLO"); txt_known_plain.setBounds(150, 148, 140, 28); add(txt_known_plain);
        javax.swing.JLabel l3 = new javax.swing.JLabel("Bản mã:"); l3.setBounds(300, 150, 60, 22); add(l3);
        txt_known_cipher = new javax.swing.JTextField("RIJVS"); txt_known_cipher.setBounds(362, 148, 140, 28); add(txt_known_cipher);
        btn_known = new javax.swing.JButton("Known Plaintext (Vigenere)"); btn_known.setBounds(150, 182, 220, 30); add(btn_known);

        javax.swing.JLabel l4 = new javax.swing.JLabel("Kết quả:"); l4.setBounds(16, 220, 130, 22); add(l4);
        txt_result = new javax.swing.JTextArea(3, 20); txt_result.setEditable(false);
        txt_result.setFont(new Font("Consolas", Font.PLAIN, 13));
        javax.swing.JScrollPane sp2 = new javax.swing.JScrollPane(txt_result); sp2.setBounds(150, 218, 480, 250); add(sp2);

        lbl_status = new javax.swing.JLabel("Sẵn sàng."); lbl_status.setBounds(16, 474, 480, 22); add(lbl_status);

        btn_bruteforce.addActionListener(e -> {
            String c = txt_cipher.getText().trim();
            if (c.isEmpty()) { JOptionPane.showMessageDialog(this, "Hãy nhập Ciphertext."); return; }
            txt_result.setText(AttackDemos.caesarBruteForce(c)); txt_result.setCaretPosition(0);
            lbl_status.setText("Đã thử đủ 26 khóa Caesar.");
        });
        btn_frequency.addActionListener(e -> {
            String c = txt_cipher.getText().trim();
            if (c.isEmpty()) { JOptionPane.showMessageDialog(this, "Hãy nhập Ciphertext."); return; }
            txt_result.setText(AttackDemos.frequency(c)); txt_result.setCaretPosition(0);
            lbl_status.setText("Đã thống kê tần suất chữ cái.");
        });
        btn_known.addActionListener(e -> {
            try {
                String key = AttackDemos.knownPlaintext(txt_known_plain.getText(), txt_known_cipher.getText());
                txt_result.setText("Khóa Vigenère suy ra từng vị trí: " + key
                        + "\nNếu khóa ngắn hơn bản rõ, khóa sẽ lặp lại (KEY KEY ...).");
                lbl_status.setText("Khóa suy ra: " + key);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Dữ liệu không hợp lệ", JOptionPane.ERROR_MESSAGE);
            }
        });

        getContentPane().setPreferredSize(new java.awt.Dimension(648, 506));
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frm_TanCong().setVisible(true));
    }
}
