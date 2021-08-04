import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        add(passwordPanel);
        setVisible(true);
    }


    public String createPassword(int num){
        String[] word1 = {"Coffee", "Tea", "Cookie", "Barrista", "Sweetened", "Calories", "Shaken", "Stirred", "Drivethrough"};
        String[] word2 = {"Sports", "Trophy", "Winner", "Draw", "Loser", "Coach", "Player", "Field", "Arena"};
        int[] numberValue = {0,1,2,3,4,5,6,7,8,9};
        char[] symbolValue = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '='};

        Random randomValue = new Random();

        /*
        level 1 = one word
        level 2 = one word 2 numbers
        level 3 = one word 2 numbers one word
        level 4 = one word 2 numbers one word 2 symbols
         */
        switch (num){
            case 4:
                return word1[randomValue.nextInt(word1.length)] +              //Assign word1
                        numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                        numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                        word2[randomValue.nextInt(word2.length)] +              //Assign word2
                        symbolValue[randomValue.nextInt(symbolValue.length)] +      //Assign symbol
                        symbolValue[randomValue.nextInt(symbolValue.length)];       //Assign symbol
            case 3:
                return word1[randomValue.nextInt(word1.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        word2[randomValue.nextInt(word2.length)] +
                        symbolValue[randomValue.nextInt(symbolValue.length)];
            case 2:
                return word1[randomValue.nextInt(word1.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        word2[randomValue.nextInt(word2.length)];
            default:
                return word1[randomValue.nextInt(word1.length)];
        }
    }
}
