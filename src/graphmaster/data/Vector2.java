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

public class Vector2 implements Cloneable {
	public double x, y;

	public Vector2() {
		x = y = 0;
	}
	
	public Vector2( double v ) {
		x = y = v;
	}
	
	public Vector2( double x, double y ) {
		this.x = x;
		this.y = y;
	}

	public double dot( Vector2 v ) {
		return x * v.x + y * v.y;
	}
	
	public double length() {
		return Math.sqrt( x * x + y * y );
	}

	@Override
	protected Vector2 clone() {
		return new Vector2( x, y );
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Vector2 )
		{
			Vector2 v = (Vector2) obj;
			return x == v.x && y == v.y;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format( "(%f,%f)", x, y );
	}

	public void add(Vector2 v) {
		x += v.x;
		y += v.y;
	}

	public void sub(Vector2 v) {
		x -= v.x;
		y -= v.y;
	}
}
