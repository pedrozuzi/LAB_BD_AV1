package util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Classe para configuração das telas
 * @author Pedro Afonso
 *
 */
public class ConfiguracoesTela extends JFrame {

	private static final long serialVersionUID = 1L;

	protected static String look = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	protected static int tamanhofonte = 16;

	/**
	 * Método para colocar o logo da empresa na barra
	 * @param tela que sera manipulada
	 * @return tela com suas configurações feitas
	 */
	public JFrame iconeBarra(JFrame tela) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/img/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tela.setIconImage(image);

		return tela;
	}

	/**
	 * Método para setar as configurações padrão das telas
	 * @param tela que sera configurada
	 */
	public void tamanho(JFrame tela) {

        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
		
	}

	/**
	 * Método para setar o estilo selecionado na tela
	 * @param tela que recebera o estilo
	 */
	public void estilo(JFrame tela) {
		try {
			UIManager.setLookAndFeel(look);
			javax.swing.SwingUtilities.updateComponentTreeUI(tela);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método para selecionar um estilo para a tela
	 * @param opcEstilo número para o estilo
	 * @return o estilo que foi escolhido
	 */
	public String selecionaEstilo(int opcEstilo) { 
		switch (opcEstilo) {
		case 0:
			look = "javax.swing.plaf.metal.MetalLookAndFeel";
			break;
		case 1:
			look = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			break;
		case 2:
			look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			break;
		case 3:
			look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			break;
		case 4:
			look = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
		}

		return look;
	}

}
