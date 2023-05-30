import javax.swing.*; 
import java.awt.*;

public class GridPanel extends JPanel { 
    private int row = -1; 
    private int col = -1; 
    private int val = -99; 
    
    public GridPanel() {
	row = -1; 
	col = -1; 
	val = -99;
    }
    
    public GridPanel(Color color, int r, int c, int v) {
	this.setBackground(color); 
	this.setPreferredSize(new Dimension(Globals.COL_WIDTH, Globals.ROW_HEIGHT)); 
	this.setBorder(BorderFactory.createLineBorder(Color.WHITE)); 
	
	row = r; 
	col = c; 
	val = v; 
    }
}
