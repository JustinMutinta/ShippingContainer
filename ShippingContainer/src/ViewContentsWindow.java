import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewContentsWindow extends JFrame {

    private final ShipData data;
    private final DefaultTableModel tableModel;
    private       JComboBox<String> containerComboBox;
    private       JLabel            capacityLabel;

    private static final String[] CONTAINER_NAMES =
            {"Container 1", "Container 2", "Container 3", "Platform 1", "Platform 2"};

    private static final String[] COLUMNS =
            {"Description", "Serial Number", "Height", "Width", "Length", "Weight (lbs)"};

    public ViewContentsWindow(ShipData data) {
        this.data = data;

        setTitle("View Container Contents");
        setSize(680, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        // Top bar
        containerComboBox = new JComboBox<>(CONTAINER_NAMES);
        containerComboBox.addActionListener(e -> refreshTable());

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshTable());

        capacityLabel = new JLabel();

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        top.add(new JLabel("Container:"));
        top.add(containerComboBox);
        top.add(refreshButton);
        top.add(capacityLabel);
        add(top, BorderLayout.NORTH);

        // Table (non-editable)
        tableModel = new DefaultTableModel(COLUMNS, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setRowHeight(26);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(55);
        table.getColumnModel().getColumn(3).setPreferredWidth(55);
        table.getColumnModel().getColumn(4).setPreferredWidth(55);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Status bar
        JLabel hint = new JLabel("  Open Add/Remove to change contents, then press Refresh.");
        hint.setBorder(BorderFactory.createEmptyBorder(2, 4, 4, 4));
        add(hint, BorderLayout.SOUTH);

        refreshTable();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);

        String selected   = (String) containerComboBox.getSelectedItem();
        Container[] slots = data.getContainerByName(selected);
        if (slots == null) return;

        int count = 0;
        for (Container c : slots) {
            if (c != null) {
                tableModel.addRow(new Object[]{
                        c.description, c.serialNumber,
                        c.height, c.width, c.length, c.weight
                });
                count++;
            }
        }

        capacityLabel.setText("  " + count + " / " + slots.length + " slots used");

        if (count == 0) {
            tableModel.addRow(new Object[]{"(empty)", "", "", "", "", ""});
        }
    }
}
