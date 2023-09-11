import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        int x = 0;
        int y = 0;
        int counter = 0;
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Timer timer = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            try {
                URL url = new URL("https://s1.iconbird.com/ico/0612/iconslandtransport/w32h321339250814ExecutiveCarBlack5.png");
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, x, y, null);
                timer.start();
                if (x == 595){
                    counter++;
                }
                if (x == 0 && counter == 1){
                    counter--;
                }
                if (x < 600 && y < 400 && counter == 0) {
                    x += 7;
                    y += 4;
                } if (x > 0 && y > 0 && counter == 1) {
                    x = 0;
                    y = 0;
                }
            } catch (MalformedURLException ex){
                ex.printStackTrace();
            }

        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 200, 600, 400);
        try{
            URL url = new URL("https://motor.ru/thumb/1500x0/filters:quality(75):no_upscale()/imgs/2020/09/07/14/4099186/52d8f45d1ae944564ab28538f5a79af4894c5106.jpg");
            Image image = new ImageIcon(url).getImage();
            jFrame.setIconImage(image);
        } catch (MalformedURLException ex){
            ex.printStackTrace();
        }
        jFrame.setVisible(true);
        return jFrame;
    }
}