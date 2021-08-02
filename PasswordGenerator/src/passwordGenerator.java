import javax.swing.*;

public class passwordGenerator extends JFrame {

    JPanel passPanel;
    JButton closeButton;
    JButton generateButton;
    JTextField passwordBox;

    public passwordGenerator(){
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        passPanel = new JPanel();
        closeButton = new JButton("Close");
        generateButton = new JButton("Generate");
        passwordBox = new JTextField();

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
