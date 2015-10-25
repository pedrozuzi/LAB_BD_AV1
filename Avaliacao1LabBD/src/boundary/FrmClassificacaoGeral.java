package boundary;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.ImageIcon;

public class FrmClassificacaoGeral {

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
		lblClassificaoGeral.setForeground(Color.WHITE);
		lblClassificaoGeral.setFont(new Font("Verdana", Font.BOLD, 18));
		lblClassificaoGeral.setBounds(272, 23, 205, 36);
		panPrincipal.add(lblClassificaoGeral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 84, 682, 346);
		panPrincipal.add(scrollPane);
		
		tabelaResultadoGeral = new JTable();
		scrollPane.setViewportView(tabelaResultadoGeral);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(626, 451, 89, 23);
		panPrincipal.add(btnVoltar);
		
		CtrlResultados ctrl = new CtrlResultados();
		List<Resultados> listaResultados = new ArrayList<Resultados>();
		listaResultados = ctrl.resultadoGeral();
		
		modelo = new ModeloTabela(listaResultados);
		
		tabelaResultadoGeral.getTableHeader().setReorderingAllowed(false);
		tabelaResultadoGeral.setModel(modelo);
		
		//deixa os rebaixados em vermelho
		tabelaResultadoGeral = ctrl.rebaixados(20, tabelaResultadoGeral);
		
		janela.setContentPane(panPrincipal);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmClassificacaoGeral.class.getResource("/img/Fotolia_66427946_Stadium-lights.jpg")));
		lblNewLabel.setBounds(-474, -124, 1421, 690);
		panPrincipal.add(lblNewLabel);
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
