import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GuiMessage extends JFrame {
    private JPanel panel;


    public GuiMessage(String message)  {

       // this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(370, 150);
        this.setForeground(new Color(192, 192, 192));
        this.setTitle("Access Password Manager");
        //   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //     this.pack();
        this.setResizable(false);

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        //    panel.setLayout(new MigLayout("", "[70.00][132.00,grow][44.00][67.00,grow][61.00][]", "[19.00][34.00][]"));
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText(message);
        panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 10, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        this.setVisible(true);
    }

    public void closeMessage(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

    }

}
