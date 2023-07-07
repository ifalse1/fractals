import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Dictionary;

public class CreateFrame extends JPanel {
    Dictionary<String, String> fracInfo;
    int size;
    Double min;
    Double max;
    Double pixel_size;

    public CreateFrame(Dictionary<String, String> fracInfo) {
        this.fracInfo = fracInfo;
        this.size = Integer.parseInt(fracInfo.get("pixels"));
        this.min = Double.valueOf(fracInfo.get("centerx")) - Double.valueOf(fracInfo.get("axislength")) / 2.0;
        this.max = Double.valueOf(fracInfo.get("centerx")) + Double.valueOf(fracInfo.get("axislength")) / 2.0;
        this.pixel_size = Math.abs(this.max - this.min) / this.size;
    }
    public void paint(Graphics g) {
        Image img = createImageWithText();
        g.drawImage(img, 0,0,this);
    }

    private Image createImageWithText() {
        BufferedImage bufferedImage = new BufferedImage(Integer.parseInt(fracInfo.get("pixels")), Integer.parseInt(fracInfo.get("pixels")), BufferedImage.TYPE_INT_RGB);
        //Graphics g = bufferedImage.getGraphics();
        Mandelbrot mandel = new Mandelbrot(Integer.parseInt(fracInfo.get("iterations")));

        for (int row = size; row > 0; row--) {
            for (int col = 0; col < size; col++) {
                Double x = min + col * pixel_size;
                Double y = (Double.valueOf(fracInfo.get("centery")) - Double.valueOf(fracInfo.get("axislength")) / 2) + row * pixel_size;
                Complex c = new Complex(x, y);
                Color color = Color.getHSBColor((float) mandel.count(c) / 255, 1.0f, 1.0f);
                //System.out.println(mandel.count(c));
                bufferedImage.setRGB(col, size - row, color.getRGB());
            }
        }

        return bufferedImage;
    }

    public void initializeFrame(Dictionary<String, String> fracInfo) {
        this.fracInfo = fracInfo;
        JFrame frame = new JFrame();
        frame.getContentPane().add(new CreateFrame(fracInfo));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Integer.parseInt(this.fracInfo.get("pixels")), Integer.parseInt(this.fracInfo.get("pixels")));
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
