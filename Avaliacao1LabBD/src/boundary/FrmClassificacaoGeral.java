package boundary;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import control.CtrlResultados;
import entity.GruposResultados;
import util.ModeloTabela;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FrmClassificacaoGeral {

	private JPanel panPrincipal;
	private JTable tabelaResultadoGeral;
	private JFrame janela;
	private ModeloTabela modelo;
	private String[] rebaixados = new String[4];
	private CtrlResultados controleResultados;

	/**
	 * Create the frame.
	 */
	public FrmClassificacaoGeral() {
		janela = new JFrame("Classificação Geral do campeonato");
		
		controleResultados = new  CtrlResultados();
		
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
		
		rebaixados = controleResultados.rebaixados();
		
		tabelaResultadoGeral = new JTable() {
			private static final long serialVersionUID = 1L;

		@Override
		public Component prepareRenderer(TableCellRenderer renderer,
				int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			
			if (tabelaResultadoGeral.getValueAt(row, 0).toString().toLowerCase().equalsIgnoreCase(rebaixados[0]) ||
					tabelaResultadoGeral.getValueAt(row, 0).toString().toLowerCase().equalsIgnoreCase(rebaixados[1]) ||
					tabelaResultadoGeral.getValueAt(row, 0).toString().toLowerCase().equalsIgnoreCase(rebaixados[2]) ||
					tabelaResultadoGeral.getValueAt(row, 0).toString().toLowerCase().equalsIgnoreCase(rebaixados[3])) {
				c.setBackground(new Color(192,0,0));
				c.setForeground(Color.WHITE);
			}else{
				c.setForeground(getForeground());
				c.setBackground(getBackground());
			}
			return c;
		}
	};
		
		scrollPane.setViewportView(tabelaResultadoGeral);
		
		tabelaResultadoGeral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabelaResultadoGeral.setBorder(new LineBorder(Color.BLACK));
		tabelaResultadoGeral.setGridColor(Color.BLACK);
		tabelaResultadoGeral.setShowGrid(true);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(626, 451, 89, 23);
		panPrincipal.add(btnVoltar);
		
		CtrlResultados ctrl = new CtrlResultados();
		List<GruposResultados> listaResultados = new ArrayList<GruposResultados>();
		listaResultados = ctrl.resultadoGeral();
		
		modelo = new ModeloTabela(listaResultados);
		
		tabelaResultadoGeral.getTableHeader().setReorderingAllowed(false);
		tabelaResultadoGeral.setModel(modelo);
		
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
