package persistence;

import java.util.List;

import entity.GruposResultados;
import entity.QuartasdeFinal;




public interface ResultadosDao {

	List<GruposResultados> resultadosGrupos(String grupo);
	
	List<GruposResultados> resultadosGeral();
	
	List<QuartasdeFinal> quartasDeFinal(String grupo);
	
	List<GruposResultados> rebaixados();
	
}
