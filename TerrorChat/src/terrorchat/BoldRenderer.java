
package terrorchat;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class BoldRenderer extends  DefaultTableCellRenderer{

    private boolean isRead;
    
    
    public BoldRenderer() {
        super();
        isRead = false;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); 
        if(isRead)
        {  
            this.setFont(this.getFont().deriveFont(Font.BOLD));
        }else{
            this.setFont(this.getFont().deriveFont(Font.PLAIN));
        }

        return this;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    
    
    
    
    

    
}
