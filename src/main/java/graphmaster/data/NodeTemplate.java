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

public class NodeTemplate {
	String name = "";
	Vector2 size = new Vector2();
	
	class NodePoint {
		String name = "";
		/**
		 * true이면 Link가 1개로 제한된다.
		 */
		boolean singleLink = false;
	}
	
	LinkedList<NodePoint> points = new LinkedList<NodePoint>();

	public Node newNode() {
		Node node = new Node(this);
		node.setSize( size );
		return node;
	}
}
