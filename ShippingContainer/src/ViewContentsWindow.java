import javax.swing.*;
import java.awt.*;

public class ViewContentsWindow extends JFrame {
    public ViewContentsWindow(){
        setSize(400,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //closes this window and not the others

        JComboBox viewContainerBox = new JComboBox();

        JTextArea viewContentsBox = new JTextArea();

        JPanel viewPanel = new JPanel();
        viewPanel.setLayout(null);

        Insets insets = getInsets();
        Dimension size;

        size = viewContainerBox.getPreferredSize();
        viewContainerBox.setBounds(5 + insets.left, 25 + insets.top, size.width + 100, size.height);

        size = viewContentsBox.getPreferredSize();
        viewContentsBox.setBounds(150 + insets.left, 25 + insets.top, size.width + 200, size.height + 200);

        viewPanel.add(viewContainerBox);
        viewPanel.add(viewContentsBox);

        add(viewPanel);

        setVisible(true);
    }
}
