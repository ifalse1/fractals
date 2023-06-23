import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        panel.setLayout(new GridLayout(2, 2));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}