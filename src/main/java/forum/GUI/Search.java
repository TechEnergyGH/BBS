/*
 * Created by JFormDesigner on Sun Jun 25 20:57:04 CST 2023
 */

package main.java.forum.GUI;

import lombok.SneakyThrows;
import main.java.forum.util.DBUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.transform.Result;

/**
 * @author 11318
 */
public class Search extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JTextField UID;
    private JPanel panel2;
    private JLabel label2;
    private JTextField Name;
    private JButton search;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTextArea Result;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void searchMouseClicked(MouseEvent e) {
        String uid = UID.getText();
        String name = Name.getText();
        System.out.println(uid);
        System.out.println(name);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        UID = new JTextField();
        panel2 = new JPanel();
        label2 = new JLabel();
        Name = new JTextField();
        search = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        Result = new JTextArea();

        //======== this ========
        setPreferredSize(new Dimension(400, 300));
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new FlowLayout());

                //======== panel1 ========
                {
                    panel1.setMinimumSize(new Dimension(86, 40));
                    panel1.setPreferredSize(new Dimension(140, 40));
                    panel1.setLayout(new FlowLayout());

                    //---- label1 ----
                    label1.setText("UID");
                    panel1.add(label1);

                    //---- UID ----
                    UID.setPreferredSize(new Dimension(100, 30));
                    UID.setHorizontalAlignment(SwingConstants.LEFT);
                    panel1.add(UID);
                }
                contentPanel.add(panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(new FlowLayout());

                    //---- label2 ----
                    label2.setText("Name");
                    panel2.add(label2);

                    //---- Name ----
                    Name.setPreferredSize(new Dimension(100, 30));
                    panel2.add(Name);
                }
                contentPanel.add(panel2);

                //---- search ----
                search.setText("\u67e5\u8be2");
                search.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        searchMouseClicked(e);
                    }
                });
                contentPanel.add(search);
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== panel3 ========
            {
                panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

                //======== scrollPane1 ========
                {

                    //---- Result ----
                    Result.setPreferredSize(new Dimension(360, 150));
                    Result.setLineWrap(true);
                    Result.setWrapStyleWord(true);
                    scrollPane1.setViewportView(Result);
                }
                panel3.add(scrollPane1);
            }
            dialogPane.add(panel3, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

}
