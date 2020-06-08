package forms;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import app.Airports;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAddFlight {

	private JFrame frmAdicionarVoo;
	private JTextField txtCityDest;
	private JTextField txtCodAirport;
	private JTextField txtCod;
	private JTextField txtCity;
	private static Airports atual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddFlight window = new FormAddFlight();
					window.frmAdicionarVoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormAddFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarVoo = new JFrame();
		frmAdicionarVoo.setTitle("Adicionar Voo");
		frmAdicionarVoo.setBounds(100, 100, 450, 230);
		frmAdicionarVoo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdicionarVoo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		frmAdicionarVoo.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbCity = new JLabel("Cidade de destino");
		panel_3.add(lbCity);
		
		txtCityDest = new JTextField();
		txtCityDest.setColumns(10);
		panel_3.add(txtCityDest);
		
		JLabel lbCodFlight = new JLabel("C\u00F3digo do voo");
		panel_3.add(lbCodFlight);
		
		txtCodAirport = new JTextField();
		txtCodAirport.setColumns(10);
		panel_3.add(txtCodAirport);
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JLabel lbError = new JLabel("");
		panel_5.add(lbError);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JPanel panel = new JPanel();
		frmAdicionarVoo.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Adicionar voo em");
		panel.add(lblNewLabel);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frmAdicionarVoo.getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnClear = new JButton("Limpar Campos");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCityDest.setText("");
				txtCodAirport.setText("");
			}
		});
		panel_2.add(btnClear);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCityDest.getText().isEmpty() || txtCodAirport.getText().isEmpty())
				{
					lbError.setText("Algum campo nulo");
					return;
				}
				try {
					atual.addFlight(txtCityDest.getText(), Integer.parseInt(txtCodAirport.getText()));
				} catch (Exception ex) {
				}
				
				frmAdicionarVoo.dispose();
				main.updateAirports();
			}
		});
		panel_2.add(btnSave);
	}

	public void setVisible(boolean b) {
		frmAdicionarVoo.setVisible(true);
		
	}

	public void setAirport(Airports atual) {
		this.atual = atual;
		txtCod.setText(this.atual.getAirportCod());
		txtCity.setText(this.atual.getCity());
	}
}
