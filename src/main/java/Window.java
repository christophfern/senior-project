import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;


public class Window extends JDialog {

            private JTextField textField_1;
            private JButton selectButton;
            private JPanel panel;
            private JTextField input;
            private JTextField input2;
            private JTextField input3;
            private JTextArea files;
            private JLabel label1;
            private JLabel label2;
            private JPasswordField passwordField;
            private String number;
            private String path;
            private String finalPath;

            public Window() {

                this.setModal(true);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setSize(500, 150);
                this.setForeground(new Color(192, 192, 192));
                this.setTitle("Class Assignment APP");
             //   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           //     this.pack();
                this.setResizable(false);

                panel = new JPanel();
              //  files=new JTextArea();
              //  files.setText("DROP HERE");


            //  new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false);

                getContentPane().add(panel, BorderLayout.CENTER);
                panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 3, new Insets(0, 0, 0, 0), -1, -1));
                final JLabel label1 = new JLabel();
                label1.setText("File");
                panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
                input2 = new JTextField();
                panel.add(input2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
                input3 = new JTextField();
                panel.add(input3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
                input = new JTextField();
                input.setDropTarget(new DropTarget() {
                    public synchronized void drop(DropTargetDropEvent evt) {
                        try {
                            evt.acceptDrop(DnDConstants.ACTION_COPY);
                            Object ob= evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                            path=ob.toString();
                            path=path.substring(1,path.length()-1);
                            input.setText(path);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                });
                panel.add(input, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
                final JLabel label2 = new JLabel();
                label2.setText("Number of Runs");
                panel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
                final JLabel label3 = new JLabel();
                label3.setText("Name of Class List");
                panel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
                selectButton = new JButton();
                selectButton.setText("Select");
               // selectButton = new JButton("Log In");
                ListenForButton listener = new ListenForButton();
                selectButton.addActionListener(listener);
              //  panel.add(selectButton, "cell 4 1");
                panel.add(selectButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 10, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            //   new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false))*/
                this.setVisible(true);

            }



private class ListenForButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        path=input.getText();

        number=input2.getText();

        finalPath= input3.getText();

       closeWindow();
    }
}


        public String getPath(){
                return this.path;
        }
        public String getFinalPath(){
                return this.finalPath;
        }

        public String getNumber(){
                return this.number;
        }

        public void closeWindow(){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            //  this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }


}
