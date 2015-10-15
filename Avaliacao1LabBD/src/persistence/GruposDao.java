package persistence;

import java.util.List;
import entity.Grupos;

public interface GruposDao {
	
	void sorteiaGrupos();
	
	List<Grupos> buscaGrupos(String grupo);
	
	

}
