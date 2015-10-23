package boundary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import util.ModeloTabela;
import control.CtrlGrupos;
import entity.GruposResultados;

public class FrmGruposPontos {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JScrollPane scrollPaneA;
	private JTable tabela;
	private CtrlGrupos controleGrupos;
	private JLabel lblTabelaDeGrupos;
	private JButton btnVoltar;
	private JComponent lblGrupoA;
	private JButton btnProximGrupo;
	private JButton btnGrupoAnterior;
	private ModeloTabela modelo;
	
	public FrmGruposPontos() {
		controleGrupos = new CtrlGrupos();
		janela = new JFrame("Grupos Paulistão");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		tabela = new JTable();
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setGridColor(Color.BLACK);
		tabela.setShowGrid(true);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.getViewport().setBorder(null);
		scrollPaneA.setViewportView(tabela);
		scrollPaneA.setBounds(10, 127, 785, 103);
		panPrincipal.add(scrollPaneA);
		
		lblGrupoA = new JLabel("Grupo A");
		lblGrupoA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoA.setBounds(366, 62, 100, 50);
		panPrincipal.add(lblGrupoA);
		
		lblTabelaDeGrupos = new JLabel("Tabelas Resultados Grupos Paulist\u00E3o");
		lblTabelaDeGrupos.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTabelaDeGrupos.setBounds(88, 11, 645, 50);
		panPrincipal.add(lblTabelaDeGrupos);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(706, 369, 89, 34);
		panPrincipal.add(btnVoltar);
		

		List<GruposResultados> listaGrupo = new ArrayList<GruposResultados>();
		
		listaGrupo = controleGrupos.buscaGruposResultados("A");
//		listaGrupo = controle.buscaGrupos("B");
//		listaGrupo = controle.buscaGrupos("C");
//		listaGrupo = controle.buscaGrupos("D");
		
		if ( !listaGrupo.isEmpty() ) {
			modelo = new ModeloTabela(listaGrupo);
			tabela.getTableHeader().setReorderingAllowed(false);
			tabela.setModel(modelo);
		}

		janela.setSize(811,442);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		btnProximGrupo = new JButton("Pr\u00F3xima Grupo");
		btnProximGrupo.setBounds(629, 254, 166, 34);
		panPrincipal.add(btnProximGrupo);
		
		btnGrupoAnterior = new JButton("Grupo Anterior");
		btnGrupoAnterior.setBounds(10, 254, 126, 34);
		panPrincipal.add(btnGrupoAnterior);
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrmGruposPontos();
	}
}
