package control;


import java.util.ArrayList;
import java.util.List;

import entity.GruposResultados;
import entity.QuartasdeFinal;

import persistence.ResultadosDao;
import persistence.ResultadosDaoImpl;

public class CtrlResultados {

	public List<GruposResultados> resultadoGeral() {

		ResultadosDao rDao = new ResultadosDaoImpl();
		List<GruposResultados> lista = new ArrayList<GruposResultados>();
		lista = rDao.resultadosGeral();
		return lista;
	}

	public List<QuartasdeFinal> quartasdeFinal(String grupo) {

		ResultadosDao rDao = new ResultadosDaoImpl();
		List<QuartasdeFinal> lista = new ArrayList<QuartasdeFinal>();
		lista = rDao.quartasDeFinal(grupo);
		return lista;
	}
	
	public String[] rebaixados(){
		ResultadosDao rDao = new ResultadosDaoImpl();
		List<GruposResultados> lista = new ArrayList<GruposResultados>();
		lista = rDao.rebaixados();
		
		String[] rebaixados = new String[4];
		for (int i = 0; i < 4; i++) {
			rebaixados[i] = lista.get(i).getTime().getNome();
		}
		
		return rebaixados;
	}

}
