import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class passwordGenerator extends JFrame {  //New class that extends JFrame

    JPanel passPanel;       //Create new Panel to hold objects
    JButton closeButton;    //Create new Button to close window
    JButton generateButton; //Create new Button to generate password
    JTextField passwordBox; //TextBox to hold password when Generated.

    public passwordGenerator(){                             //GUI set up
        setSize(600, 100);                      //set up Dimensions of GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Close GUI when X is clicked.

        passPanel = new JPanel();                           //initialize Panel
        passPanel.setLayout(null);                          //set Layout of Panel to null. Allows me to customize the panel
        passPanel.setSize(600,100);             //Set size of Panel

        closeButton = new JButton("Close");             //initialize Buttons/TextField and assign labels
        generateButton = new JButton("Generate");
        passwordBox = new JTextField();

        Insets insets = getInsets();                        //To customize placement
        Dimension size;                                     //To customize size

        size = closeButton.getPreferredSize();
        closeButton.setBounds(500 + insets.left, 25 + insets.top, size.width + 10, size.height);

        size = generateButton.getPreferredSize();
        generateButton.setBounds(400 + insets.left, 25 + insets.top, size.width + 10, size.height);

        size = passwordBox.getPreferredSize();
        passwordBox.setBounds(10 + insets.left, 25 + insets.top, size.width + 350, size.height + 8);

        passPanel.add(closeButton);                         //Add objects to panel
        passPanel.add(generateButton);
        passPanel.add(passwordBox);

        add(passPanel);                             //Add Panel to Frame

        closeButton.addActionListener(new ActionListener() { //Set action to when close button is closed.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordBox.setText("");
                generateNewPassword();
            }
        });



        setVisible(true); //Make the GUI visible
    }

    public void generateNewPassword(){
        ArrayList<String> word1 = new ArrayList<String>();
        ArrayList<String> word2 = new ArrayList<String>();
        int[] numberValue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] symbolValue = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};

        word1.add("Table"); word1.add("Pen"); word1.add("Chair"); word1.add("Book"); word1.add("Read"); word1.add("Journal");
        word2.add("Knife"); word2.add("Board"); word2.add("Plate"); word2.add("Pot"); word2.add("Cup"); word2.add("Sponge");

        Random randomValue = new Random();

        passwordBox.setText(word1.get(randomValue.nextInt(word1.size())) +
                            numberValue[randomValue.nextInt(numberValue.length)] +
                            numberValue[randomValue.nextInt(numberValue.length)] +
                            word2.get(randomValue.nextInt(word2.size())) +
                            symbolValue[randomValue.nextInt(symbolValue.length)] +
                            symbolValue[randomValue.nextInt(symbolValue.length)]);
    }

    public static void main(String[] args) {
        new passwordGenerator();
    }

}
