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

public class Node {
	private String name = "Noname";
	private NodeTemplate nodeTemplate;
	private Vector2 pos = new Vector2();
	private Vector2 size = new Vector2();
	
	public Node( NodeTemplate nodeTemplate ) {
		this.nodeTemplate = nodeTemplate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String v) {
		name = v;
	}

	@Override
	public Node clone() {
		Node n = new Node(nodeTemplate);

		n.name = name;
		n.pos.assign(pos);
		n.size.assign(size);

		return n;
	}

	public void setSize(Vector2 v) {
		size.assign(v);
	}

	public void setPos(Vector2 v) {
		pos.assign(v);
	}

	public Rect getBound() {
		return Rect.RectByPosSize(pos, size);
	}
}
