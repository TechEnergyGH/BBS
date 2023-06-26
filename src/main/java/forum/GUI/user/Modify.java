/*
 * Created by JFormDesigner on Mon Jun 26 20:01:42 CST 2023
 */

package main.java.forum.GUI.user;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.*;

import static main.java.forum.util.DBUtil.connection;

/**
 * @author 11318
 */
public class Modify extends JFrame {
    public Modify() {
        initComponents();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        if (UID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "UID为空", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();
            if (!Name.getText().equals("")) {
                String sql = "UPDATE user SET Name=\"" + Name.getText() + "\" WHERE uID=" + UID.getText();
                statement.executeUpdate(sql);
            }
            if (!Email.getText().equals("")) {
                String sql = "UPDATE user SET Email=\"" + Email.getText() + "\" WHERE uID=" + UID.getText();
                statement.executeUpdate(sql);
            }
            if (!Birthday.getText().equals("")) {
                String sql = "UPDATE user SET Birthday=\"" + Birthday.getText() + "\" WHERE uID=" + UID.getText();
                statement.executeUpdate(sql);
            }
            JOptionPane.showMessageDialog(null, "修改完成", "通知", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        dispose();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
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
        label3 = new JLabel();
        Email = new JTextField();
        label4 = new JLabel();
        Birthday = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setVisible(true);
        setPreferredSize(new Dimension(510, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout());

                    //---- label1 ----
                    label1.setText("UID");
                    panel1.add(label1);

                    //---- UID ----
                    UID.setPreferredSize(new Dimension(100, 30));
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

                    //---- label3 ----
                    label3.setText("Email");
                    panel2.add(label3);

                    //---- Email ----
                    Email.setPreferredSize(new Dimension(100, 30));
                    panel2.add(Email);

                    //---- label4 ----
                    label4.setText("Birthday");
                    panel2.add(label4);

                    //---- Birthday ----
                    Birthday.setPreferredSize(new Dimension(100, 30));
                    panel2.add(Birthday);
                }
                contentPanel.add(panel2);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u4fee\u6539");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
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
    private JPanel panel1;
    private JLabel label1;
    private JTextField UID;
    private JPanel panel2;
    private JLabel label2;
    private JTextField Name;
    private JLabel label3;
    private JTextField Email;
    private JLabel label4;
    private JTextField Birthday;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
