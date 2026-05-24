import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // falls back to the default look and feel
        }
        SwingUtilities.invokeLater(MainWindows::new);
    }
}
