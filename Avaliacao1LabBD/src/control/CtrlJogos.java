package control;

import java.util.Date;
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
	
	public List<Jogos> buscaRodadas(Date data){
		//TODO
		return null;
	}

}
