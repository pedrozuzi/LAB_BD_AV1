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
	private JPanel panel;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JScrollPane scrollPaneC;
	private JScrollPane scrollPaneD;
	private JTable grupoA;
	private JTable grupoB;
	private JTable grupoC;
	private JTable grupoD;
	private CtrlGrupos controleGrupos;
	private JButton btnVoltar;
	private JComponent lblGrupoA;
	private ModeloTabela modelo;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	
	public FrmGruposPontos() {
		controleGrupos = new CtrlGrupos();
		janela = new JFrame("Grupos Paulistão");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		lblGrupoA = new JLabel("Grupo A");
		lblGrupoA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoA.setBounds(369, 11, 100, 33);
		panPrincipal.add(lblGrupoA);
		

		List<GruposResultados> listaGrupo = new ArrayList<GruposResultados>();
		
		listaGrupo = controleGrupos.buscaGruposResultados("A");
//		listaGrupo = controle.buscaGrupos("B");
//		listaGrupo = controle.buscaGrupos("C");
//		listaGrupo = controle.buscaGrupos("D");
		
		if ( !listaGrupo.isEmpty() ) {
			modelo = new ModeloTabela(listaGrupo);
			grupoA.getTableHeader().setReorderingAllowed(false);
			grupoA.setModel(modelo);
		}

		janela.setSize(811,612);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 805, 583);
		panPrincipal.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		grupoA = new JTable();
		grupoA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoA.setBorder(new LineBorder(Color.BLACK));
		grupoA.setGridColor(Color.BLACK);
		grupoA.setShowGrid(true);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 61, 785, 103);
		panel_1.add(scrollPaneA);
		scrollPaneA.getViewport().setBorder(null);
		scrollPaneA.setViewportView(grupoA);
		
		grupoB = new JTable();
		grupoB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoB.setBorder(new LineBorder(Color.BLACK));
		grupoB.setGridColor(Color.BLACK);
		grupoB.setShowGrid(true);
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 203, 785, 103);
		panel_1.add(scrollPaneB);
		scrollPaneB.getViewport().setBorder(null);
		scrollPaneB.setViewportView(grupoB);
		
		grupoC = new JTable();
		grupoC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoC.setBorder(new LineBorder(Color.BLACK));
		grupoC.setGridColor(Color.BLACK);
		grupoC.setShowGrid(true);
		
		scrollPaneC = new JScrollPane();
		scrollPaneC.setBounds(10, 336, 785, 103);
		panel_1.add(scrollPaneC);
		scrollPaneC.getViewport().setBorder(null);
		scrollPaneC.setViewportView(grupoC);
		
		grupoD = new JTable();
		grupoD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoD.setBorder(new LineBorder(Color.BLACK));
		grupoD.setGridColor(Color.BLACK);
		grupoD.setShowGrid(true);
		
		scrollPaneD = new JScrollPane();
		scrollPaneD.setBounds(10, 467, 785, 103);
		panel_1.add(scrollPaneD);
		scrollPaneD.getViewport().setBorder(null);
		scrollPaneD.setViewportView(grupoD);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(704, 25, 89, 34);
		panel_1.add(btnVoltar);
		
		JLabel lblGrupoB = new JLabel("Grupo B");
		lblGrupoB.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoB.setBounds(366, 169, 100, 33);
		panel_1.add(lblGrupoB);
		
		JLabel lblGrupoC = new JLabel("Grupo C");
		lblGrupoC.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoC.setBounds(366, 305, 100, 33);
		panel_1.add(lblGrupoC);
		
		JLabel lblGrupoD = new JLabel("Grupo D");
		lblGrupoD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoD.setBounds(366, 437, 100, 33);
		panel_1.add(lblGrupoD);
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrmGruposPontos();
	}
}
