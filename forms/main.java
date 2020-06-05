package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtCod;
	private JTable tbFlights;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Airports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbCidade = new JLabel("Cidade");
		panel.add(lbCidade);
		
		txtCidade = new JTextField();
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lbCod = new JLabel("C\u00F3digo");
		panel.add(lbCod);
		
		txtCod = new JTextField();
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnPrevious = new JButton("Anterior");
		panel.add(btnPrevious);
		
		JButton btnNext = new JButton("Pr\u00F3ximo");
		panel.add(btnNext);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		tbFlights = new JTable();
		panel_1.add(tbFlights);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbFlights = new JLabel("Gerenciar voos");
		panel_2.add(lbFlights);
		
		JButton btnAddFlight = new JButton("Adicionar");
		panel_2.add(btnAddFlight);
		
		JButton btnExcuir = new JButton("Excluir");
		panel_2.add(btnExcuir);
		
		JButton btnNewButton_2 = new JButton("Mostrar todos");
		panel_2.add(btnNewButton_2);
	}

}
