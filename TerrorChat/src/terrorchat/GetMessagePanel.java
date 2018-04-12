/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;

import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author gambila
 */
public class GetMessagePanel extends javax.swing.JPanel {

    private GetMessageController gmc = new GetMessageController();
    private String loggedInUser;
    

    public GetMessagePanel() {
        initComponents();
        
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
                System.out.println("insert update");
                System.out.println(searchTextField.getText());
                
                ArrayList<Message> messages = gmc.getMessageBySearchedTerm(searchTextField.getText(),loggedInUser );
                System.out.println(messages);
                if (messages.size() == 0) {
                    displayTextArea.setText("No Unread Messages!");
                } else {
                    displayTextArea.setText("");
                    System.out.println(messages);
                    for (int i = 0; i < messages.size(); i++) {
                        displayTextArea.append(messages.get(i).toString());
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                System.out.println("remove update");
                System.out.println("Changed!");
                 loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
                ArrayList<Message> messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
                if (messages.size() == 0) {
                    displayTextArea.setText("No Unread Messages!");
                } else {
                    displayTextArea.setText("");
                    for (int i = 0; i < messages.size(); i++) {
                        displayTextArea.append(messages.get(i).toString());
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                System.out.println("Changed!");
                 loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
                ArrayList<Message> messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
                if (messages.size() == 0) {
                    displayTextArea.setText("No Unread Messages!");
                } else {
                    displayTextArea.setText("");
                    for (int i = 0; i < messages.size(); i++) {
                        displayTextArea.append(messages.get(i).toString());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getUnreadButton = new javax.swing.JButton();
        getSentButton = new javax.swing.JButton();
        getAllFromUserButton = new javax.swing.JButton();
        userTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();
        getAllMessagesButton = new javax.swing.JButton();

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

        getAllFromUserButton.setText("Get All From User");
        getAllFromUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllFromUserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Messages for Term");

        searchTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchTextFieldInputMethodTextChanged(evt);
            }
        });
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        jScrollPane1.setViewportView(displayTextArea);

        getAllMessagesButton.setText("Get All Messages");
        getAllMessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllMessagesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 82, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void getUnreadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUnreadButtonActionPerformed
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        ArrayList<Message> messages = gmc.getAllUnreadMessages(loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Unread Messages!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_getUnreadButtonActionPerformed

    private void getSentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSentButtonActionPerformed
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        ArrayList<Message> messages = gmc.getAllSentMessages(loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Messages Found!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_getSentButtonActionPerformed

    private void getAllMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllMessagesButtonActionPerformed
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        ArrayList<Message> messages = gmc.getAllMessages(loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Messages Found!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_getAllMessagesButtonActionPerformed

    private void getAllFromUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllFromUserButtonActionPerformed
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        ArrayList<Message> messages = gmc.getAllFromSpecifiedUser(userTextField.getText(), loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Unread Messages!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_getAllFromUserButtonActionPerformed

    private void searchTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchTextFieldInputMethodTextChanged
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        System.out.println("Changed!");
        ArrayList<Message> messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Unread Messages!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_searchTextFieldInputMethodTextChanged

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
         loggedInUser = ((MainPanel)GetMessagePanel.this.getParent()).getUsername();
        System.out.println("Action Performed!");
        ArrayList<Message> messages = gmc.getMessageBySearchedTerm(searchTextField.getText(), loggedInUser);
        if (messages.size() == 0) {
            displayTextArea.setText("No Unread Messages!");
        } else {
            displayTextArea.setText(" ");
            for (int i = 0; i < messages.size(); i++) {
                displayTextArea.append(messages.get(i).toString());
            }
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JButton getAllFromUserButton;
    private javax.swing.JButton getAllMessagesButton;
    private javax.swing.JButton getSentButton;
    private javax.swing.JButton getUnreadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
