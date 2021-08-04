import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Password extends JFrame {

    public Password(){
        setTitle("Password Generator");             //Set title of Frame
        setSize(600, 112);              //Set Size. Wanted everything in a long layout from left to right
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Close GUI when X is clicked

        JPanel passwordPanel = new JPanel();        //Created a new Panel
        passwordPanel.setLayout(null);              //Set Layout to null. Wanted to be able to customize it myself

        Insets insets = getInsets();                //Created Insets to help with object placement
        Dimension size;                             //Created size object to edit button and box size. Not initiated yet

        JButton closeButton = new JButton("Close"); //First Button is close button
        size = closeButton.getPreferredSize();          //Initialized size to .getPrefferedSize();
        closeButton.setBounds(500 + insets.left, 25 + insets.top, size.width + 10, size.height); //placement of button
        passwordPanel.add(closeButton);                 //Added to Panel

        JButton generateButton = new JButton("Generate");   //Created new Generate password button
        size = generateButton.getPreferredSize();               //re-Initialized the size object to the generate button
        generateButton.setBounds(400 + insets.left, 25 + insets.top, size.width + 5, size.height); //placement of button
        passwordPanel.add(generateButton);              //Added to Panel

        JTextField passwordBox = new JTextField();      //Created new TextField that the passwords will be generated and placed into
        size = passwordBox.getPreferredSize();          //re-Initialized the size object to the passwordBox textField
        passwordBox.setBounds(5 + insets.left, 25 + insets.top, size.width + 280, size.height + 8); //placement of text field
        passwordPanel.add(passwordBox);                 //Added to Panel

        String[] passwordOptions = {"Level 1", "Level 2", "Level 3", "Level 4"}; //Array for ComboBox options

        JComboBox passwordComboBox = new JComboBox(passwordOptions); //Created ComboBox and set options to earlier Array
        size = passwordComboBox.getPreferredSize();     //Initialized size to comboBox
        passwordComboBox.setBounds(300 + insets.left, 25 + insets.top, size.width + 22, size.height + 2); //Placement of box
        passwordPanel.add(passwordComboBox); //Added to Panel

        closeButton.addActionListener(new ActionListener() { //Action listener for close button
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);                     //Close the window
            }
        });

        generateButton.addActionListener(new ActionListener() { //Action listener for Generate button
            @Override
            public void actionPerformed(ActionEvent e) {
                                                            // When working with a comboBox, getSelectedItem() gets the currently selected item.
                String temporaryOption = (String) passwordComboBox.getSelectedItem(); //Created String item that will be used in below switch statement
                switch (temporaryOption){                   //Depending on the value of the comboBox, affects the createPassword function
                    case "Level 1":                                     //Level 1 will create a simple one word password
                        passwordBox.setText(createPassword(1));    //Sets the text in the passwordBox depending on the createPassword() function.
                        break;                                          //remember the break; or it will go to the next case
                    case "Level 2":                                     //Level 2 is a word and 2 numbers
                        passwordBox.setText(createPassword(2));
                        break;
                    case "Level 3":                                     //Level 3 is a word, 2 numbers and then a word
                        passwordBox.setText(createPassword(3));
                        break;
                    default:                                            //default, which is Level 4, will be a word, 2 numbers, a word and then 2 symbols
                        passwordBox.setText(createPassword(4));
                        break;
                }
            }
        });


        add(passwordPanel);                 //Adds panel to frame
        setVisible(true);                   //Sets frame to visible
    }


    public String createPassword(int num){          //Function to determine/Set the password based on levels 1 through 4
                                                    //Created Arrays to hold values
        String[] word1 = {"Coffee", "Tea", "Cookie", "Barrista", "Sweetened", "Calories", "Shaken", "Stirred", "Drivethrough"};
        String[] word2 = {"Sports", "Trophy", "Winner", "Draw", "Loser", "Coach", "Player", "Field", "Arena"};
        int[] numberValue = {0,1,2,3,4,5,6,7,8,9};
        char[] symbolValue = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '='};

        Random randomValue = new Random();          //Created Random object so that the password created will be unique

        /*
        level 1 = one word
        level 2 = one word 2 numbers
        level 3 = one word 2 numbers one word
        level 4 = one word 2 numbers one word 2 symbols
         */
        switch (num){
            case 4:                                                             //Case 4: One word, Two numbers, One word, 2 symbols
                return word1[randomValue.nextInt(word1.length)] +              //Assign word1
                        numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                        numberValue[randomValue.nextInt(numberValue.length)] +      //Assign numberValue
                        word2[randomValue.nextInt(word2.length)] +              //Assign word2
                        symbolValue[randomValue.nextInt(symbolValue.length)] +      //Assign symbol
                        symbolValue[randomValue.nextInt(symbolValue.length)];       //Assign symbol
            case 3:                                                         //Case 3: One word, two numbers, One word
                return word1[randomValue.nextInt(word1.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        word2[randomValue.nextInt(word2.length)];
            case 2:                                                         //Case 2: One word and two numbers
                return word1[randomValue.nextInt(word1.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)] +
                        numberValue[randomValue.nextInt(numberValue.length)];
            default:                                                            //This will be case 1, simply one word
                return word1[randomValue.nextInt(word1.length)];
        }
    }
}
