package persistence;

import java.util.List;

import entity.Grupos;
import entity.GruposResultados;

public interface GruposDao {
	
	void sorteiaGrupos();
	
	List<Grupos> buscaGrupos(String grupo);
	
	List<GruposResultados> buscarGruposResultados(String grupo);

}
