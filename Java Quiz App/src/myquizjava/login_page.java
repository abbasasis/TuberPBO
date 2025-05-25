package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login_page extends JFrame implements ActionListener {

    JButton btn1, btn2;
    JTextField namefield, idfield;

    login_page() {
        setTitle("TimeCrashQuiz - Login");
        setLayout(null);

        // Gambar kiri
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image_login.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(50, 150, 400, 400);
        add(image);

        // Judul besar
        JLabel heading = new JLabel("TimeCrashQuiz");
        heading.setBounds(580, 80, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        add(heading);

        // Label nama
        JLabel heading1 = new JLabel("Masukkan Nama:");
        heading1.setBounds(550, 200, 200, 30);
        heading1.setFont(new Font("serif", Font.BOLD, 20));
        add(heading1);

        namefield = new JTextField();
        namefield.setBounds(710, 200, 200, 30);
        namefield.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(namefield);

        // Label ID
        JLabel heading2 = new JLabel("Masukkan ID:");
        heading2.setBounds(550, 250, 200, 30);
        heading2.setFont(new Font("serif", Font.BOLD, 20));
        add(heading2);

        idfield = new JTextField();
        idfield.setBounds(710, 250, 200, 30);
        idfield.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(idfield);

        // Tombol Start
        btn1 = new JButton("Start");
        btn1.setBounds(710, 320, 90, 30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn1.addActionListener(this);
        add(btn1);

        // Tombol Exit
        btn2 = new JButton("Exit");
        btn2.setBounds(820, 320, 90, 30);
        btn2.setBackground(Color.RED);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn2.addActionListener(this);
        add(btn2);

        setSize(1000, 800);         // Sama seperti quiz_page
        setLocation(250, 50);       // Sama seperti quiz_page
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = namefield.getText().trim();
        String id = idfield.getText().trim();

        if (ae.getSource() == btn1) {
            if (name.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan ID harus diisi.");
            } else {
                setVisible(false);
                new rules_page(name, id); // Pindah ke halaman rules
            }
        } else if (ae.getSource() == btn2) {
            System.exit(0); // Keluar aplikasi
        }
    }

    public static void main(String[] args) {
        new login_page();
    }
}
