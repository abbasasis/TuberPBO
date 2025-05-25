package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener {

    JButton tryAgain, exit;

    score(String name, int score) {
        setBounds(300, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Terima kasih " + name + " telah mengikuti kuis");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Skor Anda adalah: " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        // Tombol Try Again
        tryAgain = new JButton("Try Again");
        tryAgain.setBounds(360, 270, 130, 30);
        tryAgain.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tryAgain.setBackground(Color.BLACK);
        tryAgain.setForeground(Color.WHITE);
        tryAgain.addActionListener(this);
        add(tryAgain);

        // Tombol Exit
        exit = new JButton("Exit");
        exit.setBounds(360, 320, 130, 30);
        exit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == tryAgain) {
            setVisible(false);
            new quiz_page("user"); // Ganti "user" jika ingin pakai nama yang dinamis
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new score("User", 80);
    }
}
