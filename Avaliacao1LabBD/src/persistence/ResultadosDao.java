package persistence;

import java.util.List;

import entity.Resultados;



public interface ResultadosDao {

	List<Resultados> resultadosGrupos(String grupo);
	
	List<Resultados> resultadosGeral();
	
	List<Resultados> quartasDeFinal(String grupo);
	
	List<Resultados> rebaixados(String grupo);
	
}
