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

import java.util.LinkedList;

public class TemplateRepository {
	LinkedList<NodeTemplate> nodeTemplates = new LinkedList<NodeTemplate>();
	LinkedList<Graph> graphTemplates = new LinkedList<Graph>();
	
	public TemplateRepository() {
		NodeTemplate templ = new NodeTemplate();
		templ.name = "Node";
		nodeTemplates.add(templ);
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
