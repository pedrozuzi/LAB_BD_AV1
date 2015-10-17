package persistence;

import java.util.Date;
import java.util.List;

import entity.Jogos;

public interface JogosDao {
	
	void sortearJogos();
	
	List<Jogos> BuscaRodada(Date data);

}
