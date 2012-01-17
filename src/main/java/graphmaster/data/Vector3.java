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

public class Vector3 implements Cloneable {
	public double x, y, z;

	public Vector3() {
		x = y = z = 0;
	}
	
	public Vector3( double v ) {
		x = y = z = v;
	}
	
	public Vector3( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3( Vector2 v, double z ) {
		this.x = v.x;
		this.y = v.y;
		this.z = z;
	}

	public Vector2 xy() {
		return new Vector2( x, y );
	}
	
	public double dot( Vector3 v ) {
		return x * v.x + y * v.y + z * v.z;
	}
	
	public double length() {
		return Math.sqrt( x * x + y * y + z * z );
	}
	
	@Override
	protected Vector3 clone() {
		return new Vector3( x, y, z );
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Vector3 ) {
			Vector3 v = (Vector3) obj;
			return x == v.x && y == v.y &&  z == v.z;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format( "(%f, %f, %f)", x, y, z );
	}

}
