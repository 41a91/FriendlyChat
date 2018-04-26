
package terrorchat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class TerrorTable extends JTable{

    public TerrorTable() {
        DefaultTableModel model = new DefaultTableModel();
        this.setModel(model);
        String[] columnNames = {"To", "From", "Subject", "Date", "Read"};
        BoldRenderer br = new BoldRenderer();
        model.setColumnIdentifiers(columnNames);
    }
    
    

    @Override
    public TableCellRenderer getCellRenderer(int row, int col) {
        if(col==4)
        {
            BoldRenderer br = new BoldRenderer();
            return br;
        } 
        else
        {
            return super.getCellRenderer(row, col);
        }
    }
    
    
    
}
