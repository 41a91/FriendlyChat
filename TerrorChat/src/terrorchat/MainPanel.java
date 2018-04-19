
package terrorchat;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MainPanel extends javax.swing.JPanel
{
    private PanelManager manager;
     private String username;

    public MainPanel()
    {
        initComponents();
        setLayout( new GridLayout(0,1,0,3));
        ArrayList<JPanel> panels = new ArrayList<>();
        panels.add(new LoginPanel());
        panels.add(new sendMessagePanel());
        panels.add(new registerPanel());
        //panels.add(new GetMessagePanel());
        panels.add(new RetrieveMessagePanel());
        
        username = getUsername();
       
        this.setFocusable(true);
        manager = new PanelManager(this,panels);
    }

    public PanelManager getManager()
    {
        return manager;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String name)
    {
        username = name;
        System.out.println("Set username to: "+username);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyPressed
    {//GEN-HEADEREND:event_formKeyPressed
         
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
