package control;

import java.util.ArrayList;
import java.util.List;

import entity.Resultados;
import persistence.ResultadosDao;
import persistence.ResultadosDaoImpl;

public class CtrlResultados {

	public List<Resultados> resultadoGeral(){
		
	ResultadosDao rDao = new ResultadosDaoImpl();
		List<Resultados> lista = new ArrayList<Resultados>();
		lista = rDao.resultadosGeral();
		return lista;
	}
}
