import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddRemoveWindow extends JFrame {
    Container[] shipContainer = new Container[5];
    Container[] container1 = new Container[5];
    Container[] container2 = new Container[5];
    Container[] container3 = new Container[5];
    Container box1 = new Container();
    Container box2 = new Container();
    Container box3 = new Container();
    Container bmwVehicle = new Container();
    Container hondaVehicle = new Container();

    ArrayList<Container[]> masterListContainer = new ArrayList<Container[]>();
    ArrayList<Container> masterListNonContainer = new ArrayList<Container>();

    public void setMasterListContainer(){
        this.masterListContainer.add(shipContainer);
        this.masterListContainer.add(container1);
        this.masterListContainer.add(container2);
        this.masterListContainer.add(container3);
    }

    public void setMasterListNonContainer(){
        this.masterListNonContainer.add(box1);
        this.masterListNonContainer.add(box2);
        this.masterListNonContainer.add(box3);
        this.masterListNonContainer.add(bmwVehicle);
        this.masterListNonContainer.add(hondaVehicle);
    }

    public AddRemoveWindow(){
        setSize(500,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //closes this window without closing the others

        JPanel addRemovePanel = new JPanel();
        addRemovePanel.setLayout(null);


        JTextArea textAreaLeft = new JTextArea("Left");   //Display text area on the left
        JTextArea textAreaRight = new JTextArea("Right"); //Display text area on the right

        JButton addButton = new JButton("Add >>");
        JButton removeButton = new JButton("Remove <<");
        JButton closeButton = new JButton("Close");

        Insets insets = getInsets();
        Dimension size;

        size = textAreaLeft.getPreferredSize();
        textAreaLeft.setBounds(5 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = textAreaRight.getPreferredSize();
        textAreaRight.setBounds(310 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = addButton.getPreferredSize();
        addButton.setBounds(130 + insets.left, 25 + insets.top, size.width + 100, size.height);

        size = removeButton.getPreferredSize();
        removeButton.setBounds(130 + insets.left, 75 + insets.top, size.width + 100, size.height);



        closeButton.addActionListener(e -> {
            //Want it to close only this window but not the main one
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaLeft.setText(masterListNonContainer.get(0).description);
            }
        });



        //addRemovePanel.add(closeButton);
        addRemovePanel.add(textAreaLeft);
        addRemovePanel.add(textAreaRight);
        addRemovePanel.add(addButton);
        addRemovePanel.add(removeButton);


        add(addRemovePanel);



        setVisible(true);
    }
}
