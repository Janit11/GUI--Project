import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class plotting_sine extends JFrame {

    public plotting_sine() {
        setLayout(new BorderLayout());
        add(new plotSine(), BorderLayout.CENTER);
    }

    class plotSine extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine(10, 210, 10, 600);
            g.drawLine(10, 400, 295, 400);

            g.drawString("X", 300, 390);
            g.drawString("Y", 10, 210);

            String s = JOptionPane.showInputDialog("Enter n between [1, 10]");

            int n = Integer.parseInt(s);

            // plotting sine waves from 1x to nx.
            for (int index = 1; index <= n; index++) {

                Polygon p = new Polygon();
                for (int x = 0; x < 285; x++) {
                    p.addPoint(x + 10, 400 - (int) (50 * f((index * x / 285.0) * 2
                            * Math.PI)));
                }

                int R = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                Color randomColor = new Color(R, G, B);
                g.setColor(randomColor);

                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
            }

            // plotting the sum of sine waves from 1x to nx.
            Polygon p2 = new Polygon();

            for (int t = 0; t < 285; t++) {
                p2.addPoint(t + 10, 400 - (int) (50 * f2((t / 285.0) * 2
                        * Math.PI, n)));
            }

            g.setColor(Color.blue);
            g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);

            // sampling sine waves at frequency 10Hz. Half built function.

            for (int index = 0; index < 20; index++) {
                Polygon p3 = new Polygon();
                for (int x = 0; x < 285; x++) {
                    p3.addPoint((index * 15) + 10, 400 - (int) (20 * f(n * x / 285.0) * 2));
                }

                g.setColor(Color.BLACK);
                g.drawPolyline(p3.xpoints, p3.ypoints, p3.npoints);
            }

            g.setColor(Color.BLACK);
            g.drawString("2\u03c0", 285, 410);
            g.drawString("1\u03c0", 145, 410);
            g.drawString("0", 10, 410);
            g.drawString("1", 10, 360);
            g.drawString("2", 10, 310);
            g.drawString("-1", 10, 460);
            g.drawString("-2", 10, 510);
        }

        double f(double x) {
            return Math.sin(x);
        }

        double f2(double x1, double num) {

            double val = 0;
            for (int k = 1; k <= num; k++) {

                val = val + Math.sin(k * x1);

            }
            return val;
        }
    }

    public static void main(String[] args) {
        plotting_sine frame = new plotting_sine();
        frame.setTitle("plotting_sine");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
