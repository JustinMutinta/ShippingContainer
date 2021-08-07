import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindows extends JFrame {  //main window

    public MainWindows(){
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton addRemoveButton = new JButton("Add/Remove");  //To Add/Remove Window
        addRemoveButton.addActionListener(new ActionListener() {
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


        JPanel mainPanel = new JPanel();
        mainPanel.setSize(200,200);
        mainPanel.add(addRemoveButton);
        mainPanel.add(viewContButton);
        mainPanel.add(closeButton);



        add(mainPanel);
        setVisible(true);
    }
}
