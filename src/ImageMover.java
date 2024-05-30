import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MyPanel1 extends JPanel implements ActionListener {
    private final int width = 700;
    private final int height = 500;
    private final int start_x = 0;
    private final int start_y = 250;
    private BufferedImage image;
    private Timer timer;
    private int x, y;

    public MyPanel1() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setDoubleBuffered(true);
        makeImage();
        timer = new Timer(30, this);
        timer.start();

    }
    public void makeImage(){
        File input = new File("/Users/leejunhyeong/Downloads/artwork_119/04_24설날_PC 1920X1080.jpg");
        try {
            image = ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = start_x;
        y = start_y;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, x, y, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        y -= 1;
        if (x > width || y < 0) {
            x = start_x;
            y = start_y;
        }
        repaint();
    }
}

public class ImageMover extends JFrame {
    public ImageMover() {
        add(new MyPanel1());
        setTitle("이미지 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageMover());
    }
}
