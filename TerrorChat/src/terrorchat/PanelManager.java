
package terrorchat;

import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelManager
{
    private ArrayList<JPanel>panels;
    private JPanel currentPanel;
    private int currentPanelIndex;
    private JPanel parent;
    
    public PanelManager(JPanel parent, ArrayList<JPanel>panels)
    {
        this.parent = parent;
        this.panels = panels;
        currentPanel = panels.get(0);
        parent.add(currentPanel);
        currentPanelIndex = 0;
    }
    public void next()
    {
        currentPanelIndex++;
        if( currentPanelIndex >= panels.size())
        {
            currentPanelIndex = 0;
        }
        parent.remove(currentPanel);
        currentPanel = panels.get(currentPanelIndex);
        parent.add(currentPanel);
        parent.revalidate();
        parent.repaint();
    }
    public void previous()
    {
         currentPanelIndex--;
        if( currentPanelIndex < 0)
        {
            currentPanelIndex = panels.size() - 1;
        }
        parent.remove(currentPanel);
        currentPanel = panels.get(currentPanelIndex);
        parent.add(currentPanel);
        parent.revalidate();
        parent.repaint();
    }
    
    public void goToPanel(int index) throws ArrayIndexOutOfBoundsException
    {
         if(index < 0 || index >= panels.size())
         {
             throw new ArrayIndexOutOfBoundsException("index of panel is out of range");
         }
         parent.remove(currentPanel);
         this.currentPanelIndex = index;
         this.currentPanel = this.panels.get(index);
         parent.add(currentPanel);
         parent.revalidate();
         parent.repaint();
    }
}
