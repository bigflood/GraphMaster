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

public class Matrix23 implements Cloneable {
	double values[];

	public Matrix23() {
		values = new double[] {
			1, 0, 0,
			0, 1, 0,
		};
	}

	public Matrix23( double values[] ) {
		this.values = values;
	}

	public Matrix23( double v00, double v01, double v02, double v10, double v11, double v12 ) {
		values = new double[] {
			v00, v01, v02,
			v10, v11, v12,
		};
	}
	
	public Matrix23( Vector3 r0, Vector3 r1 ) {
		values = new double[] {
				r0.x, r0.y, r0.z,
				r1.x, r1.y, r1.z,
			};
	}
	
	public Vector3 row( int i ) {
		int j = i * 3;
		return new Vector3( values[j], values[j+1], values[j+2] );
	}

	public Vector2 col( int i ) {
		return new Vector2( values[i], values[i+3] );
	}

	@Override
	protected Matrix23 clone() {
		return new Matrix23( values.clone() );
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Matrix23 ) {
			Matrix23 v = (Matrix23) obj;
			return values.equals(v.values);
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format( "(%s,%s)", row(0), row(1) );
	}
}
