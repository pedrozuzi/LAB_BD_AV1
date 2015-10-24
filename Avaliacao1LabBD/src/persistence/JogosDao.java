package persistence;

import java.util.List;
import entity.Jogos;

public interface JogosDao {
	
	void sortearJogos();
	
	List<Jogos> BuscaRodada(String data);
	
	void atualizaRodada(Jogos j);

	
}
