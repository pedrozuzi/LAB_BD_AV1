package boundary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import control.CtrlJogos;
import entity.Jogos;
import util.ModeloTabela;
import util.TratamentoTextFields;

public class FrmInsereResultado {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JTable tabela;
	private JScrollPane scrollPane;
	private JTextField txtDataRodada;
	private JLabel lblRodadasDoDia;
	private JLabel lblDigiteAData;
	private JButton btnPesquisar;
	private JMenuBar menuBarra;
	private JMenu menu;
	private JMenuItem menuPrincipal;
	private ModeloTabela modelo;
	
	public FrmInsereResultado() {
		janela = new JFrame("Pesquisa Rodadas");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		menuBarra = new JMenuBar();
		janela.setJMenuBar(menuBarra);
		
		menu = new JMenu("Menu");
		menuBarra.add(menu);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setIcon(new ImageIcon(getClass()
				.getResource("/img/HomeMenu.png")));
		menu.add(menuPrincipal);
		
		tabela = new JTable();
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setGridColor(Color.BLACK);
		tabela.setShowGrid(true);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportView(tabela);
	    scrollPane.setBounds(90, 145, 493, 183);
	    panPrincipal.add(scrollPane);
		
		txtDataRodada = new JTextField();
		txtDataRodada = TratamentoTextFields.mascara(txtDataRodada, "data");
		txtDataRodada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDataRodada.setToolTipText("Digite a data");
		txtDataRodada.setBounds(198, 27, 109, 24);
		panPrincipal.add(txtDataRodada);
		txtDataRodada.setColumns(10);
		scrollPane.setViewportView(tabela);
		scrollPane.setBounds(47, 140, 525, 183);
		panPrincipal.add(scrollPane);
		
		janela.setSize(629,446);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblRodadasDoDia = new JLabel();
		lblRodadasDoDia.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRodadasDoDia.setBounds(116, 90, 456, 39);
		panPrincipal.add(lblRodadasDoDia);
		lblRodadasDoDia.setVisible(false);
		
		lblDigiteAData = new JLabel("Digite a Data: ");
		lblDigiteAData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteAData.setBounds(101, 26, 109, 29);
		panPrincipal.add(lblDigiteAData);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(323, 14, 83, 41);
		panPrincipal.add(btnPesquisar);
		btnPesquisar.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Lupa.png")));
		
		menuPrincipal.addActionListener(l -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal();
		});
		
		btnPesquisar.addActionListener(l -> {
			try {
				CtrlJogos controleJogos = new CtrlJogos();
				List<Jogos> lista = new ArrayList<Jogos>();
				lista = controleJogos.buscaRodadas(txtDataRodada.getText());
				if (!lista.isEmpty()) {
					modelo = new ModeloTabela(lista);
					lblRodadasDoDia.setText("Rodada do dia: " + txtDataRodada.getText());
					lblRodadasDoDia.setVisible(true);
					tabela.getTableHeader().setReorderingAllowed(false);
					tabela.setModel(modelo);
				}else{
					lblRodadasDoDia.setVisible(false);
					try {
						modelo = new ModeloTabela(lista);
						modelo.clear();
					} catch (IndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Não há Rodada para o dia: " + txtDataRodada.getText());
					}
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrmInsereResultado();
	}

}
