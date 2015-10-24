package entity;

public class Resultados {

	private String nome_time;
	private int num_jogos_disputados;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int gols_marcados;
	private int gols_sofridos;
	private int saldo_gols;
	private int pontos;
	
	/**
	 * @return the nome_time
	 */
	@Coluna(nome="Nome_time", posicao=0)
	public String getNome_time() {
		return nome_time;
	}
	/**
	 * @param nome_time the nome_time to set
	 */
	public void setNome_time(String nome_time) {
		this.nome_time = nome_time;
	}
	/**
	 * @return the num_jogos_disputados
	 */
	@Coluna(nome="Num_jogos_disputados", posicao=1)
	public int getNum_jogos_disputados() {
		return num_jogos_disputados;
	}
	/**
	 * @param num_jogos_disputados the num_jogos_disputados to set
	 */
	public void setNum_jogos_disputados(int num_jogos_disputados) {
		this.num_jogos_disputados = num_jogos_disputados;
	}
	/**
	 * @return the vitorias
	 */
	@Coluna(nome="Vitorias", posicao=2)
	public int getVitorias() {
		return vitorias;
	}
	/**
	 * @param vitorias the vitorias to set
	 */
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	/**
	 * @return the empates
	 */
	@Coluna(nome="Empates", posicao=3)
	public int getEmpates() {
		return empates;
	}
	/**
	 * @param empates the empates to set
	 */
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	/**
	 * @return the derrotas
	 */
	@Coluna(nome="Derrotas", posicao=4)
	public int getDerrotas() {
		return derrotas;
	}
	/**
	 * @param derrotas the derrotas to set
	 */
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	/**
	 * @return the gols_marcados
	 */
	@Coluna(nome="Gols_marcados", posicao=5)
	public int getGols_marcados() {
		return gols_marcados;
	}
	/**
	 * @param gols_marcados the gols_marcados to set
	 */
	public void setGols_marcados(int gols_marcados) {
		this.gols_marcados = gols_marcados;
	}
	/**
	 * @return the gols_sofridos
	 */
	@Coluna(nome="Gols_sofridos", posicao=6)
	public int getGols_sofridos() {
		return gols_sofridos;
	}
	/**
	 * @param gols_sofridos the gols_sofridos to set
	 */
	public void setGols_sofridos(int gols_sofridos) {
		this.gols_sofridos = gols_sofridos;
	}
	/**
	 * @return the saldo_gols
	 */
	@Coluna(nome="Saldo_gols", posicao=7)
	public int getSaldo_gols() {
		return saldo_gols;
	}
	/**
	 * @param saldo_gols the saldo_gols to set
	 */
	public void setSaldo_gols(int saldo_gols) {
		this.saldo_gols = saldo_gols;
	}
	/**
	 * @return the pontos
	 */
	@Coluna(nome="Pontos", posicao=8)
	public int getPontos() {
		return pontos;
	}
	/**
	 * @param pontos the pontos to set
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
}
