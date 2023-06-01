import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridPanel extends JPanel
{
    private int row = -1;
    private int col = -1;
    private int val = -99;

    public GridPanel ()
    {
	row = -1;
	col = -1;
	val = -99;
    }


    public GridPanel (Color color, int r, int c, int v)
    {
	this.setBackground (color);
	this.setPreferredSize (new Dimension (Globals.COL_WIDTH, Globals.ROW_HEIGHT));
	this.setBorder (BorderFactory.createLineBorder (Color.WHITE));

	row = r;
	col = c;
	val = v;

	addMouseListener (new MoveListener ());
    }


    public void setVal (int v)
    {
	val = v;
    }


    public int getVal ()
    {
	return val;
    }


    public void drawXorO (Graphics g)
    {
	if (val == Globals.PLAYER_ONE)
	{
	    // Draw an X
	    g.setColor (Color.red);
	    g.drawLine (Globals.OFFSET, Globals.OFFSET,
		    Globals.COL_WIDTH - Globals.OFFSET,
		    Globals.ROW_HEIGHT - Globals.OFFSET);
	    g.drawLine (Globals.OFFSET, Globals.ROW_HEIGHT - Globals.OFFSET,
		    Globals.COL_WIDTH - Globals.OFFSET, Globals.OFFSET);
	}
	else if (val == Globals.PLAYER_TWO)
	{
	    // Draw an O
	    g.setColor (Color.red);
	    g.drawOval (Globals.OFFSET, Globals.OFFSET,
		    Globals.COL_WIDTH - 2 * Globals.OFFSET,
		    Globals.ROW_HEIGHT - 2 * Globals.OFFSET);
	}
    }


    private class MoveListener extends MouseAdapter
    {
	public MoveListener ()
	{

	}

	public void mousePressed (MouseEvent e)
	{
	    System.out.println ("Mouse pressed in panel: " + row + " " + col);

	    val = 1;

	    Graphics g = getGraphics ();
	    drawXorO (g);
	}
    }
}
