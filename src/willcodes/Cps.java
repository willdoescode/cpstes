package willcodes;

import javax.swing.*;
import java.awt.*;

public class Cps {
    private int five = 0;
    private int ten = 0;
    private int twenty = 0;

    public Cps() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel fiveSeconds = new JPanel();
        JPanel tenSeconds = new JPanel();
        JPanel twentySeconds = new JPanel();
        JFrame mainFrame = new JFrame("Wills CPS tester");
        JTextField fiveText = new JTextField("" + five);
        JTextField tenText = new JTextField("" + ten);
        JTextField twentyText = new JTextField("" + twenty);
        fiveText.setEditable(false); tenText.setEditable(false); twentyText.setEditable(false);



        tabbedPane.add("Five Seconds", fiveSeconds);
        tabbedPane.add("Ten Seconds", tenSeconds);
        tabbedPane.add("Twenty Seconds", twentySeconds);
        mainFrame.add(tabbedPane);
        mainFrame.setSize(dim.width / 2, dim.height / 2);
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setIconImage(new ImageIcon(getClass().getResource("icons/computer-mouse.png")).getImage());
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cps();
            }
        });
    }
}