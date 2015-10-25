package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CtrlResultados;
import entity.Resultados;
import util.ModeloTabela;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FrmClassificacaoGeral extends JFrame {

	private JPanel panPrincipal;
	private JTable tabelaResultadoGeral;
	private JFrame janela;
	private ModeloTabela modelo;

	/**
	 * Create the frame.
	 */
	public FrmClassificacaoGeral() {
		janela = new JFrame("Classificação Geral do campeonato");
		
		panPrincipal = new JPanel();
		panPrincipal.setBackground(SystemColor.text);
		panPrincipal.setForeground(Color.WHITE);
		panPrincipal.setLayout(null);

		
		JLabel lblClassificaoGeral = new JLabel("Classifica\u00E7\u00E3o Geral");
		lblClassificaoGeral.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClassificaoGeral.setBounds(274, 27, 167, 36);
		panPrincipal.add(lblClassificaoGeral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 82, 682, 348);
		panPrincipal.add(scrollPane);
		
		tabelaResultadoGeral = new JTable();
		scrollPane.setViewportView(tabelaResultadoGeral);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(623, 453, 89, 23);
		panPrincipal.add(btnVoltar);
		
		CtrlResultados ctrl = new CtrlResultados();
		List<Resultados> listaResultados = new ArrayList<Resultados>();
		listaResultados = ctrl.resultadoGeral();
		
		modelo = new ModeloTabela(listaResultados);
		
		tabelaResultadoGeral.getTableHeader().setReorderingAllowed(false);
		tabelaResultadoGeral.setModel(modelo);
		tabelaResultadoGeral = ctrl.rebaixados("A", tabelaResultadoGeral);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(755,569);
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		btnVoltar.addActionListener(l -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal();
		});
		

	}
	
}
