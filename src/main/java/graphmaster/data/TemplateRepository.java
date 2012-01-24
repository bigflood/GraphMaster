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
import java.io.IOException;
import java.util.LinkedList;


public class TemplateRepository {
	LinkedList<NodeTemplate> nodeTemplates = new LinkedList<NodeTemplate>();
	LinkedList<Graph> graphTemplates = new LinkedList<Graph>();
	
	public TemplateRepository() {
		load();
	}
	
	private void load() {
		try {
			GraphTemplateLoader loader = new GraphTemplateLoader();
			loader.load("templates.yaml");
			nodeTemplates = loader.getNodes();
			graphTemplates = loader.getGraphs();
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
