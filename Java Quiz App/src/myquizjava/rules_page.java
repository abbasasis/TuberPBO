package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rules_page extends JFrame implements ActionListener {

    String name, nameid;
    JButton start_btn, back_btn;

    rules_page(String name, String nameid) {
        this.name = name;
        this.nameid= nameid;

        JLabel heading = new JLabel("Welcome " + name + " Your Id Is "+nameid);
        heading.setBounds(320, 0, 800, 100);
        heading.setFont(new Font("serif", Font.BOLD, 26));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel heading2 = new JLabel("Please Read The Rules Carefully! ");
        heading2.setBounds(320, 40, 800, 100);
        heading2.setFont(new Font("serif", Font.BOLD, 26));
        heading2.setForeground(Color.BLACK);
        add(heading2);


        JLabel heading1 = new JLabel();
        heading1.setBounds(20, 70, 700, 450);
        heading1.setFont(new Font("serif", Font.PLAIN, 16));
        heading1.setForeground(Color.BLACK);
        heading1.setText("<html>"
                + "1. Pilih hanya satu opsi dalam satu waktu" + "<br><br>"
                + "2. Jangan menutup atau meminimalkan jendela" + "<br><br>"
                + "3. Kamu harus menyelesaikan semua pertanyaan dalam batas waktu" + "<br><br>"
                + "4. Jangan menggunakan internet untuk mencari jawaban" + "<br><br>"
                + "5. Percayalah pada dirimu sendiri dan jangan terlalu percaya diri" + "<br><br>"
                + "6. Memilih lebih dari satu opsi dapat menyebabkan akunmu ditangguhkan" + "<br><br>"
                + "7. Gunakan bantuan 50:50 untuk menjawab pertanyaan" + "<br><br>"
                + "8. Kuis ini akan menguji pengetahuanmu, semoga berhasil" + "<br><br>"
                + "<html>");

        add(heading1);

        start_btn = new JButton("Start ");
        start_btn.setBounds(250, 470, 90, 30);
        start_btn.setBackground(Color.BLACK);
        start_btn.setForeground(Color.white);
        start_btn.addActionListener(this);
        add(start_btn);

        back_btn = new JButton("Back ");
        back_btn.setBounds(480, 470, 90, 30);
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.white);
        back_btn.addActionListener(this);
        add(back_btn);

        setLayout(null);

        setSize(1000, 600);
        setVisible(true);
        setLocation(250, 150);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start_btn) {
            
            setVisible(false);
            new quiz_page(name);
            
        }else{
            
            
            new login_page();
            setVisible(false); 
            
        }
    }

    public static void main(String[] args) {

        new rules_page("User", "1235");

    }

}
