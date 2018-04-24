
package terrorchat;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class BoldRenderer extends  DefaultTableCellRenderer implements TableCellRenderer{

    private boolean isRead;
    
    
    public BoldRenderer() {
        super();
        isRead = false;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        /*
        if(!isRead)
        {  
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.BOLD));
        }else{
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.PLAIN));
        }
*/
        if(table.getValueAt(row, col).equals("false"))
        {
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.BOLD));
        }
        else
        {
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.PLAIN));
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
