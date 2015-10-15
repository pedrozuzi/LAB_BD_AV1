package control;

import java.util.ArrayList;
import java.util.List;

import persistence.GruposDao;
import persistence.GruposDaoImpl;
import entity.Grupos;

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

}
