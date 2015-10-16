package boundary;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

public class FrmPrincipal {
	
	private JFrame janela;
	private JPanel panPrincipal;
	private JLabel lblLogo;
	private JLabel lblCampeonatoPaulista;
	private JButton btnSortearGrupos;
	private JButton btnJogos;
	private JLabel lblJogos;
	private JLabel lblSortearGrupos;
	private JButton btnGrupos;
	private JLabel lblGrupos;
	
	public FrmPrincipal() {
		janela = new JFrame("Campeonato Paulista");
		panPrincipal = new JPanel();
		panPrincipal.setBackground(Color.WHITE);
		
		janela.setSize(654,468);
		janela.setContentPane( panPrincipal );
		panPrincipal.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(195, 83, 310, 306);
		panPrincipal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(this.getClass().getResource("/img/FPF.png")));
		
		lblCampeonatoPaulista = new JLabel("Campeonato Paulista");
		lblCampeonatoPaulista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCampeonatoPaulista.setBounds(219, 31, 257, 41);
		panPrincipal.add(lblCampeonatoPaulista);
		
		btnSortearGrupos = new JButton("");
		btnSortearGrupos.setBounds(513, 144, 89, 45);
		panPrincipal.add(btnSortearGrupos);
		btnSortearGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Sorteio.png")));
		
		btnJogos = new JButton("");
		btnJogos.setBounds(24, 144, 89, 41);
		panPrincipal.add(btnJogos);
		btnJogos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Jogos.png")));
		
		lblJogos = new JLabel("Jogos");
		lblJogos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJogos.setBounds(45, 186, 55, 24);
		panPrincipal.add(lblJogos);
		
		lblSortearGrupos = new JLabel("Sortear Grupos");
		lblSortearGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSortearGrupos.setBounds(508, 189, 130, 19);
		panPrincipal.add(lblSortearGrupos);
		
		btnGrupos = new JButton("");
		btnGrupos.setBounds(24, 252, 89, 41);
		panPrincipal.add(btnGrupos);
		btnGrupos.setIcon(new ImageIcon(this.getClass().getResource
				("/img/Grupos.png")));
		
		lblGrupos = new JLabel("Grupos");
		lblGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupos.setBounds(45, 292, 68, 24);
		panPrincipal.add(lblGrupos);
		
		janela.setLocationRelativeTo(null);
        janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		
		btnGrupos.addActionListener(a -> {
			janela.dispose();
			janela = null;
			new FrmGrupos();
		});
	}
	
	public static void main(String[] args) {
		new FrmPrincipal();
	}
}
