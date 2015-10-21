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

import javax.swing.JOptionPane;

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
		String query = "select codigoJogo as cod, "
				+ "(select nomeTime from times where codigoTime = jg.codigoTimeA) as TimeA, "
				+ "(select golsTimeA from times where codigoTime = jg.codigoTimeA) as golsTimeA, "
				+ "(select golsTimeB from times where codigoTime = jg.codigoTimeB) as golsTimeB, "
				+ "(select nomeTime from times where codigoTime = jg.codigoTimeB) as TimeB "
				+ "from jogos jg "
				+ "where jg.data = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setDate(1, new java.sql.Date( sdf.parse(data).getTime()));
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				Jogos j = new Jogos();
				Times timeA = new Times();
				Times timeB = new Times();
				timeA.setNome(rs.getString("TimeA"));
				j.setTimeA(timeA);
				j.setGolsTimeA(rs.getInt("golsTimeA"));
				j.setGolsTimeB(rs.getInt("golsTimeB"));
				timeB.setNome(rs.getString("TimeB"));
				j.setTimeB(timeB);
				lista.add(j);
			}
		} catch (SQLException | ParseException e) {
			JOptionPane.showMessageDialog(null, "Data Incorreta");
		}
		
		return lista;
	}

}
