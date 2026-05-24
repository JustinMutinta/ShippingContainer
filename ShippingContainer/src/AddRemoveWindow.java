import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AddRemoveWindow extends JFrame {

    private final ShipData data;

    private final DefaultListModel<Container> availableModel  = new DefaultListModel<>();
    private final DefaultListModel<Container> containerModel  = new DefaultListModel<>();
    private final JList<Container>            availableList   = new JList<>(availableModel);
    private final JList<Container>            containerList   = new JList<>(containerModel);
    private       JComboBox<String>           containerComboBox;
    private       JLabel                      statusLabel;
    private       TitledBorder                containerBorder;

    private static final String[] CONTAINER_NAMES =
            {"Container 1", "Container 2", "Container 3", "Platform 1", "Platform 2"};

    public AddRemoveWindow(ShipData data) {
        this.data = data;

        setTitle("Add / Remove Items");
        setSize(650, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        buildTopPanel();
        buildContentPanel();
        buildStatusBar();

        refreshAvailableList();
        refreshContainerList();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buildTopPanel() {
        containerComboBox = new JComboBox<>(CONTAINER_NAMES);
        containerComboBox.addActionListener(e -> refreshContainerList());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        top.add(new JLabel("Selected container:"));
        top.add(containerComboBox);
        add(top, BorderLayout.NORTH);
    }

    private void buildContentPanel() {
        // Left — available items
        availableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel leftPanel = new JPanel(new BorderLayout(0, 4));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Available Items"));
        leftPanel.add(new JScrollPane(availableList), BorderLayout.CENTER);

        // Center — buttons
        JButton addButton    = new JButton("Add >>");
        JButton removeButton = new JButton("<< Remove");
        addButton.addActionListener(e -> addItem());
        removeButton.addActionListener(e -> removeItem());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
        addButton.setAlignmentX(CENTER_ALIGNMENT);
        removeButton.setAlignmentX(CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(addButton);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(removeButton);
        centerPanel.add(Box.createVerticalGlue());

        // Right — container contents
        containerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        containerBorder = BorderFactory.createTitledBorder("Container Contents");
        JPanel rightPanel = new JPanel(new BorderLayout(0, 4));
        rightPanel.setBorder(containerBorder);
        rightPanel.add(new JScrollPane(containerList), BorderLayout.CENTER);

        JPanel content = new JPanel(new BorderLayout(8, 0));
        content.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        content.add(leftPanel,   BorderLayout.WEST);
        content.add(centerPanel, BorderLayout.CENTER);
        content.add(rightPanel,  BorderLayout.EAST);

        // Give the left and right panels equal, fixed widths
        leftPanel.setPreferredSize(new Dimension(230, 300));
        rightPanel.setPreferredSize(new Dimension(230, 300));

        add(content, BorderLayout.CENTER);
    }

    private void buildStatusBar() {
        statusLabel = new JLabel(" ");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(2, 8, 4, 8));
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void refreshAvailableList() {
        availableModel.clear();
        for (Container c : data.availableItems) {
            availableModel.addElement(c);
        }
    }

    private void refreshContainerList() {
        containerModel.clear();
        String selected      = (String) containerComboBox.getSelectedItem();
        Container[] slots    = data.getContainerByName(selected);
        if (slots == null) return;

        for (Container c : slots) {
            if (c != null) containerModel.addElement(c);
        }

        int used = data.countItems(slots);
        containerBorder.setTitle(selected + "  (" + used + "/" + slots.length + " slots used)");
        containerList.getParent().repaint();
    }

    private void addItem() {
        Container item = availableList.getSelectedValue();
        if (item == null) {
            statusLabel.setText("Select an item from the left list first.");
            return;
        }
        String target = (String) containerComboBox.getSelectedItem();
        if (data.addToContainer(item, target)) {
            statusLabel.setText("Added \"" + item.description + "\" to " + target + ".");
            refreshAvailableList();
            refreshContainerList();
        } else {
            statusLabel.setText(target + " is full — remove an item first.");
        }
    }

    private void removeItem() {
        Container item = containerList.getSelectedValue();
        if (item == null) {
            statusLabel.setText("Select an item from the right list first.");
            return;
        }
        String source = (String) containerComboBox.getSelectedItem();
        if (data.removeFromContainer(item, source)) {
            statusLabel.setText("Removed \"" + item.description + "\" from " + source + ".");
            refreshAvailableList();
            refreshContainerList();
        } else {
            statusLabel.setText("Could not remove item.");
        }
    }
}
