package util;

import java.lang.reflect.Method;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entity.Coluna;

/**
 * Classe para montar o modelo das Tabelas dinamicamente
 * @author Pedro Zuzi
 *
 */
public class ModeloTabela extends AbstractTableModel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private final List<?> lista;
	private Class<?> classe;

	/**
	 * Construtor
	 * @param lista, recebe uma lista de uma determinada classe
	 */
	public ModeloTabela(List<?> lista) {
		this.lista = lista;
		this.classe = lista.get(0).getClass();
	}
	
	/**
	 * Método para retorno do número de linhas da Tabela
	 * @return quantidade de linhas
	 */
	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	/**
	 * Método para retorno do número de colunas da Tabela
	 * @return quantidade de colunas
	 */
	@Override
	public int getColumnCount() {
		int colunas = 0;
		
		for ( Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {
				colunas++;
			}
		}
		return colunas;
	}

	/**
	 * Método para percorrer os métodos de uma determinada classe
	 * e montar a tabela dinamicamente de acordo com as anotações
	 * @return valor do método da classe
	 */
	@Override
	public Object getValueAt(int linha, int coluna) {
		try {
			Object objeto = lista.get(linha);
			for (Method metodo : classe.getDeclaredMethods()) {
				if (metodo.isAnnotationPresent(Coluna.class)) {
					Coluna anotacao = metodo.getAnnotation(Coluna.class);
					if (anotacao.posicao() == coluna) {
						return metodo.invoke(objeto);
					}
				}
			}
		} catch (Exception e) {
			return "ERRO";
		}
		return "";
	}
	
	/**
	 * Método para adicionar o nome da coluna de acordo
	 * com a anotação
	 * @return nome da coluna
	 */
	@Override
	public String getColumnName(int coluna) {
		for (Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {
				Coluna anotacao = metodo.getAnnotation(Coluna.class);
				if (anotacao.posicao() == coluna) {
					return anotacao.nome();
				}
			}
		}
		return "";
	}
	
	/**
	 * Método para retorno se a tabela vai ser editável
	 * @return true se editável, false se não editável
	 */
	@Override
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}

	@Override
	public void run() {
		getRowCount();
		getColumnCount();
		
	}
	
}
