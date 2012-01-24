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

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class GraphTemplateLoader {

	TemplateRepository templateRepo;
	LinkedList<Graph> graphTemplates = new LinkedList<Graph>();
	
	public GraphTemplateLoader(TemplateRepository repo) {
		templateRepo = repo;
	}

	static public LinkedList<Graph> load(TemplateRepository repo, String fileName) throws IOException {
		GraphTemplateLoader loader = new GraphTemplateLoader(repo);
		loader._load(fileName);
		return null;
	}

	private void _load(String fileName) throws IOException {
		YamlLoader yaml = new YamlLoader( fileName );
		Iterable<?> doc = (Iterable<?>)yaml.load();
		for ( Object v : doc ) {
			loadGraph(v);
		}
		yaml.close();
	}

	private void loadGraph(Object v) {
		Graph graph = new Graph();
		Map<String,?> m = (Map<String,?>)v;
		graph.name = (String)m.get("name");
		
		for ( Object n : (Iterable<?>)m.get("nodes") ) {
			loadNode( graph, n );
		}
		
		graphTemplates.add(graph);
	}

	private void loadNode(Graph graph, Object n) {
		Map<String,?> m = (Map<String,?>)n;
		NodeTemplate nodeTemplate = templateRepo.getNodeTemplate( (String)m.get("template") );

		Node node = nodeTemplate.newNode();
		node.setName( (String)m.get("name") );
		
		node.setPos( YamlLoader.toVector2(m.get("pos")) );
		
		graph.addNode(node);
	}

}
