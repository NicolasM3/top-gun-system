package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import app.Airports;
import app.Flights;
import app.ListaEncadeadaDesordenadaSemRepeticao;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormDelFlight {

	private JFrame frmExcluirVoo;
	private JTextField txtCod;
	private JTextField txtCity;
	private JTextField txtCodFlight;
	private JTextField txtDest;
	private static Airports atual;
	private static Flights flightToDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDelFlight window = new FormDelFlight();
					window.frmExcluirVoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormDelFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExcluirVoo = new JFrame();
		frmExcluirVoo.setTitle("Excluir voo");
		frmExcluirVoo.setBounds(100, 100, 356, 300);
		frmExcluirVoo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExcluirVoo.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmExcluirVoo.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Excluir voo em");
		panel.add(lblNewLabel);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setText("");
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frmExcluirVoo.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JButton btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					atual.removeFlight(flightToDel.getCityName(), flightToDel.getCod());
					frmExcluirVoo.dispose();
					main.updateAirports();
				} 
				catch (Exception e1) {}
			}
		});
		btnDelete.setEnabled(false);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		frmExcluirVoo.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new MigLayout("", "[69px][][grow][][grow][grow][]", "[14px][][][][][][][]"));
		
		JLabel lbCodFlight = new JLabel("N\u00FAmero do voo");
		panel_3.add(lbCodFlight, "cell 0 2,alignx left,aligny center");
		
		txtCodFlight = new JTextField();
		panel_3.add(txtCodFlight, "cell 2 2,growx");
		txtCodFlight.setColumns(10);
		
		JButton btnSearch = new JButton("Procurar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEncadeadaDesordenadaSemRepeticao<Flights> listaAirports;
				
				try {
					listaAirports = atual.getFlights();
					Flights atualFlights = listaAirports.getPrimeiro();
					
					for(int i = 0; i < listaAirports.getQtd(); i++)
					{						
						if(atualFlights.getCod() == Integer.parseInt(txtCodFlight.getText()))
						{
							txtDest.setText(atualFlights.getCityName());
							btnDelete.setEnabled(true);
							flightToDel = atualFlights;
						}
						
						listaAirports.removaDoInicio();
						listaAirports.insiraNoFim(atualFlights);
						atualFlights = listaAirports.getPrimeiro();
						
					}
				}
				catch(Exception ex)
				{}
			}
		});
		panel_3.add(btnSearch, "cell 5 2");
		
		JLabel lblNewLabel_2 = new JLabel("Destino");
		panel_3.add(lblNewLabel_2, "cell 0 3");
		
		txtDest = new JTextField();
		txtDest.setEditable(false);
		panel_3.add(txtDest, "cell 2 3,growx");
		txtDest.setColumns(10);
	}

	public void setVisible(boolean b) {
		frmExcluirVoo.setVisible(true);		
	}
	
	public void setAirport(Airports atual) {
		this.atual = atual;
		txtCod.setText(this.atual.getAirportCod());
		txtCity.setText(this.atual.getCity());
	}
}
