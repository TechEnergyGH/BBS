/*
 * Created by JFormDesigner on Mon Jun 26 10:52:46 CST 2023
 */

package main.java.forum.GUI.user;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

import static main.java.forum.util.DBUtil.connection;

/**
 * @author 11318
 */
public class Search extends JFrame {
    ArrayList<String> ls = new ArrayList<>();
    public Search() {
        initComponents();
    }

    private void searchMouseClicked(MouseEvent e) {
        // TODO add your code here
        String uid = UID.getText();
        String name = Name.getText();
        String email = Email.getText();
        if (uid.equals("") && name.equals("") && email.equals("")) {
            Result.setText("空");
            return;
        }
        try (Connection connection = connection()) {
            try {
                Result.setText("uID\tName\tEmail\tSex\tBirthday\n");
                String sql;
                ls.clear();
                if (!uid.equals("") && !name.equals("") && !email.equals("")) {
                    sql = "select * from user where uID=?&&Name=?&&Email=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, uid);
                    ps.setString(2, name);
                    ps.setString(3, email);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else if (!uid.equals("") && !name.equals("")) {
                    sql = "select * from user where uID=?&&Name=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, uid);
                    ps.setString(2, name);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else if (!uid.equals("") && !email.equals("")) {
                    sql = "select * from user where uID=?&&Email=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else if (!name.equals("") && !email.equals("")) {
                    sql = "select * from user where uID=?&&name=?&&Email=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else if (!uid.equals("")) {
                    sql = "select * from user where uID=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, uid);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else if (!name.equals("")) {
                    sql = "select * from user where Name=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, name);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                } else {
                    sql = "select * from user where Email=?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, email);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ls.add(rs.getString("uID"));
                        Result.append(rs.getString("uID") + "\t" + rs.getString("Name") + "\t" + rs.getString("Email") + "\t" + rs.getString("Sex") + "\t" + rs.getString("Birthday") + "\n");
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
    }

    private void deleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        String sql = "delete from user where uID=?";
        PreparedStatement ps;
        try (Connection connection = connection()) {
            ps = connection.prepareStatement(sql);
            for (var x : ls) {
                ps.setString(1, x);
                ps.executeUpdate();
            }
            Result.setText("uID\tName\tEmail\tSex\tBirthday\n");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
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
        panel4 = new JPanel();
        label3 = new JLabel();
        Email = new JTextField();
        search = new JButton();
        delete = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        Result = new JTextArea();

        //======== this ========
        setPreferredSize(new Dimension(690, 350));
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

                //======== panel4 ========
                {
                    panel4.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("Email");
                    panel4.add(label3);

                    //---- Email ----
                    Email.setPreferredSize(new Dimension(100, 30));
                    panel4.add(Email);
                }
                contentPanel.add(panel4);

                //---- search ----
                search.setText("\u67e5\u8be2");
                search.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        searchMouseClicked(e);
                    }
                });
                contentPanel.add(search);

                //---- delete ----
                delete.setText("\u5220\u9664");
                delete.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        deleteMouseClicked(e);
                    }
                });
                contentPanel.add(delete);
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
                cancelButton.setText("Cancel");
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

            //======== panel3 ========
            {
                panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

                //======== scrollPane1 ========
                {

                    //---- Result ----
                    Result.setPreferredSize(new Dimension(360, 150));
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JTextField UID;
    private JPanel panel2;
    private JLabel label2;
    private JTextField Name;
    private JPanel panel4;
    private JLabel label3;
    private JTextField Email;
    private JButton search;
    private JButton delete;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTextArea Result;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
