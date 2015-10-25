package persistence;

import java.util.List;

import entity.QuartasdeFinal;
import entity.Resultados;



public interface ResultadosDao {

	List<Resultados> resultadosGrupos(String grupo);
	
	List<Resultados> resultadosGeral();
	
	List<QuartasdeFinal> quartasDeFinal(String grupo);
	
	List<Resultados> rebaixados();
	
}
