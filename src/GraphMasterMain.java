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
import graphmaster.GraphView;
import graphmaster.GraphViewUI;
import graphmaster.data.Graph;
import graphmaster.data.Node;
import graphmaster.data.TemplateRepository;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GraphMasterMain {
	private TemplateRepository repo = new TemplateRepository();
	private Graph graph;
	private GraphView graphView;

	private Display display;
	private Shell shell;
	@SuppressWarnings("unused")
	private GraphViewUI graphViewUI;

	public GraphMasterMain() {
		graph = new Graph();
		graphView = new GraphView(graph);

		display = new Display();
		shell = new Shell(display);
		graphViewUI = new GraphViewUI(graphView, shell);
		initShell();
		
		graph.addNode( new Node() );
	}

	private void initShell() {
		Rectangle clientArea = shell.getClientArea();
		shell.setBounds(clientArea.x + 10, clientArea.y + 10, 800, 600);
	}

	public void doMain() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final GraphMasterMain gm = new GraphMasterMain();
		gm.doMain();
	}

}
