package control;

import java.util.ArrayList;
import java.util.List;
import persistence.GruposDao;
import persistence.GruposDaoImpl;
import entity.Grupos;
import entity.GruposResultados;

public class CtrlGrupos {
	
	private GruposDao gDao;
	
	public void sortearGrupos(){
		gDao = new GruposDaoImpl();
		gDao.sorteiaGrupos();
	}
	
	public List<Grupos> buscaGrupos(String grupo){
		List<Grupos> lista = new ArrayList<Grupos>();
		gDao = new GruposDaoImpl();
		lista = gDao.buscaGrupos(grupo);
		return lista;
	}
	
	public List<GruposResultados> buscaGruposResultados(String grupo) {
		List<GruposResultados> lista = new ArrayList<GruposResultados>();
		gDao = new GruposDaoImpl();
		lista = gDao.buscarGruposResultados(grupo);
		return lista;
	}

}
