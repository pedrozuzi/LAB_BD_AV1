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
	
	public FrmGruposPontos() {
		controleGrupos = new CtrlGrupos();
		janela = new JFrame("Grupos Paulistão");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		grupoA = new JTable();
		grupoA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoA.setBorder(new LineBorder(Color.BLACK));
		grupoA.setGridColor(Color.BLACK);
		grupoA.setShowGrid(true);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.getViewport().setBorder(null);
		scrollPaneA.setViewportView(grupoA);
		scrollPaneA.setBounds(10, 72, 785, 103);
		panPrincipal.add(scrollPaneA);
		
		grupoB = new JTable();
		grupoB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoB.setBorder(new LineBorder(Color.BLACK));
		grupoB.setGridColor(Color.BLACK);
		grupoB.setShowGrid(true);
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.getViewport().setBorder(null);
		scrollPaneB.setViewportView(grupoB);
		scrollPaneB.setBounds(10, 217, 785, 103);
		panPrincipal.add(scrollPaneB);
		
		grupoC = new JTable();
		grupoC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoC.setBorder(new LineBorder(Color.BLACK));
		grupoC.setGridColor(Color.BLACK);
		grupoC.setShowGrid(true);
		
		scrollPaneC = new JScrollPane();
		scrollPaneC.getViewport().setBorder(null);
		scrollPaneC.setViewportView(grupoC);
		scrollPaneC.setBounds(10, 361, 785, 103);
		panPrincipal.add(scrollPaneC);
		
		grupoD = new JTable();
		grupoD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoD.setBorder(new LineBorder(Color.BLACK));
		grupoD.setGridColor(Color.BLACK);
		grupoD.setShowGrid(true);
		
		scrollPaneD = new JScrollPane();
		scrollPaneD.getViewport().setBorder(null);
		scrollPaneD.setViewportView(grupoD);
		scrollPaneD.setBounds(10, 502, 785, 103);
		panPrincipal.add(scrollPaneD);
		
		lblGrupoA = new JLabel("Grupo A");
		lblGrupoA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoA.setBounds(369, 11, 100, 50);
		panPrincipal.add(lblGrupoA);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(706, 456, 89, 34);
		panPrincipal.add(btnVoltar);
		

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

		janela.setSize(811,684);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrmGruposPontos();
	}
}
