package facturitas;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Pantalla extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Label label;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Pantalla(Composite parent, int style) {
		super(parent, style);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(67, 35, 338, 21);
		
		Label lblId = new Label(this, SWT.RIGHT);
		lblId.setBounds(10, 38, 51, 15);
		lblId.setText("Nombre");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(67, 72, 105, 21);
		
		Label lblNif = new Label(this, SWT.RIGHT);
		lblNif.setBounds(10, 75, 51, 15);
		lblNif.setText("NIF");
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(67, 110, 338, 21);
		
		label = new Label(this, SWT.RIGHT);
		label.setText("Dirección");
		label.setBounds(10, 113, 51, 15);
		
		Button btnNuevoCliente = new Button(this, SWT.NONE);
		btnNuevoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(text);
			}
		});
		btnNuevoCliente.setBounds(335, 265, 105, 25);
		btnNuevoCliente.setText("Nuevo Cliente");
		
		Button btnCancelar = new Button(this, SWT.NONE);
		btnCancelar.setBounds(10, 265, 105, 25);
		btnCancelar.setText("Cancelar");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
