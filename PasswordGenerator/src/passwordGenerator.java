import javax.swing.*;
import java.awt.*;

public class passwordGenerator extends JFrame {

    JPanel passPanel;
    JButton closeButton;
    JButton generateButton;
    JTextField passwordBox;

    public passwordGenerator(){
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        passPanel = new JPanel();
        passPanel.setLayout(null);
        passPanel.setSize(600,100);

        closeButton = new JButton("Close");
        generateButton = new JButton("Generate");
        passwordBox = new JTextField();

        Insets insets = getInsets();
        Dimension size;

        size = closeButton.getPreferredSize();
        closeButton.setBounds(500 + insets.left, 25 + insets.top, size.width + 10, size.height);

        size = generateButton.getPreferredSize();
        generateButton.setBounds(400 + insets.left, 25 + insets.top, size.width + 10, size.height);

        size = passwordBox.getPreferredSize();
        passwordBox.setBounds(10 + insets.left, 25 + insets.top, size.width + 350, size.height + 8);

        passPanel.add(closeButton);
        passPanel.add(generateButton);
        passPanel.add(passwordBox);

        add(passPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new passwordGenerator();
    }

}
