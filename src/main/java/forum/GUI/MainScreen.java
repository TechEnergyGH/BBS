/*
 * Created by JFormDesigner on Sun Jun 25 20:43:57 CST 2023
 */

package main.java.forum.GUI;

import main.java.forum.GUI.user.Register;
import main.java.forum.GUI.user.Search;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 11318
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
    }

    private void SearchMouseClicked(MouseEvent e) {
        // TODO add your code here
        main.java.forum.GUI.user.Search s = new Search();
    }

    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void RegisterMouseClicked(MouseEvent e) {
        // TODO add your code here
        main.java.forum.GUI.user.Register r = new Register();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        Register = new JButton();
        Search = new JButton();
        buttonBar = new JPanel();
        cancelButton = new JButton();

        //======== this ========
        setVisible(true);
        setPreferredSize(new Dimension(400, 300));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new FlowLayout());

                //---- Register ----
                Register.setText("\u6ce8\u518c");
                Register.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        RegisterMouseClicked(e);
                    }
                });
                contentPanel.add(Register);

                //---- Search ----
                Search.setText("\u67e5\u8be2");
                Search.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        SearchMouseClicked(e);
                    }
                });
                contentPanel.add(Search);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- cancelButton ----
                cancelButton.setText("\u9000\u51fa");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton Register;
    private JButton Search;
    private JPanel buttonBar;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
