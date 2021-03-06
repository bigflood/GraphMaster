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

public class Link {
	class LinkPoint {
		Node node = null;
	}
	
	LinkPoint point1 = new LinkPoint();
	LinkPoint point2 = new LinkPoint();
	
	@Override
	public Link clone() {
		Link l = new Link();
		
		l.point1.node = point1.node;
		l.point2.node = point2.node;
		
		return l;
	}
}
