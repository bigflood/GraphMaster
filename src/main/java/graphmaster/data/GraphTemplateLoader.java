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

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class GraphTemplateLoader {
	YamlLoader yaml;
	LinkedList<NodeTemplate> nodes = new LinkedList<NodeTemplate>();
	LinkedList<Graph> graphs = new LinkedList<Graph>();
	
	public GraphTemplateLoader() {
	}
	
	public LinkedList<NodeTemplate> getNodes() {
		return nodes;
	}
	
	public LinkedList<Graph> getGraphs() {
		return graphs;
	}
	
	public void load(String fileName) throws IOException {
		yaml = new YamlLoader(fileName);
		Map<?,?> m = yaml.load();
		loadNodes((Iterable<?>)m.get("nodeTemplates"));
		loadGraphs((Iterable<?>)m.get("graphTemplates"));
		yaml.close();
	}
		
	private void loadNodes(Iterable<?> list) {
		for ( Object v : list ) {
			loadNode(v);
		}
	}
	
	private void loadNode( Object v ) {
		NodeTemplate node = new NodeTemplate();
		Map<?,?> m = (Map<?,?>)v;
		node.name = (String)m.get("name");
		node.size = YamlLoader.toVector2(m.get("size"));
		nodes.add(node);
	}

	private void loadGraphs(Iterable<?> list) {
		for ( Object v : list ) {
			loadGraph(v);
		}		
	}

	private void loadGraph(Object v) {
		Graph graph = new Graph();
		Map<?,?> m = (Map<?,?>)v;
		graph.name = (String)m.get("name");
		
		for ( Object n : (Iterable<?>)m.get("nodes") ) {
			loadNode( graph, n );
		}
		
		graphs.add(graph);
	}

	private void loadNode(Graph graph, Object n) {
		Map<?,?> m = (Map<?,?>)n;
		NodeTemplate nodeTemplate = getNodeTemplate( (String)m.get("template") );

		Node node = nodeTemplate.newNode();
		node.setName( (String)m.get("name") );
		
		node.setPos( YamlLoader.toVector2(m.get("pos")) );
		
		graph.addNode(node);
	}

	private NodeTemplate getNodeTemplate( String name ) {
		for( NodeTemplate templ : nodes ) {
			if ( templ.name.equals(name) ) {
				return templ;
			}
		}
		return null;
	}
}
