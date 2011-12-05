import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class GraphMasterMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent event) {
				Rectangle rect = shell.getClientArea();
				event.gc.drawOval(0, 0, rect.width - 1, rect.height - 1);
			}
		});
		Rectangle clientArea = shell.getClientArea();
		shell.setBounds(clientArea.x + 10, clientArea.y + 10, 200, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
}
