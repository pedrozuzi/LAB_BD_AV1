package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Jogos;

public class JogosDaoImpl implements JogosDao {
	
	private Connection c;
	
	public JogosDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void sortearJogos() {
		String query = "call {sp_datasJogos }";
		CallableStatement cs;
		try {
			cs = c.prepareCall(query);
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Jogos> BuscaRodada(Date data) {
		// TODO
		return null;
	}

}
