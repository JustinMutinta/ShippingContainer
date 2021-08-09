import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddRemoveWindow extends JFrame {
    Container[][] shipContainer = new Container[5][]; //[][] will allow the shipContainer to hold other Arrays.

    Container[] container1 = new Container[5]; //Containers will hold objects in them
    Container[] container2 = new Container[5];
    Container[] container3 = new Container[5];
    Container[] platform1 = new Container[1];
    Container[] platform2 = new Container[1];

    Container box1 = new Container("Box 1");           //Objects that will be transported
    Container box2 = new Container("Box 2");
    Container box3 = new Container("Box 3");
    Container bmwVehicle = new Container("BMW Vehicle");
    Container hondaVehicle = new Container("Honda Vehicle");

    ArrayList<Container[]> masterListContainer = new ArrayList<Container[]>();
    ArrayList<Container> masterListNonContainer = new ArrayList<Container>();

    public void setMasterListContainer(){
      //  this.masterListContainer.add(shipContainer);
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

        JComboBox containerComboBox = new JComboBox();
        //containerComboBox.addItem("Test");        //FYI: this works
        /*
        for(int i = 0; i < masterListContainer.size(); i++){
            containerComboBox.addItem(masterListContainer.get(i));
        }
                                                    //FYI: this does not work
         */

        Insets insets = getInsets();
        Dimension size;

        size = textAreaLeft.getPreferredSize();
        textAreaLeft.setBounds(5 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = textAreaRight.getPreferredSize();
        textAreaRight.setBounds(310 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = addButton.getPreferredSize();
        addButton.setBounds(130 + insets.left, 75 + insets.top, size.width + 100, size.height);

        size = removeButton.getPreferredSize();
        removeButton.setBounds(130 + insets.left, 150 + insets.top, size.width + 100, size.height);

        size = containerComboBox.getPreferredSize();
        containerComboBox.setBounds(130 + insets.left, 25 + insets.top, size.width + 100, size.height);

        setMasterListNonContainer();   //Need to run these functions. Otherwise arrays will be empty and you'll get exception errors
        setMasterListContainer();       //Also need this one.

        closeButton.addActionListener(e -> {
            //Want it to close only this window but not the main one
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < masterListNonContainer.size(); i++){ // for testing purposes. Was able to get objects to show up in left text box
                    textAreaLeft.append(masterListNonContainer.get(i).description + "\n");
                }
                //textAreaLeft.append(masterListNonContainer.get(0).description + "\n");
            }
        });



        //addRemovePanel.add(closeButton);
        addRemovePanel.add(textAreaLeft);
        addRemovePanel.add(textAreaRight);
        addRemovePanel.add(addButton);
        addRemovePanel.add(removeButton);
        addRemovePanel.add(containerComboBox);


        add(addRemovePanel);



        setVisible(true);
    }
}
