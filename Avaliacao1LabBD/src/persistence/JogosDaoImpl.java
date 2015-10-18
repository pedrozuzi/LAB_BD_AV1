package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Jogos;
import entity.Times;

public class JogosDaoImpl implements JogosDao {
	
	private Connection c;
	
	public JogosDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void sortearJogos() {
		String query = "{call sp_datasJogos()}";
		try {
			CallableStatement cs = c.prepareCall(query);
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Jogos> BuscaRodada(String data) {
		List<Jogos> lista = new ArrayList<Jogos>();
		String query = "select "
						+ "(select nomeTime from times where codigoTime = jg.codigoTimeA) as codigotimeA, "
						+ "(select nomeTime from times where codigoTime = jg.codigoTimeB) as codigotimeB "
						+ "from jogos jg "
						+ "where jg.data = ? ";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setDate(1, new java.sql.Date( sdf.parse(data).getTime()));
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				Jogos j = new Jogos();
				Times timeA = new Times();
				Times timeB = new Times();
				timeA.setNome(rs.getString("codigotimeA"));
				j.setTimeA(timeA);
				timeB.setNome(rs.getString("codigotimeB"));
				j.setTimeB(timeB);
				lista.add(j);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
