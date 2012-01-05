package graphmaster;

import graphmaster.data.Rect;
import graphmaster.data.Vector2;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class Graphics {
	private Vector2 coordOffset = new Vector2();

	private Display display;
	private GC gc;
	
	public Graphics(Display display, GC gc) {
		this.display = display;
		this.gc = gc;
	}

	public void setOffset(Vector2 viewOffset) {
		coordOffset = viewOffset;
	}

	public void setPaintArea(Rectangle paintArea) {
		// TODO Auto-generated method stub
	}

	private Rectangle translateCoord(Rect bound) {
		Point p1 = translateCoord(bound.leftTop());
		Point p2 = translateCoord(bound.rightBottom());
		
		return new Rectangle( p1.x, p1.y, p2.x - p1.x, p2.y - p1.y );
	}

	private Point translateCoord(Vector2 v) {
		v.sub( coordOffset );
		return new Point( (int)v.x, (int)v.y );
	}

	public void drawRectangle(Rect rt) {
		gc.drawRectangle( translateCoord(rt) );
	}

	public void fillRectangle(Rect rt) {
		Color color = new Color(display, 255, 255, 255);
		gc.setBackground(color);
		gc.fillRectangle( translateCoord(rt) );
		color.dispose();
	}

}
