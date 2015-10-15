package boundary;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class FrmGrupos {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JPanel panel;
	private JTable grupoA;
	private JTable grupoB;
	private JTable grupoC;
	private JTable grupoD;
	private JScrollPane scrollPane;
	
	public FrmGrupos() {
		janela = new JFrame();
		panPrincipal = new JPanel();
		panel = new JPanel();
		
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		grupoA = new JTable();
		//grupoA.addMouseListener(this);
		grupoA.setBorder(new LineBorder(Color.BLACK));
		grupoA.setGridColor(Color.BLACK);
		grupoA.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(grupoA);
		scrollPane.setBounds(100, 50, 717, 167);
		panPrincipal.add(scrollPane);
		
		janela.setSize(749,677);
		janela.setContentPane( panPrincipal );
	}
	
}
