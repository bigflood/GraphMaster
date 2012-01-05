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
import graphmaster.data.Link;
import graphmaster.data.Node;
import graphmaster.data.Vector2;

import org.eclipse.swt.graphics.Rectangle;

public class GraphView {

	private Graph graphData;
	private Vector2 viewOffset = new Vector2();
	
	public GraphView(Graph graphData) {
		this.graphData = graphData;
	}

	public void setViewOffset(Vector2 viewOffset) {
		this.viewOffset = viewOffset;
	}

	public void drawCanvas(Graphics g, Rectangle paintArea) {
		g.setOffset( viewOffset );
		
		for( Node node : graphData.getNodes() ) {
			drawNode(g, node);
		}
		
		for( Link link : graphData.getLinks() ) {
			drawLink(g, link);
		}
	}

	private void drawNode(Graphics g, Node node) {
		g.fillRectangle( node.getBound() );
		g.drawRectangle( node.getBound() );
	}

	private void drawLink(Graphics g, Link link) {
		// TODO Auto-generated method stub
	}
}
