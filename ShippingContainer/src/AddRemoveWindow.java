import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRemoveWindow extends JFrame {
    public AddRemoveWindow(){
        setSize(300,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //closes this window without closing the others

        JPanel addRemovePanel = new JPanel();


        JTextArea textAreaLeft = new JTextArea("Left");
        JTextArea textAreaRight = new JTextArea("Right");

        JButton addButton = new JButton("Add >>");
        JButton removeButton = new JButton("Remove <<");
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Want it to close only this window but not the main one
            }
        });

        addRemovePanel.add(closeButton);
        addRemovePanel.add(textAreaLeft);
        addRemovePanel.add(textAreaRight);


        add(addRemovePanel);



        setVisible(true);
    }
}
