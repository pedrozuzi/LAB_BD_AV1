package entity;

public class GruposResultados {
	
	private Times time;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golsMarcados;
	private int golsSofridos;
	private int saldoGols;
	private int pontos;
	
	@Coluna(nome="Time", posicao=0)
	public Times getTime() {
		return time;
	}
	public void setTime(Times time) {
		this.time = time;
	}
	@Coluna(nome="J", posicao=1)
	public int getJogos() {
		return jogos;
	}
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	@Coluna(nome="V", posicao=2)
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	@Coluna(nome="E", posicao=3)
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	@Coluna(nome="D", posicao=4)
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	@Coluna(nome="GP", posicao=5)
	public int getGolsMarcados() {
		return golsMarcados;
	}
	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}
	@Coluna(nome="GC", posicao=6)
	public int getGolsSofridos() {
		return golsSofridos;
	}
	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	@Coluna(nome="SG", posicao=7)
	public int getSaldoGols() {
		return saldoGols;
	}
	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}
	@Coluna(nome="P", posicao=8)
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	

}
