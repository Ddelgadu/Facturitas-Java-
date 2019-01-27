package facturitas;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class facturitas{

	public static void main(String[] args) {

		
		Display display = new Display();
	    Shell shell = new Shell(display);
	
	    Pantalla a=new Pantalla(shell, SWT.BORDER);
	    
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    a.dispose();
		
/*		
	ArrayList<String> col= new ArrayList<String>();
	col.add(0, "ID "+"INT "+"PRIMARY KEY "+"NOT NULL");
	col.add(1, "NAME "+"TEXT "+"NOT NULL ");
	col.add(2, "NIF "+"TEXT");
	col.add(3, "DIR "+"TEXT");
			
	baseDeDatos bd = new baseDeDatos("facturitas");
	 
	bd.createTable("Clientes",col);
  	bd.insert("Clientes", datos);
	bd.select("Clientes");
*/
	}
}
