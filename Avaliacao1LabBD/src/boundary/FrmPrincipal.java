package boundary;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import control.CtrlGrupos;
import control.CtrlJogos;

public class FrmPrincipal {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JLabel lblLogo;
	private JLabel lblCampeonatoPaulista;
	private JButton btnSortearGrupos;
	private JLabel lblSortearGrupos;
	private JButton btnGrupos;
	private JLabel lblGrupos;
	private JButton btnSortearJogos;
	private JLabel lblSortearJogos;
	private JButton btnPesquisaRodada;
	private JLabel lblPesquisarRodada;
	private CtrlGrupos controleGrupos;
	private CtrlJogos controleJogos;
	private JLabel lblBackGround;
	private JButton btnInsereGols;
	private JLabel lblInserirGols;
	private JButton btnClassificacaoGeral;
	private JLabel lblClassificaoGeral;
	
	public FrmPrincipal() {
		
		janela = new JFrame("Campeonato Paulista");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		janela.setSize(664,500);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblInserirGols = new JLabel("Inserir Gols");
		lblInserirGols.setBackground(Color.WHITE);
		lblInserirGols.setForeground(Color.WHITE);
		lblInserirGols.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInserirGols.setBounds(35, 359, 96, 33);
		panPrincipal.add(lblInserirGols);
		
		btnInsereGols = new JButton("");
		btnInsereGols.setBounds(35, 302, 89, 56);
		panPrincipal.add(btnInsereGols);
		btnInsereGols.setIcon(new ImageIcon(this.getClass().getResource("/img/gols.png")));
		

		
		lblLogo = new JLabel("");
		lblLogo.setBounds(178, 86, 310, 306);
		panPrincipal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/FPF.png")));
		
		lblCampeonatoPaulista = new JLabel("Campeonato Paulista");
		lblCampeonatoPaulista.setForeground(Color.WHITE);
		lblCampeonatoPaulista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCampeonatoPaulista.setBounds(202, 34, 257, 41);
		panPrincipal.add(lblCampeonatoPaulista);
		
		btnSortearGrupos = new JButton("");
		btnSortearGrupos.setBounds(513, 83, 89, 56);
		panPrincipal.add(btnSortearGrupos);
		btnSortearGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/SorteioJogos.png")));
		
		lblSortearGrupos = new JLabel("Sortear Grupos");
		lblSortearGrupos.setForeground(Color.WHITE);
		lblSortearGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSortearGrupos.setBounds(508, 143, 130, 19);
		panPrincipal.add(lblSortearGrupos);
		
		btnGrupos = new JButton("");
		btnGrupos.setBounds(35, 86, 89, 56);
		panPrincipal.add(btnGrupos);
		btnGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Grupos.png")));
		
		lblGrupos = new JLabel("Grupos");
		lblGrupos.setForeground(Color.WHITE);
		lblGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupos.setBounds(56, 140, 68, 24);
		panPrincipal.add(lblGrupos);
		
		btnSortearJogos = new JButton("");
		btnSortearJogos.setBounds(515, 191, 89, 56);
		panPrincipal.add(btnSortearJogos);
		btnSortearJogos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Jogos.png")));
		
		lblSortearJogos = new JLabel("Sortear Jogos");
		lblSortearJogos.setForeground(Color.WHITE);
		lblSortearJogos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSortearJogos.setBounds(508, 250, 106, 17);
		panPrincipal.add(lblSortearJogos);
		
		btnPesquisaRodada = new JButton("");
		btnPesquisaRodada.setBounds(35, 191, 89, 56);
		panPrincipal.add(btnPesquisaRodada);
		btnPesquisaRodada.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Rodadas.png")));
		
		lblPesquisarRodada = new JLabel("Pesquisar Rodada");
		lblPesquisarRodada.setForeground(Color.WHITE);
		lblPesquisarRodada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPesquisarRodada.setBounds(21, 247, 147, 24);
		panPrincipal.add(lblPesquisarRodada);
		
		btnClassificacaoGeral = new JButton("New button");
		btnClassificacaoGeral.setBounds(513, 302, 96, 56);
		panPrincipal.add(btnClassificacaoGeral);
		
		lblClassificaoGeral = new JLabel("Classifica\u00E7\u00E3o Geral");
		lblClassificaoGeral.setForeground(Color.WHITE);
		lblClassificaoGeral.setBackground(Color.WHITE);
		lblClassificaoGeral.setFont(new Font("Arial", Font.BOLD, 13));
		lblClassificaoGeral.setBounds(487, 356, 139, 41);
		panPrincipal.add(lblClassificaoGeral);
		
		lblBackGround = new JLabel("");
		lblBackGround.setBounds(-284, -83, 978, 554);
		panPrincipal.add(lblBackGround);
		lblBackGround.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/blackback.jpg")));
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		
		btnGrupos.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmGrupos();
		});
		
		btnSortearGrupos.addActionListener(a -> {
			if (confirma("Deseja sortear novos grupos para o Campeonato ? \n") == JOptionPane.YES_OPTION) {
				geraNovosGrupos();
			}
		});
		
		btnPesquisaRodada.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmPesquisaRodada();
		});
		
		btnSortearJogos.addActionListener(a -> {
			if (confirma("Deseja sortear novas Rodadas ? \n") == JOptionPane.YES_OPTION) {
				geraNovasRodadas();
			}
		});
		
		btnInsereGols.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmInsereResultado();
		});
		
		btnClassificacaoGeral.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmClassificacaoGeral();
		});
		
	}
	
	private void geraNovasRodadas() {
		janela.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		controleJogos = new CtrlJogos();
		controleJogos.sortearJogos();
		try {
			
			Thread.sleep(1000);
			JOptionPane.showMessageDialog(null, "Rodadas sorteadas!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			janela.setCursor(Cursor.getDefaultCursor());
		}
		
	}

	private int confirma(String msg){
		Object[] opcoes = {"Sim", "Não"};
		int escolha = JOptionPane.showOptionDialog(null, ""
				+ msg,
				"Aviso", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				null, opcoes, opcoes[1]);
		return escolha;
	}
	
	private void geraNovosGrupos(){
		janela.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		controleGrupos = new CtrlGrupos();
		controleGrupos.sortearGrupos();
		janela.setCursor(Cursor.getDefaultCursor());
		JOptionPane.showMessageDialog(null, "Novos grupos formados");
		janela.dispose();
		janela = null;
		new FrmGrupos();
	}
	
	public static void main(String[] args) {
		new FrmPrincipal();
	}
}
