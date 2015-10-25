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
	private JButton btnGruposResultados;
	private JLabel lblGruposResultados;
	
	public FrmPrincipal() {
		
		janela = new JFrame("Campeonato Paulista");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		janela.setSize(664,500);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblGruposResultados = new JLabel("Grupos Resultados");
		lblGruposResultados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGruposResultados.setForeground(Color.WHITE);
		lblGruposResultados.setBackground(Color.WHITE);
		lblGruposResultados.setBounds(489, 364, 149, 22);
		panPrincipal.add(lblGruposResultados);
		
		btnGruposResultados = new JButton("");
		btnGruposResultados.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Quartas.png")));
		btnGruposResultados.setBounds(515, 302, 89, 56);
		panPrincipal.add(btnGruposResultados);
		
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
		
		lblCampeonatoPaulista = new JLabel("Campeonato Paulista");
		lblCampeonatoPaulista.setForeground(Color.WHITE);
		lblCampeonatoPaulista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCampeonatoPaulista.setBounds(202, 34, 257, 41);
		panPrincipal.add(lblCampeonatoPaulista);
		
		btnSortearGrupos = new JButton("");
		btnSortearGrupos.setBounds(515, 86, 89, 56);
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
		
		btnClassificacaoGeral = new JButton("");
		btnClassificacaoGeral.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/classificacao.png")));
		btnClassificacaoGeral.setBounds(210, 364, 89, 60);
		panPrincipal.add(btnClassificacaoGeral);
		
		lblClassificaoGeral = new JLabel("Classifica\u00E7\u00E3o Geral");
		lblClassificaoGeral.setForeground(Color.WHITE);
		lblClassificaoGeral.setBackground(Color.WHITE);
		lblClassificaoGeral.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClassificaoGeral.setBounds(187, 422, 139, 41);
		panPrincipal.add(lblClassificaoGeral);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(187, 65, 292, 306);
		panPrincipal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/FPF.png")));
		
		JButton btnQuartasdeFinal = new JButton("");
		btnQuartasdeFinal.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/versus-48.png")));
		btnQuartasdeFinal.setBounds(355, 366, 89, 60);
		panPrincipal.add(btnQuartasdeFinal);
		
		JLabel lblQuartasdeFinal = new JLabel("Quartas de Final");
		lblQuartasdeFinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuartasdeFinal.setForeground(Color.WHITE);
		lblQuartasdeFinal.setBounds(336, 435, 130, 14);
		panPrincipal.add(lblQuartasdeFinal);
		
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
		
		btnGruposResultados.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmGruposResultados();
		});
		
		btnQuartasdeFinal.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmQuartasdeFinal();
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
