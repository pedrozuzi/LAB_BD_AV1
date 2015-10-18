package entity;

import java.util.Date;

public class Jogos {
	
	private int codigoJogo;
	private int codigoTimeA;
	private int codigoTimeB;
	private int golsTimeA;
	private int golsTimeB;
	private Date data;
	private Times timeA;
	private Times timeB;
	
	public int getCodigoJogo() {
		return codigoJogo;
	}
	public void setCodigoJogo(int codigoJogo) {
		this.codigoJogo = codigoJogo;
	}
	public int getCodigoTimeA() {
		return codigoTimeA;
	}
	public void setCodigoTimeA(int codigoTimeA) {
		this.codigoTimeA = codigoTimeA;
	}
	public int getCodigoTimeB() {
		return codigoTimeB;
	}
	public void setCodigoTimeB(int codigoTimeB) {
		this.codigoTimeB = codigoTimeB;
	}
	public int getGolsTimeA() {
		return golsTimeA;
	}
	public void setGolsTimeA(int golsTimeA) {
		this.golsTimeA = golsTimeA;
	}
	public int getGolsTimeB() {
		return golsTimeB;
	}
	public void setGolsTimeB(int golsTimeB) {
		this.golsTimeB = golsTimeB;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Coluna(nome="Time", posicao=1)
	public Times getTimeB() {
		return timeB;
	}
	public void setTimeB(Times timeB) {
		this.timeB = timeB;
	}
	
	@Coluna(nome="Time", posicao=0)
	public Times getTimeA() {
		return timeA;
	}
	public void setTimeA(Times timeA) {
		this.timeA = timeA;
	}


}
