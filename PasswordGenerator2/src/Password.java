import javax.swing.*;
import java.awt.*;

public class Password extends JFrame {

    public Password(){
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(null);

        Insets insets = getInsets();
        Dimension size;

        JButton closeButton = new JButton("Close");
        size = closeButton.getPreferredSize();
        closeButton.setBounds(500 + insets.left, 25 + insets.top, size.width + 10, size.height);
        passwordPanel.add(closeButton);

        JButton generateButton = new JButton("Generate");
        size = generateButton.getPreferredSize();
        generateButton.setBounds(500 + insets.left, 75 + insets.top, size.width + 5, size.height);
        passwordPanel.add(generateButton);

        JTextField passwordBox = new JTextField();
        size = passwordBox.getPreferredSize();
        passwordBox.setBounds(5 + insets.left, 25 + insets.top, size.width + 150, size.height);
        passwordPanel.add(passwordBox);

        String[] passwordOptions = {"Level 1", "Level 2", "Level 3", "Level 4"};

        JComboBox passwordComboBox = new JComboBox(passwordOptions);
        size = passwordComboBox.getPreferredSize();
        passwordComboBox.setBounds(500 + insets.left, 120 + insets.top, size.width + 5, size.height);
        passwordPanel.add(passwordComboBox);



        add(passwordPanel);
        setVisible(true);
    }
}
