package entity;

public class Grupos {
	
	private int codigo;
	private String Grupo;
	private Times time;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Coluna(nome="Grupo", posicao=0)
	public String getGrupo() {
		return Grupo;
	}
	public void setGrupo(String grupo) {
		Grupo = grupo;
	}
	
	@Coluna(nome="Time", posicao=1)
	public Times getTime() {
		return time;
	}
	public void setTime(Times time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		return this.time.getNome();
	}

}
