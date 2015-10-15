package boundary;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FrmGrupos {
	
	private JFrame janela;
	private JPanel panPrincipal;
	//private JPanel panel;
	private JTable grupoB;
	private JTable grupoC;
	private JTable grupoD;
	private JScrollPane scrollPaneA;
	private JTable grupoA;
	private JScrollPane scrollPaneB;
	private JScrollPane scrollPaneC;
	private JScrollPane scrollPaneD;
	private JLabel lblGrupoB;
	private JLabel lblGrupoC;
	private JLabel lblGrupoD;
	private JLabel lblTabelaDeGrupos;
	private JLabel lblGrupoA;
	private JButton btnVoltar;
	
	public FrmGrupos() {
		janela = new JFrame("Grupos Paulistão");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		//panel = new JPanel();
		
		grupoA = new JTable();
		grupoA.setBorder(new LineBorder(Color.BLACK));
		grupoA.setGridColor(Color.BLACK);
		grupoA.setShowGrid(true);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.getViewport().setBorder(null);
		scrollPaneA.setViewportView(grupoA);
		scrollPaneA.setBounds(10, 112, 327, 163);
		panPrincipal.add(scrollPaneA);
		
		grupoB = new JTable();
		grupoB.setBorder(new LineBorder(Color.BLACK));
		grupoB.setGridColor(Color.BLACK);
		grupoB.setShowGrid(true);
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.getViewport().setBorder(null);
		scrollPaneB.setViewportView(grupoB);
		scrollPaneB.setBounds(406, 112, 327, 163);
		panPrincipal.add(scrollPaneB);
		
		grupoC = new JTable();
		grupoC.setBorder(new LineBorder(Color.BLACK));
		grupoC.setGridColor(Color.BLACK);
		grupoC.setShowGrid(true);
		
		scrollPaneC = new JScrollPane();
		scrollPaneC.getViewport().setBorder(null);
		scrollPaneC.setViewportView(grupoC);
		scrollPaneC.setBounds(10, 334, 327, 163);
		panPrincipal.add(scrollPaneC);
		
		grupoD = new JTable();
		grupoD.setBorder(new LineBorder(Color.BLACK));
		grupoD.setGridColor(Color.BLACK);
		grupoD.setShowGrid(true);
		
		scrollPaneD = new JScrollPane();
		scrollPaneD.getViewport().setBorder(null);
		scrollPaneD.setViewportView(grupoD);
		scrollPaneD.setBounds(406, 334, 327, 163);
		panPrincipal.add(scrollPaneD);
		
		lblGrupoA = new JLabel("Grupo A");
		lblGrupoA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoA.setBounds(120, 56, 100, 50);
		panPrincipal.add(lblGrupoA);
		
		lblGrupoB = new JLabel("Grupo B");
		lblGrupoB.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoB.setBounds(534, 56, 100, 50);
		panPrincipal.add(lblGrupoB);
		
		lblGrupoC = new JLabel("Grupo C");
		lblGrupoC.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoC.setBounds(120, 286, 100, 50);
		panPrincipal.add(lblGrupoC);
		
		lblGrupoD = new JLabel("Grupo D");
		lblGrupoD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoD.setBounds(534, 286, 100, 50);
		panPrincipal.add(lblGrupoD);
		
		lblTabelaDeGrupos = new JLabel("Tabela de Grupos Paulist\u00E3o");
		lblTabelaDeGrupos.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTabelaDeGrupos.setBounds(160, 11, 459, 50);
		panPrincipal.add(lblTabelaDeGrupos);
		
		janela.setSize(749,611);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(644, 533, 89, 23);
		panPrincipal.add(btnVoltar);
		
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	}
}


