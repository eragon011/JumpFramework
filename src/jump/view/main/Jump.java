package jump.view.main;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextField;



import java.awt.event.InputMethodListener;

import javax.swing.JButton;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.internal.win32.SIZE;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import databases.MySQL;

import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.custom.ScrolledComposite;

public class Jump extends ViewPart {

	private Label lblConfiguration,lblInfo;
	private Panel panel;
	private Button button;
	private TextField text;
	private Combo comboTB;
	public static int i = 0;
	private String db,user,pass;
	private Text txtDatabase;
	private Text txtUser;
	private Text txtPass;
	private MySQL mysql;
	private Text txtLocation;
	
	public Jump() {
		
	}

	public void setFocus() {
		lblConfiguration.setFocus();

	}

	/*public void dbcon() {
		Connector conn = new Connector("cdcol", "root", "");
		conn.connection();
		conn.showTableName();
			
	}
	*/
	public void createPartControl(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		panel = new Panel();
		parent.setLayout(null);
		lblConfiguration = new Label(parent, 0);
		lblConfiguration.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblConfiguration.setText("JUMP Task");
		lblConfiguration.setBounds(22, 20, 121, 24);
		lblConfiguration.setAlignment(SWT.CENTER);
		text = new TextField();
		Shell shell = new Shell();
		Color color = new Color(shell.getDisplay(), new RGB(255, 255, 0));
		lblConfiguration.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblTable = new Label(parent, SWT.NONE);
		lblTable.setText("Select Table");
		lblTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTable.setAlignment(SWT.CENTER);
		lblTable.setBounds(35, 208, 87, 24);
		
		comboTB = new Combo(parent, SWT.NONE);
		comboTB.setItems(new String[] {});
		comboTB.setBounds(149, 208, 252, 23);
		comboTB.setText("Select Table");
		
		Button btnConnect = new Button(parent, SWT.NONE);
		btnConnect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mysql = new MySQL(txtDatabase.getText(), txtUser.getText(), txtPass.getText());
				if (mysql.getConnection()) lblInfo.setText("Connection successful.");
				else lblInfo.setText("Connection failed.");
			}
		});
		btnConnect.setBounds(416, 62, 75, 25);
		btnConnect.setText("Connect");
		
		txtDatabase = new Text(parent, SWT.BORDER);
		txtDatabase.setBounds(149, 64, 252, 21);
		
		Label lblDatabaseName = new Label(parent, SWT.NONE);
		lblDatabaseName.setText("Database Name");
		lblDatabaseName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDatabaseName.setBounds(22, 67, 121, 24);
		
		txtUser = new Text(parent, SWT.BORDER);
		txtUser.setBounds(149, 94, 252, 21);
		
		Label lblDatabaseUser = new Label(parent, SWT.NONE);
		lblDatabaseUser.setText("Database User");
		lblDatabaseUser.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDatabaseUser.setBounds(22, 97, 121, 24);
		
		txtPass = new Text(parent, SWT.BORDER);
		txtPass.setBounds(149, 127, 252, 21);
		
		Label lblDatabasePassword = new Label(parent, SWT.NONE);
		lblDatabasePassword.setText("Database Password");
		lblDatabasePassword.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDatabasePassword.setBounds(22, 130, 121, 24);
		
		lblInfo = new Label(parent, SWT.BORDER);
		lblInfo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblInfo.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblInfo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblInfo.setBounds(68, 270, 386, 70);
		
		Button btnGenerate = new Button(parent, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblInfo.setText("Clicked");
			}
		});
		btnGenerate.setBounds(416, 207, 75, 25);
		btnGenerate.setText("Generate");
		
		txtLocation = new Text(parent, SWT.BORDER);
		txtLocation.setBounds(149, 157, 252, 21);
		
		Label lblProjectLocation = new Label(parent, SWT.NONE);
		lblProjectLocation.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblProjectLocation.setBounds(22, 160, 100, 15);
		lblProjectLocation.setText("Project Location");
		
	

	}
}
