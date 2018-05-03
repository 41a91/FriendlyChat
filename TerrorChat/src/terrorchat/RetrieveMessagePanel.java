/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;

import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.options.Options;

/**
 *
 * @author moorhem
 */
public class RetrieveMessagePanel extends javax.swing.JPanel {

    private GetMessageController gmc = new GetMessageController();
    private String loggedInUser;
    private ArrayList<Message> messages;
    private Mode mode = Mode.GETALL;

    public RetrieveMessagePanel() {
        initComponents();
        table.setCellEditor(null);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int selected = table.getSelectedRow();
                try {
                    Message m = messages.get(selected);
                    if (m != null) {
                        Object[] options = {"Mark Read", "Cancel", "Delete Message"};
                        JTextArea text = new JTextArea(m.getBody());
                        text.setRows(25);
                        text.setColumns(80);
                        JComponent[] inputs = new JComponent[]{
                            new JLabel("To: " + m.getToUsername()), new JLabel("From: " + m.getFromUsername()),
                            new JLabel("Subject: " + m.getSubject()),
                            new JLabel("Date: " + m.getTimeStamp()), text
                        };
                        //int response = JOptionPane.showConfirmDialog(RetrieveMessagePanel.this,inputs, "Message", JOptionPane.INFORMATION_MESSAGE);
                        int response = JOptionPane.showOptionDialog(RetrieveMessagePanel.this, inputs, "Message", JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        System.out.println("response" + response);
                        if (response == 0) {
                            //Mark as read
                            boolean success = gmc.updateMessageToRead(m, loggedInUser);
                            System.out.println("Success " + success);
                            System.out.println("Mode " + mode);
                            if (success) {
                                if(mode == Mode.GETALL)
                                {
                                    getAllFromUser();
                                }
                                else if(mode == Mode.GETSENT)
                                {
                                    getSentMessages();
                                }
                                else if(mode == Mode.GETSPECIFICUSER)
                                {
                                    getAllFromUser();
                                }
                                else if(mode == Mode.GETUNREAD)
                                {
                                    getUnreadMessages();
                                }
                            }
                        } else if (response == 1) {
                            //Cancel
                        } else {
                            //Delete
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Excpeiton caught");
                }

            }
        });
        messages = new ArrayList<>();
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
                DefaultTableModel model = new DefaultTableModel();
                table.setModel(model);
                String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
                BoldRenderer br = new BoldRenderer();
                model.setColumnIdentifiers(columnNames);
                messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
                if (messages.size() == 0) {
                    //displayTextArea.setText("No Messages Found!");
                } else {
                    //displayTextArea.setText(" ");

                    for (int i = 0; i < messages.size(); i++) {
                        Object[] row = new Object[5];
                        System.out.println(i + ": " + br.isIsRead());
                        if (messages.get(i).isRead()) {
                            br.setIsRead(true);
                        } else {
                            br.setIsRead(false);
                        }
                        row[0] = messages.get(i).getToUsername();
                        row[1] = messages.get(i).getFromUsername();
                        row[2] = messages.get(i).getSubject();
                        row[3] = new Date(messages.get(i).getTimeStamp());
                        row[4] = messages.get(i).isRead();

                        model.addRow(row);

                        //displayTextArea.append(messages.get(i).toString());
                    }
                    table.setDefaultRenderer(Object.class, br);
                }
                revalidate();
                repaint();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                System.out.println("remove update");
                System.out.println("Changed!");
                loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
                DefaultTableModel model = new DefaultTableModel();
                table.setModel(model);
                String[] columnNames = {"To", "From", "Subject", "Date"};
                BoldRenderer br = new BoldRenderer();
                model.setColumnIdentifiers(columnNames);
                messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
                if (messages.size() == 0) {
                    //displayTextArea.setText("No Messages Found!");
                } else {
                    //displayTextArea.setText(" ");

                    for (int i = 0; i < messages.size(); i++) {
                        Object[] row = new Object[5];
                        System.out.println(i + ": " + br.isIsRead());
                        if (messages.get(i).isRead()) {
                            br.setIsRead(true);
                        } else {
                            br.setIsRead(false);
                        }
                        row[0] = messages.get(i).getToUsername();
                        row[1] = messages.get(i).getFromUsername();
                        row[2] = messages.get(i).getSubject();
                        row[3] = new Date(messages.get(i).getTimeStamp());
                        row[4] = messages.get(i).isRead();

                        model.addRow(row);

                        //displayTextArea.append(messages.get(i).toString());
                    }
                    table.setDefaultRenderer(Object.class, br);
                }
                revalidate();
                repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                System.out.println("Changed!");
                loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
                DefaultTableModel model = new DefaultTableModel();
                table.setModel(model);
                String[] columnNames = {"To", "From", "Subject", "Date"};
                BoldRenderer br = new BoldRenderer();
                model.setColumnIdentifiers(columnNames);
                messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
                if (messages.size() == 0) {
                    //displayTextArea.setText("No Messages Found!");
                } else {
                    //displayTextArea.setText(" ");

                    for (int i = 0; i < messages.size(); i++) {
                        Object[] row = new Object[5];
                        System.out.println(i + ": " + br.isIsRead());
                        if (messages.get(i).isRead()) {
                            br.setIsRead(true);
                        } else {
                            br.setIsRead(false);
                        }
                        row[0] = messages.get(i).getToUsername();
                        row[1] = messages.get(i).getFromUsername();
                        row[2] = messages.get(i).getSubject();
                        row[3] = new Date(messages.get(i).getTimeStamp());
                        row[4] = messages.get(i).isRead();

                        model.addRow(row);

                        //displayTextArea.append(messages.get(i).toString());
                    }
                    table.setDefaultRenderer(Object.class, br);
                }
                revalidate();
                repaint();
            }
        });
    }
    
    
    
    
    
    private void getUnreadMessages()
    {
        messages = gmc.getAllUnreadMessages(loggedInUser);
        String[][] data = new String[messages.size()][5];
        String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
        for (int i = 0; i < messages.size(); i++) {
                String[] row = new String[5];
                row[0] = messages.get(i).getToUsername();
                row[1] = messages.get(i).getFromUsername();
                row[2] = messages.get(i).getSubject();
                row[3] = new Date(messages.get(i).getTimeStamp()).toString();
                row[4] = messages.get(i).isRead() +"";
                data[i]=row;
            }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);
        //revalidate();
        //repaint();
        //model.fireTableDataChanged();
    }
    
    private void getSentMessages()
    {
        mode = Mode.GETSENT;
        loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
        messages = gmc.getAllSentMessages(loggedInUser);
        if (messages.size() == 0) {
            //displayTextArea.setText("No Messages Found!");
        } else {
            //displayTextArea.setText(" ");

            table.setDefaultRenderer(Object.class, br);
            for (int i = 0; i < messages.size(); i++) {
                Object[] row = new Object[5];
                System.out.println(i + ": " + br.isIsRead());
                if (messages.get(i).isRead()) {
                    br.setIsRead(true);
                } else {
                    br.setIsRead(false);
                }
                row[0] = messages.get(i).getToUsername();
                row[1] = messages.get(i).getFromUsername();
                row[2] = messages.get(i).getSubject();
                row[3] = new Date(messages.get(i).getTimeStamp());
                row[4] = messages.get(i).isRead();
                model.addRow(row);

                //displayTextArea.append(messages.get(i).toString());
            }
        }
        revalidate();
        repaint();
        model.fireTableDataChanged();
    }
    
    private void getAllMessages()
    {
        mode = Mode.GETALL;
        loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
        messages = gmc.getAllMessages(loggedInUser);
        if (messages.size() == 0) {
            //displayTextArea.setText("No Messages Found!");
        } else {
            //displayTextArea.setText(" ");

            table.setDefaultRenderer(Object.class, br);
            for (int i = 0; i < messages.size(); i++) {
                Object[] row = new Object[5];
                //table.getColumn("To").setCellRenderer(br);
                System.out.println(i + ": " + br.isIsRead());
                if (messages.get(i).isRead()) {
                    br.setIsRead(true);
                } else {
                    br.setIsRead(false);
                }

                row[0] = messages.get(i).getToUsername();
                row[1] = messages.get(i).getFromUsername();
                row[2] = messages.get(i).getSubject();
                row[3] = new Date(messages.get(i).getTimeStamp());
                row[4] = messages.get(i).isRead();
                model.addRow(row);

                //displayTextArea.append(messages.get(i).toString());
            }

        }
        revalidate();
        repaint();
        model.fireTableDataChanged();
    }
    
    public void getAllFromUser()
    {
        mode = Mode.GETSPECIFICUSER;
        loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
        messages = gmc.getAllFromSpecifiedUser(userTextField.getText(), loggedInUser);
        if (messages.size() == 0) {
            //displayTextArea.setText("No Messages Found!");
        } else {
            //displayTextArea.setText(" ");

            table.setDefaultRenderer(Object.class, br);
            for (int i = 0; i < messages.size(); i++) {
                Object[] row = new Object[5];
                System.out.println(i + ": " + br.isIsRead());
                if (messages.get(i).isRead()) {
                    br.setIsRead(true);
                } else {
                    br.setIsRead(false);
                }
                row[0] = messages.get(i).getToUsername();
                row[1] = messages.get(i).getFromUsername();
                row[2] = messages.get(i).getSubject();
                row[3] = new Date(messages.get(i).getTimeStamp());
                row[4] = messages.get(i).isRead();
                model.addRow(row);

                //displayTextArea.append(messages.get(i).toString());
            }
        }
        revalidate();
        repaint();
        model.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getUnreadButton = new javax.swing.JButton();
        getSentButton = new javax.swing.JButton();
        getAllMessagesButton = new javax.swing.JButton();
        getAllFromUserButton = new javax.swing.JButton();
        userTextField = new javax.swing.JTextField();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        getUnreadButton.setText("Get Unread");
        getUnreadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getUnreadButtonActionPerformed(evt);
            }
        });

        getSentButton.setText("Get Sent");
        getSentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSentButtonActionPerformed(evt);
            }
        });

        getAllMessagesButton.setText("Get All Messages");
        getAllMessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllMessagesButtonActionPerformed(evt);
            }
        });

        getAllFromUserButton.setText("Get All From User");
        getAllFromUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllFromUserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Messages for Term");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "To", "From", "Subject", "Date"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getUnreadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getSentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getAllMessagesButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getAllFromUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getUnreadButton)
                    .addComponent(getSentButton)
                    .addComponent(getAllMessagesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getAllFromUserButton)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getUnreadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUnreadButtonActionPerformed
        getUnreadMessages();
    }//GEN-LAST:event_getUnreadButtonActionPerformed

    private void getSentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSentButtonActionPerformed
        getSentMessages();
    }//GEN-LAST:event_getSentButtonActionPerformed

    private void getAllMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllMessagesButtonActionPerformed
        getAllMessages();
    }//GEN-LAST:event_getAllMessagesButtonActionPerformed

    private void getAllFromUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllFromUserButtonActionPerformed
        getAllFromUser();
    }//GEN-LAST:event_getAllFromUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getAllFromUserButton;
    private javax.swing.JButton getAllMessagesButton;
    private javax.swing.JButton getSentButton;
    private javax.swing.JButton getUnreadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
