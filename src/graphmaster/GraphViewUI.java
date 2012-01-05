/*
    GraphMaster
    Copyright (C) 2011 Taesu Pyo

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses/.
*/
package graphmaster;

import graphmaster.data.Vector2;
import graphmaster.Graphics;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

public class GraphViewUI implements PaintListener, MouseListener, MouseMoveListener, MouseTrackListener, ControlListener {
	private GraphView graphView;
	private Shell shell;

	public GraphViewUI(GraphView graphView, Shell shell) {
		this.graphView = graphView;
		this.shell = shell;
		
		graphView.setViewOffset( new Vector2(-100, -100) );
				
		shell.addMouseListener(this);
		shell.addMouseMoveListener(this);
		shell.addMouseTrackListener(this);
		shell.addPaintListener(this);
		shell.addControlListener(this);

		updateViewRect();
	}
	
	private void updateViewRect() {
	}
	
	@Override
	public void paintControl(PaintEvent e) {
		Rectangle paintArea = new Rectangle(e.x, e.y, e.width, e.height);
		Graphics g = new Graphics(e.display, e.gc);
		g.setPaintArea( paintArea );
		graphView.drawCanvas(g, paintArea);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMove(MouseEvent e) {
		// (new Point(e.x, e.y));
		shell.redraw();
	}

	@Override
	public void mouseEnter(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExit(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseHover(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlMoved(ControlEvent e) {
		updateViewRect();
	}

	@Override
	public void controlResized(ControlEvent e) {
		updateViewRect();
	}
}
