package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Grupos;

public class GruposDaoImpl implements GruposDao{
	
	private Connection c;
	
	public GruposDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
		System.out.println("conectado");
	}

	@Override
	public List<Grupos> sorteiaGrupos() {
		String query = "{call sp_sorteioGrupos()}";
		try {
			CallableStatement cs = c.prepareCall(query);
			cs.execute();
			cs.close();
			System.out.println("executado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
