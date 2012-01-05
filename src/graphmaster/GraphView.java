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

import graphmaster.data.Graph;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class GraphView {

	@SuppressWarnings("unused")
	private Graph graphData;
	private Rectangle canvasRect;
	private Point mousePos = new Point(0,0);
	
	public GraphView(Graph graphData) {
		this.graphData = graphData;
	}

	public void drawCanvas(GC gc, Rectangle paintArea) {
		gc.drawOval(0, 0, canvasRect.width - 1, canvasRect.height - 1);
		gc.drawLine(0, mousePos.y, canvasRect.width-1, mousePos.y);
		gc.drawLine(mousePos.x, 0, mousePos.x, canvasRect.height-1);
	}

	public void setCanvasRect(Rectangle canvasRect) {
		this.canvasRect = canvasRect;
	}

	public void setMousePos(Point mousePos) {
		this.mousePos = mousePos;
	}
}
