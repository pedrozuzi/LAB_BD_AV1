package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.Grupos;
import entity.GruposResultados;
import entity.Times;

public class GruposDaoImpl implements GruposDao{
	
	private Connection c;
	
	public GruposDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void sorteiaGrupos() {
		String query = "{call sp_sorteioGrupos()}";
		try {
			CallableStatement cs = c.prepareCall(query);
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Grupos> buscaGrupos(String grupo) {
		List<Grupos> lista = new ArrayList<Grupos>();
		String query = "select grupos.grupo, times.nomeTime "
						+ "from grupos "
						+ "inner join times "
						+ "on grupos.codigoTime = times.codigoTime "
						+ "where grupos.grupo like ? "
						+ "group by grupos.grupo, times.nomeTime";
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setString(1, grupo);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Grupos g = new Grupos();
				Times t = new Times();
				t.setNome( rs.getString("nomeTime") );
				g.setGrupo( rs.getString("grupo") );
				g.setTime(t);
				lista.add( g );
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<GruposResultados> buscarGruposResultados(String grupo) {
		List<GruposResultados> lista = new ArrayList<GruposResultados>();
		String query ="select * from dbo.fn_grupo(?) order by pontos desc, vitorias desc, gols_marcados desc, saldo_gols desc";
		try {
			PreparedStatement ps = c.prepareStatement( query );
			ps.setString(1, grupo);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				GruposResultados gr = new GruposResultados();
				Times t = new Times();
				t.setNome( rs.getString("nome_Time"));
				gr.setTime(t);
				gr.setJogos(rs.getInt("num_jogos_disputados"));
				gr.setVitorias(rs.getInt("vitorias"));
				gr.setEmpates(rs.getInt("empates"));
				gr.setDerrotas(rs.getInt("derrotas"));
				gr.setGolsMarcados(rs.getInt("gols_marcados"));
				gr.setGolsSofridos(rs.getInt("gols_sofridos"));
				gr.setSaldoGols(rs.getInt("saldo_gols"));
				gr.setPontos(rs.getInt("pontos"));
				lista.add(gr);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
