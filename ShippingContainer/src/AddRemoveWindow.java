import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddRemoveWindow extends JFrame {

    JTextArea textAreaRight;            //Making this a global value so that other functions can access it.

    Container[][] shipContainer = new Container[5][]; //[][] will allow the shipContainer to hold other Arrays.

    Container[] container1 = new Container[5]; //Containers will hold objects in them
    Container[] container2 = new Container[5];
    Container[] container3 = new Container[5];
    Container[] platform1 = new Container[1]; //This will be used for the vehicles or objects that are bigger than a box
    Container[] platform2 = new Container[1];

    Container box1 = new Container("Box 1");           //Objects to be transported and/or put into containers
    Container box2 = new Container("Box 2");
    Container box3 = new Container("Box 3");
    Container bmwVehicle = new Container(60, 60, 120, 450, "BMW Vehicle", "45RFT90RV");
    Container hondaVehicle = new Container(54, 60, 100, 450, "Honda Vehicle", "KL5690TR5");

    ArrayList<Container> masterListNonContainer = new ArrayList<Container>(); //ArrayList of all objects to be moved. ArrayList so it can grow/shrink as the user changes the list

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
        //JTextArea textAreaRight = new JTextArea("Right"); //Display text area on the right //moved to global variable so other functions can work with it
        textAreaRight = new JTextArea("Right");

        JButton addButton = new JButton("Add >>");
        JButton removeButton = new JButton("Remove <<");
        JButton closeButton = new JButton("Close");

        String[] containerArray = {"Ship", "Container 1", "Container 2", "Container 3", "Platform 1", "Platform 2"};
        JComboBox containerComboBox = new JComboBox(containerArray);
        //containerComboBox.addItem("Test");        //FYI: this works. This is for future reference

        Insets insets = getInsets();
        Dimension size;

        size = textAreaLeft.getPreferredSize();
        textAreaLeft.setBounds(5 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = textAreaRight.getPreferredSize();
        textAreaRight.setBounds(310 + insets.left, 25 + insets.top, size.width + 100, size.height + 150);

        size = addButton.getPreferredSize();
        addButton.setBounds(130 + insets.left, 75 + insets.top, size.width + 100, size.height);

        size = removeButton.getPreferredSize();
        removeButton.setBounds(130 + insets.left, 150 + insets.top, size.width + 75, size.height);

        size = containerComboBox.getPreferredSize();
        containerComboBox.setBounds(130 + insets.left, 25 + insets.top, size.width + 80, size.height);

        setMasterListNonContainer();   //Need to run these functions. Otherwise arrays will be empty and you'll get exception errors

        closeButton.addActionListener(e -> {
            //Want it to close only this window but not the main one
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < masterListNonContainer.size(); i++){ // for testing purposes. Was able to get objects to show up in left text box
                    textAreaLeft.append(i + ". " + masterListNonContainer.get(i).description + "\n");
                }
            }
        });

        ActionListener comboBoxActionListener = new ActionListener() {  //Create new Action Lister for when the ComboBox is used. Used this because I did not want to add an "update" Button to the window
            @Override
            public void actionPerformed(ActionEvent e) {
                String comboBoxValue = (String) containerComboBox.getSelectedItem();  //Creates String Value of what is selected in the comboBox

                switch(comboBoxValue){                  //runs the following depending on the selected value
                    case "Container 1":                 //If "Container 1" is selected...
                        showContents(container1);       //The function showContents() is run
                        break;                          //break, so that it know to stop here
                    case "Container 2":
                        showContents(container2);
                        break;
                    case "Container 3":
                        showContents(container3);
                        break;
                    case "Platform 1":
                        showContents(platform1);
                        break;
                    case "Platform 2":
                        showContents(platform2);
                        break;
                }
            }
        };

        containerComboBox.addActionListener(comboBoxActionListener);



        //addRemovePanel.add(closeButton);
        addRemovePanel.add(textAreaLeft);
        addRemovePanel.add(textAreaRight);
        addRemovePanel.add(addButton);
        addRemovePanel.add(removeButton);
        addRemovePanel.add(containerComboBox);


        add(addRemovePanel);



        setVisible(true);
    }


    public void showContents(Container[] selectedContainer){
        textAreaRight.setText("");
        if (selectedContainer == null){
            textAreaRight.setText("This container is empty");
        }else{
            for(int i = 0; i < selectedContainer.length; i++){
                if(selectedContainer[i] == null){
                    textAreaRight.append("Nothing on " + i + "\n"); //Visual that there's nothing in that slot. Remember to remove
                }else{
                    textAreaRight.append(selectedContainer[i].description + "\n");
                }
            }
        }

    }
}
