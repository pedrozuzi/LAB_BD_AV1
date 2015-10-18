package boundary;

import java.awt.Color;






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
	
	public FrmPrincipal() {
		janela = new JFrame("Campeonato Paulista");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		janela.setSize(654,456);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(178, 86, 310, 306);
		panPrincipal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/FPF.png")));
		
		lblCampeonatoPaulista = new JLabel("Campeonato Paulista");
		lblCampeonatoPaulista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCampeonatoPaulista.setBounds(202, 34, 257, 41);
		panPrincipal.add(lblCampeonatoPaulista);
		
		btnSortearGrupos = new JButton("");
		btnSortearGrupos.setBounds(513, 83, 89, 60);
		panPrincipal.add(btnSortearGrupos);
		btnSortearGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/SorteioJogos.png")));
		
		lblSortearGrupos = new JLabel("Sortear Grupos");
		lblSortearGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSortearGrupos.setBounds(508, 143, 130, 19);
		panPrincipal.add(lblSortearGrupos);
		
		btnGrupos = new JButton("");
		btnGrupos.setBounds(24, 86, 89, 56);
		panPrincipal.add(btnGrupos);
		btnGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Grupos.png")));
		
		lblGrupos = new JLabel("Grupos");
		lblGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupos.setBounds(45, 140, 68, 24);
		panPrincipal.add(lblGrupos);
		
		btnSortearJogos = new JButton("");
		btnSortearJogos.setBounds(515, 191, 89, 56);
		panPrincipal.add(btnSortearJogos);
		btnSortearJogos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Jogos.png")));
		
		lblSortearJogos = new JLabel("Sortear Jogos");
		lblSortearJogos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSortearJogos.setBounds(508, 250, 106, 17);
		panPrincipal.add(lblSortearJogos);
		
		btnPesquisaRodada = new JButton("");
		btnPesquisaRodada.setBounds(24, 191, 89, 56);
		panPrincipal.add(btnPesquisaRodada);
		btnPesquisaRodada.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Rodadas.png")));
		
		lblPesquisarRodada = new JLabel("Pesquisar Rodada");
		lblPesquisarRodada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPesquisarRodada.setBounds(10, 247, 147, 24);
		panPrincipal.add(lblPesquisarRodada);
		
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
		
	}
	
	private void geraNovasRodadas() {
		controleJogos = new CtrlJogos();
		controleJogos.sortearJogos();
		try {
			Thread.sleep(1000);
			JOptionPane.showMessageDialog(null, "Rodadas sorteadas!");
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		controleGrupos = new CtrlGrupos();
		controleGrupos.sortearGrupos();
		JOptionPane.showMessageDialog(null, "Novos grupos formados");
		janela.dispose();
		janela = null;
		new FrmGrupos();
	}
	
	public static void main(String[] args) {
		new FrmPrincipal();
	}
}
