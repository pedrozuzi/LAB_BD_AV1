package control;

import java.util.ArrayList;
import java.util.List;
import persistence.JogosDao;
import persistence.JogosDaoImpl;
import entity.Jogos;

public class CtrlJogos {
	
	private JogosDao jDao;
	
	public void sortearJogos(){
		jDao = new JogosDaoImpl();
		jDao.sortearJogos();
	}
	
	public List<Jogos> buscaRodadas(String data){
		jDao = new JogosDaoImpl();
		List<Jogos> lista = new ArrayList<Jogos>();
		lista = jDao.BuscaRodada(data);
		return lista;
	}
	
	public void atualizaRodada(Jogos j) {
		jDao = new JogosDaoImpl();
		jDao.atualizaRodada(j);
	}

}
