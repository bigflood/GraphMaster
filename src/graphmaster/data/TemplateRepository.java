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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class TemplateRepository {
	LinkedList<NodeTemplate> nodeTemplates = new LinkedList<NodeTemplate>();
	LinkedList<Graph> graphTemplates = new LinkedList<Graph>();
	
	public TemplateRepository() {
		load();
	}
	
	class NodeTemplateLoader {
		LinkedList<NodeTemplate> nodeTemplates = new LinkedList<NodeTemplate>();

		public LinkedList<NodeTemplate> load( String fileName ) throws IOException {
			FileReader reader = new FileReader( "node_templates.yaml" );
			Yaml yaml = new Yaml();
			Iterable<?> doc = (Iterable<?>)yaml.load(reader);
			for ( Object v : doc ) {
				loadNode(v);
			}
			reader.close();
			
			return nodeTemplates;
		}
		
		void loadNode( Object v ) {
			NodeTemplate node = new NodeTemplate();
			Map<String,?> m = (Map<String,?>)v;
			node.name = (String)m.get("name");
			node.size = toVector2(m.get("size"));
			nodeTemplates.add(node);
		}
		
		Vector2 toVector2( Object o ) {
			Vector2 v = new Vector2();
			double[] a = toDoubleArray(2, o);
			v.x = a[0];
			v.y = a[1];
			return v;
		}
		
		public double[] toDoubleArray( int n, Object obj ) {
			double[] v = new double[n];
			ArrayList<?> a = (ArrayList<?>)obj;
			for( int i = 0 ; i < n ; ++i ) {
				v[i] = toDouble( a.size() > 0 ? a.get(i) : 0.0 );
			}
			return v;
		}

		private double toDouble(Object obj) {
			if ( obj instanceof Double ) {
				return (Double)obj;
			} else if ( obj instanceof Integer ) {
				return (Integer)obj;
			}
			return 0;
		}
	}
	
	private void load() {
		try {
			nodeTemplates = new NodeTemplateLoader().load("node_templates.yaml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public NodeTemplate getNodeTemplate( String name ) {
		for( NodeTemplate templ : nodeTemplates ) {
			if ( templ.name.equals(name) ) {
				return templ;
			}
		}
		return null;
	}
	
	public Graph getGraphTemplate( String name ) {
		for( Graph g : graphTemplates ) {
			if ( g.name.equals(name) ) {
				return g;
			}
		}
		return null;
	}
}
