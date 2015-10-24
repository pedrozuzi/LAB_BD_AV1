package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FrmClassificacaoGeral extends JFrame {

	private JPanel panPrincipal;
	private JTable table;
	private JFrame janela;

	/**
	 * Create the frame.
	 */
	public FrmClassificacaoGeral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 482);
		panPrincipal = new JPanel();
		panPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panPrincipal);
		panPrincipal.setLayout(null);
		
		JLabel lblClassificaoGeral = new JLabel("Classifica\u00E7\u00E3o Geral");
		lblClassificaoGeral.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClassificaoGeral.setBounds(235, 35, 275, 36);
		panPrincipal.add(lblClassificaoGeral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 82, 592, 321);
		panPrincipal.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(535, 409, 89, 23);
		panPrincipal.add(btnNewButton);
	}
	
}
