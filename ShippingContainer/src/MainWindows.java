import javax.swing.*;
import java.awt.*;

public class MainWindows extends JFrame {

    private final ShipData data = new ShipData();

    public MainWindows() {
        setTitle("Shipping Container Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JButton addRemoveButton = new JButton("Add / Remove Items");
        JButton viewContButton  = new JButton("View Container Contents");
        JButton closeButton     = new JButton("Close");

        addRemoveButton.addActionListener(e -> new AddRemoveWindow(data));
        viewContButton.addActionListener(e -> new ViewContentsWindow(data));
        closeButton.addActionListener(e -> System.exit(0));

        // Make all buttons the same width
        Dimension btnSize = new Dimension(200, 35);
        addRemoveButton.setPreferredSize(btnSize);
        viewContButton.setPreferredSize(btnSize);
        closeButton.setPreferredSize(btnSize);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        addRemoveButton.setAlignmentX(CENTER_ALIGNMENT);
        viewContButton.setAlignmentX(CENTER_ALIGNMENT);
        closeButton.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(addRemoveButton);
        panel.add(Box.createVerticalStrut(8));
        panel.add(viewContButton);
        panel.add(Box.createVerticalStrut(8));
        panel.add(closeButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
