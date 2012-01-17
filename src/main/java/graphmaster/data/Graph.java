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
package graphmaster.data;

import java.util.LinkedList;

public class Graph {
	public String name = "";
	private LinkedList<Node> nodes = new LinkedList<Node>();
	LinkedList<Link> links = new LinkedList<Link>();

	public Graph() {
		super();
	}

	public void addNode( Node node ) {
		nodes.add( node );
	}

	public LinkedList<Node> getNodes() {
		return nodes;
	}
	
	public LinkedList<Link> getLinks() {
		return links;
	}

	@Override
	public Object clone() {
		Graph g = new Graph();
	
		for( Node node : nodes ) {
			g.nodes.add( node.clone() );
		}
		
		for( Link link : links ) {
			g.links.add( link.clone() );
		}
		
		return g;
	}

}
