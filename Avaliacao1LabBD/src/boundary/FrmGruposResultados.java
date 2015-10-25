package boundary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import util.ModeloTabela;
import control.CtrlGrupos;
import control.CtrlResultados;
import entity.GruposResultados;

public class FrmGruposResultados {

	private JFrame janela;
	private JPanel panPrincipal;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JScrollPane scrollPaneC;
	private JScrollPane scrollPaneD;
	private JTable grupoA;
	private JTable grupoB;
	private JTable grupoC;
	private JTable grupoD;
	private CtrlGrupos controleGrupos;
	private JComponent lblGrupoA;
	private ModeloTabela modeloA;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private ModeloTabela modeloB;
	private ModeloTabela modeloC;
	private ModeloTabela modeloD;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private CtrlResultados controleResultados;

	public FrmGruposResultados() {
		controleGrupos = new CtrlGrupos();
		controleResultados = new  CtrlResultados();
		janela = new JFrame("Grupos Paulistão");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);

		menuBarra = new JMenuBar();
		janela.setJMenuBar(menuBarra);

		menu = new JMenu("Menu");
		menuBarra.add(menu);

		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass().getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 805, 583);
		panPrincipal.add(scrollPane);

		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		String[] rebaixados = controleResultados.rebaixados();

		grupoA = new JTable() {
			
		@Override
		public Component prepareRenderer(TableCellRenderer renderer,
				int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			
			if (grupoA.getValueAt(row, 0).toString().toLowerCase().equalsIgnoreCase(rebaixados[3])) {
				c.setBackground(new Color(192,0,0));
				c.setForeground(Color.WHITE);
			}else{
				c.setForeground(getForeground());
			}
			return c;
		}
	};

		grupoA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoA.setBorder(new LineBorder(Color.BLACK));
		grupoA.setGridColor(Color.BLACK);
		grupoA.setShowGrid(true);

		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 40, 785, 103);
		panel_1.add(scrollPaneA);
		scrollPaneA.getViewport().setBorder(null);
		scrollPaneA.setViewportView(grupoA);

		grupoB = new JTable();
		grupoB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoB.setBorder(new LineBorder(Color.BLACK));
		grupoB.setGridColor(Color.BLACK);
		grupoB.setShowGrid(true);

		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 177, 785, 103);
		panel_1.add(scrollPaneB);
		scrollPaneB.getViewport().setBorder(null);
		scrollPaneB.setViewportView(grupoB);

		grupoC = new JTable();
		grupoC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoC.setBorder(new LineBorder(Color.BLACK));
		grupoC.setGridColor(Color.BLACK);
		grupoC.setShowGrid(true);

		scrollPaneC = new JScrollPane();
		scrollPaneC.setBounds(10, 310, 785, 103);
		panel_1.add(scrollPaneC);
		scrollPaneC.getViewport().setBorder(null);
		scrollPaneC.setViewportView(grupoC);

		grupoD = new JTable();
		grupoD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		grupoD.setBorder(new LineBorder(Color.BLACK));
		grupoD.setGridColor(Color.BLACK);
		grupoD.setShowGrid(true);

		scrollPaneD = new JScrollPane();
		scrollPaneD.setBounds(10, 441, 785, 103);
		panel_1.add(scrollPaneD);
		scrollPaneD.getViewport().setBorder(null);
		scrollPaneD.setViewportView(grupoD);

		JLabel lblGrupoB = new JLabel("Grupo B");
		lblGrupoB.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoB.setBounds(366, 143, 100, 33);
		panel_1.add(lblGrupoB);

		JLabel lblGrupoC = new JLabel("Grupo C");
		lblGrupoC.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoC.setBounds(366, 279, 100, 33);
		panel_1.add(lblGrupoC);

		JLabel lblGrupoD = new JLabel("Grupo D");
		lblGrupoD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrupoD.setBounds(366, 411, 100, 33);
		panel_1.add(lblGrupoD);

		lblGrupoA = new JLabel("Grupo A");
		lblGrupoA.setBounds(366, 11, 100, 33);
		panel_1.add(lblGrupoA);
		lblGrupoA.setFont(new Font("Tahoma", Font.BOLD, 18));

		carregaTabelas();

		// DefaultTableCellRenderer linha = new DefaultTableCellRenderer();
		// linha.setForeground(Color.WHITE);
		// linha.setBackground(Color.RED);
		// grupoA.getColumnModel().getColumn(0).setCellRenderer(linha);

		 //pinta as linhas dos rebaixados de vermelho
		 CtrlResultados ctrl = new CtrlResultados();
		 grupoA = ctrl.rebaixados(5, grupoA);
		 grupoB = ctrl.rebaixados(5, grupoB);
		 grupoC = ctrl.rebaixados(5, grupoC);
		 grupoD = ctrl.rebaixados(5, grupoD);

		menuPrincipal.addActionListener(l -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal();
		});

		janela.setSize(811, 602);
		janela.setContentPane(panPrincipal);
		panPrincipal.setLayout(null);

		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	private void carregaTabelas() {
		List<GruposResultados> listaGrupoA = new ArrayList<GruposResultados>();
		List<GruposResultados> listaGrupoB = new ArrayList<GruposResultados>();
		List<GruposResultados> listaGrupoC = new ArrayList<GruposResultados>();
		List<GruposResultados> listaGrupoD = new ArrayList<GruposResultados>();

		listaGrupoA = controleGrupos.buscaGruposResultados("A");
		listaGrupoB = controleGrupos.buscaGruposResultados("B");
		listaGrupoC = controleGrupos.buscaGruposResultados("C");
		listaGrupoD = controleGrupos.buscaGruposResultados("D");

		if (!listaGrupoA.isEmpty() && !listaGrupoB.isEmpty() && !listaGrupoC.isEmpty() && !listaGrupoD.isEmpty()) {

			modeloA = new ModeloTabela(listaGrupoA);
			modeloB = new ModeloTabela(listaGrupoB);
			modeloC = new ModeloTabela(listaGrupoC);
			modeloD = new ModeloTabela(listaGrupoD);

			grupoA.getTableHeader().setReorderingAllowed(false);
			grupoA.setModel(modeloA);

			grupoB.getTableHeader().setReorderingAllowed(false);
			grupoB.setModel(modeloB);

			grupoC.getTableHeader().setReorderingAllowed(false);
			grupoC.setModel(modeloC);

			grupoD.getTableHeader().setReorderingAllowed(false);
			grupoD.setModel(modeloD);

		}
	}
}
