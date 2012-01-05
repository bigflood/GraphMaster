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
	@SuppressWarnings("unused")
	private NodeTemplate nodeTemplate;
	private Rect bound = new Rect(0, 0, 100, 50);
	
	public Rect getBound() {
		return bound;
	}
	
	public void setBound(Rect bound) {
		this.bound = bound;
	}
	
	public String getName() {
		return name;
	}
}
