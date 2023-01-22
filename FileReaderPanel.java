import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

// this is the FileReaderPanel java class which displays the image
class FileReaderPanel extends JPanel {
    BufferedImage image;

    public FileReaderPanel() {
    }

    // setting the image
    public void setImage(BufferedImage img) {
        image = img;
        // sets the image
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
