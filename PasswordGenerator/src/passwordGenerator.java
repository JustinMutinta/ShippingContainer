import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setVisible(true); //Make the GUI visible
    }

    public static void main(String[] args) {
        new passwordGenerator();
    }

}
