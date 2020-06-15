package willcodes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Cps {
    private int five = 0;
    private int ten = 0;
    private int twenty = 0;

    public Cps() {


        JInternalFrame frame1 = new JInternalFrame("Click here to start");
        JInternalFrame frame2 = new JInternalFrame("Click here to start");
        JInternalFrame frame3 = new JInternalFrame("Click here to start");
        JButton fiveReset = new JButton("Reset test");
        JButton tenReset = new JButton("Reset test");
        JButton twentyReset = new JButton("Reset test");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel fiveSeconds = new JPanel();
        JPanel tenSeconds = new JPanel();
        JPanel twentySeconds = new JPanel();
        JFrame mainFrame = new JFrame("Wills CPS tester");
        JTextField fiveText = new JTextField("" + five, 20);
        fiveText.setEditable(false);
        JTextField tenText = new JTextField("" + ten, 20);
        tenText.setEditable(false);
        JTextField twentyText = new JTextField("" + twenty, 20);
        twentyText.setEditable(false);
        JButton fiveButton = new JButton("Click");
        JButton tenButton = new JButton("Click");
        JButton twentyButton = new JButton("Click");


        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                five += 1;
                fiveText.setText("" + five);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fiveReset.setEnabled(false);
                            TimeUnit.SECONDS.sleep(5);
                            if (five != 0) {
                                fiveText.setText("Your average CPS is: " + five / 5);
                            }
                            fiveButton.setEnabled(false);
                            TimeUnit.SECONDS.sleep(2);
                            fiveReset.setEnabled(true);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        fiveReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                five = 0;
                fiveText.setText("" + five);
                fiveButton.setEnabled(true);

            }
        });

        tenReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ten = 0;
                tenText.setText("" + ten);
                tenButton.setEnabled(true);
            }
        });
        twentyReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twenty = 0;
                twentyText.setText("" + twenty);
                twentyButton.setEnabled(true);
            }
        });

        frame1.setFont(new Font("Times new Roman", Font.BOLD, 24));
        frame2.setFont(new Font("Times new Roman", Font.BOLD, 24));
        frame3.setFont(new Font("Times new Roman", Font.BOLD, 24));
        fiveText.setFont(new Font("Times new Roman", Font.BOLD, 24));
        tenText.setFont(new Font("Times new Roman", Font.BOLD, 24));
        twentyText.setFont(new Font("Times new Roman", Font.BOLD, 24));
        fiveButton.setFont(new Font("Times new Roman", Font.BOLD, 24));
        tenButton.setFont(new Font("Times new Roman", Font.BOLD, 24));
        twentyButton.setFont(new Font("Times new Roman", Font.BOLD, 24));



        frame1.setPreferredSize(new Dimension(250, 150));
        frame1.setResizable(false);
        frame1.add(fiveButton);
        frame1.setVisible(true);
        fiveSeconds.add(frame1); fiveSeconds.add(fiveText); fiveSeconds.add(fiveReset);

        frame2.setPreferredSize(new Dimension(250, 150));
        frame2.setResizable(false);
        frame2.add(tenButton);
        frame2.setVisible(true);
        tenSeconds.add(frame2); tenSeconds.add(tenText); tenSeconds.add(tenReset);

        frame3.setPreferredSize(new Dimension(250, 150));
        frame3.setResizable(false);
        frame3.add(twentyButton);
        frame3.setVisible(true);
        twentySeconds.add(frame3); twentySeconds.add(twentyText); twentySeconds.add(twentyReset);


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