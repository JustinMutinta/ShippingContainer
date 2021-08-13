import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindows extends JFrame {  //main window extending JFrame

    public MainWindows(){                   //create main GUI
        setSize(200,200);       //Set the size of the Window
        setDefaultCloseOperation(EXIT_ON_CLOSE); //enable the X button to close the window

        JButton addRemoveButton = new JButton("Add/Remove");  //To open the Add/Remove Window
        addRemoveButton.addActionListener(new ActionListener() {    //creates an action listener for the button. When clicked, will open the other window
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddRemoveWindow();
            }
        });

        JButton viewContButton = new JButton("View Contents");  //To View ContentWindow
        viewContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewContentsWindow();
            }
        });

        JButton closeButton = new JButton("Close");         //To close the window
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JPanel mainPanel = new JPanel();        //create panel to hold objects and add objects to it
        mainPanel.setSize(200,200);
        mainPanel.add(addRemoveButton);
        mainPanel.add(viewContButton);
        mainPanel.add(closeButton);



        add(mainPanel);                 //add panel to frame
        setVisible(true);               //set the frame to visible
    }
}
