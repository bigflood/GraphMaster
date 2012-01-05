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

public class Rect {
	double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	
	public Rect() {
	}
	
	public Rect( double x1, double y1, double x2, double y2 ) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public double left() {
		return x1;
	}
	
	public double top() {
		return y1;
	}
	
	public double right() {
		return x2;
	}
	
	public double bottom() {
		return y2;
	}
	
	public Vector2 leftTop() {
		return new Vector2( x1, y1 );
	}
	
	public Vector2 rightBottom() {
		return new Vector2( x2, y2 );
	}
}
