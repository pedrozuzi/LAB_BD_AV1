package boundary;

import java.awt.Color;
import java.awt.Cursor;
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
import util.ModeloTabelaEditavel;
import util.TratamentoTextFields;

public class FrmInsereResultado{
	
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
	private ModeloTabelaEditavel modelo;
	private JLabel lblAdicioneOsGols;
	private JButton btnSalvar;
	private List<Jogos> lista;
	private CtrlJogos controleJogos = new CtrlJogos();
	private JLabel lblNewLabel;
	
	public FrmInsereResultado() {
		janela = new JFrame("Insere Resultados");
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
	    scrollPane.setBounds(47, 28, 493, 183);
	    panPrincipal.add(scrollPane);
		
		txtDataRodada = new JTextField();
		txtDataRodada = TratamentoTextFields.mascara(txtDataRodada, "data");
		txtDataRodada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDataRodada.setToolTipText("Digite a data");
		txtDataRodada.setBounds(361, 273, 109, 24);
		panPrincipal.add(txtDataRodada);
		txtDataRodada.setColumns(10);
		scrollPane.setViewportView(tabela);
		scrollPane.setBounds(49, 62, 525, 183);
		panPrincipal.add(scrollPane);
		
		janela.setSize(629,494);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblRodadasDoDia = new JLabel();
		lblRodadasDoDia.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRodadasDoDia.setBounds(89, 330, 456, 39);
		panPrincipal.add(lblRodadasDoDia);
		lblRodadasDoDia.setVisible(false);
		
		lblDigiteAData = new JLabel("Digite a Data: ");
		lblDigiteAData.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDigiteAData.setBounds(242, 272, 109, 29);
		panPrincipal.add(lblDigiteAData);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(491, 256, 83, 41);
		panPrincipal.add(btnPesquisar);
		btnPesquisar.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Lupa.png")));
		
		lblAdicioneOsGols = new JLabel("Adicione os Gols para cada partida");
		lblAdicioneOsGols.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAdicioneOsGols.setBounds(157, 11, 322, 24);
		panPrincipal.add(lblAdicioneOsGols);
		lblAdicioneOsGols.setVisible(false);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(491, 380, 89, 38);
		panPrincipal.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmInsereResultado.class.getResource("/img/Fotolia_66427946_Stadium-lights.jpg")));
		lblNewLabel.setBounds(-558, -40, 1248, 484);
		panPrincipal.add(lblNewLabel);
		
		
		menuPrincipal.addActionListener(l -> {
			janela.dispose();
			janela = null;
			new FrmPrincipal();
		});
		
		btnSalvar.addActionListener(a -> {
			janela.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			lista.forEach(j -> {
				controleJogos.atualizaRodada(j);
			});
			janela.setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "Dados Salvos");
		});
		
		btnPesquisar.addActionListener(l -> {
			try {
				CtrlJogos controleJogos = new CtrlJogos();
				lista = new ArrayList<Jogos>();
				lista = controleJogos.buscaRodadas(txtDataRodada.getText());
				if (!lista.isEmpty()) {
					modelo = new ModeloTabelaEditavel(lista);
					lblRodadasDoDia.setText("Rodada do dia: " + txtDataRodada.getText());
					lblRodadasDoDia.setVisible(true);
					lblAdicioneOsGols.setVisible(true);
					btnSalvar.setEnabled(true);
					tabela.getTableHeader().setReorderingAllowed(false);
					tabela.setModel(modelo);
				}else{
					lblRodadasDoDia.setVisible(false);
					lblAdicioneOsGols.setVisible(false);
					btnSalvar.setEnabled(false);
					try {
						modelo = new ModeloTabelaEditavel(lista);
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
