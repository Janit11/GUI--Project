import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Container;

public class FileReader extends JFrame {

    JFrame frame;
    FileReaderPanel fileReaderPanel;
    JButton button;
    JPanel panel;
    JButton exit_button;

    public static void main(String[] args) {
        System.setProperty("key", "");
        FileReader fileReader = new FileReader();
        fileReader.setVisible(true);
    }

    public FileReader() {

        // setting frame
        setSize(650, 500);
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        // creating filereader panel
        fileReaderPanel = new FileReaderPanel();
        Container container = getContentPane();
        container.add(new JScrollPane(fileReaderPanel));

        // new panel
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setForeground(Color.BLUE);

        // adding a statusbar to highlight the buttons for the user.
        final JLabel statusbar = new JLabel("Choose a bmp file");
        panel.add(statusbar);

        button = new JButton("Open");
        panel.add(button);
        OpenButton(button, statusbar);

        exit_button = new JButton("Exit");
        panel.add(exit_button);
        ExitButton(exit_button);

        container.add(panel, "First");
    }

    // if user wants to display the image.
    public void ExitButton(JButton button) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // if user wants to terminate the program.
    public void OpenButton(JButton button, JLabel statusbar) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".bmp image");
                int result = fileChooser.showOpenDialog(frame);

                // if file was chosen then display
                if (result == JFileChooser.APPROVE_OPTION) {
                    ChoosingImage(fileChooser);
                } else {
                    statusbar.setText("You cancelled!");
                }
            }

        });
    }

    // choosing a file from the computer.
    public void ChoosingImage(JFileChooser fileChooser) {
        File file = fileChooser.getSelectedFile();

        // reading a bmp image
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException exception) {
            System.out.println("read error: " + exception.getMessage());
        }
        fileReaderPanel.setImage(image);
    }
}