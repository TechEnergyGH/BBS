/*
 * Created by JFormDesigner on Mon Jun 26 13:02:19 CST 2023
 */

package main.java.forum.GUI;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 11318
 */
public class Register extends JFrame {
    private String Sex;

    public Register() {
        initComponents();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        if (Name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "请填写名字！", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (Password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "请填写密码！", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (Email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "请填写邮箱！", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (Sex == null) {
            JOptionPane.showMessageDialog(null, "请选择性别！", "警告", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

    }

    private void MenMouseClicked(MouseEvent e) {
        // TODO add your code here
        Sex = "男";
    }

    private void WomenMouseClicked(MouseEvent e) {
        // TODO add your code here
        Sex = "女";
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        Name = new JTextField();
        panel6 = new JPanel();
        label2 = new JLabel();
        Password = new JTextField();
        panel1 = new JPanel();
        label3 = new JLabel();
        Email = new JTextField();
        panel5 = new JPanel();
        label4 = new JLabel();
        Year = new JTextField();
        label5 = new JLabel();
        Month = new JTextField();
        label6 = new JLabel();
        Day = new JTextField();
        label7 = new JLabel();
        panel2 = new JPanel();
        Men = new JRadioButton();
        Women = new JRadioButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== panel3 ========
                {
                    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

                    //======== panel4 ========
                    {
                        panel4.setLayout(new FlowLayout());

                        //---- label1 ----
                        label1.setText("Name");
                        panel4.add(label1);

                        //---- Name ----
                        Name.setPreferredSize(new Dimension(100, 30));
                        panel4.add(Name);
                    }
                    panel3.add(panel4);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new FlowLayout());

                        //---- label2 ----
                        label2.setText("Password");
                        panel6.add(label2);

                        //---- Password ----
                        Password.setPreferredSize(new Dimension(100, 30));
                        panel6.add(Password);
                    }
                    panel3.add(panel6);

                    //======== panel1 ========
                    {
                        panel1.setLayout(new FlowLayout());

                        //---- label3 ----
                        label3.setText("Email");
                        panel1.add(label3);

                        //---- Email ----
                        Email.setPreferredSize(new Dimension(100, 30));
                        panel1.add(Email);
                    }
                    panel3.add(panel1);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout());

                        //---- label4 ----
                        label4.setText("\u751f\u65e5");
                        panel5.add(label4);

                        //---- Year ----
                        Year.setPreferredSize(new Dimension(50, 30));
                        panel5.add(Year);

                        //---- label5 ----
                        label5.setText("\u5e74");
                        panel5.add(label5);

                        //---- Month ----
                        Month.setMinimumSize(new Dimension(50, 30));
                        panel5.add(Month);

                        //---- label6 ----
                        label6.setText("\u6708");
                        panel5.add(label6);

                        //---- Day ----
                        Day.setMinimumSize(new Dimension(50, 30));
                        panel5.add(Day);

                        //---- label7 ----
                        label7.setText("\u65e5");
                        panel5.add(label7);
                    }
                    panel3.add(panel5);

                    //======== panel2 ========
                    {
                        panel2.setLayout(new FlowLayout());

                        //---- Men ----
                        Men.setText("\u7537");
                        Men.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                MenMouseClicked(e);
                            }
                        });
                        panel2.add(Men);

                        //---- Women ----
                        Women.setText("\u5973");
                        Women.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                WomenMouseClicked(e);
                            }
                        });
                        panel2.add(Women);
                    }
                    panel3.add(panel2);
                }
                contentPanel.add(panel3, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u6ce8\u518c");
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

        //---- Sex ----
        var Sex = new ButtonGroup();
        Sex.add(Men);
        Sex.add(Women);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JTextField Name;
    private JPanel panel6;
    private JLabel label2;
    private JTextField Password;
    private JPanel panel1;
    private JLabel label3;
    private JTextField Email;
    private JPanel panel5;
    private JLabel label4;
    private JTextField Year;
    private JLabel label5;
    private JTextField Month;
    private JLabel label6;
    private JTextField Day;
    private JLabel label7;
    private JPanel panel2;
    private JRadioButton Men;
    private JRadioButton Women;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
