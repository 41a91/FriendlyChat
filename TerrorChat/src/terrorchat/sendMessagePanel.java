
package terrorchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class sendMessagePanel extends javax.swing.JPanel {

    
    private HashMap<String,Draft> map;
    private int bongo;
   
    public sendMessagePanel() {
        initComponents();
        
        map = new HashMap<>();
        bongo = 0;
        
        
    }

    private void fillCombo(){
        
       map = SendMessageController.getDrafts(((MainPanel)this.getParent()).getUsername());
       Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            //set to string and save to variable. Then add that to the combobox
            draftComboBobo.addItem((String)it.next());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subjectTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        getButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        draftComboBobo = new javax.swing.JComboBox<>();
        deleteComboButton = new javax.swing.JButton();

        toTextField.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        toTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                toTextFieldInputMethodTextChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        jLabel1.setText("To:");

        jLabel2.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        jLabel2.setText("Subject:");

        subjectTextField.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N

        bodyTextArea.setColumns(20);
        bodyTextArea.setFont(new java.awt.Font("Jokerman", 0, 13)); // NOI18N
        bodyTextArea.setRows(5);
        jScrollPane1.setViewportView(bodyTextArea);

        sendButton.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        getButton.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        getButton.setText("get draft");
        getButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N
        saveButton.setText("save draft");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        draftComboBobo.setFont(new java.awt.Font("Jokerman", 0, 11)); // NOI18N

        deleteComboButton.setText("X");
        deleteComboButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteComboButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addComponent(sendButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(draftComboBobo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteComboButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toTextField)
                            .addComponent(subjectTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sendButton)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(saveButton)
                                .addComponent(draftComboBobo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteComboButton)))
                        .addGap(1, 1, 1)
                        .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
       
        String[] toList = toTextField.getText().split(";");
        String from = ((MainPanel)this.getParent()).getUsername();
        String subject = subjectTextField.getText();
        String body = bodyTextArea.getText();
        
        SendMessageController.insertMessage(toList, from, subject, body);
        bodyTextArea.setText("");
        subjectTextField.setText("");
        toTextField.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

    private void toTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_toTextFieldInputMethodTextChanged
        
    }//GEN-LAST:event_toTextFieldInputMethodTextChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String toList = toTextField.getText();
        String from = ((MainPanel)this.getParent()).getUsername();
        String subject = subjectTextField.getText();
        String body = bodyTextArea.getText();
        
        SendMessageController.insertDrafts(toList, from, subject, body);
        bodyTextArea.setText("");
        subjectTextField.setText("");
        toTextField.setText("");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void getButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButtonActionPerformed
        if(bongo == 0){
            bongo = 1;
            fillCombo();
        }
        else{
            Draft draft = map.get(draftComboBobo.getSelectedItem());
            toTextField.setText(draft.getToUsername());
            bodyTextArea.setText(draft.getBody());
            subjectTextField.setText(draft.getSubject());  
        }
        
    }//GEN-LAST:event_getButtonActionPerformed

    private void deleteComboButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteComboButtonActionPerformed
        
    }//GEN-LAST:event_deleteComboButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyTextArea;
    private javax.swing.JButton deleteComboButton;
    private javax.swing.JComboBox<String> draftComboBobo;
    private javax.swing.JButton getButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField subjectTextField;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}
