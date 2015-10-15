package control;

import java.util.List;

import persistence.GruposDao;
import persistence.GruposDaoImpl;
import entity.Grupos;

public class CtrlGrupos {
	
	private GruposDao gDao;
	
	public List<Grupos> sortearGrupos(){
		gDao = new GruposDaoImpl();
		gDao.sorteiaGrupos();
		return null;
		
	}

}
