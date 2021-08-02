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

        //Set size for each object
        //Set location and size of each object
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
            public void actionPerformed(ActionEvent e) {       //Function when the button is clicked
                System.exit(0);                         //Close out the GUI
            }
        });

        generateButton.addActionListener(new ActionListener() {    //This is when the Generate button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {            //function for when the button is clicked.
                passwordBox.setText("");                            //Clears out current contents
                generateNewPassword();                              //Uses the function to generate new password
            }
        });



        setVisible(true);                               //Make the GUI visible
    }

    public void generateNewPassword(){                          //Function to create new password
        ArrayList<String> word1 = new ArrayList<String>();      //Create ArrayList for first word
        ArrayList<String> word2 = new ArrayList<String>();      //Create ArrayList for second word
        int[] numberValue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};     //Create Arrays for Symbols and Numbers
        char[] symbolValue = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};

        //Add values to ArrayLists
        word1.add("Table"); word1.add("Pen"); word1.add("Chair"); word1.add("Book"); word1.add("Read"); word1.add("Journal");
        word2.add("Knife"); word2.add("Board"); word2.add("Plate"); word2.add("Pot"); word2.add("Cup"); word2.add("Sponge");

        //Create new Random object. This will be used to pull random values from the Arrays/ArrayLists
        Random randomValue = new Random();

        passwordBox.setText(word1.get(randomValue.nextInt(word1.size())) +              //Assign word1
                            numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                            numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                            word2.get(randomValue.nextInt(word2.size())) +              //Assign word2
                            symbolValue[randomValue.nextInt(symbolValue.length)] +      //Assign symbol
                            symbolValue[randomValue.nextInt(symbolValue.length)]);      //Assign symbol
    }

    public static void main(String[] args) {
        new passwordGenerator(); //Run it
    }

}
