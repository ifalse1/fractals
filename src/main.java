import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JPanel {

    public void paint(Graphics g) {
        Image img = createImageWithText();
        g.drawImage(img, 0,0,this);
    }

    private Image createImageWithText() {
        BufferedImage bufferedImage = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        //Graphics g = bufferedImage.getGraphics();
        bufferedImage.setRGB(150,150, Color.RED.getRGB());

        return bufferedImage;
    }

    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }

        JFrame frame = new JFrame();
        frame.getContentPane().add(new main());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}