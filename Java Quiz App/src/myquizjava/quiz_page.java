package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz_page extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] answergiver = new String[10][1];

    JLabel titleLabel, questionLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup grouping;
    JButton nextbtn, submit;

    int timer;
    int count;
    int score;
    long startTime;

    String name;
    Thread timerThread;

    CircularTimerPanel circularTimer;

    public quiz_page(String name) {
        this.name = name;
        timer = 60;
        count = 0;
        score = 0;

        setTitle("Quiz App");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Panel utama bergaya kartu
        JPanel cardPanel = new JPanel(null);
        cardPanel.setBounds(20, 20, 340, 520);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        add(cardPanel);

        titleLabel = new JLabel("Soal #1 - Waktu: 60 detik", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setBounds(20, 10, 300, 30);
        cardPanel.add(titleLabel);

        circularTimer = new CircularTimerPanel(60);
        circularTimer.setBounds(110, 40, 120, 120);
        cardPanel.add(circularTimer);

        questionLabel = new JLabel("Pertanyaan akan muncul di sini", JLabel.CENTER);
        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        questionLabel.setBounds(20, 170, 300, 50);
        questionLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        cardPanel.add(questionLabel);

        opt1 = new JRadioButton();
        opt2 = new JRadioButton();
        opt3 = new JRadioButton();
        opt4 = new JRadioButton();

        JRadioButton[] options = {opt1, opt2, opt3, opt4};
        int y = 230;
        for (JRadioButton opt : options) {
            opt.setBounds(20, y, 300, 30);
            opt.setBackground(Color.WHITE);
            opt.setFont(new Font("SansSerif", Font.PLAIN, 14));
            cardPanel.add(opt);
            y += 40;
        }

        grouping = new ButtonGroup();
        grouping.add(opt1);
        grouping.add(opt2);
        grouping.add(opt3);
        grouping.add(opt4);

        nextbtn = new JButton("Next");
        nextbtn.setBounds(20, 400, 140, 30);
        nextbtn.setBackground(Color.BLACK);
        nextbtn.setForeground(Color.WHITE);
        nextbtn.addActionListener(this);
        cardPanel.add(nextbtn);

        submit = new JButton("Submit");
        submit.setBounds(180, 400, 140, 30);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        cardPanel.add(submit);

        // Pertanyaan dan jawaban
        setQuestions();
        start(count);
        startTimer();

        setVisible(true);
    }

    void setQuestions() {
        questions[0][0] = "Apa nama kimia dari garam dapur?";
        questions[0][1] = "NACL";
        questions[0][2] = "H2SO4";
        questions[0][3] = "HCL";
        questions[0][4] = "M2SO4";

        questions[1][0] = "Apa mata uang resmi Amerika Serikat?";
        questions[1][1] = "Dollar";
        questions[1][2] = "Rupee";
        questions[1][3] = "Dinar";
        questions[1][4] = "Riyal";

        questions[2][0] = "Siapa pendiri negara Pakistan?";
        questions[2][1] = "Quaide Azam";
        questions[2][2] = "Imran Khan";
        questions[2][3] = "Nawaz Sharif";
        questions[2][4] = "Ronaldo";

        questions[3][0] = "Apa buah nasional Indonesia?";
        questions[3][1] = "Mangga";
        questions[3][2] = "Jeruk";
        questions[3][3] = "Pisang";
        questions[3][4] = "Anggur";

        questions[4][0] = "Siapa yang dijuluki GOAT sejati dalam sepak bola?";
        questions[4][1] = "Messi";
        questions[4][2] = "Ronaldo";
        questions[4][3] = "Neymar";
        questions[4][4] = "Mbappe";

        questions[5][0] = "Apa tipe data untuk bilangan bulat di Java?";
        questions[5][1] = "int";
        questions[5][2] = "double";
        questions[5][3] = "String";
        questions[5][4] = "char";

        questions[6][0] = "Keyword apa yang digunakan untuk membuat objek di Java?";
        questions[6][1] = "new";
        questions[6][2] = "class";
        questions[6][3] = "object";
        questions[6][4] = "this";

        questions[7][0] = "Fungsi utama dalam program Java disebut?";
        questions[7][1] = "main";
        questions[7][2] = "start";
        questions[7][3] = "run";
        questions[7][4] = "init";

        questions[8][0] = "Apa hasil dari System.out.println(\"Halo\"); ?";
        questions[8][1] = "Halo";
        questions[8][2] = "halo";
        questions[8][3] = "\"Halo\"";
        questions[8][4] = "Error";

        questions[9][0] = "Apa hasil dari 10 + 2 * 3 di Java?";
        questions[9][1] = "16";
        questions[9][2] = "36";
        questions[9][3] = "60";
        questions[9][4] = "24";

        for (int i = 0; i < 10; i++) {
            answers[i][1] = questions[i][1];
        }
    }

    void start(int count) {
        titleLabel.setText("Soal #" + (count + 1) + " - Waktu: 60 detik");
        questionLabel.setText(questions[count][0]);
        opt1.setText("A. " + questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText("B. " + questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText("C. " + questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText("D. " + questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        grouping.clearSelection();
        startTime = System.currentTimeMillis();
    }

    void startTimer() {
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }

        timer = 60;
        circularTimer.setTimeLeft(timer);

        timerThread = new Thread(() -> {
            try {
                while (timer > 0) {
                    Thread.sleep(1000);
                    timer--;
                    SwingUtilities.invokeLater(() -> circularTimer.setTimeLeft(timer));
                }

                SwingUtilities.invokeLater(() -> processAnswer(true));
            } catch (InterruptedException ignored) {}
        });
        timerThread.start();
    }

    void processAnswer(boolean isTimeout) {
        String selected = grouping.getSelection() != null ? grouping.getSelection().getActionCommand() : null;

        answergiver[count][0] = selected != null ? selected : " ";

        if (selected == null) {
            // No answer
        } else if (selected.equals(answers[count][1])) {
            if (isTimeout) {
                score -= 5; // Penalti
            } else {
                score += 10;
            }
        }

        count++;

        if (count == 9) {
            nextbtn.setEnabled(false);
            submit.setEnabled(true);
        }

        if (count < 10) {
            start(count);
            startTimer();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextbtn) {
            timerThread.interrupt();
            processAnswer(false);
        } else if (ae.getSource() == submit) {
            timerThread.interrupt();
            processAnswer(false);
            setVisible(false);
            new score(name, score);
        }
    }

    public static void main(String[] args) {
        new quiz_page("User");
    }
}
