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
    
    public RetrieveMessagePanel() {
        initComponents();
        table.setCellEditor(null);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
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
        });
        messages = new ArrayList<>();
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
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
                        Object[] row = new Object[4];
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
                        Object[] row = new Object[4];
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
                        Object[] row = new Object[4];
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
        jScrollPane2 = new javax.swing.JScrollPane();
        terrorTable1 = new terrorchat.TerrorTable();

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

        jScrollPane2.setViewportView(terrorTable1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getUnreadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUnreadButtonActionPerformed
        loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
        messages = gmc.getAllUnreadMessages(loggedInUser);
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
    }//GEN-LAST:event_getUnreadButtonActionPerformed

    private void getSentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSentButtonActionPerformed
        loggedInUser = ((MainPanel) RetrieveMessagePanel.this.getParent()).getUsername();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
        messages = gmc.getAllSentMessages(loggedInUser);
        if (messages.size() == 0) {
            //displayTextArea.setText("No Messages Found!");
        } else {
            //displayTextArea.setText(" ");
            
            table.setDefaultRenderer(Object.class, br);
            for (int i = 0; i < messages.size(); i++) {
                Object[] row = new Object[4];
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
                model.addRow(row);

                //displayTextArea.append(messages.get(i).toString());
            }
        }
        revalidate();
        repaint();
    }//GEN-LAST:event_getSentButtonActionPerformed

    private void getAllMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllMessagesButtonActionPerformed
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
    }//GEN-LAST:event_getAllMessagesButtonActionPerformed

    private void getAllFromUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllFromUserButtonActionPerformed
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
                Object[] row = new Object[4];
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
                model.addRow(row);

                //displayTextArea.append(messages.get(i).toString());
            }
        }
        revalidate();
        repaint();
    }//GEN-LAST:event_getAllFromUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getAllFromUserButton;
    private javax.swing.JButton getAllMessagesButton;
    private javax.swing.JButton getSentButton;
    private javax.swing.JButton getUnreadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private terrorchat.TerrorTable terrorTable1;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
