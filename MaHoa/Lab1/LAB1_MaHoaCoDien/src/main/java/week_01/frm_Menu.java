package week_01;

import java.awt.Font;

public class frm_Menu extends javax.swing.JFrame {

    public frm_Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LAB 1 - Mã hóa đối xứng cổ điển");
        getContentPane().setLayout(null);

        javax.swing.JLabel t = new javax.swing.JLabel("LAB 1 - MÃ HÓA ĐỐI XỨNG CỔ ĐIỂN");
        t.setFont(new Font("Segoe UI", Font.BOLD, 20)); t.setBounds(16, 12, 640, 38); add(t);
        javax.swing.JLabel s = new javax.swing.JLabel("Chọn một bài để mở form tương ứng:");
        s.setBounds(16, 54, 640, 22); add(s);

        String[][] b = {
            {"1.1 Caesar", "caesar"}, {"1.2 Vigenère", "vigenere"}, {"1.3 Rail Fence", "railfence"},
            {"1.4 Playfair", "playfair"}, {"1.5 Transposition", "transposition"}, {"1.6 Autokey", "autokey"},
            {"Nâng cao 01 - Tổng hợp", "tonghop"}, {"Nâng cao 02 - Tấn công", "tancong"},
            {"Kết nối SQL Server", "sql"}
        };
        int x = 16, y = 86;
        for (int i = 0; i < b.length; i++) {
            javax.swing.JButton btn = new javax.swing.JButton(b[i][0]);
            btn.setBounds(x, y, 200, 32);
            final String act = b[i][1];
            btn.addActionListener(e -> open(act));
            add(btn);
            if (i % 2 == 0) { x = 232; } else { x = 16; y += 42; }
        }
        javax.swing.JLabel note = new javax.swing.JLabel("Mỗi form mở ra là một cửa sổ riêng; đóng form con không làm tắt chương trình.");
        note.setBounds(16, y + 48, 640, 22); add(note);

        getContentPane().setPreferredSize(new java.awt.Dimension(460, y + 86));
        pack();
    }

    private void open(String act) {
        switch (act) {
            case "caesar": new frm_Caesar().setVisible(true); break;
            case "vigenere": new frm_Vigenere().setVisible(true); break;
            case "railfence": new frm_RailFence().setVisible(true); break;
            case "playfair": new frm_Playfair().setVisible(true); break;
            case "transposition": new frm_Transposition().setVisible(true); break;
            case "autokey": new frm_Autokey().setVisible(true); break;
            case "tonghop": new frm_TongHop().setVisible(true); break;
            case "tancong": new frm_TanCong().setVisible(true); break;
            case "sql": new frm_KetNoiSQL().setVisible(true); break;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frm_Menu().setVisible(true));
    }
}
