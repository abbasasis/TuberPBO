package myquizjava;

import javax.swing.*;
import java.awt.*;

public class CircularTimerPanel extends JPanel {
    private int timeLeft;
    private int totalTime;

    public CircularTimerPanel(int totalTime) {
        this.totalTime = totalTime;
        this.timeLeft = totalTime;
        setPreferredSize(new Dimension(100, 100));
        setOpaque(false);
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.min(getWidth(), getHeight()) - 10;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawOval(x, y, size, size);

        float angle = 360f * timeLeft / totalTime;
        g2.setColor(Color.PINK);
        g2.drawArc(x, y, size, size, 90, -(int) angle);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("SansSerif", Font.BOLD, 24));
        String text = String.valueOf(timeLeft);
        FontMetrics fm = g2.getFontMetrics();
        int tx = getWidth()/2 - fm.stringWidth(text)/2;
        int ty = getHeight()/2 + fm.getAscent()/2 - 4;
        g2.drawString(text, tx, ty);
    }
}
